package com.chuwa.com.redbook.dao;

import com.chuwa.com.redbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
