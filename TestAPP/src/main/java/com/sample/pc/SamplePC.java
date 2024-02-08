package com.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.SampleOutDTO;
import com.sample.ec.SampleEC;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 2. 8. 오후 2:09",
	comments= "SamplePC"
)
@Service
public class SamplePC{
    
	
	@Autowired
	SampleEC sampleEC;
	
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
    /**
     * @param com.sample.dto.SampleInDTO
     * @return com.sample.dto.SampleOutDTO
     */
    @ServiceMethod
    public com.sample.dto.SampleOutDTO select(com.sample.dto.SampleInDTO input) throws Throwable {
    	
    	logger.info("########## TestAPP 호출 성공 ##############");
    	
    	SampleOutDTO output = new SampleOutDTO();
    	
    	output = sampleEC.select(input);
    	
    	
        return output;
    }
    
}

