package com.assignment01.q03.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ApplicationLogger;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.ServiceLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.PreProcessor;

@Component(value = "PreProcessor")
public class q03PreProcessor implements PreProcessor {

	// PO 로그
	ProObjectLogger logger = SystemLogger.getLogger();
	ProObjectLogger appLogger = ApplicationLogger.getLogger();
	ProObjectLogger svcLogger = ServiceLogger.getLogger();
	
	@Override
	public Object processPreProcess(RequestContext requestContext, ServiceName serviceName, Object object) {
		
		// TODO Auto-generated method stub
		logger.info("\n [PO-21 q03] processPreProcess Start \n");
		
		logger.info("\n [PO-21 q03] processPreProcess RequestContext : "+requestContext);
		
		logger.info("\n [PO-21 q03] processPreProcess ServiceName : "+serviceName);
		// input
		logger.info("\n [PO-21 q03] processPreProcess Object : "+object);
		
		return null;
	}

}
