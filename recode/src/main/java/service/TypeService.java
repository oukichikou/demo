package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Type;

public interface TypeService {
	public  List<Type> getWhere( String where );
	
	public  List<Type> getWhere1( Type t );
}
