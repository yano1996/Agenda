package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.model.Cliente;
import com.example.agenda.ui.ListaClienteView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.agenda.ui.activity.ConstantesActivities.CHAVE_CLIENTE;

public class ListaClienteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Cliente";
    private final ListaClienteView listaClienteView = new ListaClienteView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);
        setTitle(TITULO_APPBAR);
        configuraFabNovoCliente();
        configuraLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
       getMenuInflater().inflate(R.menu.activity_lista_cliente_menu, menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_lista_alunos_menu_remover){
            listaClienteView.confirmaRemocao(item);

        }
        return super.onContextItemSelected(item);

    }

    private void configuraFabNovoCliente() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_clientes_fab_novo_cliente);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioModoInsereCliente();
            }
        });
    }

    private void abreFormularioModoInsereCliente() {
        startActivity(new Intent(this, FormularioClienteActivity.class));
    }

    @Override
    protected void onResume(){
        super.onResume();
        listaClienteView.atualizaCliente();
    }

    private void configuraLista() {
        ListView listaDeCliente = findViewById(R.id.activity_lista_clientes_listview);
        listaClienteView.configuraAdapter(listaDeCliente);
        configuraListenerDeCliquePorItem(listaDeCliente);
        registerForContextMenu(listaDeCliente);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeCliente) {
        listaDeCliente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id){
                Cliente clienteEscolhido = (Cliente) adapterView.getItemAtPosition(posicao);
                abreFormularioModoEditaCliente(clienteEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaCliente(Cliente cliente) {
        Intent vaiParaFormularioActivity = new Intent(ListaClienteActivity.this, FormularioClienteActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_CLIENTE, cliente);
        startActivity(vaiParaFormularioActivity);
    }
}