package com.sample.dao;

import com.datasource.DatabaseTest;
import com.sample.dto.SampleDTO;

@DatabaseTest
public interface TestDAO {
	
	public SampleDTO select(SampleDTO input) throws Exception; 
	
}


