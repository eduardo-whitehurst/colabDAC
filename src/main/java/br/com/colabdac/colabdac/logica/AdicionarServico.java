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
        String idServico = req.getParameter("idServico");

        Servico servico = new Servico();
        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setValor(Double.parseDouble(valor));
        servico.setIdFuncionario(Long.parseLong(idServico));

        ServicoDao servicoDao;

        try {
            servicoDao = new ServicoDao();
            servicoDao.inserirServico(servico);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/Servico-adicionado.jsp");
        rd.forward(req, res);


    }

}
