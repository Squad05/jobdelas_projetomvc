package com.squad05.jobdelas.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker

public class ChatRepository implements WebSocketMessageBrokerConfigurer{

    @Override
    //As linhas comentadas estão com algum erro que eu não sei arrumar  =/ 

   // public void configureMessageBroker(MessageBrokerRegistry registry){
     //   registry.enableSimpleBroker(destinationPrefixes:"/chat");
    //    registry.setApplicationDestinationPrefixes(prefixes:"/ChatController");

   //}
    


    //@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/conect");
        registry.addEndpoint("/conect").withSockJS();


    }
    
}
