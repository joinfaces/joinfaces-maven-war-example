package org.joinfaces.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JoinFacesExampleApplication 
    extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JoinFacesExampleApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(JoinFacesExampleApplication.class, args);
	}
    
}
