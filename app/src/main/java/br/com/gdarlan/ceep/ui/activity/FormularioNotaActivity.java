package br.com.gdarlan.ceep.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.gdarlan.ceep.R;
import br.com.gdarlan.ceep.dao.NotaDAO;
import br.com.gdarlan.ceep.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_nota_salva, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int itemId = item.getItemId();
        if (itemId == R.id.menu_formulario_nota_ic_salva) {
            final EditText titulo = findViewById(R.id.formulario_nota_titulo);
            final EditText descricao = findViewById(R.id.formulario_nota_descricao);
            final Nota notaCriada = new Nota(titulo.getText().toString(),
                    descricao.getText().toString());

            final Intent resultadoInsercao = new Intent();
            resultadoInsercao.putExtra("nota", notaCriada);
            setResult(2,resultadoInsercao);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}