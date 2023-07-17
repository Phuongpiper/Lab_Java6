package com.example.demo.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "{NotBlank.student2.email}")
    @Email(message = "{Email.student2.email}")
    private String email;

    @NotBlank(message = "{NotBlank.student2.fullName}")
    private String fullName;

    @NotNull(message = "{NotNull.student2.marks}")
    @PositiveOrZero(message = "{PositiveOrZero.student2.marks}")
    @Max(message = "{Max.student2.marks}", value = 10)
    private Double marks;

    @NotNull(message = "{NotNull.student2.gender}")
    private Boolean gender;

    @NotBlank(message = "{NotBlank.student2.country}")
    private String country;
}
