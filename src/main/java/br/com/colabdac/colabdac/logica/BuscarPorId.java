package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.FuncionarioDao;
import br.com.colabdac.colabdac.entities.Funcionario;
import br.com.colabdac.colabdac.logica.Logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarPorId implements Logica {
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idCliente = req.getParameter("idFuncionario");
        Long id = Long.parseLong(idCliente);


        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = dao.buscarPorId(id);

        req.setAttribute("idFuncionario", funcionario.getId());
        req.setAttribute("nome", funcionario.getNome());
        req.setAttribute("funcao", funcionario.getFuncao());
        req.setAttribute("cpf", funcionario.getCpf());

        RequestDispatcher rd = req.getRequestDispatcher("editarFuncionario.jsp");
        rd.forward(req, res);
    }
}
