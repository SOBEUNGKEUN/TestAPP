package com.assignment01.q02.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment01.q01.dto.q01OutDTO;
import com.assignment01.q02.ec.q02EC;
import com.tmax.proobject.core2.annotation.ServiceMethod;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 3. 21. 오후 7:55",
	comments= "Q02PC"
)
@Service
public class Q02PC{
    
	@Autowired
	q02EC q02EC;
	
    /**
     * @param com.assignment01.q01.dto.q01InDTO
     * @return com.assignment01.q01.dto.q01OutDTO
     */
    @ServiceMethod
    public com.assignment01.q01.dto.q01OutDTO select(com.assignment01.q01.dto.q01InDTO input) throws Throwable {
    	
    	q01OutDTO output = new q01OutDTO();
    	
    	output = q02EC.select(input);
    	
        return output;
    }
    
}

