/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import java.util.List;
import org.tartarus.snowball.ext.EnglishStemmer;

/**
 *
 * @author makki
 */
public class Stemmer {
    //List<String> strlist;
    String[] str;
    
    public Stemmer(String input) {
        str = input.trim().toLowerCase().split("\\s");
//        for (String s : str) {
//            strlist.add(s);
//        }
    }
    
    public String getStem () {
        String stemmed = "";
        EnglishStemmer stemmer = new EnglishStemmer();
        
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            stemmer.setCurrent(s);
            stemmer.stem();
            result.append(stemmer.getCurrent() + " ");
        }
        stemmed = result.toString();
        
        return stemmed;
    }
}
