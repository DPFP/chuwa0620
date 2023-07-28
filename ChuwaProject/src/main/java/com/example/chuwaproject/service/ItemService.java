package com.example.chuwaproject.service;

import com.example.chuwaproject.bean.Item;
import com.example.chuwaproject.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao){this.itemDao = itemDao;}

    public List<Item> getAllItems(){return itemDao.findAll();}
}
