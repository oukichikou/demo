package service;

import java.util.List;


import entity.User;

public interface UserService {
	public  User login(User u);

	public  List<User> getWhere( String where);

	public  List<User> getAll();

	public  User getByid(int id);

	public int delete(int id);

	 public Integer insert(User t);

	 public Integer update(User t);
}
