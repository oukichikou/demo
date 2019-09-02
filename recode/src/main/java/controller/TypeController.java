package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Type;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	TypeService service;
	
	@RequestMapping("index")
	public String index(String name,ModelMap m) {
		String where=""; 
		if(name!=null&&name.length()>0) where=" where name like '%"+name+"%' ";
		m.put("list", service.getWhere(where));
		return "Type/index";
	}
	
	
	
	@RequestMapping("delete")
	public String delete(int id,ModelMap m) {
		service.delete(id);
		return index("", m);
	}
	
	@RequestMapping("add")
	public String add(ModelMap m) {
		return "Type/edit";
	}
	@RequestMapping("edit")
	public String edit(int id,ModelMap m) {
		m.put("info", service.getByid(id));
		return add(m);
	}
	
	@RequestMapping("insert")
	public String insert(  Type t,ModelMap m) {
		service.insert(t);
		return index("", m);
	}
	@RequestMapping("update")
	public String update(Type t,ModelMap m) {
		service.update(t);
		return index("", m);
	}
}
