package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/16/23$
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
