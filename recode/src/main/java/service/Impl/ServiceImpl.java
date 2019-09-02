package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import dao.TypeDao1;
import entity.Type;
import service.TypeService;

@Service
public class ServiceImpl implements TypeService{
@Autowired
TypeDao dao;
@Autowired
TypeDao1 mdao;
	public List<Type> getWhere(String where) {
		// TODO Auto-generated method stub
		return dao.getWhere(where);
	}

	public List<Type> getWhere1(Type t) {
		// TODO Auto-generated method stub
		return mdao.getWhere(t);
	}

	public Type getByid(int id) {
		// TODO Auto-generated method stub
		return dao.getByid(id);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	public Integer insert(Type t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	public Integer update(Type t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

}
