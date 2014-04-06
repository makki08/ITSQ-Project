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
            <h3>Automated Essay Evaluator</h3>
            <form role="form" action="controller" method="post">
            <div class="form-group">
                 <div class="container col-lg-5">
                     </br>
                     <h4>Topic: Choosing a Career</h4> 
                     </br>
                     </br>
                     <p class="text-left">Student Number: </p><input type="text"  name="s_number" class="form-control">
                     </br>
                     <p class="text-left">Name: </p><input type="text"  name="s_name" class="form-control">
                     </br>
                     <p class="text-left">Year: </p><input type="text"  name="s_year" class="form-control">
                     </br>
                     <p class="text-left">Section: </p><input type="text"  name="s_section" class="form-control">
                 </div>
                <div class="container col-lg-7">
                    <label class="control-label" for="textarea"></label>
                    <textarea class="form-control" id="textarea" name="textarea" rows="18" placeholder="Type or paste your text submission here..."></textarea>
                </div>
                <div class="text-center">
                    <p>&nbsp</p>
                    <button type="submit" class="btn btn-primary" name="submit" value="Submit">Submit</button>
                </div>
            </div>
        </form>
        </div>
        

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

