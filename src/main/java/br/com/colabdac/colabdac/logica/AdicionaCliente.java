package br.com.colabdac.colabdac.logica;

import br.com.colabdac.colabdac.dao.ClienteDao;
import br.com.colabdac.colabdac.entities.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaCliente implements Logica{
    @Override
    public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("Executando");

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        ClienteDao clienteDao;

        try {
            clienteDao = new ClienteDao();
            clienteDao.inserirCliente(cliente);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/cliente-adicionado.jsp");
        rd.forward(req, res);


    }

}
