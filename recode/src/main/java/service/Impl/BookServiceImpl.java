package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import service.BookService;
import utils.ReturnInfo;

@Service
public class BookServiceImpl implements BookService{
@Autowired
BookDao dao;

public ReturnInfo getWhere(String where, Integer page, Integer limit) {
	boolean canpage=page!=null;
	ReturnInfo info = new ReturnInfo();
	info.setList(dao.getWhere(where,ReturnInfo.getLimit(page, limit)));
	if(canpage)info.setCount(dao.getCount(where));
	  return info;
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
