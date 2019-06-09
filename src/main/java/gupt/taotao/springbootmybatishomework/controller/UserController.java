package gupt.taotao.springbootmybatishomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gupt.taotao.springbootmybatishomework.common.User;
import gupt.taotao.springbootmybatishomework.server.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String dologin(){
		return "login";
	}
	
	@RequestMapping(value="/dologin")
	public String login(User loginuser, Model model){
		System.out.println("user:" + loginuser);
		User user = userService.selectUser(loginuser) ;
		System.out.println(user);
		if(user == null){
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "loginresult";
		}else {
			model.addAttribute("msg", "登录成功！！！");
			return "loginresult";
		}
		
	}
	@RequestMapping(value="/register")
	public String Register(){
		return "register";
	}
	
	@RequestMapping(value="/doregister")
	public String doRegister(User registeruser,Model model){
		User user1 = userService.selectUsername(registeruser);
		if(user1 == null){
		    userService.insert(registeruser);
			model.addAttribute("resl", "注册成功");
			return "registerresult";
		}else {
			model.addAttribute("resl", "用户名已存在");
			return "registerresult";
		}
	}
	

}
