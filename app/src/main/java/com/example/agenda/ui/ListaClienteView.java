package com.example.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.agenda.DAO.ClienteDAO;
import com.example.agenda.model.Cliente;
import com.example.agenda.ui.adapter.ListaClienteAdapter;

public class ListaClienteView {

    private final ListaClienteAdapter adapter;
    private final ClienteDAO dao;
    private final Context context;

    public ListaClienteView(Context context) {
        this.context = context;
        this.adapter = new ListaClienteAdapter(this.context);
        this.dao = new ClienteDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo cliente")
                .setMessage("Tem ceteza que quer remover o cliente")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Cliente clienteEscolhido = adapter.getItem(menuInfo.position);
                        remove(clienteEscolhido);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaCliente() {
        adapter.atualia(dao.todos());
    }

    public void remove(Cliente cliente) {
        dao.remove(cliente);
        adapter.remove(cliente);
    }

    public void configuraAdapter(ListView listaDeCliente) {

        listaDeCliente.setAdapter(adapter);
    }

}


