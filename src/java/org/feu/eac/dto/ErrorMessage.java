/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac.dto;

import java.util.List;

/**
 *
 * @author makki
 */
public class ErrorMessage {
    private int line_no;
    private int column_no;
    private String description;
    private List suggestion;

    public ErrorMessage() {
        this.line_no = 0;
        this.column_no = 0;
        this.description = "";
        this.suggestion = null;
    }

    public int getLine_no() {
        return line_no;
    }

    public void setLine_no(int line_no) {
        this.line_no = line_no;
    }

    public int getColumn_no() {
        return column_no;
    }

    public void setColumn_no(int column_no) {
        this.column_no = column_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List suggestion) {
        this.suggestion = suggestion;
    }


}
