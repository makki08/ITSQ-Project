/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.feu.eac.dto.Scoring;

/**
 *
 * @author makki
 */
@WebServlet(name = "Grading", urlPatterns = {"/grading"})
public class Grading extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Grading</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Grading at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        if (request.getParameter("modify") != null && 
                request.getParameter("modify").equals("Modify")) {
            try {
                double content = Double.parseDouble(request.getParameter("content"));
                double grammar = Double.parseDouble(request.getParameter("grammar"));
                
                if (content + grammar != 100.0 ) {
                    request.getSession().setAttribute("message4", "Total should be 100.");
                } else {
                    Scoring.setCONTENTWEIGHT(content);
                    Scoring.setGRAMMARWEIGHT(grammar);
                    request.getSession().setAttribute("message4", "Changes saved sucessfully.");
                }
                
            } catch (NumberFormatException e) {
                request.getSession().setAttribute("message4", "Please enter a valid input.");
            } 
            
            response.sendRedirect("grading.jsp");
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
