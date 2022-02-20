package com.test.socket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//채팅 소켓 서버
@ServerEndpoint("/chatserver")
public class ChatServer {

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//현재 채팅 서버에 접속한 클라이언트 목록
	private static List<Session> list = new ArrayList<Session>();

	// 클라이언트가 연결 요청을 했을 때 발생
	@OnOpen
	public void handleOpen(Session session) {

		logger.info("클라이언트가 접속했습니다.");
		
		list.add(session);

	}

	// 클라이언트가 메시지를 전송했을 때 발생
	@OnMessage
	public void handleMessage(String msg, Session session) {

		//1#유저명
		//2#유저명
		int index = -1;
		String no = "";
		String user = "";
		
		index = msg.indexOf('#');
		no = msg.substring(0, 1);
		user = msg.substring(index+1);
		
		if (no.equals("1")) { //누군가가 접속
			
			for(Session s : list) {
				if (s != session) { //모든 접속자 중에서 메시지를 보낸 세션을 제외하고(방금 접속한 사람 빼고)
					//다른 사람들에게 현재 접속자를 알리는 메시지 전달
					try {
						s.getBasicRemote().sendText("1#" + user);						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (no.equals("2")) { //누군가가 종료
			
			list.remove(session);
			
			for(Session s : list) {
				try {
					//누군가가 나갔습니다 라는 메시지를 나머지 사람들에게 전달
					s.getBasicRemote().sendText("2#" + user);						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		/*
		try {
			
			for(Session session : list) {
				session.getBasicRemote().sendText(msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

	// 연결이 종료될 때 발생
	@OnClose
	public void handleClose() {

		logger.info("클라이언트와 연결이 종료되었습니다.");
	}

	// 에러
	@OnError
	public void handleError(Throwable e) {
		logger.info("에러 발생" + e.getMessage());
	}
}
