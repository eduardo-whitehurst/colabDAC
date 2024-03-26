package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarCliente implements Logica{

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idCliente = req.getParameter("idCliente");
        Long id = Long.parseLong(idCliente);

        ClienteDao dao = new ClienteDao();
        dao.remove(id);

        res.sendRedirect("listaClientes");
    }
}
