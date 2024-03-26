package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VeiculoDao;
import br.com.colabdac.colabdac.entities.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarPorIdVeiculo implements Logica {
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idVeiculo = req.getParameter("idVeiculo");
        Long id = Long.parseLong(idVeiculo);

        VeiculoDao dao = new VeiculoDao();

        Veiculo veiculo = dao.buscarPorId(id);
        req.setAttribute("idVeiculo", veiculo.getId());
        req.setAttribute("modelo", veiculo.getModelo());
        req.setAttribute("marca", veiculo.getMarca());
        req.setAttribute("ano", veiculo.getAno());

        RequestDispatcher rd = req.getRequestDispatcher("pages/editarVeiculo.jsp");
        rd.forward(req, res);
    }
}