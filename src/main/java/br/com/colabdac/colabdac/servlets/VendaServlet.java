package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.entities.Cliente;
import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cadastraVenda", "/listaVendas", "/editaVenda", "/selecionaVenda", "/removeVenda"})
public class VendaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Venda.html");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();

        if(action.equals("/listaVendas")){
            vendas(request, response);
        } else if (action.equals("/editaVenda")) {
            editarVendas(request, response);
        } else if (action.equals("/selecionaVenda")) {
            selecionarPorId(request, response);
        } else if (action.equals("/removeVenda")) {
            remover(request, response);
        } else if(action.equals("/cadastraVenda")) {
            ClienteDao clienteDao = null;
            try {
                clienteDao = new ClienteDao();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            List<Cliente> clientes = clienteDao.all();
            System.out.println(clientes.isEmpty());
            request.setAttribute("clientes", clientes);
            dispatcher = request.getRequestDispatcher("pages/adiciona-venda.jsp");
            dispatcher.forward(request, response);
        } else {
            dispatcher.forward(request, response);
        }
    }

    protected void vendas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuscarTodasVendas buscarTodasVendas = new BuscarTodasVendas();

        try {
            buscarTodasVendas.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraVenda")) {
            adicionarVenda(request, response);
        }
    }

    public void editarVendas(HttpServletRequest request, HttpServletResponse response) {
        EditarVenda editarVenda = new EditarVenda();

        try {
            editarVenda.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorIdVenda buscarPorIdVenda = new BuscarPorIdVenda();

        try {
            buscarPorIdVenda.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarVenda(HttpServletRequest request, HttpServletResponse response) {
        AdicionaVenda adicionaVenda = new AdicionaVenda();
        try {
            adicionaVenda.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarVenda deletarVenda = new DeletarVenda();

        try {
            deletarVenda.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}