package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraServicoVenda", "/removeServicoVenda"})
public class ServicoVendaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();

        if (action.equals("/removeServicoVenda")) {
            remover(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraServicoVenda")) {
            adicionarServicoVenda(request, response);
        }
    }


    public void adicionarServicoVenda(HttpServletRequest request, HttpServletResponse response) {
        AdicionaServicoVenda adicionaServicoVenda = new AdicionaServicoVenda();
        try {
            adicionaServicoVenda.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarServicoVenda deletarServicoVenda = new DeletarServicoVenda();

        try {
            deletarServicoVenda.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
