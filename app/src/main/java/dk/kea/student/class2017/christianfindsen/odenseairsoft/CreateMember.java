package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateMember extends AppCompatActivity
{
    DatabaseHandler myDb;

    EditText editNavn, editEfternavn, editAdresse, editTelefon, editEmail;
    Button btn_create_addMember, btn_create_back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_member);
        myDb = new DatabaseHandler(this);
        editNavn = (EditText)findViewById(R.id.editNavn);
        editEfternavn = (EditText)findViewById(R.id.editEfternavn);
        editAdresse = (EditText)findViewById(R.id.editAdresse);
        editTelefon = (EditText)findViewById(R.id.editTelefon);
        editEmail = (EditText)findViewById(R.id.editEmail);
        btn_create_addMember = (Button)findViewById(R.id.btn_create_addMember);
        addData();
        backToMain();
    }

    public void addData()
    {

        btn_create_addMember.setOnClickListener(
                new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             boolean isInserted = myDb.insertData(
                     editNavn.getText().toString(),
                     editEfternavn.getText().toString(),
                     editAdresse.getText().toString(),
                     editTelefon.getText().toString(),
                     editEmail.getText().toString());

                if (isInserted == true)
             {
                 Toast.makeText(CreateMember.this, "Medlem tilføjet", Toast.LENGTH_SHORT).show();
                 editNavn.getText().clear();
                 editEfternavn.getText().clear();
                 editAdresse.getText().clear();
                 editTelefon.getText().clear();
                 editEmail.getText().clear();
             }else
             {
                 Toast.makeText(CreateMember.this, "Noget gik galt!", Toast.LENGTH_SHORT).show();
             }

            }
        });
    }

    public void backToMain()
    {
        btn_create_back = (Button)findViewById(R.id.btn_create_back) ;
        btn_create_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent getBack = new Intent(CreateMember.this,Mainmenu.class);
                startActivity(getBack);
            }
        });
    }
}
