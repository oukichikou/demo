package service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import entity.Type;

public interface TypeService {
	public  List<Type> getWhere( String where );
	
	public  List<Type> getWhere1( Type t );
	
	
	public  Type getByid(int id);

	public int delete(int id);

	 public Integer insert(Type t);
	 public Integer update(Type t);
}
