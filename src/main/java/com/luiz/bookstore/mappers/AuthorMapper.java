package com.luiz.bookstore.mappers;

import com.luiz.bookstore.domain.Author;
import com.luiz.bookstore.dtos.AuthorDTO;
import org.mapstruct.factory.Mappers;
import springfox.documentation.swagger2.mappers.LicenseMapper.LicenseTranslator;

@LicenseTranslator
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toModel(AuthorDTO authorDTO);

    AuthorDTO toDto (Author author);
}
