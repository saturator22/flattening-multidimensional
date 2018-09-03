package com.codecool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FlatteningTest {
    Flattening flattening;

    List<Object> firstCaseSetup() {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> nested = new ArrayList<>();
        nested.add("age");
        nested.add(5);
        ArrayList<Object> secondNested = new ArrayList<>();
        ArrayList<Object> thirdNested = new ArrayList<>();
        ArrayList<Object> fourthNested = new ArrayList<>();
        secondNested.add(1);
        fourthNested.add(4);
        fourthNested.add(5);
        thirdNested.add(3);
        thirdNested.add(fourthNested);
        thirdNested.add("codecool");
        secondNested.add(thirdNested);
        secondNested.add(6);
        secondNested.add(7);
        list.add(1);
        list.add(3);
        list.add(nested);
        list.add("Kraków");
        list.add(secondNested);

        return list;
    }

    @Test
    void testFirst() {
        flattening = new Flattening();
        flattening.flat(firstCaseSetup());

        assertEquals("[1, 3, age, 5, Kraków, 1, 3, 4, 5, codecool, 6, 7]",
                    flattening.flatten.toString());
    }

    List<Object> secondCaseSetup() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add("codecool");
        list.add(5);
        list.add(8);

        return list;
    }

    @Test
    void testSecond() {
        flattening = new Flattening();

        flattening.flat(secondCaseSetup());

        assertEquals("[1, 3, codecool, 5, 8]", flattening.flatten.toString());
    }
}
