<%-- 
    Document   : entrar
    Created on : 23/ago/2016, 10:54:30
    Author     : len
--%>
<%-- 
    Document   : cabecalho
    Created on : 23/ago/2016, 10:58:04
    Author     : len
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="http://ostirh.com/assets/images/ostilogo-128x43-55.png" type="image/x-icon">
    <title>OSTIRH Admin v1 Beta</title>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="/appAdmin/css/main_style.css" rel="stylesheet" type="text/css"/>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- JavaScript JQuery -->
    <!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
     <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.js"></script>-->
    <!-- JavaScript JQuery Google Host-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>

</head>

<body>
    <h1 class="text-center text-success"><tt>OSTIRH v1 Admin</tt> <i>Beta</i></h1>
    <div class="container">
        <div class="row">
              <h1 class="text-success">Autenticação</h1>
              <hr>
            <div class="col-md-6">
                <form name="formLogin" action="iniciarsessao">
                    <p>Utilizador:</p> <input type="text" class="input-noborder" name="utilizador" value="" placeholder="Digite o Email" />
                    <p>Senha:</p><input type="password" class="input-noborder" name="senha" value="" placeholder="Digite a Senha" />
                    <hr>

                    <br><button type="submit" name="opr" value="2" class="btn btn-success">Entrar</button>
                </form>
            </div>
            <div class="col-md-6">
                <h4><tt>${mensagem}</tt></h4>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">

            <div class="row">
                <p class="text-center">Copyright © 2016 Todos os direitos reservados <a href="http://ostiinvestimentos.com"> OSTI Investimentos </a></p>
            </div>
        </div>

    </footer>
</body>
</html>
