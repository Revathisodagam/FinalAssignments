package com.wipro.app;

import com.wipro.model.CustomObject;
import com.wipro.service.SerializationService;

public class SerializationDemo {
    public static void main(String[] args) {
       
        CustomObject objToSerialize = new CustomObject("John Doe", 30);

    
        SerializationService serializationService = new SerializationService();
        serializationService.serializeObject(objToSerialize, "customObject.ser");

      
        CustomObject deserializedObj = serializationService.deserializeObject("customObject.ser");

       
        if (deserializedObj != null) {
            System.out.println("Deserialized Object: " + deserializedObj);
        }
    }
}
