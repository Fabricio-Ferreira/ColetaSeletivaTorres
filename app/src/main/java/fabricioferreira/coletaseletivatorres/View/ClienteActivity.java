package fabricioferreira.coletaseletivatorres.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import fabricioferreira.coletaseletivatorres.Model.Cliente;
import fabricioferreira.coletaseletivatorres.Model.ClienteDB;
import fabricioferreira.coletaseletivatorres.R;

public class ClienteActivity extends Activity {

    public Cliente cliente;
    public ClienteDB clienteDB;

    public EditText edtNome;
    public EditText edtEmail;
    public EditText edtSenha;

    public Button btnEntrar;
    public Button btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        edtNome = (EditText) findViewById(R.id.editTextNome);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtSenha = (EditText) findViewById(R.id.editTextSenha);

        btnEntrar = (Button) findViewById(R.id.buttonEntrar);
        btnLimpar = (Button) findViewById(R.id.buttonLimpar);

        clienteDB = new ClienteDB(this);

        Intent intent = getIntent();
        if (intent != null){

            Bundle bundle = intent.getExtras();

            if (bundle != null){

                cliente = new Cliente();

                cliente.set_id(bundle.getInt("_id"));
                cliente.setNome(bundle.getString("nome"));
                cliente.setEmail(bundle.getString("email"));
                cliente.setSenha(bundle.getString("senha"));

                edtNome.setText(cliente.getNome());
                edtEmail.setText(cliente.getEmail());
                edtSenha.setText(cliente.getSenha());

            }

        }

    }

    public void Limpar (View view){

        edtNome.setText("");
        edtEmail.setText("");
        edtSenha.setText("");

        edtNome.requestFocus();

    }


    public void Salvar (View view){

        try{
            if (edtNome.getText() == null){
                Toast.makeText(ClienteActivity.this, "Insira o seu nome!", Toast.LENGTH_SHORT).show();
                edtNome.requestFocus();
            }else {
                if (edtEmail.getText() == null) {
                    Toast.makeText(ClienteActivity.this, "Insira seu email!", Toast.LENGTH_SHORT).show();
                    edtEmail.requestFocus();
                } else {
                    if (edtSenha.getText() == null) {
                        Toast.makeText(ClienteActivity.this, "Insira uma senha!", Toast.LENGTH_SHORT).show();
                        edtSenha.requestFocus();
                    } else {

                        cliente = new Cliente();
                        cliente.setNome(edtNome.getText().toString());
                        cliente.setEmail(edtEmail.getText().toString());
                        cliente.setSenha(edtSenha.getText().toString());

                        clienteDB.inserir(cliente);
                    }
                }
            }

            Toast.makeText(ClienteActivity.this, "Usuario salvo com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){

            Toast.makeText(ClienteActivity.this, "Erro ao salvar o usuario! \n"
                    + e.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }finally{
            chamaDrawerActivity(view);
        }


    }

    public void chamaDrawerActivity(View view){

        Intent intent = new Intent(this, DrawerActivity.class);
        startActivity(intent);
    }

}
