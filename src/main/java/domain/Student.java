package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String name;
    private String surname;
    private int year;
    private JsonObject[] pairs;


    public Student(String inputName, String inputSurname, Integer inputYear, Tuple<String, Integer>... exams) {
        this.name = inputName;
        this.surname = inputSurname;
        this.year = inputYear;
        this.pairs = new JsonObject[exams.length];
        int iterator = 0;
        for (Tuple<String, Integer> tuple : exams
                ) {
            pairs[iterator++] = (new JsonObject(new JsonPair("course", new JsonString(tuple.key)),
                    new JsonPair("mark", new JsonNumber(tuple.value)),
                    new JsonPair("passed", new JsonBoolean(checkIfPassed(tuple.value)))));
        }
    }

    public JsonObject toJsonObject() {
        JsonObject obj = new JsonObject();
        obj.add(new JsonPair("name", new JsonString(this.name)));
        obj.add(new JsonPair("surname", new JsonString(this.surname)));
        obj.add(new JsonPair("year", new JsonNumber(this.year)));
        obj.add(new JsonPair("exams", new JsonArray(pairs)));
        System.out.println(obj.toJson());
        return obj;
    }

    public boolean checkIfPassed(int mark) {
        return (mark >= 3);
    }
}
