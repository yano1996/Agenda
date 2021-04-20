package com.example.agenda.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.ContextMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.DAO.ClienteDAO;
import com.example.agenda.R;
import com.example.agenda.model.Cliente;

import static com.example.agenda.ui.activity.ConstantesActivities.CHAVE_CLIENTE;

public class FormularioClienteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_NOVO_CLIENTE = "Novo cliente";
    public static final String TITULO_APPBAR_EDITAR_CLIENTE = "Editar cliente";

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoCpf;
    private EditText campoUf;
    private EditText campoDataDeNascimento;
    private EditText campoDataCadastro;
    private EditText campoHorarioCadastro;


    private final ClienteDAO dao = new ClienteDAO();
    private Cliente cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cliente);
        inicializacaoDosCampos();

        carregaAluno();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_cliente_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_formulario_cliente_menu_salvar){
            finalizaFormulario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if(dados.hasExtra(CHAVE_CLIENTE)){
            setTitle(TITULO_APPBAR_EDITAR_CLIENTE);
            cliente = (Cliente) dados.getSerializableExtra(CHAVE_CLIENTE);
            preencheCampo();
        } else {
            setTitle(TITULO_APPBAR_NOVO_CLIENTE);
            cliente = new Cliente();
        }
    }

    private void preencheCampo() {
        campoNome.setText(cliente.getNome());
        campoTelefone.setText(cliente.getTelefone());
        campoUf.setText(cliente.getUf());
        campoDataDeNascimento.setText(cliente.getDataDeNascimento());
        campoCpf.setText(cliente.getCpf());

    }


    private void finalizaFormulario() {
        preencheCliente();

        if(cliente.temIdValido()){
            dao.edita(cliente);
        }else{
            dao.salva(cliente);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_cliente_nome);
        campoTelefone = findViewById(R.id.activity_formulario_cliente_telefone);
        campoCpf = findViewById(R.id.activity_formulario_cliente_cpf);
        campoDataDeNascimento = findViewById(R.id.activity_formulario_cliente_nascimento);
        campoUf = findViewById(R.id.activity_formulario_cliente_uf);

    }


    private void preencheCliente() {
    Context context = getApplicationContext();

        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String cpf = campoCpf.getText().toString();
        String nascimento = campoDataDeNascimento.getText().toString();
        String uf = campoUf.getText().toString();

        if (uf != "SP" || uf != "sp" && cpf == null ) {
            new AlertDialog
                    .Builder(context)
                    .setTitle("CPF vazio")
                    .setMessage("Por favor, preencher o CPF");
        }else{
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setDataDeNascimento(nascimento);
        cliente.setUf(uf);}

    }
}