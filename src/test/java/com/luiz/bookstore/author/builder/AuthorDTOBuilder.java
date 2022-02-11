package com.luiz.bookstore.author.builder;

import com.luiz.bookstore.dtos.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Integer id = 1;

    @Builder.Default
    private final String name = "Valdir Cezar";

    @Builder.Default
    private final Integer age = 27;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);
    }
}
