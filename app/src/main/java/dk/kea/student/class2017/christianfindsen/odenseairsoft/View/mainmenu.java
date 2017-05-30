package dk.kea.student.class2017.christianfindsen.odenseairsoft.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dk.kea.student.class2017.christianfindsen.odenseairsoft.MainActivity;
import dk.kea.student.class2017.christianfindsen.odenseairsoft.R;

public class mainmenu extends AppCompatActivity
{
    private Button memberlist;
    private Button createMember;
    private Button logout;

    public void logout()
    {
        logout = (Button)findViewById(R.id.mainmenu_Logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent logout = new Intent(mainmenu.this, MainActivity.class);
                startActivity(logout);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        logout();
    }
}
