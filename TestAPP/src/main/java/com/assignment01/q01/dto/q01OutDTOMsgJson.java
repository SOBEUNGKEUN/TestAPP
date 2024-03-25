package com.assignment01.q01.dto;
import com.tmax.proobject.model.message.AbstractMessage;
import com.tmax.proobject.model.message.exception.UnmarshalException;
import com.tmax.proobject.model.message.exception.MarshalException;
import com.tmax.proobject.core2.annotation.Message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import proobject.com.google.gson.stream.JsonReader;
import proobject.com.google.gson.stream.JsonWriter;
import proobject.com.google.gson.stream.JsonToken;

@javax.annotation.Generated(
	value = "com.tmaxsoft.sts4.codegen.message.MessageGenerator",
	date= "24. 3. 20. 오후 5:12"
)

@Message
public class q01OutDTOMsgJson extends AbstractMessage {
    public byte[] marshal(Object obj) throws MarshalException {
    	q01OutDTO _q01OutDTO = (q01OutDTO)obj;
    	
    	if (_q01OutDTO == null)
    		return null;
    	
    	BufferedWriter bw = null;
    	JsonWriter jw = null;
    	
    	try{
    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );
    		jw = new JsonWriter( bw );
    		jw.beginObject();
    
    		marshal( _q01OutDTO, jw);
    		
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
       	} catch(Exception e) {
       		throw new MarshalException(e);
       	} finally{
       		try {
       			if ( jw != null )
    				try {
    					jw.close();
    				} catch (IOException e) {
    					throw new MarshalException(e);
    				}
    		} finally {
    			if ( bw != null )
    				try {
    					bw.close();
    				} catch (IOException e) {
    					throw new MarshalException(e);
    				}
    		}
    	}
    }
    
    
    public void marshal(com.assignment01.q01.dto.q01OutDTO _q01OutDTO, JsonWriter writer )throws IOException {
    
    	writer.name("empno");
    	writer.value(_q01OutDTO.getEmpno());
    	writer.name("ename"); 
    	if (_q01OutDTO.getEname() != null) {
    		writer.value(_q01OutDTO.getEname());
    	} else {
    		writer.nullValue();
    	}
    }
    
    public String removeNullChar(String charString) {
    	if ( charString == null )
        	return "";
        
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0 ; i<charString.length(); i++) {
    		if (charString.charAt(i) == (char)0) {
    			sb.append("");
    		} else {
    			sb.append(charString.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    
    
    public q01OutDTO unmarshal(byte[] bytes) throws UnmarshalException {
    	q01OutDTO _q01OutDTO = new q01OutDTO();
    	BufferedReader reader = null;
    	JsonReader jr = null;
    
    	if ( bytes.length <= 0)
    		return new q01OutDTO();
    
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_q01OutDTO = (q01OutDTO)unmarshal( jr,  _q01OutDTO);
    
    		jr.endObject();
    		jr.close();
    
    	} catch(Exception e) {
    	    throw new UnmarshalException(e);
    	}finally{
    		try{
    			if ( jr != null )
    				try {
    					jr.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		} finally {
    			if ( reader != null )
    				try {
    					reader.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		}
    	}
    	return _q01OutDTO;
    }
    	
    public Object unmarshal(byte[] bytes, q01OutDTO dto) throws UnmarshalException {
    	
    	q01OutDTO _q01OutDTO = (q01OutDTO) dto;
    	BufferedReader reader = null;
    	JsonReader jr = null;
    	
    	if ( bytes.length <= 0)
    		return new q01OutDTO();
    	
    	try{
    		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
    		jr = new JsonReader( reader );                
    		jr.beginObject();
    
    		_q01OutDTO = (q01OutDTO)unmarshal( jr,  _q01OutDTO);
    
    		jr.endObject();
    		jr.close();
    	
    	} catch(Exception e) {
    		throw new UnmarshalException(e);
    	} finally {
    		try{
    			if ( jr != null ) 
    				try{
    					jr.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    		} finally {
    			if ( reader != null )
    				try {
    					reader.close();
    				} catch (IOException e) {
    					throw new UnmarshalException(e);
    				}
    			
    		}
    	}
    	                       
        return _q01OutDTO;
    }
    
    public q01OutDTO unmarshal(JsonReader reader, q01OutDTO dto) throws IOException {	
    	
    	while( reader.hasNext() ){
    		String name = reader.nextName();			
    		setField(dto, reader, name);
    	}
    	
    	return dto;
    }
    	 
    protected void setField(q01OutDTO dto, JsonReader reader, String name) throws IOException {
    	
    	switch(name) {
    		case "empno" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setEmpno( reader.nextInt());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		case "ename" :
    		{	
    			if (reader.peek() != JsonToken.NULL) {
    				dto.setEname( reader.nextString());
    			} else {
    				reader.nextNull();
    			}
    			break;
    		}	
    		default :
    		reader.skipValue();
    			break;
    	}
    }
    
    @Override
    public Object getDtoInstance() {        
       return new q01OutDTO();
    }
        
}
