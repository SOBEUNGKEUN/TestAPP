package com.sample.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.dao.TestDAO;
import com.sample.dto.SampleDTO;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

@Repository
public class TestEC {
	
	@Autowired
	TestDAO testDAO;
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
	public SampleDTO select (SampleDTO input) throws Throwable{
		
		logger.info("########## TestAPP TestEC 호출 성공 ###############");
		
		logger.info("########## TestAPP TestEC input: \n"+input);
		
		SampleDTO output = new SampleDTO();
		
		output = testDAO.select(input);
		
		return output;
		
	}
}
