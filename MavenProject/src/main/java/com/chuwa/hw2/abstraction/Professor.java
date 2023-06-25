package com.chuwa.hw2.abstraction;

public class Professor implements Faculty{
    @Override
    public void work(){
        System.out.println("Teaching");
    }
}
