package com.Hbaraki.calender;

import com.Hbaraki.calender.model.Content;
import com.Hbaraki.calender.model.Status;
import com.Hbaraki.calender.model.Type;
import com.Hbaraki.calender.repository.ContentCollectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class CalenderApplication {

	public static void main(String[] args) {

	 SpringApplication.run(CalenderApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner(ContentCollectionRepository repository){
		return args ->{
			Content c =new Content(1,
					"my first Blog post",
					"my first Blog post",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					"");
			repository.save(c);
		};
	}

}
