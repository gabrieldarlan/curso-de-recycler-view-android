package br.com.gdarlan.ceep.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.gdarlan.ceep.R;
import br.com.gdarlan.ceep.dao.NotaDAO;
import br.com.gdarlan.ceep.model.Nota;
import br.com.gdarlan.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Nota";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);
        setTitle(TITULO_APPBAR);

        final List<Nota> todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);

        TextView botaoInsereNota = findViewById(R.id.lista_notas_insere_nota);
        botaoInsereNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent iniciaFormularioNota = new Intent(ListaNotasActivity.this,
                        FormularioNotaActivity.class);
                startActivity(iniciaFormularioNota);
            }
        });
    }

    private List<Nota> notasDeExemplo() {
        final NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeiro nota", "Descrição pequena"), new Nota("Segunda nota",
                "Descrição bem maior do que a primeira"));
        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        final RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdapter(todasNotas, listaNotas);
    }


    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }

}