package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Flattening {

    List<Object> flatten = new ArrayList<>();

    public void flat(List<Object> list) {
        for(Object object : list) {
            if(object instanceof ArrayList) {
                flat((ArrayList) object);
            } else {
                flatten.add(object);
            }
        }
    }
}
