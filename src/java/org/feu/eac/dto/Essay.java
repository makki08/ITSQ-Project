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
public class Essay {
    private int essay_id;
    private int student_num;
    private String student_name;
    private String student_year;
    private String student_section;
    private String content;
    private double overall_score;
    private double content_score;
    private double grammar_score;
    private String date;

    public Essay() {
        this.essay_id = 0;
        this.student_num = 0;
        this.student_name = "";
        this.student_year = "";
        this.student_section = "";
        this.content = "";
        this.overall_score = 0.0;
        this.content_score = 0.0;
        this.grammar_score = 0.0;
        this.date = "";
    }

    public int getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(int essay_id) {
        this.essay_id = essay_id;
    }

    public int getStudent_num() {
        return student_num;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_year() {
        return student_year;
    }

    public void setStudent_year(String student_year) {
        this.student_year = student_year;
    }

    public String getStudent_section() {
        return student_section;
    }

    public void setStudent_section(String student_section) {
        this.student_section = student_section;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(double overall_score) {
        this.overall_score = overall_score;
    }

    public double getContent_score() {
        return content_score;
    }

    public void setContent_score(double content_score) {
        this.content_score = content_score;
    }

    public double getGrammar_score() {
        return grammar_score;
    }

    public void setGrammar_score(double grammar_score) {
        this.grammar_score = grammar_score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
