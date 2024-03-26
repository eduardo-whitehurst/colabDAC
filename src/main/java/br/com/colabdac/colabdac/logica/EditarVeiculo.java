package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VeiculoDao;
import br.com.colabdac.colabdac.entities.Veiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarVeiculo implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idVeiculo = req.getParameter("id");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String ano = req.getParameter("ano");

        Veiculo veiculo = new Veiculo();
        veiculo.setId(Long.parseLong(idVeiculo));
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setAno(Integer.parseInt(ano));

        VeiculoDao dao;
        try {
            dao = new VeiculoDao();
            dao.alterar(veiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaVeiculos");
    }

}