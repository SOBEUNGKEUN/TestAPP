package com.assignment01.q03.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PostProcessor;

@Component(value = "SGPostProcessor")
public class q03SGPostProcessor implements PostProcessor{

	// PO 로그
	ProObjectLogger logger = SystemLogger.getLogger();
	
	@Override
	public Object processPostProcess(RequestContext requestContext, ServiceName serviceName, Object object1, Object object2) {
		// TODO Auto-generated method stub
		
		logger.info("\n [PO-21 q03] processPostProcess Service Group Start \n");
		
		logger.info("\n [PO-21 q03] processPostProcess RequestContext : "+requestContext);
		
		logger.info("\n [PO-21 q03] processPostProcess ServiceName : "+serviceName);
		
		// input
		logger.info("\n [PO-21 q03] processPostProcess Object1 : "+object1);
		// output
		logger.info("\n [PO-21 q03] processPostProcess Object2 : "+object2);
		
		return null;
	}

	
}
