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
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Book;
import entity.Book;
import service.BookService;
import service.TypeService;
import utils.ReturnInfo;
import utils.ReturnJson;
import utils.SearchInfo;

@Controller
@RequestMapping("Book")
public class BookController extends BasicController<Book>{
	@Autowired
	BookService service;
	
	
	@Override
	public ReturnInfo index(SearchInfo info, Integer page, Integer limit, ModelMap m) {
		info.addLike("book.name");
		return super.index(info, page, limit, m);
	}
	
	@GetMapping(value="sexs")
	public @ResponseBody String[] getsexs() {
		return Book.sexs;
	}
	
}
