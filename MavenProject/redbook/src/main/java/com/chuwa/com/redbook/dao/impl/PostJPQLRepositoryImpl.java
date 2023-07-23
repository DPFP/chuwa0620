package com.chuwa.com.redbook.dao.impl;

import com.chuwa.com.redbook.dao.PostJPQLRepository;
import com.chuwa.com.redbook.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Post insertPost(Post post) {
        return entityManager.merge(post);
    }
}
