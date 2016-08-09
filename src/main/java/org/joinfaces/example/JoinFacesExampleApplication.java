package org.joinfaces.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
/* Uncomment this if you want to run with executable jetty war
(exclude = org.joinfaces.jetty.JettySpringBootAutoConfiguration.class)
*/
/* Uncomment this if you want to run with executable undertow war
(exclude = org.joinfaces.undertow.UndertowSpringBootAutoConfiguration.class)
*/
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
