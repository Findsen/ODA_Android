package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import dk.kea.student.class2017.christianfindsen.odenseairsoft.View.mainmenu;


public class MainActivity extends AppCompatActivity
{
    private Button login_button;
    private EditText pw;
    private EditText userText;
    private static final String TAG = "myActivity";



    public void login()
    {
        pw = (EditText)findViewById(R.id.login_pw);
        userText= (EditText)findViewById(R.id.loginName);


        login_button = (Button)findViewById(R.id.loginmenu_login);
        login_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (pw.getText().toString().equals("admin")&& userText.getText().toString().equals("admin"))
                {
                    Intent login = new Intent(MainActivity.this, mainmenu.class);
                    startActivity(login);
                }
            }

        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();

    }
}
