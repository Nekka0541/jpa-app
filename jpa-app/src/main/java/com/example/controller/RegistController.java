package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.User;
import com.example.form.RegistForm;
import com.example.repository.UserRepository;

@Controller
public class RegistController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGet(Model model) {
		model.addAttribute("registForm", new RegistForm());
		
		model.addAttribute("message", "");
		return "register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPost(RegistForm form, Model model) {
		String id = form.getId();
		String pass = form.getPass();
		String name = form.getName();
		
		List<User> users = userRepository.findAll();
		
		for (User user : users) {
			if ((id.equals(user.getId())) && (pass.equals(user.getPass()))) {
				System.out.println("ログイン成功");
				model.addAttribute("name", user.getName());
				return "user";
			}
		}
		model.addAttribute("message", "登録したぜ");
		User user = new User(id, pass, name);
		userRepository.save(user);
		return "register";
	}
}
