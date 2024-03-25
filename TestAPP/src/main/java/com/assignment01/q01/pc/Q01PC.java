package com.assignment01.q01.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment01.q01.dto.q01InDTO;
import com.assignment01.q01.dto.q01OutDTO;
import com.assignment01.q01.ec.q01EC;
import com.tmax.proobject.core2.annotation.ServiceMethod;

/**
 * @author user
 * @version
 * @see
 */
@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.service.ServiceGenerator",
	date= "24. 3. 21. 오후 7:05",
	comments= "Q01PC"
)
@Service
public class Q01PC{
   
	@Autowired
	q01EC q01EC; 
	
    /**
     * @param com.assignment01.q01.dto.q01InDTO
     * @return com.assignment01.q01.dto.q01OutDTO
     */
    @ServiceMethod	
    public com.assignment01.q01.dto.q01OutDTO select(com.assignment01.q01.dto.q01InDTO input) throws Throwable {
    	q01OutDTO output = new q01OutDTO();	
    	output = q01EC.select(input);   	
        return output;
    }
    
    /**
     * @param com.assignment01.q01.dto.q01InDTO
     * @return com.assignment01.q01.dto.q01OutDTO
     */
    @ServiceMethod
    public com.assignment01.q01.dto.q01OutDTO insert(com.assignment01.q01.dto.q01InDTO input) throws Throwable {
    	q01OutDTO output = new q01OutDTO();
    	q01EC.insert(input);
        return output;
    }

	/**
	 * @param com.assignment01.q01.dto.q01InDTO
	 * @return com.assignment01.q01.dto.q01OutDTO
	 */
	@ServiceMethod
	public q01OutDTO update(q01InDTO input) throws Throwable {
		// TODO Auto-generated method stub
		q01OutDTO output = new q01OutDTO();	
		q01EC.update(input);	
		return output;
	}

	/**
	 * @param com.assignment01.q01.dto.q01InDTO
	 * @return com.assignment01.q01.dto.q01OutDTO
	 */
	@ServiceMethod
	public q01OutDTO delete(q01InDTO input) throws Throwable {
		// TODO Auto-generated method stub
		q01OutDTO output = new q01OutDTO();	
		q01EC.delete(input);
		return output;
	}
    
}

