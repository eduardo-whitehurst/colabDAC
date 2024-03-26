package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.entities.Cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarCliente implements Logica {

    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String idCliente = req.getParameter("id");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");

        Cliente cliente = new Cliente();
        cliente.setId(Long.parseLong(idCliente));
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.altera(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("listaClientes");
    }

}
