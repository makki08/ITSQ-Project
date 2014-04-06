/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac;

import com.cybozu.labs.langdetect.LangDetectException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.feu.eac.dto.ErrorMessage;
import org.feu.eac.dto.Scoring;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.English;
import org.languagetool.rules.RuleMatch;
import org.tartarus.snowball.SnowballProgram;

/**
 *
 * @author makki
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    LangDetect langDetect;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (request.getParameter("submit") != null && request.getParameter("submit").equals("Submit")) {
            String input = request.getParameter("textarea");
            int studentNum = Integer.parseInt(request.getParameter("s_number"));
            String name = request.getParameter("s_name");
            String year = request.getParameter("s_year");
            String section = request.getParameter("s_section");
            
            try {
                String lang = langDetect.detect(input);
                String language = "";
                
                if (lang.equals("tl")) {
                    request.getSession().setAttribute("language", "Filipino");
                    language = "Tagalog";
                } else if (lang.equals("en")) {
                    request.getSession().setAttribute("language", "English");
                    language = "English";
                }
                
                CheckGrammar checkGrammar = new CheckGrammar();
                List<ErrorMessage> errorMessages = checkGrammar.getErrors(input, language);
                int sentenceCount = checkGrammar.getCount();
                
                /* FOR TESTING!!!!!!!!!!!!
                for (ErrorMessage message : errorMessages) {
                    out.println(message.getLine_no() + "</br>");
                    out.println(message.getColumn_no() + "</br>");
                    out.println(message.getDescription()+ "</br>");
                    out.println(message.getSuggestion() + "</br>");
                    out.println("</br>");
                } */
                
                Stemmer stemmer = new Stemmer(input);
                String stemmed = stemmer.getStem();
                
                CheckContent checkContent = new CheckContent(stemmed);
                int length = checkContent.getContentScore().length();
                String score = checkContent.getContentScore().substring(length - 6, length - 4);
                request.getSession().setAttribute("contentScore", score);
                
                Scoring scoring = new Scoring(Double.parseDouble(score), errorMessages.size(), sentenceCount);
                double overallScore = scoring.getOverallScore();
                double contentScore = scoring.getContentScore();
                double grammarScore = scoring.getGrammarScore();
                
                
                WriteToDB write = new WriteToDB();
                
                write.addToSubmissions(studentNum, name, year, section, input, overallScore, contentScore, grammarScore);
                request.getSession().setAttribute("errorMessages", errorMessages);
                request.getSession().setAttribute("scoring", scoring);
                response.sendRedirect("result.jsp");
                
            } catch (LangDetectException ex) {
                //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("error.jsp");
            }
        }

    }

    @Override
    public void init() throws ServletException {
        try {
            langDetect = new LangDetect();
        } catch (LangDetectException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
