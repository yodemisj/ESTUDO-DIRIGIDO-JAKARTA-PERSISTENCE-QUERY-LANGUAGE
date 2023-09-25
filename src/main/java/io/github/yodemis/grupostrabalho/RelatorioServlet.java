/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.yodemis.grupostrabalho;

import io.github.yodemis.grupostrabalho.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author yodem
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/Relatorios"})
@Transactional
public class RelatorioServlet extends HttpServlet {
    @Inject
    private PessoaBeanLocal pb;
    @Inject
    private GrupoBeanLocal gb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PessoaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>Consulta 1.A: Quais as pessoas (dados completos) cadastradas? Por meio de Query</h2>");

            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findAllPessoaQuery())
                    + "</pre></p>");

            out.println("<h2>Consulta 1.B: Quais as pessoas (dados completos) cadastradas? Por meio de TypedQuery</h2>");

            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findAllPessoaQuery())
                    + "</pre></p>");
            
            out.println("<h2>Consulta 1.C: Quais as pessoas (dados completos) cadastradas? Por meio de NamedQuery</h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findAllPessoaQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 2.A: Quais os nomes das pessoas? Por meio de Query </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomePessoaQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 2.B: Quais os nomes das pessoas? Por meio de TypedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomePessoaTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 2.C: Quais os nomes das pessoas? Por meio de NamedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomePessoaNamedQuery())
                    + "</pre></p>");
        
            out.println("<h2> Consulta 3.A: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? "
                + "Por meio de Query </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeEnderecoPessoaQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 3.B: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? "
                + "Por meio de TypedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeEnderecoPessoaTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 3.C: Quais as pessoas (nome) e seus respectivos endereços (dados completos)? "
                + "Por meio de NamedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeEnderecoPessoaNamedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 4.A: Quais pessoas (dados completos) moram em avenidas? Por meio de Query </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoaByTipoLogradouroQuery(TipoLogradouro.AVENIDA))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 4.B: Quais pessoas (dados completos) moram em avenidas? Por meio de TypedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoaByTipoLogradouroTypedQuery(TipoLogradouro.AVENIDA))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 4.C: Quais pessoas (dados completos) moram em avenidas? Por meio de NamedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoaByTipoLogradouroNamedQuery(TipoLogradouro.AVENIDA))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 5.A: Quais pessoas (dados completos) não moram em praças? Por meio de Query </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasSemTipoLogradouroQuery(TipoLogradouro.PRACA))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 5.B: Quais pessoas (dados completos) não moram em praças? Por meio de TyoedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasSemTipoLogradouroTypedQuery(TipoLogradouro.PRACA))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 5.C: Quais pessoas (dados completos) não moram em praças? Por meio de NamedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasSemTipoLogradouroNamedQuery(TipoLogradouro.PRACA))
                    + "</pre></p>");
            
            
            out.println("<h2> Consulta 6.A: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? " +
"Por meio de Query </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeTelefonesPessoasQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 6.B: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? " +
"Por meio de TypedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeTelefonesPessoasTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 6.C: Quais os nomes das pessoas e seus respectivos telefones (dados completos)? " +
"Por meio de NamedQuery </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findNomeTelefonesPessoasNamedQuery())
                    + "</pre></p>");
            
            out.println("<h2> 07. Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasBydataNascimentoTypedQuery(LocalDate.of(2001, Month.APRIL, 1), LocalDate.of(2004, Month.APRIL, 30)))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 8.A: Quais pessoas (dados completos) têm telefone do estado do Paraná? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasByDDDTypedQuery((byte)44))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 8.B: Quais pessoas (dados completos) têm telefone do estado do Rio de Janeiro? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasByDDDTypedQuery((byte)22))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 9: Quais pessoas (dados completos) não possuem telefone? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.findPessoasSemTelefoneTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 10: Quantos telefones cada pessoa (nome) tem? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(pb.countTelefonesPessoaTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 11: Quais grupos (dados completos) não estão ativos? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findGruposInativosTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 12: Quais são os líderes (nomes) dos grupos (nomes)? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findLiderGruposTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 13: Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com" +
"ordenação alfabética inversa? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findNomeMembroGrupoTypedQuery("Estudo IV"))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 14: Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findGrupoByliderTypedQuery("Beatriz Yana"))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 15: Quais são as datas de início e de término da atuação e os grupos (nomes) nos" +
"quais \"Cecília Xerxes\" é membro? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findAtuacaoGrupoByNomeTypedQuery("Cecília Xerxes"))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 16: Quais são os grupos (dados completos) que contêm \"II\" em seus nomes? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findGruposBySubstringTypedQuery("II"))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 17: Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.countMebrosGruposTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 18: Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses\n" +
"totais de atuações? </h2>");
            
            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findGruposByQuantidadeAtuacaoTypedQuery(3))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 19: Quais membros (nomes) entraram a partir de 2012 no primeiro grupo? </h2>");
            List<Long> gruposId = new ArrayList<>();
            gruposId.add((long) 1);            ;
//            gruposId.add((long) 2);
//            gruposId.add((long) 3);
//            gruposId.add((long) 4);

            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findMembrosByDataAtuacaoTypedQuery(gruposId,LocalDate.of(2012, 1, 1)))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 20: Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada\n" +
"daqueles que entraram a partir de 2012 em qualquer grupo? </h2>");
            List<Long> gruposId2 = new ArrayList<>();
            gruposId2.add((long) 1);            ;
            gruposId2.add((long) 2);
            gruposId2.add((long) 3);
            gruposId2.add((long) 4);

            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findMembrosDtoByDataAtuacaoTypedQuery(gruposId2,LocalDate.of(2012, 1, 1)))
                    + "</pre></p>");
            
            out.println("<h2> Consulta 21: Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data\n" +
"de término de atuação em seus grupos? </h2>");

            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findMembrosDtoSemDataFimTypedQuery())
                    + "</pre></p>");
            
            out.println("<h2> Consulta 22: Quais são os grupos (nomes) e líderes (nomes) com respectivos membros\n" +
"(nomes)? </h2>");

            out.println("<p><pre class=\"high\">"
                    + Util.toJson(gb.findGruposNomeLiderMembrosTypedQuery())
                    + "</pre></p>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
