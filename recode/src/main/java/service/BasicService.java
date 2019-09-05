package service;

import java.util.List;


import utils.ReturnInfo;

public interface BasicService<T> {
	public  ReturnInfo getWhere( String where,Integer page,Integer limit);

	public  List<T> getAll();

	public  T getByid(Integer id);

	public Integer delete(Integer id);

	 public Integer insert(T t);

	 public Integer update(T t);
}
