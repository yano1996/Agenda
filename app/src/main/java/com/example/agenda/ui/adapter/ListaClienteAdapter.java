package com.example.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListaClienteAdapter extends BaseAdapter {
    
    
    private final List<Cliente> clientes = new ArrayList<>();
    private final Context context;

    public ListaClienteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.size();

    }

    @Override
    public Cliente getItem(int posicao) {
        return clientes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return clientes.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View View, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);
        Cliente clienteDevolvido = clientes.get(posicao);
        vincula(viewCriada, clienteDevolvido);
        return viewCriada;
    }

    private void vincula(View view, Cliente cliente) {
        TextView nome = view.findViewById(R.id.item_cliente_nome);
        nome.setText(cliente.getNome());
        TextView telefone = view.findViewById(R.id.item_cliente_telefone);
        telefone.setText(cliente.getTelefone()) ;
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_cliente, viewGroup, false);
    }


    public void atualia(List<Cliente> clientes){
        this.clientes.clear();
        this.clientes.addAll(clientes);
        notifyDataSetChanged();
    }

    public void remove(Cliente cliente) {
        clientes.remove(cliente);
        notifyDataSetChanged();
    }
}
