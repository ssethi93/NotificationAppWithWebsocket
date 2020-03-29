package org.demo.websocket;

import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class SPMessageEncoder implements Encoder.Text<Message>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Message object) throws EncodeException {
		
    	Gson oJson = new Gson();
    	return oJson.toJson(object).toString();
	}
	

}
