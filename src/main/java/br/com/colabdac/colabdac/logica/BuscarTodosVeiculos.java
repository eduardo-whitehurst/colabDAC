package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.VeiculoDao;
import br.com.colabdac.colabdac.entities.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BuscarTodosVeiculos implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        VeiculoDao veiculoDao;

        try {
            veiculoDao = new VeiculoDao();

            List<Veiculo> veiculos = veiculoDao.listarTodos();
            req.setAttribute("veiculos", veiculos);

            RequestDispatcher rd = req.getRequestDispatcher("pages/paginaVeiculos.jsp");
            rd.forward(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
