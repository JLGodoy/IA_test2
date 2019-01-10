package e.juanluis.ia_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.juanluis.ia_test.Data.UserModel;
import e.juanluis.ia_test.R;

public class MainActivity extends AppCompatActivity{

    private EditText EmailET, PasswordET;
    private Button LogInButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailET = (EditText) findViewById(R.id.email);
        PasswordET = (EditText) findViewById(R.id.password);
        LogInButton = (Button) findViewById(R.id.loginBtn);
        LogInButton.setOnClickListener((View.OnClickListener) this);
    }

    public void onClickLogIn(View view) {

        String userMail = EmailET.getText().toString();
        String userPassword = PasswordET.getText().toString();

        UserModel user = new UserModel();
        user.setEmail(userMail);
        user.setPassword(userPassword);


        if (userMail.isEmpty()){
            Toast.makeText(this, "Introduzca su Email", Toast.LENGTH_SHORT).show();
        }else if (userPassword.isEmpty()){
            Toast.makeText(this, "Contraseña no valida", Toast.LENGTH_SHORT).show();
        } else{

        }

    }


}



