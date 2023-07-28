package com.example.chuwaproject.controller;

import com.example.chuwaproject.bean.Item;
import com.example.chuwaproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {
    private ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> getAllItems(){return this.itemService.getAllItems();}
}
