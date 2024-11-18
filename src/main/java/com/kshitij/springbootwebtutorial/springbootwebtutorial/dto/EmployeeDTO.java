package com.kshitij.springbootwebtutorial.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kshitij.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO  { //POJO class (Plain Old Java Object

    private Long id;

//    @NotNull(message = "Required field in Employee: name")
//    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 10, message = "size for name")
    private String name;

    @Email
    private String email;

    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18) // or @Min(12) is the same
    private Integer age;

    @NotBlank
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of the employee can be admin or user")
    @EmployeeRoleValidation
    private String role;

    @NotNull
    @Positive
    @Digits(integer = 6, fraction = 2, message = "Salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "Data of joining cannot be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
