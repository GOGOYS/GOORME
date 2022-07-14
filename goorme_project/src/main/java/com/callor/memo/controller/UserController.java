package com.callor.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.UserVO;
import com.callor.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserVO userVO,HttpSession session,Model model) {
		
		String message = null;
		
		UserVO user = userService.findById(userVO.getU_userid());
		
		if(user.getU_userid() == null) {
			message= "USER_ID FAIL";
		}else if(!(user.getU_password().equals(userVO.getU_password()))) {
			message= "USER_PASSWORD FAIL";
		}
		
		log.debug(message);
		if(message == null) {
			session.setAttribute("USER", userVO);
		}else {
			session.removeAttribute("USER");
		}
		
		model.addAttribute("LOGIN_MESSAAGE",message);
		
		return "redirect:/";
	}
		
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		UserVO userid = userService.findById(userVO.getU_userid());
		if(userid == null) {
			userService.insert(userVO);			
		}else {
			return "이미 가입 되어있음";
		}
		return "redirect:/user/login";
	}
	
}
