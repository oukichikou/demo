package service;

import java.util.List;


import entity.Book;

public interface BookService {
	public  List<Book> getWhere( String where);

	public  List<Book> getAll();

	public  Book getByid(int id);

	public int delete(int id);

	 public Integer insert(Book t);

	 public Integer update(Book t);
}
