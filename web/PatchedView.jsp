<%-- 
    Document   : PatchedView
    Created on : Jul 24, 2025, 8:05:41?AM
    Author     : SuJain
--%>

<%@ page import="java.io.*" %>
<html>
  <head>
    <title>View Report</title>
  </head>
  <body>
    <h2>Secure Report Viewer</h2>
    <%
      String studentId = request.getParameter("id");

      if (studentId == null || studentId.trim().isEmpty()) {
          out.println("<p>No student ID provided!</p>");
          return;
      }

    
      if (studentId.contains("..") || studentId.contains("/") || studentId.contains("\\")) {
          out.println("<p> Invalid student ID!</p>");
          return;
      }

      if (!studentId.matches("^[a-zA-Z0-9]+$")) {
          out.println("<p>Invalid characters in ID!</p>");
          return;
      }

      String basePath = application.getRealPath("/") + "reports" + File.separator;
      String filePath = basePath + studentId ;

      File file = new File(filePath);

      if (!file.getCanonicalPath().startsWith(new File(basePath).getCanonicalPath())) {
          out.println("<p>Access denied!</p>");
          return;
      }

      if (file.exists() && file.isFile()) {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String line;
          while ((line = reader.readLine()) != null) {
              out.println(line + "<br>");
          }
          reader.close();
      } else {
          out.println("<p>Report not found!</p>");
      }
    %>
  </body>
</html>
