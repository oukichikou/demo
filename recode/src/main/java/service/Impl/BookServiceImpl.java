package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import service.BookService;

@Service
public class BookServiceImpl implements BookService{
@Autowired
BookDao dao;

public List<Book> getWhere(String where) {
	// TODO Auto-generated method stub
	return dao.getWhere(where);
}

public List<Book> getAll() {
	// TODO Auto-generated method stub
	return dao.getAll();
}

public Book getByid(int id) {
	// TODO Auto-generated method stub
	return dao.getByid(id);
}

public int delete(int id) {
	// TODO Auto-generated method stub
	return dao.delete(id);
}

public Integer insert(Book t) {
	// TODO Auto-generated method stub
	return dao.insert(t);
}

public Integer update(Book t) {
	// TODO Auto-generated method stub
	return dao.update(t);
}

}
