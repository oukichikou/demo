package com.ima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ima.model.Type;
import com.ima.repository.TypeRepository;

@Service
public class TypeService {
	@Autowired
    private TypeRepository Repository;

    public List<Type> select(){
       return  Repository.findAll();
    }

	public void insert(Type t) {
		  Repository.save(t);
	}
    
}
