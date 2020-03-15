package com.company;

import java.util.*;

public class AutocompleteEngine {
    String[] autocompleteTerms;
    String inputTerm;
    List<HashMap<Character, Set<String>>> fullLetterDictionary;
    private AutocompleteEngine(){}
    public AutocompleteEngine(String[] autocompleteTerms){
        initialize(autocompleteTerms);
    }
    private void initialize(String[] autocompleteTerms){
        int sizeOfLargestWord = findLargestSizeStr(autocompleteTerms);
        fullLetterDictionary = new ArrayList<>(sizeOfLargestWord);
        HashMap<Character, Set<String>> termDictionary;
        for(int i = 0; i < sizeOfLargestWord; i++) {
            termDictionary = new HashMap<>();
            for (String term : autocompleteTerms) {
                try {
                    if (termDictionary.containsKey(term.toLowerCase().charAt(i))) {
                        Set<String> listChainedToKey = termDictionary.get(term.toLowerCase().charAt(i));
                        listChainedToKey.add(term.toLowerCase());
                        termDictionary.replace(term.toLowerCase().charAt(i), listChainedToKey);
                    } else {
                        Set<String> matchingFirstLetterList = new HashSet<>();
                        matchingFirstLetterList.add(term);
                        termDictionary.put(term.toLowerCase().charAt(i), matchingFirstLetterList);
                    }
                }
                catch(StringIndexOutOfBoundsException e){}
            }
            fullLetterDictionary.add(termDictionary);
        }
    }
    private int findLargestSizeStr(String[] termsToParse) {
        //O(n)
        int max = 0;
        for (int i = 0; i < termsToParse.length; i++) {
            if (max < termsToParse[i].length()) {
                max = termsToParse[i].length();
            }
        }
        return max;
    }
    public Set<String> search(String inputTerm){
        Set<String> results = new HashSet<>();
        if(!inputTerm.isEmpty() && fullLetterDictionary.get(0).get(inputTerm.charAt(0))!=null){
            results = fullLetterDictionary.get(0).get(inputTerm.charAt(0));
            for (int i = 1; i < inputTerm.length(); i++) {
                results.retainAll(fullLetterDictionary.get(i).get(inputTerm.charAt(i)));
                if (results.isEmpty()) {
                    break;
                }
            }
        }
        return results;
    }
}
