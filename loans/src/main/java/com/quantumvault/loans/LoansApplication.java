package com.quantumvault.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice REST API",
				version = "v1",
				description = "QuantumVault Accounts Microservice REST API documentation",
				license = @License(
						name = "Apache 2.0",
						url = "https://apache.org"
				),
				contact = @Contact(
						name = "Rushikesh Nagothanekar",
						email = "rushikeshnagothanekar@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "QuantumVault Loans Microservice REST API Documentation",
				url = "https://quantumvault.com"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
