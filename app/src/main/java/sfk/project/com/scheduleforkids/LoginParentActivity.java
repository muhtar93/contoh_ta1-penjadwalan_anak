package sfk.project.com.scheduleforkids;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import sfk.project.com.scheduleforkids.config.Config;
import sfk.project.com.scheduleforkids.handler.RequestHandler;

public class LoginParentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private TextView textViewLupakKtaSandi;
    EditText username_ortu, password_ortu;
    SessionParent session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_login_ortu);

        session = new SessionParent(getApplicationContext());
        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG)
                .show();

        username_ortu = (EditText) findViewById(R.id.usernameParent);
        password_ortu = (EditText) findViewById(R.id.passwordParent);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        //btnLogin.setOnClickListener(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                //startActivity(new Intent(LoginParentActivity.this, MainMenuParentActivity.class));
            }
        });

        textViewLupakKtaSandi = (TextView) findViewById(R.id.lupaKataSandi);
        textViewLupakKtaSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginParentActivity.this, ForgotPasswordActivity.class));
            }
        });
    }

    private void login() {
        String username = username_ortu.getText().toString().trim();
        String password = password_ortu.getText().toString().trim();

        if (username_ortu.getText().toString().trim().length() > 0
                && password_ortu.getText().toString().trim().length() > 0)
        {
            userLogin(username, password);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Username/Password is Empty!!", Toast.LENGTH_LONG).show();
        }
    }

    private void userLogin(final String username, final String password) {
        class UserLoginClass extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginParentActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equalsIgnoreCase("Success")) {
                    Intent intent = new Intent(LoginParentActivity.this, MainMenuParentActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra(Config.USER_NAME, username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), " Invalid Email/Password!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> data = new HashMap<>();
                data.put("username_ortu", params[0]);
                data.put("password_ortu", params[1]);

                session.createLoginSession(username, password);

                RequestHandler ruc = new RequestHandler();
                String result = ruc.sendPostRequest(Config.URL_LOGIN, data);
                return result;
            }
        }

        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(username, password);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            login();
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), BeforeLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}