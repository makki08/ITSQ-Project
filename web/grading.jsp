<%-- 
    Document   : index
    Created on : Mar 12, 2014, 9:10:08 PM
    Author     : makki
--%>

<%@page import="org.feu.eac.dto.Scoring"%>
<%@page import="org.feu.eac.dto.Summary"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Automated Essay Evaluator</title>

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
                        <li ><a href="admin.jsp">Admin Home</a></li>
                        <li><a href="train.jsp">Train the System</a>
                        <li class="active"><a href="grading.jsp">Change Grading Scheme</a>
                        <li class="active"><a class="button right" href="viewEssays">View Submissions</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->

            </div>
        </div>

        <div class="container">
            <div class="starter-template">
                <h3>Current Grading Scheme Breakdown</h3>
                </br>
                <div class="col-md-4">

                </div>
                <div class="col-md-4">
                    <table class="table col-md-6 table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>
                        <div class="col-4">
                            <p class="text-center">Category</p>
                        </div>
                        </th>
                        <th>
                        <div class="col-2">
                            <p class="text-center">Weight</p>
                        </div>
                        </th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <p class="text-center">Content</p>
                                </td>
                                <td>
                                    <p class="text-center"><%=Scoring.getCONTENTWEIGHT()%></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p class="text-center">Grammar</p>
                                </td>
                                <td>
                                    <p class="text-center"><%=Scoring.getGRAMMARWEIGHT()%></p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                &nbsp;
                    <h3>Modify Grading Scheme</h3>
                    </br>
                    <form role="form" action="grading" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <p class="text-right">Content: </p>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="number" name="content" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <p class="text-right">Grammar </p>
                            </div>
                            <div class="col-md-6">
                                <input class="form-control" type="number" name="grammar" required>
                            </div>
                        </div>
                        </br>
                        <div class="row">
                            <div class="col-md-12">
                                <button class="btn btn-primary form-control" type="modify" name="modify" value="Modify">Modify</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4">

                </div>
                <div class="col-lg-12 text-center">
                    <%
                        if (!(session.getAttribute("message4") == null)) {

                    %>
                    </br>
                    <%=session.getAttribute("message4")%>
                    <%  session.removeAttribute("message4");
                        }
                    %>
                </div>
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

