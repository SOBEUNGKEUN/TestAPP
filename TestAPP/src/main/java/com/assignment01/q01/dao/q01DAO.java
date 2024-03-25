package com.assignment01.q01.dao;

import com.assignment01.q01.dto.q01InDTO;
import com.assignment01.q01.dto.q01OutDTO;
import com.datasource.DatabaseTest;

@DatabaseTest
public interface q01DAO {
	
	public q01OutDTO select(q01InDTO input) throws Exception; 
	
	public void insert(q01InDTO input) throws Exception;
	
	public void update(q01InDTO input) throws Exception;
	
	public void delete(q01InDTO input) throws Exception;
	
}
