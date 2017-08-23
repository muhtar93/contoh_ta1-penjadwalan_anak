package sfk.project.com.scheduleforkids;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeforeLoginActivity extends AppCompatActivity {
    private Button btnKid;
    private Button btnParent;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_before_login);

        btnKid = (Button)findViewById(R.id.btnKid);
        btnParent = (Button)findViewById(R.id.btnParent);
        btnDaftar = (Button)findViewById(R.id.daftar);

        btnKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeforeLoginActivity.this, LoginChildActivity.class));
            }
        });

        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeforeLoginActivity.this, LoginParentActivity.class));
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BeforeLoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
