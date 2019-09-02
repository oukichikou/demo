package service;

import java.util.List;


import entity.Book;
import utils.ReturnInfo;

public interface BookService {
	public  ReturnInfo getWhere( String where,Integer page,Integer limit);


	public  List<Book> getAll();

	public  Book getByid(int id);

	public int delete(int id);

	 public Integer insert(Book t);

	 public Integer update(Book t);
}
