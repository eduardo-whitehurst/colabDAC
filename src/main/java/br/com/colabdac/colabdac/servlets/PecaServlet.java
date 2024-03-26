package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraPeca", "/listaPecas", "/editaPeca", "/selecionaPeca", "/removePeca"})
public class PecaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();

        if(action.equals("/listaPecas")){
            pecas(request, response);
        } else if (action.equals("/editaPeca")) {
            editarPecas(request, response);
        } else if (action.equals("/selecionaPeca")) {
            selecionarPorId(request, response);
        } else if (action.equals("/removePeca")) {
            remover(request, response);
        }
    }

    protected void pecas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuscarTodasPecas buscarTodasPecas = new BuscarTodasPecas();

        try {
            buscarTodasPecas.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraPeca")) {
            adicionarPeca(request, response);
        }
    }

    public void editarPecas(HttpServletRequest request, HttpServletResponse response) {
        EditarPeca editarPeca = new EditarPeca();

        try {
            editarPeca.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorIdPeca buscarPorIdPeca = new BuscarPorIdPeca();

        try {
            buscarPorIdPeca.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarPeca(HttpServletRequest request, HttpServletResponse response) {
        AdicionaPeca adicionaPeca = new AdicionaPeca();
        try {
            adicionaPeca.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarPeca deletarPeca = new DeletarPeca();

        try {
            deletarPeca.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}