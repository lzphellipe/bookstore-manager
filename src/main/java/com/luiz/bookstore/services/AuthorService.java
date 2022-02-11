package com.luiz.bookstore.services;

import com.luiz.bookstore.mappers.AuthorMapper;
import com.luiz.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private final static AuthorMapper AUTHOR_MAPPER = AuthorMapper.INSTANCE;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
