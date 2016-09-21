<%-- 
    Document   : cabecalho
    Created on : 23/ago/2016, 10:58:04
    Author     : len
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
    <!-- CSS JQuery -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
</head>

<body>
    <h1 class="text-center text-success"><tt>OSTIRH v1 Admin</tt> <i>Beta</i></h1>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">OSTIRH Admin v1 Beta</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"> <a href="#" class="icon-menu"> <i class="fa fa-bars"></i> Menu </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                <li><a href="terminarsessao?idorg=0&def_opr=ts"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
            </ul>
        </div>
    </nav>
    ${confirmacao}



    <div class="menu"> 

        <!-- Menu icon -->

        <div class="icon-close"> <i class="fa fa-close"></i> <a></a></div>

        <!-- Menu -->

        <ul>
            <li><a href="redirect?p=admin/org&a=organizacao">Organizações</a></li>
            <li><a href="redirect?p=admin/candidato&a=candidato">Candidatos</a></li>
            <li><a href="redirect?p=admin/planos&a=planos">Planos</a></li>
            <li><a href="redirect?p=admin&a=definicoes">Definições</a></li>
            <li><a href="redirect?p=admin/ajuda">Ajuda</a></li>
        </ul>
    </div>
