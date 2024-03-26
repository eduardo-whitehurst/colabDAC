package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.FuncionarioDao;
import br.com.colabdac.colabdac.entities.Funcionario;
import br.com.colabdac.colabdac.logica.Logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarFuncionario implements Logica {
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idFuncionario = req.getParameter("id");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String funcao = req.getParameter("funcao");

        Funcionario funcionario = new Funcionario();
        funcionario.setId(Long.parseLong(idFuncionario));
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setFuncao(funcao);

        FuncionarioDao dao;
        try {
            dao = new FuncionarioDao();
            dao.alterar(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaFuncionarios");
    }
}
