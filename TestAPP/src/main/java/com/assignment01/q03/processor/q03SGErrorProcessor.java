package com.assignment01.q03.processor;

import org.springframework.stereotype.Component;

import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;
import com.tmax.proobject.service.processor.ErrorProcessor;

@Component(value = "SGErrorProcessor")
public class q03SGErrorProcessor implements ErrorProcessor {

	// PO 로그
	ProObjectLogger logger = SystemLogger.getLogger();

	@Override
	public void processServiceError(RequestContext requestContext, ServiceName serviceName, Object object, Throwable t) {
		// TODO Auto-generated method stub

		logger.info("\n [PO-21 q03] processErrorProcess Service Group Start \n");

		logger.info("\n [PO-21 q03] processErrorProcess RequestContext : " + requestContext);

		logger.info("\n [PO-21 q03] processErrorProcess ServiceName : " + serviceName);
		// input
		logger.info("\n [PO-21 q03] processErrorProcess Object : " + object);

		logger.info("\n [PO-21 q03] processErrorProcess Throwable : " + t);
		
	}

}
