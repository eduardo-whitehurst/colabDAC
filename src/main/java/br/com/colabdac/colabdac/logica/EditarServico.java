package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.dao.ServicoDao;
import br.com.colabdac.colabdac.entities.Cliente;
import br.com.colabdac.colabdac.entities.Servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarServico implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idServico = req.getParameter("id");
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String valor = req.getParameter("valor");
        String idFuncionario = req.getParameter("idFuncionario");

        Servico servico = new Servico();
        servico.setId(Long.parseLong(idServico));
        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setValor(Double.parseDouble(valor));
        servico.setIdFuncionario(Long.parseLong(idFuncionario));

        ServicoDao dao;
        try {
            dao = new ServicoDao();
            dao.alterar(servico);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaClientes");
    }

}
