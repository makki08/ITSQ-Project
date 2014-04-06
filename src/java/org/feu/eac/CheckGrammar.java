/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.feu.eac.dto.ErrorMessage;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.Tagalog;
import org.languagetool.rules.RuleMatch;

/**
 *
 * @author makki
 */
public class CheckGrammar {
    JLanguageTool langTool;
    private int count;

    public CheckGrammar() throws IOException {
        this.langTool = new JLanguageTool(new AmericanEnglish());
        this.count = 0;
    }
       
    
    public List<ErrorMessage> getErrors(String input, String language) throws IOException {
        if (language.equals("English")) {
            langTool = new JLanguageTool(new AmericanEnglish());
        } else if (language.equals("Tagalog")) {
            langTool = new JLanguageTool(new Tagalog());
        }
        
        langTool.activateDefaultPatternRules();
        List<RuleMatch> matches = langTool.check(input);
                    
        List<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
        
        for (RuleMatch match : matches) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setLine_no(match.getLine());
            errorMessage.setColumn_no(match.getColumn());
            errorMessage.setDescription(match.getMessage());
            errorMessage.setSuggestion(match.getSuggestedReplacements());
            errorMessages.add(errorMessage);
        }
        
        langTool.check(input);
        count = langTool.getSentenceCount();
        
        return errorMessages;
    }

    public int getCount() {
        return count;
    }
    
}
