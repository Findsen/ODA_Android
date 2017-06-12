package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainmenu extends AppCompatActivity
{

    private Button logout,createMember,searchMember;

    private void logout()
    {
        logout = (Button)findViewById(R.id.mainmenu_Logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent logout = new Intent(Mainmenu.this, MainActivity.class);
                startActivity(logout);
            }
        });
    }
    private void createMember()
    {
        createMember = (Button)findViewById(R.id.mainmenu_createMember);
        createMember.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createMember = new Intent(Mainmenu.this,CreateMember.class);
                startActivity(createMember);
            }
        });
    }
    private void searchForMember()
    {
        searchMember = (Button)findViewById(R.id.searchMember);
        searchMember.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent searchMember = new Intent(Mainmenu.this,CheckMember.class);
                startActivity(searchMember);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        logout();
        createMember();
        searchForMember();
    }
}
