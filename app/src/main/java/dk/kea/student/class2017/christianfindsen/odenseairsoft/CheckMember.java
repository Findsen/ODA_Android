package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CheckMember extends AppCompatActivity
{
    DatabaseHandler myDb;
    EditText editSearchMember;
    Button btn_search_back, btn_search_search;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_member);
        myDb = new DatabaseHandler(this);
        editSearchMember = (EditText)findViewById(R.id.editSearchMember);
        btn_search_back = (Button)findViewById(R.id.btn_search_back);
        btn_search_search = (Button)findViewById(R.id.btn_search_search);
        showMemberData();
        backPressed();
    }

    private void backPressed()
    {
        btn_search_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent backMainmenu = new Intent(CheckMember.this,Mainmenu.class);
                startActivity(backMainmenu);
                finish();
            }
        });
    }

    private void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void showMemberData()
    {
        btn_search_search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Log.d("Find",editSearchMember.getText().toString());
                Cursor result = myDb.searchMember(editSearchMember.getText().toString());
                if (result.getCount() == 0)
                {
                    showMessage("ERROR","Medlem findes ikke");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext())
                {
                    buffer.append("ID :" + result.getString(0) +"\n");
                    buffer.append("Fornavn :" + result.getString(1) +"\n");
                    buffer.append("Efternavn :" + result.getString(2) +"\n");
                    buffer.append("Adresse :" + result.getString(3) +"\n");
                    buffer.append("Telefon :" + result.getString(4) +"\n");
                    buffer.append("Email :" + result.getString(5) +"\n");
                }
                showMessage("INFO om medlem",buffer.toString());
            }
        });
    }
}
