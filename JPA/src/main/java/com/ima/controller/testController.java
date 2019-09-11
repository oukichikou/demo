package com.ima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ima.model.Type;
import com.ima.repository.TypeRepository;
import com.ima.service.TypeService;
import com.ima.service.UserService;

@Controller
public class testController {
	@Autowired
    private TypeService Service;
	@RequestMapping("index")
	public String index(ModelMap m) {
		m.put("list", Service.select());
		return "index";
	}
	
	@RequestMapping("insert")
	public String insert(Type t,ModelMap m) {
		Service.insert(t);
		return index(m);
	}
}
