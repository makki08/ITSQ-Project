/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac;

import com.cybozu.labs.langdetect.LangDetectException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.feu.eac.dto.ErrorMessage;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.English;
import org.languagetool.rules.RuleMatch;

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
            try {
                String lang = langDetect.detect(input);
                String language = "";
                CheckGrammar checkGrammar = new CheckGrammar();
                
                if (lang.equals("tl")) {
                    request.getSession().setAttribute("language", "Filipino");
                    language = "Tagalog";
                } else if (lang.equals("en")) {
                    request.getSession().setAttribute("language", "English");
                    language = "English";
                }
                
                List<ErrorMessage> errorMessages = checkGrammar.getErrors(input, language);
                
                /* FOR TESTING!!!!!!!!!!!!
                for (ErrorMessage message : errorMessages) {
                    out.println(message.getLine_no() + "</br>");
                    out.println(message.getColumn_no() + "</br>");
                    out.println(message.getDescription()+ "</br>");
                    out.println(message.getSuggestion() + "</br>");
                    out.println("</br>");
                } */
                
                CheckContent checkContent = new CheckContent(input);
                request.getSession().setAttribute("contentScore", checkContent.getContentScore());
                
                request.getSession().setAttribute("errorMessages", errorMessages);
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
