package com.controller;

import com.sample.pc.TestPC;
import com.assignment01.q01.pc.Q01PC;
import com.assignment01.q02.pc.Q02PC;
import com.assignment01.q03.pc.Q03PC;
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
    date= "24. 3. 21. 오후 8:21",
    comments= "SG_AAController"
)

@Component(value="ProObjectSG_AAController")
@EnableAutoConfiguration
@ProObjectController
public class ProObjectSG_AAController
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
    public Object executeTestPC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.sample.dto.SampleDTO svcInput;
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
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _TestPC.select(svcInput);
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
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeTestPC_logCall(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.sample.dto.SampleDTO svcInput;
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
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.sample.dto.SampleDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.sample.dto.SampleDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.sample.dto.SampleDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _TestPC.logCall(svcInput);
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
                dtoMsg = new com.sample.dto.SampleDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ01pc_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.select(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ01pc_insert(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.insert(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ01pc_update(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.update(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ01pc_delete(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q01PC.delete(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ02PC_select(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q02PC.select(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
    public Object executeQ03PC_error(ProObjectControllerInput controllerInput) throws Throwable {
        ServiceName serviceName = controllerInput.getServiceName();
        RequestContext requestContext = controllerInput.getRequestContext();
        ServiceContextHolder.getServiceContext().setRequestContext(requestContext);
    
        boolean fromDispatcher = (controllerInput.getServiceInputObject() == null);
    
        com.assignment01.q01.dto.q01InDTO svcInput;
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
                dtoMsg = new com.assignment01.q01.dto.q01InDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setInputMsg(dtoMsg);
            }
            svcInput = (com.assignment01.q01.dto.q01InDTO) ProObjectControllerUtil.unmarshalInput(controllerInput.getServiceInputBytes(), serviceName, requestContext, msgType, parser);
        } else {
            svcInput = (com.assignment01.q01.dto.q01InDTO) controllerInput.getServiceInputObject();
        }
        
        ProObjectControllerUtil.handlePreService(serviceName, requestContext, svcInput); // getTransaction
        
        com.assignment01.q01.dto.q01OutDTO svcOutput = null;
        try {
            validExecutor.execute(svcInput);
            svcOutput = _Q03PC.error(svcInput);
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
                dtoMsg = new com.assignment01.q01.dto.q01OutDTOMsgJson();
                ((DefaultProObjectBodyParser)parser).setOutputMsg(dtoMsg);
            }
            controllerOutput.setOutputBytes(ProObjectControllerUtil.marshalOutput(svcOutput, serviceName, requestContext, msgType, parser));
            
            return controllerOutput;
        } else {
            return svcOutput;
        }
    }
}
