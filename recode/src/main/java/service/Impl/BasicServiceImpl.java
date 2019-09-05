package service.Impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import entity.Type;
import service.BookService;
import service.basicService;

@Service
public class BasicServiceImpl<T> implements basicService<T>{


private Object execDao(String mname,Object... objs){
	try {
	Field f=this.getClass().getDeclaredField("dao");
	f.setAccessible(true);
	Object dao=f.get(this);
		
	Class cls=dao.getClass();  //  daoµÄ×Ö½ÚÂë
	Class[] cs=new Class[objs.length];
	for(int i=0;i<objs.length;i++)cs[i]=objs[i].getClass();
	Method m= cls.getMethod(mname, cs);
	m.setAccessible(true);
	return m.invoke(dao, objs);
	}catch (Exception e) {
		e .printStackTrace();
		return null;
	}
	
}

public List<T> getWhere(String where) {
	Object o=execDao("getWhere", where);
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

public List<T> getAll() {
	Object o=execDao("getAll");
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

public T getByid(Integer id) {
	Object o=execDao("getByid",id);
	if(o!=null) return (T) o;
	else return null;
}

public int delete(Integer id) {
	Object o=execDao("delete",id);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer insert(T t) {
	Object o=execDao("insert",t);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer update(T t) {
	Object o=execDao("update",t);
	if(o!=null) return (Integer) o;
	else return -2;
}


}
