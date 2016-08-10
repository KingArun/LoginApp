package arun.loginapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.content.Intent;

public class LoginActivity extends Activity {
    private EditText emailEditText;
    private EditText passEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText) findViewById(R.id.editText_email);
        passEditText = (EditText) findViewById(R.id.editText_password);

        findViewById(R.id.btn_login).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                final String email = emailEditText.getText().toString();
                if (!isValidEmail(email)) {
                    emailEditText.setError("Invalid Email");
                }

                final String pass = passEditText.getText().toString();
                if (!isValidPassword(pass)) {
                    passEditText.setError("Invalid Password");
                }
                if(isValidEmail(email)&&isValidPassword(pass))
                {
                    onButtonClick(arg0);
                }

            }
        });
    }
public void onButtonClick(View v)
{
    if(v.getId()==R.id.btn_login)
    {
        Intent i = new Intent(LoginActivity.this,NextPage.class);
        startActivity(i);
    }
}
    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}