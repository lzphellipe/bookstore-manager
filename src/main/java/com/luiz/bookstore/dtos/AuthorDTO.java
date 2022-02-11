package com.luiz.bookstore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotBlank
    private Integer age;

}
