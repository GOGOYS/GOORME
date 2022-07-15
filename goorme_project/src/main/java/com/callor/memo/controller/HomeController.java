package com.callor.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	

	@RequestMapping(value = {"/","/login-ok"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		UserVO user = (UserVO)session.getAttribute("USER");
		

		return "home";
	}
	
	
	
}
