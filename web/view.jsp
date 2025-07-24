<%-- 
    Document   : view.jsp
    Created on : Jul 23, 2025, 9:38:41?PM
    Author     : SuJain
--%>


<%@ page import="java.io.*" %>
<html>
  <head>
    <title>View Report</title>
  </head>
  <body>
    <h2>Report Viewer</h2>
    <%--<%
      String studentId = request.getParameter("id");

      if (studentId == null || studentId.trim().isEmpty()) {
          out.println("<p>No student ID provided!</p>");
          return;
      }

      // Vulnerable part
       
      String basePath = application.getRealPath("/") + "reports/";
      String filePath = basePath + studentId ;  

      File file = new File(filePath);

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
</html>--%>
    <%@ page import="java.io.*" %>
<html>
  <head>
    <title>Vulnerable Report Viewer</title>
  </head>
  <body>
    <h2>Vulnerable Report Viewer</h2>
    <%
      String studentId = request.getParameter("id");

      String basePath = application.getRealPath("/") + "reports/";
      String filePath = basePath + studentId;

      File file = new File(filePath);

      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
          out.println(line + "<br>");
      }
      reader.close();
    %>
  </body>
</html>

