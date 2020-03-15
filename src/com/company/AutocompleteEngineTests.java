package com.company;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
public class AutocompleteEngineTests {
    static final String[] dictionary = {"apple", "bees", "beer", "bat", "batman", "battle", "credit", "credulous",
    "discard", "Disney", "Discord", "end", "ending", "enderman", "hello", "high", "seattle", "seatac", "see", "hollow",
    "how"};
    static final String[] requiredDictionary = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
    @Test
    public void testNoInput(){
        AutocompleteEngine e = new AutocompleteEngine(dictionary);
        assertEquals(new HashSet<>(), e.search(""));
    }
    @Test
    public void requiredTestH(){
        AutocompleteEngine e = new AutocompleteEngine(requiredDictionary);
        Set<String> expected = new HashSet<>();
        for(int i = 0; i < 4; i++){
            if(i > 1){
                expected.add(requiredDictionary[i+3]);
            }
            else{
                expected.add(requiredDictionary[i]);
            }
        }
        assertEquals(expected, e.search("h"));
    }
    @Test
    public void requiredTestSe(){
        AutocompleteEngine e = new AutocompleteEngine(requiredDictionary);
        Set<String> expected = new HashSet<>();
        for(int i = 2; i < 5; i++){
            expected.add(requiredDictionary[i]);
        }
        assertEquals(expected, e.search("se"));
    }
    @Test
    public void requiredTestSea(){
        AutocompleteEngine e = new AutocompleteEngine(requiredDictionary);
        Set<String> expected = new HashSet<>();
        for(int i = 2; i < 4; i++){
            expected.add(requiredDictionary[i]);
        }
        assertEquals(expected, e.search("sea"));
    }
    @Test
    public void requiredTestHo(){
        AutocompleteEngine e = new AutocompleteEngine(requiredDictionary);
        Set<String> expected = new HashSet<>();
        expected.add("how");
        expected.add("hollow");
        assertEquals(expected, e.search("ho"));
    }
    @Test
    public void requiredTestXyz(){
        AutocompleteEngine e = new AutocompleteEngine(requiredDictionary);
        Set<String> expected = new HashSet<>();
        assertEquals(expected, e.search("xyz"));
    }
}
