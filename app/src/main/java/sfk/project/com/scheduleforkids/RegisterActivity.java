package sfk.project.com.scheduleforkids;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import sfk.project.com.scheduleforkids.config.Config;
import sfk.project.com.scheduleforkids.handler.RequestHandler;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnDaftar;
    private EditText inputFullName;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputFullName = (EditText) findViewById(R.id.editTextNama);
        inputUsername = (EditText) findViewById(R.id.editTextUsername);
        inputEmail = (EditText) findViewById(R.id.editTextEmail);
        inputPassword = (EditText) findViewById(R.id.editTextPassword);

        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        /*btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, BeforeLoginActivity.class));
            }
        });*/

        btnDaftar.setOnClickListener(this);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Daftar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void registerOrtu() {

        final String nama_ortu = inputFullName.getText().toString().trim();
        final String username_ortu = inputUsername.getText().toString().trim();
        final String email_ortu = inputEmail.getText().toString().trim();
        final String password_ortu = inputPassword.getText().toString().trim();

        class register extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,"Memproses...","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), LoginParentActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_NAME,nama_ortu);
                params.put(Config.KEY_USERNAME,username_ortu);
                params.put(Config.KEY_EMAIL,email_ortu);
                params.put(Config.KEY_PASSWORD,password_ortu);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        register ae = new register();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnDaftar){

            if (inputFullName.getText().toString().trim().length() > 0
                    && inputUsername.getText().toString().trim().length() > 0
                    && inputEmail.getText().toString().trim().length() > 0
                    && inputPassword.getText().toString().trim().length() > 0
                    )
            {
                registerOrtu();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Isikan data dengan benar.", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), BeforeLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
