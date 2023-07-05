package org.example;

/**
 * Hello world!
 *
 */
public class GenericClass<T>
{
    T obj;
    public GenericClass(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}
