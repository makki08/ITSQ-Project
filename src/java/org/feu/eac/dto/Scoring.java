/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac.dto;

/**
 *
 * @author makki
 */
public class Scoring {
    private static double contentWeight = 70.0 ;
    private static double grammarWeight = 30.0;
    private double contentScore;
    private double grammarScore;
    
    public Scoring(double contentScore, int grammarScore) {
        this.contentScore = contentScore;
        this.grammarScore = (100 - grammarScore);
        if (this.grammarScore < 70) {
            this.grammarScore = 70;
        }
    }

    public static double getContentWeight() {
        return contentWeight;
    }

    public static void setContentWeight(float contentWeight) {
        Scoring.contentWeight = contentWeight;
    }

    public static double getGrammarWeight() {
        return grammarWeight;
    }

    public static void setGrammarWeight(float grammarWeight) {
        Scoring.grammarWeight = grammarWeight;
    }

    public double getContentScore() {
        return contentScore;
    }

    public void setContentScore(float contentScore) {
        this.contentScore = contentScore;
    }

    public double getGrammarScore() {
        return grammarScore;
    }

    public void setGrammarScore(float grammarScore) {
        this.grammarScore = grammarScore;
    }
    
    public double getOverallScore () {
        double overallScore = 0.0;
        double contentPart = contentScore * (contentWeight/100);
        double grammarPart = grammarScore * (grammarWeight/100);
        
        overallScore = contentPart + grammarPart;
        
        return overallScore;
    }
    
}
