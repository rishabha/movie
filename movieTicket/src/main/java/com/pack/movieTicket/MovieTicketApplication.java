package com.pack.movieTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EntityScan( basePackages = {"com.pack.entity"} )
@ComponentScan(basePackages= {"com.pack.*"})
@EnableSwagger2
@SpringBootApplication
public class MovieTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketApplication.class, args);
	}

}
