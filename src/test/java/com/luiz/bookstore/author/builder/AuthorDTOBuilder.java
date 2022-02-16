package com.luiz.bookstore.author.builder;

import com.luiz.bookstore.dtos.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Integer id = 1;

    @Builder.Default
    private final String name = "Luiz Felipe ";

    @Builder.Default
    private final Integer age = 25;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);
    }
}
