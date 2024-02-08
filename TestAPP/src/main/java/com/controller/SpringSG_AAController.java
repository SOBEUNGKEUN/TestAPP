package com.controller;

import com.sample.pc.SamplePC;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.protocol.http.ProObjectHttpProtocol;
import com.tmax.proobject.network.parser.HttpBodyParser;
import com.tmax.proobject.engine.parser.DefaultHttpBodyParser;
import com.tmax.proobject.service.util.SpringControllerUtil;
import com.tmax.proobject.service.exception.ProObjectServiceErrorHandlingException;
import com.tmax.proobject.runtime.context.ServiceContextHolder;
import com.tmax.proobject.runtime.util.ParserUtil;
import com.tmax.proobject.runtime.memory.validator.ValidExecutor;

@javax.annotation.Generated(
    value = "com.tmaxsoft.sts4.codegen.controller.SpringControllerGenerator",
    date= "24. 2. 8. 오후 2:11",
    comments= "SG_AAController"
)

@Controller
public class SpringSG_AAController
{
    @Autowired
    SamplePC _SamplePC;
    
    @Autowired
    ValidExecutor validExecutor;
    @RequestMapping(value="/TestAPP/SG_AA/SamplePC_select", method=RequestMethod.POST)
    public void executeSamplePC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.SamplePC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.sample.dto.SampleInDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.sample.dto.SampleInDTO svcInput = (com.sample.dto.SampleInDTO)protocol.getDto();
        com.sample.dto.SampleOutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            try {
                SpringControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e);
            } catch (Throwable e1) {
                Exception exception = new ProObjectServiceErrorHandlingException(e1);
                throw exception;
            }
            
            SpringControllerUtil.writeErrorResponseBody(response, e, svcInput, serviceName, requestContext, msgType, parser);
            ServiceContextHolder.removeServiceContext();
            return;
        }
        
        SpringControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput);
        ServiceContextHolder.removeServiceContext();
        
        protocol.setDto(svcOutput);
        
        if (parser instanceof DefaultHttpBodyParser) {
            dtoMsg = new com.sample.dto.SampleOutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
}
