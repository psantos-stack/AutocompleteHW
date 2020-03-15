package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] autocorrectTerms = {"ghost", "green", "jizz", "saucer", "train", "freedom", "generation"};
        AutocompleteEngine a = new AutocompleteEngine(autocorrectTerms);
        System.out.println(a.fullLetterDictionary);
        System.out.println(a.search("g"));
    }
}
