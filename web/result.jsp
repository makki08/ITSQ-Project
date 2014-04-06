<%-- 
    Document   : result
    Created on : Mar 12, 2014, 11:35:10 PM
    Author     : makki
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.feu.eac.dto.ErrorMessage"%>
<%@page import="org.feu.eac.dto.Scoring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Result</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/starter-template.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">ITSQ Project</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li class="active"><a class="button right" href="viewEssays">View Submissions</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
        <div class="container">
            <div class="starter-template">
                <h3>Language: <%=session.getAttribute("language")%></h3></br>
                <% Scoring scoring = (Scoring)session.getAttribute("scoring"); 
                DecimalFormat df = new DecimalFormat("#.##");%>
                <h2>Content Score: <%=df.format(scoring.getContentScore()) %></br> </h2>
                <h2>Grammar Score: <%=df.format(scoring.getGrammarScore())%></br> </h2>
                <h2>Overall Score: <%=df.format(scoring.getOverallScore())%></br> </h2>
                </br>
                <h2>Potential Errors List</h2>
                <% List<ErrorMessage> errorMessages = (ArrayList)session.getAttribute("errorMessages");
                   
                for (ErrorMessage errorMessage : errorMessages) {
                %>Line Number: <%=errorMessage.getLine_no() %> </br> 
                Column Number: <%=errorMessage.getColumn_no() %> </br>
                Description: <%=errorMessage.getDescription() %> </br>
                Suggestion: <%=errorMessage.getSuggestion() %> </br>
                </br>
                <%
                }
                %>
                 
            </div>
        </div><!-- /.container -->


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

