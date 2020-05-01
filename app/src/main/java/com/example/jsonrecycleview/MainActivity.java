package com.example.jsonrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    DetailsListPojo detailsListPojo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        recyclerView = findViewById( R.id.rvList );
        recyclerView.setHasFixedSize( true );

        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setItemAnimator( new DefaultItemAnimator() );

        detailsListPojo = new Gson().fromJson( parseJSONData(), DetailsListPojo.class );
        adapter = new MyAdapterRecyclerView( detailsListPojo.getDetailList(), this );
        recyclerView.setAdapter( adapter );
    }

    public String parseJSONData() {
        String JSONString = null;
        JSONObject jsonObject = null;
        try {
            InputStream inputStream = getAssets().open( "userDetail.json" );

            int sizeOfJSONFile = inputStream.available();

            byte[] bytes = new byte[sizeOfJSONFile];

            inputStream.read( bytes );

            inputStream.close();

            JSONString = new String( bytes, "UTF-8" );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return JSONString;
    }
}
