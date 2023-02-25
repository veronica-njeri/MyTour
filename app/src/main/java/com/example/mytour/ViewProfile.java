//package com.example.mytour;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import com.google.android.material.progressindicator.CircularProgressIndicator;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class ViewProfile extends AppCompatActivity {
//    private static final String TAG = "ViewProfileActivity";
//    CircularProgressIndicator progress_circular;
//    RecyclerView recyclerView;
//    DatabaseReference databaseReference;
//    private Context mContext;
//    private Activity mActivity;
//    private ArrayList<Imagemodel> imagesList;
//    private ImageAdapter imageAdapter = null;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_profile);
//
//        mActivity = ViewProfile.this;
//        mContext = getApplicationContext();
//        FirebaseApp.initializeApp(this);
//        recyclerView = findViewById(R.id.recycler_view);
//        progress_circular = findViewById(R.id.progress_circular3);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2, GridLayoutManager.VERTICAL, false));
//        recyclerView.setNestedScrollingEnabled(false);
//        imagesList = new ArrayList<>();
//
//
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                imagesList.clear();
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    Imagemodel imagemodel = dataSnapshot.getValue(Imagemodel.class);
//                    imagesList.add(imagemodel);
//                }
//                imageAdapter = new ImageAdapter(mContext,mActivity, (ArrayList<Imagemodel>) imagesList);
//                recyclerView.setAdapter(imageAdapter);
//                imageAdapter.notifyDataSetChanged();
//                progress_circular.setVisibility(View.GONE);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ViewProfile.this,"Error:" + error.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}