package com.example.android.findyourbook;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String URL=
            "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
  private bookadapter mAdapter;
    EditText textis;
    String temp="";
    Button button;
    EditText editText;
    int sig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView bookListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new bookadapter(this, new ArrayList<four_data>());

        bookListView.setAdapter(mAdapter);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
         button.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 temp = editText.getText().toString();
                 StringBuilder sb1 = new StringBuilder("https://www.googleapis.com/books/v1/volumes?q=");
                 sb1.append(temp);
                 sb1.append("&maxResults=10");
                 temp = sb1.toString();
       //             display.setText(temp);
                 URL = temp;
                bookAsyncTask task = new bookAsyncTask();
        task.execute(URL);

             }
         });



    }


    private class bookAsyncTask extends AsyncTask<String, Void, List<four_data>> {

        @Override
        protected List<four_data> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<four_data> result = Query.fetchBookData(urls[0]);
            return result;
        }


        @Override
        protected void onPostExecute(List<four_data> data) {
            mAdapter.clear();
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }



}






