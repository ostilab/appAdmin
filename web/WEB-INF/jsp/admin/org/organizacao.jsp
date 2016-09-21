<%-- 
    Document   : home
    Created on : 23/ago/2016, 23:04:03
    Author     : len
--%>

<%@include file="../../estrutura/cabecalho.jsp" %>

<div class="container">

    <div class="row">
        <h4 class="text-center">Organizações</h4>
        <hr>
        <form name="formPesquisa" class="form-inline" action="pesquisarOrg">
            Nome: <input class="form-control input-noborder"  type="search" name="nome" placeholder="Nome da Organização" /> 
            | Obj Social: <input class="form-control input-noborder" type="search" name="obj_social" placeholder="Objecto Social" /> 
            | Por Plano: <input class="form-control input-noborder" type="search" name="plano" placeholder="Por Plano aderido" /> |
            <input type="submit" value="Pesquisar" name="pesquisa" class="btn btn-info" />
            <script>
                $(document).ready(function () {
                    var index_opr = 0;

                    $("#flip").click(function () {
                        $("#panel").slideToggle("slow", function () {

                            if (index_opr === 1) {
                                $("#flip").text("Clique aqui para ver mais Filtros!");
                                index_opr = 0;
                            } else {
                                $("#flip").text("Ocultar Filtros!");
                                index_opr = 1;
                            }
                        });
                    });
                });

            </script>

            <span id="flip" class="text-info"  style="cursor: pointer">Clique aqui para ver mais Filtros!</span>

            <div id="panel"  style="display:none">
                <hr>
                <h4>Inicio do Plano de Adesão</h4>
                <div class="form-group">
                    <label for="datainicio_ia">Inicio:</label>
                    <input type="text" id="datainicio_ia" class="form-control" name="datainicio_ia">
                </div>
                <div class="form-group">
                    <label for="datafim_ia">Fim:</label>
                    <input type="text" id="datafim_ia" class="form-control" name="datafim_ia">
                </div>
                <h4>Fim do Plano de Adesão</h4>
                <div class="form-group">
                    <label for="datainicio_fa">Inicio:</label>
                    <input type="text" id="datainicio_fa" class="form-control" name="datainicio_fa">
                </div>
                <div class="form-group">
                    <label for="datafim_fa">Fim:</label>
                    <input type="text" id="datafim_fa" class="form-control" name="datafim_fa">
                </div>
            </div>
        </form> 
        <hr>
        <table class="table table-hover table-striped" data-toggle="table" data-cache="false" data-height="299">
            <thead>
                <tr>
                    <th data-field="id_org" data-sortable="true">ID</th>
                    <th data-field="nome_org" data-sortable="true">Nome</th>
                    <th data-field="objecto_social" data-sortable="true">Objecto Social</th>
                    <th data-field="plano" data-sortable="true">Plano</th>
                    <th data-field="datainicioadesao" data-sortable="true">Inicio Adesão</th>
                    <th data-field="datafimadesao" data-sortable="true">Fim da Adesão</th>
                    <th data-field="org_estado" data-sortable="true">Estado</th>
                    <th data-field="org_opr" data-sortable="true">Opr</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${organizacao}" var="org">
                <tr>
                    <td>${org.idorganizacao}</td>
                    <td>${org.nomedaorganizacao}</td>
                    <td>${org.objectosocial}</td>
                    <td>${org.plano}</td>
                    <td><fmt:formatDate value="${org.datainicioadesao}" pattern="dd-MM-yyyy"/></td>
                    <td><fmt:formatDate value="${org.datafimadesao}" pattern="dd-MM-yyyy"/></td>
                    <c:if test="${org.estado eq true}">
                        <td >Activo</td>
                    </c:if>
                    <c:if test="${org.estado != true}">
                        <td class="text-danger">Desativado</td>
                    </c:if>
                    <td>
                        <a href="definicoes.html?idorg=${org.idorganizacao}&def_opr=defOrg" class="btn btn-default">Definições</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${organizacao eq '[]'}"> 
                <h1 class="text-center text-info">Não foram encontradas correspondências!</h1> 
            </c:if>
            </tbody>
        </table>
    </div>
</div>
<script>

    $(function () {

        $("#datainicio_ia").datepicker(
                {onSelect: function (selected) {
                        $("#datafim_ia").datepicker("option", "minDate", selected);
                    }, showOn: "button",
                    buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
                    buttonImageOnly: true,
                    buttonText: "Selecione a Data Inicial",
                    dateFormat: "yy-mm-dd",
                    yearRange: "2010:2026",
                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                    changeYear: true,
                          changeMonth: true,
                    //maxDate: "+1m +1w",
                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                }
        );


        $("#datafim_ia").datepicker(
                {onSelect: function (selected) {
                        $("#datainicio_ia").datepicker("option", "maxDate", selected);
                    }, showOn: "button",
                    buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
                    buttonImageOnly: true,
                    buttonText: "Selecione a Data Final",
                    dateFormat: "yy-mm-dd",
                    yearRange: "2010:2026",
                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                    changeYear: true,
                     changeMonth: true,
                    //maxDate: "+1m +1w",
                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                }
        );

        $("#datainicio_fa").datepicker(
                {onSelect: function (selected) {
                        $("#datafim_fa").datepicker("option", "minDate", selected);
                    }, showOn: "button",
                    buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
                    buttonImageOnly: true,
                    buttonText: "Selecione a Data Inicial",
                    dateFormat: "yy-mm-dd",
                    yearRange: "2010:2026",
                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                    changeYear: true,
                     changeMonth: true,
                    //maxDate: "+1m +1w",
                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                }
        );


        $("#datafim_fa").datepicker(
                {onSelect: function (selected) {
                        $("#datainicio_fa").datepicker("option", "maxDate", selected);
                    }, showOn: "button",
                    buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
                    buttonImageOnly: true,
                    buttonText: "Selecione a Data Final",
                    dateFormat: "yy-mm-dd",
                    yearRange: "2010:2026",
                    dayNamesMin: ["Seg", "Ter", "Q", "Qi", "Sex", "Sab", "Dom"],
                    changeYear: true,
                     changeMonth: true,
                    //maxDate: "+1m +1w",
                    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Octubro", "Novembro", "Dezembro"]

                }
        );
    });
</script>


<%@include file="../../estrutura/rodape.jsp" %>
