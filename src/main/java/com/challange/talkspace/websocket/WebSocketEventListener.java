//package com.challange.talkspace.websocket;
//
//import com.challange.talkspace.model.Message;
//import com.challange.talkspace.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//public class WebSocketEventListener {
//
//    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
//
//    private SimpMessageSendingOperations messagingTemplate;
//
//    @Autowired
//    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//        logger.info("Received a new web socket connection");
//    }
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        User sender = (User) headerAccessor.getSessionAttributes().get("userName");
//
//        if (sender != null) {
//            logger.info("User Disconnected : " + sender);
//
//            Message chatMessage = new Message();
//            chatMessage.setType(Message.MessageType.LEAVE);
//            chatMessage.setSender(sender);
//
//            messagingTemplate.convertAndSend("/topic/publicChatRoom", chatMessage);
//        }
//    }
//}
