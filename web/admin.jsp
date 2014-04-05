<%-- 
    Document   : index
    Created on : Mar 12, 2014, 9:10:08 PM
    Author     : makki
--%>

<%@page import="org.feu.eac.dto.Properties"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Online Grammar Checker</title>

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
        <% if (request.getSession().getAttribute("admin") == null) {
                response.sendRedirect("index.jsp");
            } else {
        %>
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
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->

            </div>
        </div>

        <div class="container">
            <div class="starter-template">
                <h3>Administrator's Module</h3>
                <% Properties props = (Properties) session.getAttribute("props");
                %>
                </br>
                </br>
                <table class="table col-sm-6 table-striped table-bordered" >
                    <thead >
                        <tr>
                            <th class="col-sm-2">
                                <div class="text-center">Category</div>
                            </th>
                            <th class="col-sm-1">
                                <div class="text-center">Value</div>
                            </th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Current topic</td>
                            <td><%=props.getTopic()%></td>
                        </tr>
                        <tr>
                            <td>Size of the corpus</td>
                            <td><%=props.getFilesInCorpus()%></td>
                        </tr>
                        <tr>
                            <td>Number of submitted essays</td>
                            <td><%=props.getNumberOfSubmittesEssays()%></td>
                        </tr>
                    </tbody>

                </table>

            </div>
        </div><!-- /.container -->
        <%
            }
        %>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

