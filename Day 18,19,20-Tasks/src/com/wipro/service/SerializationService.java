package com.wipro.service;

import com.wipro.model.CustomObject;

import java.io.*;

public class SerializationService {

    public void serializeObject(CustomObject obj, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);
            System.out.println("Object serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CustomObject deserializeObject(String filename) {
        CustomObject obj = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            obj = (CustomObject) ois.readObject();
            System.out.println("Object deserialized successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
