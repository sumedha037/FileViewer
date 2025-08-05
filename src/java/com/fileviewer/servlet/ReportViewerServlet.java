/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.fileviewer.servlet;

import com.fileviewer.utils.FileUtils;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public class ReportViewerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("id");
        if (!FileUtils.isValidId(studentId)) {
            out.println("<p>Invalid Student ID!</p>");
            return;
        }

        String basePath = getServletContext().getRealPath("/") + "reports" + File.separator;

        try {
            String filePath = FileUtils.getCanonicalPath(basePath, studentId);
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                out.println("<h2>Report Viewer</h2>");
                out.println(FileUtils.readFile(filePath));
            } else {
                out.println("<p>Report not found!</p>");
            }
        } catch (SecurityException se) {
            out.println("<p>Access denied!</p>");
        } catch (IOException ioe) {
           log("File reading failed", ioe); // logs to server log
    out.println("<p>Something went wrong. Please try again later.</p>");
        }
    }
}
