package org.demo.websocket;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnError;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint(value = "/push", encoders = { SPMessageEncoder.class })
public class WebSocketInteraction {

    @OnMessage
    public void onMessage(String message, final Session session) {

    	Message mObj = new Message("Message from S&P Global", "Get latest news here !!", "");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                	mObj.setId(session.getId());
                    session.getBasicRemote().sendObject(mObj);;
                } catch (Exception ex) {
                	ex.printStackTrace();
                }
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 3 * 5000);
    }


    @OnOpen
    public void onOpen(Session session) throws IOException {    	
    	System.out.println("Connection established !!");
    }


    @OnClose
    public void onClose(Session session) throws IOException {
    	
    	System.out.println("Connection Closed !!");

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    	try {
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

    }
}