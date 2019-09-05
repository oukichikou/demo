package service;

import java.util.List;


public interface basicService<T> {
	public  List<T> getWhere( String where);

	public  List<T> getAll();

	public  T getByid(Integer id);

	public int delete(Integer id);

	 public Integer insert(T t);

	 public Integer update(T t);
}
