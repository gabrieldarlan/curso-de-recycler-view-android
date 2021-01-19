package br.com.gdarlan.ceep.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.gdarlan.ceep.R;
import br.com.gdarlan.ceep.model.Nota;

import static br.com.gdarlan.ceep.ui.activity.NotaActivityConstatnes.CHAVE_NOTA;
import static br.com.gdarlan.ceep.ui.activity.NotaActivityConstatnes.CODIGO_RESULTADO_NOTA_CRIADA;

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
        if (isMenuSalvaNota(itemId)) {
            final Nota notaCriada = criadaNota();
            retornaNota(notaCriada);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void retornaNota(Nota nota) {
        final Intent resultadoInsercao = new Intent();
        resultadoInsercao.putExtra(CHAVE_NOTA, nota);
        setResult(CODIGO_RESULTADO_NOTA_CRIADA,resultadoInsercao);
    }

    private Nota criadaNota() {
        final EditText titulo = findViewById(R.id.formulario_nota_titulo);
        final EditText descricao = findViewById(R.id.formulario_nota_descricao);
        return new Nota(titulo.getText().toString(),
                descricao.getText().toString());
    }

    private boolean isMenuSalvaNota(int itemId) {
        return itemId == R.id.menu_formulario_nota_ic_salva;
    }
}