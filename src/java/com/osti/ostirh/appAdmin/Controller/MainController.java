/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Controller;

import com.osti.ostirh.appAdmin.JDBC.ConnectionFactory;
import com.osti.ostirh.appAdmin.Logica.AdminLogica;
import com.osti.ostirh.appAdmin.Logica.OrganizacaoLogica;
import com.osti.ostirh.appAdmin.Modelo.Admin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author len
 */
@Controller
public class MainController {
    
    private final OrganizacaoLogica OrgLogica;

    public MainController() {
        Connection conexao = ConnectionFactory.getConexao();
        this.OrgLogica = new OrganizacaoLogica(conexao);
    }
    /**/


    /**
     *
     * @param request
     */
    public MainController(HttpServletRequest request) {
        this.OrgLogica = new OrganizacaoLogica(request);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirect(@RequestParam(value = "opr", required = false) String opr,
            @RequestParam(value = "usuario", required = false) String usuario,
            @RequestParam(value = "senha", required = false) String senha,
            @RequestParam(value = "mensagem", required = false) String mensagem,
            ModelMap map) {
        opr = ("".equals(opr) || opr == null) ? "-1" : opr;
        switch (opr) {
            case "1":
                map.addAttribute("usr", usuario + " : " + senha);
                break;
            case "2":
                map.addAttribute("usr", usuario + " : " + senha);

                return "admin/home";
            default:

                return "redirect:/login?opr=1";

        }
        map.addAttribute("mensagem", mensagem);
        return "autenticacao/entrar";
    }

    @RequestMapping(value = "/redirect")
    public String redirecionar(@RequestParam(value = "p") String p,
            @RequestParam(value = "a") String a) {

        return p + "/" + a;
        //return "organizacao";
    }
/*
    @RequestMapping(value = "/pesquisarOrg")
    public String pesquisarOrg(@RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "obj_social", required = true) String objectosocial,
            @RequestParam(value = "plano", required = true) String plano,
            @RequestParam(value = "datainicio_ia", required = true) String datainicio_ia,
            @RequestParam(value = "datafim_ia", required = true) String datafim_ia,
            @RequestParam(value = "datainicio_fa", required = true) String datainicio_fa,
            @RequestParam(value = "datafim_fa", required = true) String datafim_fa, HttpSession mod) {

        nome = nome.equals("") ? null : nome;
        objectosocial = objectosocial.equals("") ? null : objectosocial;
        plano = plano.equals("") ? null : plano;
        datainicio_ia = datainicio_ia.equals("") ? null : datainicio_ia;
        datafim_ia = datafim_ia.equals("") ? null : datafim_ia;
        datainicio_fa = datainicio_fa.equals("") ? null : datainicio_fa;
        datafim_fa = datafim_fa.equals("") ? null : datafim_fa;

        if (nome == null && objectosocial == null && plano == null && datainicio_ia == null && datafim_ia == null && datainicio_fa == null && datafim_fa == null) {
            mod.setAttribute("organizacao", OrgLogica.getTodasOrgs());
        } else {
            mod.setAttribute("organizacao", OrgLogica.getTodasOrgs(nome, objectosocial, plano, datainicio_ia, datafim_ia, datainicio_fa, datafim_fa));

        }

        return "admin/org/organizacao";
        //return "organizacao";
    }

    @RequestMapping(value = "/definicoes")
    public String getDefinicoes(@RequestParam(value = "idorg", required = true) int idorg,
            @RequestParam(value = "def_opr", required = true) String opr,
            ModelMap mod) {

        switch (opr) {
            case "defOrg":
                mod.addAttribute("organizacao", OrgLogica.getOrgPorId(idorg));
                return "admin/org/definicoes";
            case "defCand":
                return "admin/candidato/definicoes";
            default:
                return "admin/home";
        }

        //return "organizacao";
    }
*/
    @RequestMapping(value = "/iniciarsessao")
    public String login(@RequestParam(value = "utilizador", required = true) String utilizador,
            @RequestParam(value = "senha", required = true) String senha,
            ModelMap mod, HttpSession session, HttpServletRequest request) {

        Admin admin = new Admin(utilizador, senha);

        if (new AdminLogica(request).eAdmin(admin)) {
            session.setAttribute("admin", "Administrador Master");
            session.setAttribute("utilizadorLogado", admin);
            return "admin/home";
        }
        mod.addAttribute("mensagem", "Erro ao efectuar Autenticação!");
        return "redirect:/login?opr=1";

    }

    @RequestMapping(value = "/terminarsessao")
    public String logout(@RequestParam(value = "idorg", required = true) int idorg,
            @RequestParam(value = "def_opr", required = true) String opr,
            HttpSession session) {

        session.invalidate();

        return "redirect:/";

    }

   /* @RequestMapping(value = "/alterarOrg")
    public String alterarOrganizacao(@RequestParam(value = "idorg", required = true) int idorg,
            @RequestParam(value = "def_opr", required = true) String opr,
            @RequestParam("datainicioadesao") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datainicioadesao,
            @RequestParam("datafimadesao") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datafimadesao,
            ModelMap mod) {

        switch (opr) {
            case "defOrg":
                mod.addAttribute("organizacao", OrgLogica.getOrgPorId(idorg));
                return "admin/org/definicoes";
            case "defCand":
                return "admin/candidato/definicoes";
            default:
                return "redirect:/";
        }

    }

    @RequestMapping(value = "/alterarEstadoConta")
    public void alterarEstadoConta(HttpServletResponse response,
            @RequestParam("idorg") int idorg, ModelMap mod) throws IOException {
        OrgLogica.alterarEstadoConta(idorg);

        response.sendRedirect("definicoes?def_opr=defOrg&idorg=" + idorg);
    }*/
}
