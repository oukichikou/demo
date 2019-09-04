package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping("login")
	public String login(User u,String code,ModelMap m,HttpSession s) {
//		String num=s.getAttribute("number").toString();
//		if(!num.equalsIgnoreCase(code)) {
//			return "redirect:/login.html";
//		}
//		
		try {
		
		SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(),
				u.getPass()));
		}catch (AccountException e) {
			return "redirect:/login.html";
		}
		return "redirect:/index.jsp";
	}
	@RequestMapping("outlogin")
	public String login(HttpSession s,HttpServletRequest req) {
		SecurityUtils.getSubject().logout();
		return "redirect:../login.html";
	}
	
	
	@RequestMapping("index")
	public String index(String name,ModelMap m) {
		String where=""; 
		if(name!=null&&name.length()>0) where=" where name like '%"+name+"%' ";
		m.put("list", service.getWhere(where));
		return "User/index";
	}
	
	
	
	@RequestMapping("delete")
	public String delete(int id,ModelMap m) {
		service.delete(id);
		return index("", m);
	}
	
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		return "User/edit";
	}
	@RequestMapping("edit")
	public String edit(int id,ModelMap m) {
		m.put("info", service.getByid(id));
		return add(m);
	}
	
	@RequestMapping("insert")
	public String insert(  User t,ModelMap m) {
		service.insert(t);
		return index("", m);
	}
	@RequestMapping("update")
	public String update(User t,ModelMap m) {
		service.update(t);
		return index("", m);
	}
}
