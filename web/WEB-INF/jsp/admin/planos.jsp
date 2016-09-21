<%-- 
    Document   : home
    Created on : 23/ago/2016, 23:04:03
    Author     : len
--%>

<%@include file="../estrutura/cabecalho.jsp" %>
<div class="menu"> 

    <!-- Menu icon -->

    <div class="icon-close"> <i class="fa fa-close"></i> <a></a></div>

    <!-- Menu -->

    <ul>
        <li><a href="#">Organizações</a></li>
        <li><a href="#">Planos</a></li>
        <li><a href="#">Definições</a></li>
        <li><a href="#">Ajuda</a></li>
    </ul>
</div>

<!-- Main body -->

<div class="jumbotron jumbotron_a">
    <div class="icon-menu"> <i class="fa fa-bars"></i> Menu </div>
</div>
<div class="container">
    <div class="row">
        <input type="search" name="busca" value="" />
        <hr>
        <table class="table table-hover table-striped" data-toggle="table" data-cache="false" data-height="299">
            <thead>
                <tr>
                    <th data-field="id_org" data-sortable="true">ID</th>
                    <th data-field="nome_org" data-sortable="true">Nome</th>
                    <th data-field="org_estado" data-sortable="true">Estado</th>
                    <th data-field="org_opr" data-sortable="true">Opr</th>
                </tr>
            </thead>
            <tbody>

                <tr>

                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                 
                </tr>
            </tbody>
        </table>



    </div>
</div>
<script>
    var main = function () {

        /* Push the body and the nav over by 285px over */

        $('.icon-menu').click(function () {

            $('.icon-menu i').hide();

            $('.menu').animate({
                left: "0px"

            }, 200);



            /*$('.jumbotron_a').animate({
             
             left: "285px"
             
             }, 200);*/

        });


        /* Then push them back */

        $('.icon-close').click(function () {
            $('.icon-menu i').show();
            $('.menu').animate({
                left: "-285px"

            }, 200);

            /*
             $('body').animate({
             
             left: "0px"
             
             }, 200);*/

        });

    };



    $(document).ready(main);
</script>

<%@include file="../estrutura/rodape.jsp" %>
