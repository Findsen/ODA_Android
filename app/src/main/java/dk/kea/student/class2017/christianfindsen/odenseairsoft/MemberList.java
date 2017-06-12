package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberList extends AppCompatActivity
{

    DatabaseHandler myDb;
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        myDb = new DatabaseHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        myList = (ListView)findViewById(R.id.myList);
        populateList();
    }

    private void populateList()
    {
        Cursor data = myDb.getMembers();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext())
        {
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
            listData.add(data.getString(4));
            listData.add(data.getString(5));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        myList.setAdapter(adapter);
    }
}
