<%-- 
    Document   : index
    Created on : Mar 12, 2014, 9:10:08 PM
    Author     : makki
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.feu.eac.dto.Essay"%>
<%@page import="java.util.List"%>
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
                        <li><a href="index.jsp">Home</a></li>
                        <li class="active"><a class="button right" href="viewEssays">View Submissions</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    <form method="post" action="admin" class="navbar-form navbar-right" role="form" >
                        <div class="form-group">
                            <input type="text"  name="username" placeholder="Username" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password"  placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success" name="admin" value="admin">Sign in</button>
                    </form>
                </div><!--/.nav-collapse -->

            </div>
        </div>
        <!--
        <div class="container">
            <div class="starter-template" >
                <h3>Automated Essay Evaluator</h3>
                <form role="form" action="controller" method="post">
                     <div class="form-group">
                         <label class="control-label" for="textarea"></label>
                         <textarea class="form-control" id="textarea" name="textarea" rows="18" placeholder="Type or paste your text submission here..."></textarea></br>
                         <button type="submit" class="btn btn-primary" name="submit" value="Submit">Submit</button>
                     </div>
                </form>
            </div>
        </div><!-- /.container -->

        <div class="starter-template">
            <h3>List of Submitted Essays</h3>
            <% List<Essay> essays = (ArrayList)session.getAttribute("essays"); %>
            </br>
            <div class="col-md-12">
                <table class="table table-striped table-bordered" >
                    <thead >
                        <tr>
                            <th class="col-sm-1">
                    <div class="text-center">Essay No.</div>
                    </th>
                    <th class="col-sm-2">
                    <div class="text-center">Student No.</div>
                    </th>
                    <th class="col-sm-4">
                    <div class="text-center">Name</div>
                    </th>
                    <th class="col-sm-1">
                    <div class="text-center">Year</div>
                    </th>
                    <th class="col-sm-1">
                    <div class="text-center">Section</div>
                    </th>
                    <th class="col-sm-1">
                    <div class="text-center">Score</div>
                    </th>
                    <th class="col-sm-2">
                    <div class="text-center">Date Submitted</div>
                    </th>
                    </tr>
                    </thead>
                    <tbody>
                        <%  DecimalFormat df = new DecimalFormat("#.##");
                            for (Essay essay : essays) {%>
                        <tr>      
                            <td><%=essay.getEssay_id()%></td>
                            <td><%=essay.getStudent_num()%></td>
                            <td><%=essay.getStudent_name()%></td>
                            <td><%=essay.getStudent_year()%></td>
                            <td><%=essay.getStudent_section()%></td>
                            <td><h5><%=df.format(essay.getOverall_score())%></h5></td>
                            <td><%=essay.getDate()%></td>
                        </tr>
                        <% } %>

                    </tbody>

                </table>
            </div>
            <div class="col-lg-12 text-center">
                <%
                    if (!(session.getAttribute("test") == null)) {

                %>
                </br>
                <%=session.getAttribute("test")%>
                <%  //session.removeAttribute("test");
                    }
                %>
            </div>
            <div class="col-md-12">
                </br>
                <form method="post" action="readEssay" role="form" >
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-3">
                            <p class="text-right">Enter Essay No. to read the essay: </p>
                        </div>
                        <div class="col-md-1">
                            <input class="form-control" type="number" name="choice">
                        </div>
                        <div class="col-md-5">
                        </div>
                    </div>
                    </br>
                    <button class="btn btn-primary btn-success" data-toggle="modal" data-target="#myModal" 
                            name="read" value="Read">
                        Read essay
                    </button>
                </form>
            </div>
            <div class="col-md-3"></div>
            <div class="col-lg-6 text-center">
                </br>
                <%
                    if (!(session.getAttribute("content") == null)) {

                %>
                <%=session.getAttribute("content")%>
                <%  session.removeAttribute("content");
                    }
                %>
            </div>
            <div class="col-md-3"></div>
            <div class="col-md-12">
                </br>
                </br>
            </div>
            <!-- Modal
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Read Essay</h4>
                        </div>
                        <div class="modal-body">
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div> -->
        </div>
            
         
    </div>               

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

