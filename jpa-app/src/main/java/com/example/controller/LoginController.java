package com.example.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Log;
import com.example.entity.User;
import com.example.form.LoginForm;
import com.example.repository.LogRepository;
import com.example.repository.UserRepository;

/**
 * コントローラークラス
 * 
 * @author sjdu002
 *
 */
@Controller
public class LoginController {

	// リポジトリアクセス
	//ひとつひとつのオブジェクトごとにアノテーションをつける
	@Autowired
	UserRepository userRepository;
	@Autowired
	LogRepository logRepository;

	// login受付
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		// Formクラスオブジェクトを生成して
		// Modelに追加
		model.addAttribute("loginForm", new LoginForm());
		// errormessage初期化
		model.addAttribute("message", "");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(LoginForm form, Model model) {
		// POSTパラメータからidpassを取り出す
		String id = form.getId();
		String pass = form.getPass();

		// logincheck
		// userTableと照合する

		//userRepositoryのインスタンスはDIが生成
		List<User> users = userRepository.findAll();

		// 登録されているユーザーの文だけ繰り返す
		for (User user : users) {
			if ((id.equals(user.getId())) && (pass.equals(user.getPass()))) {
				System.out.println("ログイン成功");
				model.addAttribute("name", user.getName());
				putLog(user);
				return "user";
			}

		}

		// ログインに成功した場合ユーザー画面に遷移する

		model.addAttribute("message", "まちごうてるで");

		return "login";
	}

	/**
	 * ログを記録するメソッド
	 * @param user ログインしたユーザー
	 */
	private void putLog(User user) {
		/*
		 * リポジトリに対して、ログインしたユーザーのログを追加する
		 */
		
		//リポジトリに対してログインしたユーザーのログを追加
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();		//現在時刻取得
		
		//ログのEntityオブジェクト生成
		Log log = new Log(now, user);
		
		
		//リポジトリにログEntityを追加
		logRepository.save(log);
		System.out.println(log);
		
	}

}
