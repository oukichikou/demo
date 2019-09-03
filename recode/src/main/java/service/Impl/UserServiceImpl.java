package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserDao dao;

public List<User> getWhere(String where) {
	// TODO Auto-generated method stub
	return dao.getWhere(where);
}

public List<User> getAll() {
	// TODO Auto-generated method stub
	return dao.getAll();
}

public User getByid(int id) {
	// TODO Auto-generated method stub
	return dao.getByid(id);
}

public int delete(int id) {
	// TODO Auto-generated method stub
	return dao.delete(id);
}

public Integer insert(User t) {
	// TODO Auto-generated method stub
	return dao.insert(t);
}

public Integer update(User t) {
	// TODO Auto-generated method stub
	return dao.update(t);
}

public User login(User u) {
	// TODO Auto-generated method stub
	return dao.login(u);
}

}
