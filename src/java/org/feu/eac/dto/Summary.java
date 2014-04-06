/*
 * To change this license header, choose License Headers in Project Summary.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac.dto;

import java.io.File;

/**
 *
 * @author makki
 */
public class Summary {
    private static String topic;
    private static int filesInCorpus;
    private static int numberOfSubmittesEssays;

    public static String getTopic() throws Exception {
        ReadFromDB read = new ReadFromDB();
        return read.getTopic();
    }

    public static int getFilesInCorpus() {
        return new File("C:/Users/makki/Documents/NetBeansProjects/ITSQ-Project/corpus").listFiles().length;
    }

    public static int getNumberOfSubmittesEssays() throws Exception {
        ReadFromDB read = new ReadFromDB();
        return read.getNumberOfEssays();
    }
}
