<%-- 
    Document   : index
    Created on : Mar 12, 2014, 9:10:08 PM
    Author     : makki
--%>

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
                        <li><a href="admin.jsp">Admin Home</a></li>
                        <li class="active"><a href="train.jsp">Train the System</a>
                        <li><a href="grading.jsp">Change Grading Scheme</a>
                        <li class="active"><a class="button right" href="viewEssays">View Submissions</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->

            </div>
        </div>

        <div class="container col-lg-12">
            <div class="starter-template">
                <h3> Add pre-graded essays to corpus </h3>
                </br>
                </br>
                <form role="form" action="upload" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-3">
                        </div>
                        <div class="col-lg-6">
                            <div class="col-lg-5">
                                <input type="file" name="file" />
                            </div>
                            <div class="col-lg-4">
                                <div class="col-lg-6">
                                    <p class="text-center">Grade: </p>
                                </div>
                                <div class="col-lg-6">
                                    <input class="form-control" type="number" name="grade" required/>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <button class="btn btn-primary" type="submit" name="addfile" value="Add">Add to Corpus</button>
                            </div>
                        </div>
                        <div class="col-lg-3">
                        </div>
                    </div>
                </form>
                
            </div>
            <div class="col-lg-12 text-center">
                <%
                    if (!(session.getAttribute("message2") == null)) {

                %>
                <%=session.getAttribute("message2")%>
                <%  session.removeAttribute("message2");
                    }
                %>
            </div>
            <div class="col-lg-12 text-center">
                </br>
                <form role="form" action="train" method="post">
                    <button class="btn btn-success" type="submit" name="train" value="Train the System">Train the System</button>
                </form>
            </div>
            <div class="col-lg-12 text-center">
                <%
                    if (!(session.getAttribute("message3") == null)) {

                %>
                </br>
                <%=session.getAttribute("message3")%>
                <%  session.removeAttribute("message3");
                    }
                %>
            </div>
            </br>
            &nbsp
            <div class="col-lg-12 text-center">
                <h3>Create a new essay topic</h3>
                &nbsp;
                <p>Note: Creating a new topic will delete the contents of the current corpus and all essays submitted.</p>
                <form role="form" action="newTopic" method="post">
                <div class="col-lg-3">   
                </div>
                <div class="col-lg-6">
                    <div class="col-lg-3">
                        <p class="text-right">New Topic :</p>
                    </div>
                    <div class="col-lg-9">
                        <input type="text" class="form-control" name="topic" required>
                    </div>
                </div>
                <div class="col-lg-3">   
                </div>
                <div class="col-lg-12">
                    </br>
                    <button class="btn btn-success" type="submit" name="newTopic" value="newTopic" >Create New Topic</button>
                </div>
                </form>
            </div>
            <div class="col-lg-12 text-center">
                <%
                    if (!(session.getAttribute("newTopic") == null)) {

                %>
                </br>
                <%=session.getAttribute("newTopic")%>
                <%  session.removeAttribute("newTopic");
                    }
                %>
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

