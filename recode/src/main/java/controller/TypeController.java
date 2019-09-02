package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Type;
import service.TypeService;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
public class TypeController {
	@Autowired
	TypeService service;
	
	
	@GetMapping("Type/{id}")
	public @ResponseBody Type edit(@PathVariable("id") int id,ModelMap m) {
		return service.getByid(id);
	}
	@GetMapping(value="Type")
	public @ResponseBody ReturnInfo index(String name,Integer page,Integer limit,ModelMap m) {
		String where=""; 
		if(name!=null&&name.length()>0) where=" where name like '%"+name+"%' ";
		return service.getWhere(where,page,limit);
	}
	
	@PostMapping("Type")
	public @ResponseBody ReturnJson insert( Type t,ModelMap m) {
		service.insert(t);
		return new ReturnJson();
	}
	
	@DeleteMapping("Type/{id}")
	public @ResponseBody ReturnJson delete(@PathVariable("id") int id,ModelMap m) {
		service.delete(id);
       return new ReturnJson();
	}
	
	@PutMapping("Type/{id}")
	public @ResponseBody ReturnJson update(Type t,ModelMap m) {
		service.update(t);
		return new ReturnJson();
	}
}
