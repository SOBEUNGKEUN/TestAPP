package com.controller;

import com.sample.pc.TestPC;
import com.assignment01.q01.pc.Q01PC;
import com.assignment01.q02.pc.Q02PC;
import com.assignment01.q03.pc.Q03PC;
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
    date= "24. 3. 21. 오후 8:21",
    comments= "SG_AAController"
)

@Controller
public class SpringSG_AAController
{
    @Autowired
    TestPC _TestPC;
    
    @Autowired
    Q01PC _Q01PC;
    
    @Autowired
    Q02PC _Q02PC;
    
    @Autowired
    Q03PC _Q03PC;
    
    @Autowired
    ValidExecutor validExecutor;
    @RequestMapping(value="/TestAPP/SG_AA/TestPC_select", method=RequestMethod.POST)
    public void executeTestPC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.TestPC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.sample.dto.SampleDTO svcInput = (com.sample.dto.SampleDTO)protocol.getDto();
        com.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _TestPC.select(svcInput);
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
            dtoMsg = new com.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/TestPC_logCall", method=RequestMethod.POST)
    public void executeTestPC_logCall(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.TestPC_logCall");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.sample.dto.SampleDTO svcInput = (com.sample.dto.SampleDTO)protocol.getDto();
        com.sample.dto.SampleDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _TestPC.logCall(svcInput);
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
            dtoMsg = new com.sample.dto.SampleDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q01pc_select", method=RequestMethod.POST)
    public void executeQ01pc_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q01pc_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.select(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q01pc_insert", method=RequestMethod.POST)
    public void executeQ01pc_insert(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q01pc_insert");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.insert(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q01pc_update", method=RequestMethod.POST)
    public void executeQ01pc_update(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q01pc_update");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.update(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q01pc_delete", method=RequestMethod.POST)
    public void executeQ01pc_delete(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q01pc_delete");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.delete(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q02PC_select", method=RequestMethod.POST)
    public void executeQ02PC_select(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q02PC_select");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q02PC.select(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
    @RequestMapping(value="/TestAPP/SG_AA/Q03PC_error", method=RequestMethod.POST)
    public void executeQ03PC_error(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ProMapperMessageType msgType = SpringControllerUtil.getMsgType(request, response);
        
        ProObjectHttpProtocol protocol = null;
        ServiceName serviceName = new ServiceName("TestAPP.SG_AA.Q03PC_error");
       
        RequestContext requestContext = SpringControllerUtil.createRequestContext(serviceName);
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
        
        AbstractMessage headerMsg = null;
        AbstractMessage dtoMsg = null;
        
        HttpBodyParser parser = ParserUtil.getHttpBodyParser(serviceName);
        if (parser instanceof DefaultHttpBodyParser) {
            headerMsg = new com.tmax.proobject.model.context.HeaderMsgJson();
            ((DefaultHttpBodyParser)parser).setHeaderMsg(headerMsg);
            dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setInputMsg(dtoMsg);
        }
        
        protocol = SpringControllerUtil.unmarshalRequestBody(request.getInputStream(), serviceName, requestContext, msgType, parser);
        
        com.assignment01.q01.dto.q01InDTO svcInput = (com.assignment01.q01.dto.q01InDTO)protocol.getDto();
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        
        SpringControllerUtil.handlePreService(serviceName, requestContext, svcInput);
        
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q03PC.error(svcInput);
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
            dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
            ((DefaultHttpBodyParser)parser).setOutputMsg(dtoMsg);
        }
        byte[] outputProtocolBytes = SpringControllerUtil.marshalResponseBody(protocol, serviceName, requestContext, msgType, parser);
        SpringControllerUtil.writeServiceResponseBody(response, outputProtocolBytes, serviceName, requestContext);
        
        return;
    }
    
}
