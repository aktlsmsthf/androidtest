package com.example.user.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ListView listview = (ListView) findViewById(R.id.listview);
        ListViewAdapter adapter = new ListViewAdapter();

        listview.setAdapter(adapter);

        String str = "[{'name':'이창훈', 'number':'010-9335-9510'},"+
                    "{'name':'으으으', 'number':'000-0000-0000'},"+
                    "{'name':'가나다', 'number':'012-3456-7890'}]";

        try{
            JSONArray jarray = new JSONArray(str);
            for(int i=0; i<jarray.length(); i++){
                JSONObject jobject = jarray.getJSONObject(i);
                String name = jobject.getString("name");
                String number = jobject.getString("number");

                adapter.addItem(name, number);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }

}
