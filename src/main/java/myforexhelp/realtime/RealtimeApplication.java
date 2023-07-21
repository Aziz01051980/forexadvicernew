package myforexhelp.realtime;

import myforexhelp.realtime.config.SecurityConfig;
import myforexhelp.realtime.domain.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableAutoConfiguration
@ComponentScan("myforexhelp.realtime")
@EnableJpaRepositories
@SpringBootApplication
public class RealtimeApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RealtimeApplication.class, args);
		System.out.println("Application is running");
	}
}
