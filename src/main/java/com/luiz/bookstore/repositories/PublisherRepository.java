package com.luiz.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.bookstore.domain.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
