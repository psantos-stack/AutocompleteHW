package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] autocorrectTerms={"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        AutocompleteEngine a = new AutocompleteEngine(autocorrectTerms);
        System.out.println(a.fullLetterDictionary);
        System.out.println(a.search("ho"));
    }
}
