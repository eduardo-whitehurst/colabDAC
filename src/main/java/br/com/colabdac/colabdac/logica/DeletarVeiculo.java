package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VeiculoDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarVeiculo implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idVeiculo = req.getParameter("idVeiculo");
        Long id = Long.parseLong(idVeiculo);

        VeiculoDao dao = new VeiculoDao();
        dao.remover(id);

        res.sendRedirect("listaVeiculos");
    }
}
