package com.example.ta_prakppb_ihsanh.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ta_prakppb_ihsanh.activity_class.DetailActivity;
import com.example.ta_prakppb_ihsanh.R;
import com.example.ta_prakppb_ihsanh.api.DataImageLinks;
import com.example.ta_prakppb_ihsanh.api.DataVolumeInfo;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<DataVolumeInfo> dataBuku;
    private List<DataImageLinks> dataGambar;
    private Context mContext;

    public BookAdapter(List<DataVolumeInfo> dataBuku, List<DataImageLinks> dataGambar, Context mContext) {
        this.dataBuku = dataBuku;
        this.dataGambar = dataGambar;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (dataBuku != null && dataGambar != null && position < dataBuku.size() && position < dataGambar.size()) {
            String sambungAuthor = TextUtils.join(", ", dataBuku.get(position).getAuthors());

            holder.tvTitle.setText(dataBuku.get(position).getTitle());
            holder.tvAuthor.setText(sambungAuthor);

            Glide.with(mContext)
                    .load(dataGambar.get(position).getSmallThumbnail())
                    .placeholder(R.drawable.placeholder_image)  // Replace with your placeholder image
                    .error(R.drawable.error_image)  // Replace with your error image
                    .into(holder.imgBook);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedPosition = holder.getAdapterPosition();
                    if (clickedPosition != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("title", dataBuku.get(clickedPosition).getTitle());
                        intent.putExtra("authors", TextUtils.join(", ", dataBuku.get(clickedPosition).getAuthors()));
                        intent.putExtra("description", dataBuku.get(clickedPosition).getDescription());
                        intent.putExtra("thumbnail", dataGambar.get(clickedPosition).getSmallThumbnail());
                        // Add other data as needed
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataBuku.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgBook;
        private TextView tvTitle, tvAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.image_poster);
            tvTitle = itemView.findViewById(R.id.text_judul);
            tvAuthor = itemView.findViewById(R.id.text_penulis);
        }
    }
}
