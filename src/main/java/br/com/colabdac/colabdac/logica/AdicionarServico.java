package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.dao.ServicoDao;
import br.com.colabdac.colabdac.entities.Cliente;
import br.com.colabdac.colabdac.entities.Servico;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarServico implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("Executando");

        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String valor = req.getParameter("valor");
        String id_funcionario = req.getParameter("id_funcionario");

        Servico servico = new Servico();
        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setValor(valor);
        servico.setIdFuncionario(Long.parseLong(id_funcionario));

        ServicoDao servicoDao;

        try {
            servicoDao = new ServicoDao();
            servicoDao.inserirServico(servico);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/servico-adicionado.jsp");
        rd.forward(req, res);

    }

}
