package com.anabneri.messagingsystem.notfication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EntityScan("com.anabneri.messagingsystem.notfication.model")
@EnableJpaRepositories("com.anabneri.messagingsystem.notfication.repository")
@ComponentScan("com.anabneri.messagingsystem.notfication")
@EnableWebSocket
@EnableWebSocketMessageBroker
@EnableJpaAuditing
public class NotficationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotficationApplication.class, args);
	}

}
