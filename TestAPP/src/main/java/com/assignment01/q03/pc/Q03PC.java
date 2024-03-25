package com.assignment01.q03.pc;

import org.springframework.stereotype.Service;

import com.assignment01.q01.dto.q01OutDTO;
import com.tmax.proobject.core2.annotation.ServiceMethod;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 3. 21. 오후 8:20",
	comments= "Q03PC"
)
@Service
public class Q03PC{
    
    /**
     * @param com.assignment01.q01.dto.q01InDTO
     * @return com.assignment01.q01.dto.q01OutDTO
     */
    @ServiceMethod
    public com.assignment01.q01.dto.q01OutDTO error(com.assignment01.q01.dto.q01InDTO input) throws Throwable {
        
    	q01OutDTO output = new q01OutDTO();
    	
    	throw new Exception();
    	
//    	return output;
    }
    
}

