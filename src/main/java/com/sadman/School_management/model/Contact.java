package com.sadman.School_management.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact extends BaseEntity{
    private int contactId;
    @NotBlank(message = "Name must not be empty")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message="Mobile number must not be empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message="Email must not be empty")
    @Email(message = "Please provide a valid email address" )
    private String email;

    @NotBlank(message="Subject must not be empty")
    @Size(min=5, message="Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message="Message must not be empty")
    @Size(min=10, message="Message must be at least 10 characters long")
    private String message;

    private String status;

}
