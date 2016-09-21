<%-- 
    Document   : home
    Created on : 23/ago/2016, 23:04:03
    Author     : len
--%>

<%@include file="../../estrutura/cabecalho.jsp" %>

<div class="container">
    <div class="row">
        <h4 class="text-center">Candidatos</h4>
        <hr>
        Nome: <input type="search" name="nome" placeholder="Nome do Candidato" /> | Idade : <input type="search" name="busca" placeholder="Idade do Candidato" /> |  N Oferta : <input type="search" name="noferta" placeholder="Nº da Oferta" /> |  Organização: <input type="search" name="org" placeholder="Organização que Publicou a Oferta" />
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


<%@include file="../../estrutura/rodape.jsp" %>
