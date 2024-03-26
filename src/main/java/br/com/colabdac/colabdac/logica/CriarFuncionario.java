package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.FuncionarioDao;
import br.com.colabdac.colabdac.entities.Funcionario;
import br.com.colabdac.colabdac.logica.Logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CriarFuncionario implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // buscando os parâmetros no request
        String name = req.getParameter("nome");
        String funcao = req.getParameter("funcao");
        String cpf = req.getParameter("cpf");

        //Montando  o obejto cliente
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(name);
        funcionario.setFuncao(funcao);
        funcionario.setCpf(cpf);

        //salvar o cliente
        FuncionarioDao dao;
        try {
            dao = new FuncionarioDao();
            dao.inserirFuncionario(funcionario);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/FuncionarioAdd.jsp");
        rd.forward(req, res);
    }
}
