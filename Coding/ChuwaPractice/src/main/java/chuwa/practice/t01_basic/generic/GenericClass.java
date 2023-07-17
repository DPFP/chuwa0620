package chuwa.practice.t01_basic.generic;

public class GenericClass <T>{
    T obj;

    public GenericClass (T t) {
        this.obj = t;
    }

    public T getObj(){
        return obj;
    }
}
