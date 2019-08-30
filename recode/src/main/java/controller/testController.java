package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Type;
import service.TypeService;

@Controller
public class testController {
	@Autowired
	TypeService service;
	
	@RequestMapping("index")
	public void index(String name,ModelMap m) {
		String where=""; 
		if(name!=null&&name.length()>0) where=" where name like '%"+name+"%' ";
		m.put("list", service.getWhere(where));
	}
	
	@RequestMapping("index1")
	public String index1(Type t,ModelMap m) {
		m.put("list", service.getWhere1(t));
		return "index";
	}
	
}
