package framework.services;

import framework.Requests;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader<T>{

    T object;
    Requests baseAPIRequests = new Requests();

    public JsonReader(T object) {
        this.object = object;
    }

    public T getDataFromJsonFile(String dataFileName) throws FileNotFoundException {
        return (T) baseAPIRequests.gson.fromJson(new FileReader((baseAPIRequests.confgReader.getProperty("testDataDirectory") + dataFileName)),
                object.getClass());
    }
}
