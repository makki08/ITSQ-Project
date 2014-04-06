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
    private static double CONTENTWEIGHT = 70.0;
    private static double GRAMMARWEIGHT = 30.0;
    private double contentScore;
    private double grammarScore;
    private int correctSentences;
    
    public Scoring() {
        contentScore = 0.0;
        grammarScore = 0.0;
        correctSentences = 0;
    }

    public static double getCONTENTWEIGHT() {
        return CONTENTWEIGHT;
    }

    public static void setCONTENTWEIGHT(double contentWeight) {
        Scoring.CONTENTWEIGHT = contentWeight;
    }

    public static double getGRAMMARWEIGHT() {
        return GRAMMARWEIGHT;
    }

    public static void setGRAMMARWEIGHT(double GRAMMARWEIGHT) {
        Scoring.GRAMMARWEIGHT = GRAMMARWEIGHT;
    }

    public double getContentScore() {
        return contentScore;
    }

    public void setContentScore(double contentScore) {
        this.contentScore = contentScore;
    }

    public double getGrammarScore() {
        return grammarScore;
    }

    public void setGrammarScore(int errors, int sentenceCount) {
        this.correctSentences = sentenceCount - errors;
        if (errors > sentenceCount) {
            this.grammarScore = 70;
        } else if ((((double)correctSentences/(double)sentenceCount) * 100) < 50) {
            this.grammarScore = 70;
        } else {
            this.grammarScore = ((double)correctSentences/(double)sentenceCount) * 100;
        }
    }
    
    public double getOverallScore () {
        double overallScore = 0.0;
        double contentPart = contentScore * (CONTENTWEIGHT/100);
        double grammarPart = grammarScore * (GRAMMARWEIGHT/100);
        
        overallScore = contentPart + grammarPart;
        
        return overallScore;
    }
}
