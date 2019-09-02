package service;

import java.util.List;


import entity.Type;
import utils.ReturnInfo;

public interface TypeService {
	public  ReturnInfo getWhere( String where,Integer page,Integer limit);

	public  List<Type> getAll();

	public  Type getByid(int id);

	public int delete(int id);

	 public Integer insert(Type t);

	 public Integer update(Type t);
}
