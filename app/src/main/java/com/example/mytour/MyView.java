package com.example.mytour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyView extends AppCompatActivity {
    private RecyclerView recyclerView;
    viewAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        

        mbase = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Imagemodel>options = new FirebaseRecyclerOptions.Builder<Imagemodel>()
                .setQuery(mbase, Imagemodel.class)
                .build();

        adapter = new viewAdapter(options);
        recyclerView.setAdapter(adapter);
    }
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}