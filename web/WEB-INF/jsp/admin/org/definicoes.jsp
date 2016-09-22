<%-- 
    Document   : home
    Created on : 23/ago/2016, 23:04:03
    Author     : len
--%>

<%@include file="../../estrutura/cabecalho.jsp" %>

<div class="container">

    <div class="row">
        <a href="/appAdmin/org/">Voltar</a>
        <h4 class="text-center">Organizações</h4>
        <hr>
        <div class="col-md-5 col-lg-offset-3">
            <form class="form-horizontal" action="/app/mctr" method="POST" role="form">
                ${confirmacao}
                <h3 class="text-center">Detalhes da Organização</h3>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="idorg" class="control-label">ID Organização:</label>
                    </div>

                    <div class="col-xs-4">
                        <input type="text" value="${organizacao.idorganizacao}" class="form-control" id="idorg" name="idorg" readonly="readonly">
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="nome_org" class="control-label">Nome:</label>
                    </div>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input_no_board" value="${organizacao.nomedaorganizacao}" name="nome_org" id="nome_org" placeholder="Nome da Organização">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="codigo_org" class="control-label">Código:</label>
                    </div>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input_no_board" value="${organizacao.codigoorganizacao}" name="codigo_org" id="codigo_org">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="obj_social" class="control-label">Objecto Social:</label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text" value="${organizacao.objectosocial}" class="form-control" name="obj_social" id="obj_social" placeholder="Objecto Social da Organização">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="enderecoweb" class="control-label">Endereço Web:</label>
                    </div>

                    <div class="col-xs-4">
                        <input type="text" value="${organizacao.enderecoWeb}" class="form-control" id="enderecoweb" name="enderecoweb"  placeholder="Ex: empresa">
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="nfuncionarios" class="control-label">N# Funcionarios:</label>
                    </div>

                    <div class="col-xs-4">
                        <input type="text" value="${organizacao.numerofuncionarios}" class="form-control" id="nfuncionarios" name="nfuncionarios" >
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="armazenamento" class="control-label">Armazenamento:</label>
                    </div>

                    <div class="col-xs-4">
                        <input type="text" value="${organizacao.armazenamento}" class="form-control" id="armazenamento" name="armazenamento" >
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-sm-4">
                        <label for="plano" class="control-label">Plano:</label>
                    </div>

                    <div class="col-xs-4">
                        <input type="text" value="${organizacao.plano}" class="form-control" id="plano" readonly="readonly" name="plano"  placeholder="Plano">
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-xs-8">
                        <h4  class="control-label text-center">Data de Adesão:</h4>
                        <br>
                    </div>
                    <div class="col-xs-5">
                        <input type="text" class="form-control" value="<fmt:formatDate value="${organizacao.datainicioadesao}" pattern="dd-MM-yyyy"/>" id="datainicioadesao" name="datainicioadesao" placeholder="Inicio da Adesão">
                    </div>
                    <div class="col-xs-5">
                        <input type="text" class="form-control" value="<fmt:formatDate value="${organizacao.datafimadesao}" pattern="dd-MM-yyyy"/>" id="datafimadesao" name="datafimadesao" placeholder="Fim da Adesão">
                    </div>
                </div>
                <script>
                    $(function () {
                        $("#datainicioadesao").datepicker(
                                {
                                    dateFormat: "dd-mm-yyyy",
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
                <div class="form-group">
                    ${confirmacao}
                    <div class="col-xs-8">
                        <h4  class="control-label text-center">Estado da Conta:</h4>
                        <br>
                    </div>

                    <div id="EstadoDaConta" class="col-xs-5">
                        <c:if test="${organizacao.estado eq true}">
                            <p class="text-primary">Activa</p>
                        </c:if>
                        <c:if test="${organizacao.estado != true}">
                            <p class="text-danger">Desativada</p>
                        </c:if>
                    </div>
                     <div class="col-xs-5">
                         <a href="alterarEstadoConta?idorg=${organizacao.idorganizacao}">Alterar</a>
                    </div>
                </div>
                <h3 class="text-center">Conta de Administrador</h3>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">Utilizador:</label>
                    </div>
                    <div class="col-sm-10">
                        <label class="control-label">Admin</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="inputEmail4u" class="control-label">E-mail:</label>
                    </div>
                    <div class="col-sm-10">
                        <input type="email"  class="form-control"  name="email" id="inputEmail4u" placeholder="E-mail">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-2">
                        <label for="senha"  class="control-label">Senha:</label>
                    </div>
                    <div class="col-xs-5">
                        <input type="text" class="form-control" autocomplete="off" id="senha" name="senha" placeholder="Senha">
                    </div>
                    <div class="col-xs-5">
                        <input type="text" class="form-control" autocomplete="off" name="senha_repedita" placeholder="Repetir Senha">
                    </div>
                </div>




                <hr>
                <div class="form-group">
                    <input type="hidden" name="opr" value="0">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" name="logica" value="NovaConta" class="btn btn-sm btn-success btn-block">Salvar</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>


<%@include file="../../estrutura/rodape.jsp" %>
