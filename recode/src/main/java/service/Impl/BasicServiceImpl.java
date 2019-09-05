package service.Impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import service.BasicService;
import utils.ReturnInfo;

public class BasicServiceImpl<T> implements BasicService<T>{


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

public ReturnInfo getWhere(String where, Integer page, Integer limit) {
	boolean canpage=page!=null;
	ReturnInfo info = new ReturnInfo();
	info.setList((List) execDao("getWhere", where,ReturnInfo.getLimit(page, limit)));
	if(canpage)info.setCount((Integer)execDao("getCount",where));
	  return info;
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

public Integer delete(Integer id) {
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
