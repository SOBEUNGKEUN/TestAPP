package com.assignment01.q01.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment01.q01.dao.q01DAO;
import com.assignment01.q01.dto.q01InDTO;
import com.assignment01.q01.dto.q01OutDTO;

@Repository
public class q01EC {
	
	@Autowired
	q01DAO q01DAO;
	
	public q01OutDTO select(q01InDTO input) throws Exception{
		
		q01OutDTO output = new q01OutDTO();
		
		output = q01DAO.select(input);
		
		return output;
		
	}
	
	public void insert(q01InDTO input) throws Exception{
		
		q01DAO.insert(input);
		
	}
	
	public void update(q01InDTO input) throws Exception{
		
		q01DAO.update(input);
		
	}
	
	public void delete(q01InDTO input) throws Exception{
		
		q01DAO.delete(input);
		
	}
}
