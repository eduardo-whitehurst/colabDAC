package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.dao.ServicoDao;
import br.com.colabdac.colabdac.entities.Cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarServico implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idServico = req.getParameter("idServico");
        Long id = Long.parseLong(idServico);

        ServicoDao dao = new ServicoDao();
        dao.remover(id);

        res.sendRedirect("listaServicos");
    }

}
