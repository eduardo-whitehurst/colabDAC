package br.com.colabdac.colabdac.logica;


import br.com.colabdac.colabdac.dao.VeiculoDao;
import br.com.colabdac.colabdac.entities.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaVeiculo implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        int ano = Integer.parseInt(req.getParameter("ano"));

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setAno(ano);

        VeiculoDao veiculoDao;

        try {
            veiculoDao = new VeiculoDao();
            veiculoDao.inserirVeiculo(veiculo);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("pages/paginaVeiculos.jsp");
        rd.forward(req, res);
    }

}
