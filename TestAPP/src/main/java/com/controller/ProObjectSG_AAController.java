package com.controller;

import com.sample.pc.SamplePC;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import com.tmax.proobject.core2.service.ServiceName;
import com.tmax.proobject.core2.annotation.ProObjectController;
import com.tmax.proobject.model.context.Header;
import com.tmax.proobject.model.network.context.RequestContext;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.network.parser.ProObjectBodyParser;
import com.tmax.proobject.engine.parser.DefaultProObjectBodyParser;
import com.tmax.proobject.runtime.ProObjectControllerInput;
import com.tmax.proobject.runtime.ProObjectControllerOutput;
import com.tmax.proobject.runtime.context.ServiceContextHolder;
import com.tmax.proobject.runtime.util.ParserUtil;
import com.tmax.proobject.service.util.ProObjectControllerUtil;
import com.tmax.proobject.runtime.memory.validator.ValidExecutor;

@javax.annotation.Generated(
    value = "com.tmaxsoft.sts4.codegen.controller.POControllerGenerator",
    date= "24. 2. 8. 오후 2:11",
    comments= "SG_AAController"
)

@Component(value="ProObjectSG_AAController")
@EnableAutoConfiguration
@ProObjectController
public class ProObjectSG_AAController
{
    @Autowired
    SamplePC _SamplePC;
    
    @Autowired
    ValidExecutor validExecutor;
    public Object executeSamplePC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.sample.dto.SampleInDTO svcInput;
        Header header = null;
        ProMapperMessageType msgType;
        
        ProObjectBodyParser parser = null;
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        if (fromDispatcher) {
            parser = ParserUtil.getProObjectBodyParser(serviceName);
            
            msgType = controllerInput.getRequestMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            header = ProObjectControllerUtil.unmarshalHeader(controllerInput.getHeaderBytes(), serviceName, requestContext, msgType, parser);
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.sample.dto.SampleInDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.sample.dto.SampleInDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.sample.dto.SampleInDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.sample.dto.SampleOutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _SamplePC.select(svcInput);
            validExecutor.execute(svcOutput);
        } catch (Throwable e) {
            ProObjectControllerUtil.handleServiceError(serviceName, requestContext, svcInput, e, fromDispatcher); // rollback
            throw e;
        }
        
        ProObjectControllerUtil.handlePostService(serviceName, requestContext, svcInput, svcOutput, fromDispatcher); // commit
        ServiceContextHolder.removeServiceContext();
        
        if (fromDispatcher) {
            ProObjectControllerOutput controllerOutput = new ProObjectControllerOutput();
            
            msgType = controllerInput.getResponseMessageType();
            
            if(parser instanceof DefaultProObjectBodyParser) {
                headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
                ((DefaultProObjectBodyParser)parser).setHeaderMsg(headerMsg);
            }
            controllerOutput.setHeaderBytes(ProObjectControllerUtil.marshalHeader(header, serviceName, requestContext, msgType, parser));
            
            if(parser instanceof DefaultProObjectBodyParser) {
                dtoMsg = new com.sample.dto.SampleOutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
}
