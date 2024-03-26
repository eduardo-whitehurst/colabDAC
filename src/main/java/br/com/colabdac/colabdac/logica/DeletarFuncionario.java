package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.FuncionarioDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarFuncionario implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idFuncionario = req.getParameter("idFuncionario");
        Long id = Long.parseLong(idFuncionario);

        FuncionarioDao dao = new FuncionarioDao();
        dao.remover(id);

        res.sendRedirect("listaFuncionarios");
    }
}