package br.com.colabdac.colabdac.servlets;

import br.com.colabdac.colabdac.logica.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraCliente", "/listaClientes", "/editarCliente", "/selectCliente", "/selectDelCliente"})
public class ClienteServerlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Cliente.html");
            response.getWriter().append("Served at: ").append(request.getContextPath());
            String action = request.getServletPath();

            if(action.equals("/listaClientes")){
                clientes(request, response);
            } else if (action.equals("/editarCliente")) {
                editar(request, response);
            } else if (action.equals("/selectCliente")) {
                selecionarPorId(request, response);
            } else if (action.equals("/selectDelCliente")) {
                remover(request, response);
            } else if (action.equals("/cadastraCliente")) {
                dispatcher = request.getRequestDispatcher("pages/adiciona-cliente.html");
                dispatcher.forward(request, response);
            } else {

                dispatcher.forward(request, response);
            }


        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
            dispatcher.forward(request, response);
        }




    }

    protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuscarTodosClientes buscarTodos = new BuscarTodosClientes();

        try {
            buscarTodos.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraCliente")) {
            cadastrar(request, response);
        }
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) {
        EditarCliente editarCliente = new EditarCliente();

        try {
            editarCliente.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorId buscarPorId = new BuscarPorId();

        try {
            buscarPorId.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) {
        AdicionaCliente addCliente = new AdicionaCliente();
        try {
            addCliente.executa(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarCliente deletarCliente = new DeletarCliente();

        try {
            deletarCliente.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
