/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

/**
 *
 * @author makki
 */
public class LangDetect {
    String profileDirectory;
    
    public LangDetect () throws LangDetectException {
        profileDirectory = "C:\\Users\\makki\\Documents\\NetBeansProjects\\ITSQ-Project\\trunk\\profiles";
        DetectorFactory.loadProfile(profileDirectory);
    }
    
    public String detect(String input) throws LangDetectException  {
        Detector detector = DetectorFactory.create();
        detector.append(input);
        return detector.detect();
    }

}
