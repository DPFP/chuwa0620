package com.example.chuwaproject.dao;

import com.example.chuwaproject.bean.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item,Long> {
}
