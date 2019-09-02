package service;

import java.util.List;


import entity.Type;

public interface TypeService {
	public  List<Type> getWhere( String where);

	public  List<Type> getAll();

	public  Type getByid(int id);

	public int delete(int id);

	 public Integer insert(Type t);

	 public Integer update(Type t);
}
