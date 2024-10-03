package com.tq.tq;

import com.tq.tq.persistence.postgre.entity.listener.AuditListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class TqApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TqApplication.class, args);
		AuditListener.setApplicationContext(context);
	}


}
