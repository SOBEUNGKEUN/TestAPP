package com.sample.dao;

import com.datasource.DatabasePO21;
import com.sample.dto.SampleInDTO;
import com.sample.dto.SampleOutDTO;

@DatabasePO21
public interface SampleDAO {
	
	public SampleOutDTO select(SampleInDTO input) throws Exception; 
	
}


