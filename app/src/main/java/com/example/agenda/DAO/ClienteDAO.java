package com.example.agenda.DAO;

import com.example.agenda.model.Cliente;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class ClienteDAO {

    private final static List<Cliente> CLIENTES = new ArrayList<>();
    private static int contadorDeIds = 1;


    public void salva(Cliente cliente) {
        cliente.setId(contadorDeIds);
        CLIENTES.add(cliente);
        atualiaIds();
    }

    private int atualiaIds() {
        return contadorDeIds++;
    }

    public void edita(Cliente cliente) {
        Cliente clienteEncontrado = buscaAlunoPeloId(cliente);
        if (clienteEncontrado != null) {
            int posicaoDoCliente = CLIENTES.indexOf(clienteEncontrado);
            CLIENTES.set(posicaoDoCliente, cliente);
        }
    }

    private Cliente buscaAlunoPeloId(Cliente cliente) {
        for (Cliente a :
                CLIENTES) {
            if (a.getId() == cliente.getId()) {
                return a;
            }
        }
        return null;
    }


    public List<Cliente> todos(){
        return new ArrayList<>(CLIENTES);
    }

    public void remove(Cliente cliente) {
        Cliente clienteDevolvido = buscaAlunoPeloId(cliente);
        if(clienteDevolvido != null){
            CLIENTES.remove(clienteDevolvido);
    }
}
}
