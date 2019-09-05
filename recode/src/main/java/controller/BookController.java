package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Book;
import service.BookService;
import service.TypeService;

@Controller
@RequestMapping("Book")
public class BookController extends BasicController<Book> {
	@Autowired
	BookService service;
	
	@Autowired
	TypeService tservice;
//	
//	
//	

	
	@Override
	public String index(ModelMap m,HttpServletRequest req) {
		String txt=req.getParameter("txt");
		String where=""; 
		if(txt!=null&&txt.length()>0) where=" where book.name like '%"+txt+"%' ";
		m.put("list", service.getWhere(where));
		return "Book/index";
	}

	@RequestMapping("add")
	public String add(ModelMap m,HttpServletRequest req) {
		m.put("sexs", Book.sexs);
		m.put("typelist", tservice.getAll());
		return "Book/edit";
	}
	@RequestMapping("edit")
	public String edit(Integer id,ModelMap m,HttpServletRequest req) {
		m.put("info", service.getByid(id));
		return add(m,req);
	}

}
