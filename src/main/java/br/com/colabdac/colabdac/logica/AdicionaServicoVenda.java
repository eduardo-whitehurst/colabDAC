package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ServicoVendaDao;
import br.com.colabdac.colabdac.entities.ServicoVenda;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaServicoVenda implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idVenda = req.getParameter("idVenda");
        String idServico = req.getParameter("idServico");
        String idVeiculo = req.getParameter("idVeiculo");

        ServicoVenda servicoVenda = new ServicoVenda();
        servicoVenda.setIdVenda(Long.valueOf(idVenda));
        servicoVenda.setIdServico(Long.valueOf(idServico));
        servicoVenda.setIdVeiculo(Long.valueOf(idVeiculo));

        ServicoVendaDao dao;

        try {
            dao = new ServicoVendaDao();
            dao.inserirServicoVenda(servicoVenda);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/servicovenda-adicionado.jsp");
        rd.forward(req, res);


    }

}