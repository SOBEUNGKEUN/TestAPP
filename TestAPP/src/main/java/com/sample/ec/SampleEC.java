package com.sample.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.dao.SampleDAO;
import com.sample.dto.SampleInDTO;
import com.sample.dto.SampleOutDTO;

@Repository
public class SampleEC {
	
	@Autowired
	SampleDAO sampleDAO;
	
	
	public SampleOutDTO select (SampleInDTO input) throws Throwable{
		
		SampleOutDTO output = new SampleOutDTO();
		
		output = sampleDAO.select(input);
		
		return output;
		
	}
}
