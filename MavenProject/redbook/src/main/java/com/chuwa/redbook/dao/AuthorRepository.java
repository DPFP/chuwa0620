package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
