package com.test.socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//WebSocket 서버
@ServerEndpoint("/server") //종단점
public class SocketServer {
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	//클라이언트가 연결 요청을 했을 때 발생
	@OnOpen
	public void handleOpen() {
		//System.out.println("클라이언트가 접속했습니다.");
		logger.info("클라이언트가 접속했습니다."); //일반 메시지
		//logger.debug(""); //상세 메시지
		//logger.error(""); //에러
		//logger.trace(""); //
	}
	
	//클라이언트가 메시지를 전송했을 때 발생
	@OnMessage
	public String handleMessage(String msg) {
		
		logger.info("클라이언트가 메시지를 보냈습니다. > " + msg);
		
		return "(응답)" + msg;
	}
	
	//연결이 종료될 때 발생
	@OnClose
	public void handleClose() {
		
		logger.info("클라이언트와 연결이 종료되었습니다.");
	}
	
	//에러
	@OnError
	public void handleError(Throwable e) {
		logger.info("에러 발생" + e.getMessage());
	}
	
}
