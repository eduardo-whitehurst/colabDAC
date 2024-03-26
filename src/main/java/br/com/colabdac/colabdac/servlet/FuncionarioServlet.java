package br.com.colabdac.colabdac.servlet;

import br.com.colabdac.colabdac.logica.BuscarPorId;
import br.com.colabdac.colabdac.logica.CriarFuncionario;
import br.com.colabdac.colabdac.logica.EditarFuncionario;
import br.com.colabdac.colabdac.logica.ListarFuncionarios;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastraFuncionarios", "/listaFuncionarios", "/editaFuncionarios", "/selecionaFuncionarios"})
public class FuncionarioServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();

        if(action.equals("/listaFuncionarios")){
            funcionarios(request, response);
        } else if (action.equals("/editaFuncionarios")) {
            editar(request, response);
        } else if (action.equals("/selecionaFuncionarios")) {
            selecionarPorId(request, response);
        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();
        if (action.equals("/cadastraFuncionarios")) {
            criarFuncionarios(request, response);
        }
    }


    public void criarFuncionarios(HttpServletRequest request, HttpServletResponse response) {
        CriarFuncionario criarFuncionario = new CriarFuncionario();
        try {
            criarFuncionario.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void funcionarios(HttpServletRequest request, HttpServletResponse response) {
        ListarFuncionarios buscarTodos = new ListarFuncionarios();

        try {
            buscarTodos.executa(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editar(HttpServletRequest request, HttpServletResponse response) {
        EditarFuncionario editarFuncionario = new EditarFuncionario();

        try {
            editarFuncionario.executa(request, response);
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

}
