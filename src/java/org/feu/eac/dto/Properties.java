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
public class Properties {
    private static String topic;
    private static int filesInCorpus;
    private static int numberOfSubmittesEssays;

    public Properties() {
        this.topic = "";
        this.filesInCorpus = 0;
        this.numberOfSubmittesEssays = 0;
    }

    

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        Properties.topic = topic;
    }

    public int getFilesInCorpus() {
        return filesInCorpus;
    }

    public void setFilesInCorpus(int filesInCorpus) {
        Properties.filesInCorpus = filesInCorpus;
    }

    public int getNumberOfSubmittesEssays() {
        return numberOfSubmittesEssays;
    }

    public void setNumberOfSubmittesEssays(int numberOfSubmittesEssays) {
        Properties.numberOfSubmittesEssays = numberOfSubmittesEssays;
    }
    
}
