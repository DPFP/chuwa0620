package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAuthorByIdBetween(long a, long b);
}
