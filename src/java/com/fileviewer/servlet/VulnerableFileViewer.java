package com.fileviewer.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

public class VulnerableFileViewer extends HttpServlet {

    private final String BASE_DIR = "reports";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("id"); 
        if (fileName == null) {
            response.getWriter().println("Missing file ID!");
            return;
        }

       
        String relativePath = BASE_DIR + File.separator + fileName;
        String absolutePath = getServletContext().getRealPath("/") + relativePath;

        response.setContentType("text/plain");

        try (BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
             PrintWriter out = response.getWriter()) {

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
           
            e.printStackTrace(response.getWriter());
        }
    }
}
