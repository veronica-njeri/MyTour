package com.example.mytour;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import java.text.BreakIterator;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class viewAdapter extends FirebaseRecyclerAdapter<Imagemodel, viewAdapter.viewViewholder> {
    public viewAdapter(
            @NonNull FirebaseRecyclerOptions<Imagemodel> options)
    {super(options);}
    // Function to bind the view in Card view(here
    // "person.xml") with data in
    // model class(here "person.class")
    @Override
    protected void onBindViewHolder(@NonNull viewViewholder holder, int position, @NonNull Imagemodel model) {
        holder.description.setText(model.getDescription());
        holder.name.setText(model.getName());
        Picasso.get().load(model.getImageURL()).into(holder.imageURL);


    }
    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public viewViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new viewAdapter.viewViewholder(view);
    }

    // Sub Class to create references of the views in Card
    // view (here "person.xml")
    public class viewViewholder extends RecyclerView.ViewHolder {
        ImageView imageURL;
        CardView cardView;
        TextView name, description ;
        public viewViewholder(@NonNull  View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.card_view_top);
            imageURL =(ImageView) itemView.findViewById(R.id.imageURL);
            name =(TextView) itemView.findViewById(R.id.name);


            description =(TextView) itemView.findViewById(R.id.description);
        }
    }
}
