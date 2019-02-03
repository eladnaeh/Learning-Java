package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        String sentence = "every the I go to school";
        String[] arrayWords = sentence.split(" ");
        words.addAll(arrayWords);
    }
}
