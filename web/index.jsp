<%-- 
    Document   : index
    Created on : Jul 23, 2025, 10:11:01 PM
    Author     : SuJain
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student Report Viewer</title>
  </head>
  <body>
    <h2>View Your Report Card</h2>

    <form action="view.jsp" method="get">
      <label for="id">Enter Student ID:</label>
      <input type="text" id="id" name="id" placeholder="e.g. 1001" required>
      <input type="submit" value="View Report">
    </form>

    <p>Example valid ID: <code>1001</code></p>
  </body>
</html>

