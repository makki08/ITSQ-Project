<%-- 
    Document   : success
    Created on : Apr 6, 2014, 2:36:08 PM
    Author     : makki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
                if (!(session.getAttribute("message2") == null)) {

            %>
            <%=session.getAttribute("message2") %>
            <%  session.removeAttribute("message2");
                }
            %>
    </body>
</html>
