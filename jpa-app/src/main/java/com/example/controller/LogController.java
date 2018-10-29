package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Log;
import com.example.repository.LogRepository;

/**
 * Logを処理するコントローラー
 * @author sjdu002
 *
 */
@Controller
public class LogController {

	//ログテーブルのリポジトリ
	@Autowired
	private LogRepository logRepository;
	
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public String logGet(Model model) {
		
		//log取得
		//ListジェネリクスをLogクラス型にすること
		List<Log> logs = logRepository.findAll();
		
		model.addAttribute("logs", logs);
		
		return "log";
		
	}
}
