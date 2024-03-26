package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.FuncionarioDao;
import br.com.colabdac.colabdac.entities.Funcionario;
import br.com.colabdac.colabdac.logica.Logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
public class ListarFuncionarios implements Logica {
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        FuncionarioDao funcionarioDao;

        try {
            funcionarioDao = new FuncionarioDao();

            List<Funcionario> funcionarios = funcionarioDao.listarTodos();
            req.setAttribute("funcionarios", funcionarios);

            RequestDispatcher rd = req.getRequestDispatcher("pagina-funcionarios.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
