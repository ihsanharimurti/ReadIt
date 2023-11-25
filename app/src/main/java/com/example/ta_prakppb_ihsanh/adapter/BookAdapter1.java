package com.example.ta_prakppb_ihsanh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ta_prakppb_ihsanh.Book;
import com.example.ta_prakppb_ihsanh.R;

import java.util.List;

public class BookAdapter1 extends RecyclerView.Adapter<BookAdapter1.BookHolder> {

    private Context context;
    private List<Book> bookList;

//    public BookAdapter1(Context context, List<Book> books) {
//        this.context = context;
//        bookList = books;
//    }
public BookAdapter1(List<Book> books) {
    this.bookList = books;
}
    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_grid_item, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        Book book = bookList.get(position);
        holder.title.setText(book.getTitle());

        // Convert the list of authors to a single comma-separated string
        String joinedAuthors = String.join(", ", book.getAuthors());
        holder.authors.setText(joinedAuthors);

        holder.description.setText(book.getDescription());

        Glide.with(context).load(book.getThumbnailUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, authors, description;

        public BookHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_poster);
            title = itemView.findViewById(R.id.text_judul);
            authors = itemView.findViewById(R.id.text_penulis);
//            description = itemView.findViewById(R.id.text_description);
        }
    }
}
