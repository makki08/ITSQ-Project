/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feu.eac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author makki
 */
public class Upload extends HttpServlet {

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
            out.println("<title>Servlet Upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Upload at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private final String UPLOAD_DIRECTORY = "C:/Users/makki/Documents/NetBeansProjects/ITSQ-Project/corpus";
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
        PrintWriter out = response.getWriter();
                
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                String grade = "";
                
                for (int i = multiparts.size() - 1; i >= 0; i--) {
                    if (multiparts.get(i).isFormField()) {
                        String fieldvalue = multiparts.get(i).getString();
                        grade = fieldvalue;
                    } else {
                        String name = new File(multiparts.get(i).getName()).getName();
                        String fname = new StringBuilder(name).insert(name.length()-4, "_" + grade).toString();
                        
                        InputStream uploadedStream = multiparts.get(i).getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uploadedStream));
                        
                        File file = new File(UPLOAD_DIRECTORY + File.separator + fname);
                        file.createNewFile();
                        
                        FileWriter writer = new FileWriter(file);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            // do your processing 
                            try {
                                Stemmer stemmer = new Stemmer(line);
                                String stemmed = stemmer.getStem();
                                writer.append(stemmed);
                                writer.flush();
                                
                            } catch (IOException e) {
                                out.println(e.getMessage());
                            }
                        //out.println(line);
                        }
                        writer.close();
                        //multiparts.get(i).write(new File(UPLOAD_DIRECTORY + File.separator + fname));
                    }
                }
                //File uploaded successfully
                request.getSession().setAttribute("message2", "File uploaded successfully.");
                //request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.getSession().setAttribute("message2", "File upload failed due to " + ex);
                //request.setAttribute("message", "File Upload Failed due to " + ex);
            }
               
        } else {
            request.setAttribute("message2",
                    "Sorry this Servlet only handles file upload request");
        }
        
        response.sendRedirect("train.jsp");
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
