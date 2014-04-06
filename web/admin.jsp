<%-- 
    Document   : index
    Created on : Mar 12, 2014, 9:10:08 PM
    Author     : makki
--%>

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
                        <li class="active"><a href="admin.jsp">Admin Home</a></li>
                        <li><a href="train.jsp">Train the System</a>
                        <li><a href="grading.jsp">Change Grading Scheme</a>
                        <li><a href="viewEssays.jsp">View Submissions</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->

            </div>
        </div>

        <div class="container">
            <div class="starter-template">
                <h3>Administrator's Module</h3>
                </br>
                </br>
                <div class="col-lg-3">
                    
                </div>
                <div class="col-lg-6">
                    <table class="table col-sm-6 table-striped table-bordered" >
                        <thead >
                            <tr>
                                <th class="col-sm-3">
                        <div class="text-center">Category</div>
                        </th>
                        <th class="col-sm-3">
                        <div class="text-center">Value</div>
                        </th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Current topic</td>
                                <td><%=Summary.getTopic()%></td>
                            </tr>
                            <tr>
                                <td>Size of the corpus</td>
                                <td><%=Summary.getFilesInCorpus()%></td>
                            </tr>
                            <tr>
                                <td>Number of submitted essays</td>
                                <td><%=Summary.getNumberOfSubmittesEssays()%></td>
                            </tr>
                        </tbody>

                    </table>
                </div>
                <div class="col-lg-3">

                </div>
                <div class="col-lg-12">
                    <h3>Change Password</h3>
                    </br>
                    <div class="col-lg-3">
                        
                    </div>
                    <div class="col-lg-6">
                        <form role="form" action="changePass" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text-right">Old Password: </p>
                                </div>
                                <div class="col-md-6">
                                    <input class="form-control" type="password" name="oldPass" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text-right">New Password: </p>
                                </div>
                                <div class="col-md-6">
                                    <input class="form-control" type="password" name="password" id="password" required pattern=".{6,}" title="Password should be at least 6 characters long">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text-right">Re-type Password: </p>
                                </div>
                                <div class="col-md-6">
                                    <input class="form-control" type="password" name="password2" id="password2" oninput="check(this)" value="" required pattern=".{6,}" title="Password should be at least 6 characters long"> 
                                </div>
                            </div>
                            </br>
                            <div class="row">
                                <div class="col-md-12">
                                    <button class="btn btn-primary" type="submit" name="change" value="Change">Change</button>
                                </div>
                            </div>
                        </form>
                    </div>
                        <div class="col-lg-3">

                        </div>
                        <div class="col-lg-12 text-center">
                            <%
                                if (!(session.getAttribute("success") == null)) {

                            %>
                            </br>
                            <%=session.getAttribute("success")%>
                            <%  session.removeAttribute("success");
                                }
                            %>
                        </div>
                    </div>
                </div><!-- /.container -->
            <%
                }
            %>
            <script language='javascript' type='text/javascript'>
                    function check(input) {
                        if (input.value !== document.getElementById('password').value) {
                            input.setCustomValidity('The two passwords must match.');
                        } else {
                            // input is valid -- reset the error message
                            input.setCustomValidity('');
                        }
                        
                    }
                    </script>
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

