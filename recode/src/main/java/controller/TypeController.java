package controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import annotation.logTextAnotation;
import entity.Type;
import service.TypeService;
import utils.ReturnInfo;
import utils.ReturnJson;
import utils.SearchInfo;

@RestController
@RequestMapping("Type")
public class TypeController extends BasicController<Type> {
	@Autowired
	TypeService service;
	
	@Override
	public ReturnInfo index(SearchInfo info, Integer page, Integer limit, ModelMap m) {
			info.addLike("name");
		return super.index(info, page, limit, m);
	}
	@GetMapping("aaaaa")
	public String aaaa(){
		service.getByid(1);
		return "";
	}
	@GetMapping("aaaaa1")
	public String getByid(){
		service.getByid(1);
		return "";
	}
	
	@GetMapping("list")
	public List getlist(SearchInfo info) {
		return service.getAll();
	}
	
	
	
	
}
