package Singleton.demo9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {
    public static void main(String[] args) throws Exception {
        // writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    // write data(object) to file
    public static void writeObject2File() throws Exception {
        // get object
        Singleton instance = Singleton.getInstance();
        // create object output stream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        // write object
        oos.writeObject(instance);
        // close
        oos.close();
    }

    // get data(object) from file
    public static void readObjectFromFile() throws Exception {
        // create input stream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        // read object
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);
        // close resource
        ois.close();
    }
}