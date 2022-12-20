package com.example.assignment_day8.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data @AllArgsConstructor @Entity @NoArgsConstructor
public class User {
    @Id
    @NotNull(message = "Your id can't be empty!!")
    private Integer Id;
    @NotBlank(message = "Your name can't be empty!")
    @Size(min = 5, message = "Your name must have more than 4 letters!")
    private String name;
    @NotEmpty(message = "Your username can't be empty!")
    @Column(unique = true)
    @Size(min = 5 , message = "Username should be 5 or more letters!")
    private String username;
    @NotNull(message = "your pass can't be null")
    private Integer password;
    @NotEmpty(message = "write ur email!")
    @Email
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "enter your role")
    @Column(columnDefinition = "check ( role='user' or role='admin' )")
    private String role;
    @NotNull(message = "input your age!")
    private Integer age;

}
