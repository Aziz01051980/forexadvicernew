package myforexhelp.realtime;

import myforexhelp.realtime.Controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"myforexhelp.realtime.Controller"})
public class RealtimeApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RealtimeApplication.class, args);
		System.out.println("Hello world");
	}
}
