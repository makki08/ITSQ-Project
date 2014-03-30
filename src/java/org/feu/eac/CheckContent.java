/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import pitt.search.semanticvectors.FlagConfig;
import pitt.search.semanticvectors.SearchResult;

/**
 *
 * @author makki
 */
public class CheckContent {

    String[] st;
    List<String> strlist;

    public CheckContent(String input) {
        strlist = new ArrayList<String>();
        strlist.add("-queryvectorfile");
        strlist.add("termvectors.bin");
        strlist.add("-searchvectorfile");
        strlist.add("docvectors.bin");
        st = input.toLowerCase().trim().split("\\s");
        for (String s : st) {
            if (s.equalsIgnoreCase("not")) {
                continue;
            } else {
                strlist.add(s);
            }
        }
    }

    public String getContentScore() {
        String[] strarray = strlist.toArray(new String[0]);
        FlagConfig config = FlagConfig.getFlagConfig(strarray);
        List<SearchResult> results = pitt.search.semanticvectors.Search.runSearch(config);
        String contentScore = "";
        for (SearchResult result : results) {
            contentScore = result.getObjectVector().getObject().toString();
            break;
//            System.out.println(String.format(
//                    "%f:%s",
//                    result.getScore(),
//                    result.getObjectVector().getObject().toString()));
        }

        return contentScore;
    }
}
