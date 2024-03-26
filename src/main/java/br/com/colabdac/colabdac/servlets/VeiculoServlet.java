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

@WebServlet(urlPatterns = {"/cadastraVeiculo", "/listaVeiculos", "/editarVeiculo", "/selectVeiculo", "/selectDelVeiculo"})
public class VeiculoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String sessionToken = (String) session.getAttribute("sessionToken");
        if (sessionToken != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/Veiculo.html");
            response.getWriter().append("Served at: ").append(request.getContextPath());
            String action = request.getServletPath();

            if(action.equals("/listaVeiculos")){
                veiculos(request, response);
            } else if (action.equals("/editarVeiculo")) {
                editar(request, response);
            } else if (action.equals("/selectVeiculo")) {
                selecionarPorId(request, response);
            } else if (action.equals("/selectDelVeiculo")) {
                remover(request, response);
            } else if (action.equals("/cadastraVeiculo")) {
                dispatcher = request.getRequestDispatcher("pages/cadastro-veiculo.jsp");
                dispatcher.forward(request, response);
            }else  {
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void veiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuscarTodosVeiculos buscarTodos = new BuscarTodosVeiculos();

        try {
            buscarTodos.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if(action.equals("/cadastraVeiculo")) {
            cadastrar(request, response);
        }
    }

    public void editar(HttpServletRequest request, HttpServletResponse response) {
        EditarVeiculo editarVeiculo = new EditarVeiculo();

        try {
            editarVeiculo.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selecionarPorId(HttpServletRequest request, HttpServletResponse response) {
        BuscarPorIdVeiculo buscarPorIdVeiculo = new BuscarPorIdVeiculo();

        try {
            buscarPorIdVeiculo.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) {
        AdicionaVeiculo addVeiculo = new AdicionaVeiculo();
        try {
            addVeiculo.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) {
        DeletarVeiculo deletarVeiculo = new DeletarVeiculo();

        try {
            deletarVeiculo.executa(request, response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}