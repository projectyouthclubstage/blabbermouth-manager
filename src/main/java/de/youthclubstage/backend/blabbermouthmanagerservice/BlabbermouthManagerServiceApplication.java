package de.youthclubstage.backend.blabbermouthmanagerservice;

import de.youthclubstage.backend.blabbermouthmanagerservice.repository.MessageExtentedRepositoryImpl;
import de.youthclubstage.backend.blabbermouthmanagerservice.service.EventWriter;
import de.youthclubstage.blabbermouth.core.EnableBlabbermouth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableBlabbermouth
public class BlabbermouthManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlabbermouthManagerServiceApplication.class, args);
	}

}
