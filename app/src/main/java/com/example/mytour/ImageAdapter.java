//package com.example.mytour;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.ArrayList;
//
//import androidx.appcompat.view.menu.MenuView;
//import androidx.cardview.widget.CardView;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.annotation.NonNull;
//
//public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private Context mContext;
//    private Activity mActivity;
//    private ArrayList<Imagemodel> mContentList;
//
//    public ImageAdapter(Context mContext, Activity mFragment, ArrayList<Imagemodel> mContentList){
//        this.mContext = mContext;
//        this.mActivity = mActivity;
//        this.mContentList = mContentList;
//
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
//        return null;
//    }
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//
//        private ImageView imgPost;
//        private TextView tvTitle, tvDesc;
//
//        public ViewHolder(View itemView, int viewType){
//            super(itemView);
//
//            //find all views ids
//            //cardView = (CardView) itemView.findViewById(R.id.card_view_top);
//            imgPost = (ImageView) itemView.findViewById(R.id.post_img);
//            tvTitle = (TextView) itemView.findViewById(R.id.title_text);
//            tvDesc = (TextView)  itemView.findViewById(R.id.description_text);
//
//        }
//    }
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder mainHolder, int position){
//        ViewHolder holder = (ViewHolder) mainHolder;
//        final Imagemodel model = mContentList.get(position);
//        // setting data over views
//        String imgUrl = model.getImageURL();
//        if (imgUrl != null && !imgUrl.isEmpty()) {
//            Glide.with(mContext)
//                    .load(imgUrl)
//                    .into(holder.imgPost);
//        }
//        holder.tvTitle.setText(model.getImagename());
//        holder.tvDesc.setText(model.getImagedescription());
//    }
//    @Override
//    public int getItemCount(){
//        return mContentList.size();
//    }
//}
