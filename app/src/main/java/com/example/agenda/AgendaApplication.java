package com.example.agenda;

import android.app.Application;

import com.example.agenda.DAO.ClienteDAO;
import com.example.agenda.model.Cliente;

public class AgendaApplication extends Application {

   @Override
    public void onCreate(){
       super.onCreate();
       criaClientesDeTeste();
   }

    private void criaClientesDeTeste() {
        ClienteDAO dao = new ClienteDAO();
        dao.salva(new Cliente("Alex", "123456798", "2584876598","20/01/2020","SP"));
        dao.salva(new Cliente("Lucila", "789456132", "41858692","20/01/2020","SP"));
    }

}
