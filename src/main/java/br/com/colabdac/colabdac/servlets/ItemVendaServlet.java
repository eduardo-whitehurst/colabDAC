package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraItemVenda", "/removeItemVenda"})
public class ItemVendaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();

        if (action.equals("/removeItemVenda")) {
            remover(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraItemVenda")) {
            adicionarItemVenda(request, response);
        }
    }


    public void adicionarItemVenda(HttpServletRequest request, HttpServletResponse response) {
        AdicionaItemVenda adicionaItemVenda = new AdicionaItemVenda();
        try {
            adicionaItemVenda.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarItemVenda deletarItemVenda = new DeletarItemVenda();

        try {
            deletarItemVenda.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
