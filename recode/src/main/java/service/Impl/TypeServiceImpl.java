package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import entity.Type;
import service.TypeService;

@Service
public class TypeServiceImpl extends BasicServiceImpl<Type> implements  TypeService{
@Autowired
TypeDao dao;


	public List<Type> getAll() {
		return super.getAll();
	}

	@CachePut(value="type")
	public Type getByid(Integer id) {

		System.out.println("≤È—Ø");
		return super.getByid(id);
	}

}
