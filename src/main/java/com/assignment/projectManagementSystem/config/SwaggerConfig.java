package com.assignment.projectManagementSystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Project Management System",
                description = "Implementation of CRUD operation for Project Management System",
                contact = @Contact(
                        name = "Ali Kamran Ansari",
                        email = "ali.ansarikamran@gmail.com"
                        ),
                version = "v1"
        )
)


public class SwaggerConfig {

}
