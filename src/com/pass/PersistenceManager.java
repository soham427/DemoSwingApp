package com.pass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO Throw all errors instead of ambiguous returns
public class PersistenceManager {

    /**
     * Method stores an object of type Serializable to the disk persistently
     *
     * @param object   The object to store
     * @param filePath The storage path for the object
     * @return false if an exception occurs, otherwise true
     */
    public static boolean storeObject(Object object, String filePath) {
        try (FileOutputStream fileStream = new FileOutputStream(filePath);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method reads an object of type Serializable from the disk and returns it
     *
     * @param filePath Path of the file to be loaded from disk
     * @return Object that has been read from the disk, null in case of exceptions
     */
    public static Object loadObject(String filePath) {
        try (FileInputStream fileStream = new FileInputStream(filePath);
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            return objectStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}