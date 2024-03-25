package com.sample.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.SampleDTO;
import com.sample.ec.TestEC;
import com.tmax.proobject.core2.annotation.ServiceMethod;
import com.tmax.proobject.model.network.context.RequestContext;
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
	comments= "TestPC"
)
@Service
public class TestPC{
    
	RequestContext requestContext;
	
	@Autowired
	TestEC testEC;
	
	
	public ProObjectLogger logger = SystemLogger.getLogger();
	
    /**
     * @param com.sample.dto.SampleDTO
     * @return com.sample.dto.SampleDTO
     */
    @ServiceMethod
    public SampleDTO select(SampleDTO input) throws Throwable {
    		
    	logger.info("########## TestAPP select 호출 성공 ###############");
    	
    	SampleDTO output = new SampleDTO();
    	
    	output = testEC.select(input);
    	 	
        return output;
    }

	/**
	 * @param com.sample.dto.SampleDTO
	 * @return com.sample.dto.SampleDTO
	 */
	@ServiceMethod
	public SampleDTO logCall(SampleDTO input) throws Throwable {
		logger.info("########## TestAPP logCall 호출 성공 ###############");
		// TODO Auto-generated method stub
		
		logger.info("########## TestAPP input \n"+input);
		
		SampleDTO output = new SampleDTO();
		
		output.setEmpno(input.getEmpno());
		output.setEname(input.getEname());
		
		//RequestContext = null
		logger.info("########## Log Test #1 ###############");
		logger.info("########## Log Test #2 ###############");
		logger.info("########## Log Test #3 ###############");
		logger.info("########## result : \n"+output);
		return output;
	}
    
}

