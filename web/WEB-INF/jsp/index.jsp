<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OSTIRH v1 Admin Beta</title>

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
        <div class="container">
            <div class="row">
                <p class="text-center text-primary">OSTIRH v1 Admin <i>Beta</i>.</p>
                <p><i>Se esta a ver essa tela quer dizer que entrou em modo </i>
                    <tt>Administrador</tt> <i> do Sistema OSTIRH v1, caso tenha vindo aqui por engano
                        por favor clique em </i> <tt><a href="http://ostirh.com">Tira-me daqui!</a>"</tt> <i> de outro modo
                        é considerado um membro da Equipa OSTIRH</i>
                    <tt>então clique no botão abaixo</tt>.</p>

                <a href="login?opr=0" class="btn btn-default">Continuar</a>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <script>
                    $(document).ready(function () {
                        $("#flip").click(function () {
                            $("#panel").slideToggle("slow");
                        });
                    });

                </script>

                <div id="flip">Clique aqui para ver mais filtros!</div>
                <div id="panel" style="display:none">
                    <input type="text" id="datainicioadesao" class="form-control" name="data_inicio_adesao">
                </div>
                <script>
                    $(function () {
                        $("#datainicioadesao").datepicker(
                                {
                                    dateFormat: "dd-MM-yyyy",
                                    yearRange: "2016:2100",
                                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                                    changeYear: true,
                                    //maxDate: "+1m +1w",
                                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                                }
                        );
                        $("#datafimadesao").datepicker(
                                {
                                    dateFormat: "dd-mm-yy",
                                    yearRange: "2016:2100",
                                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                                    changeYear: true,
                                    //maxDate: "+1m +1w",
                                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                                }
                        );
                    });
                </script>
            </div>
        </div>
    </body>
</html>
