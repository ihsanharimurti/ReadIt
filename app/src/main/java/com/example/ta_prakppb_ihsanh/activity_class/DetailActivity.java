package com.example.ta_prakppb_ihsanh.activity_class;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ta_prakppb_ihsanh.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvJudul, tvAuthor, tvDesc;
    private ImageView imgPoster, starButton;

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_AUTHORS = "authors";
    public static final String EXTRA_IMAGE = "thumbnail";

    public static final String EXTRA_DESC = "description";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.detail_text);
        tvAuthor = findViewById(R.id.detail_text_authors);
        tvDesc=findViewById(R.id.detail_text_desc);
        imgPoster= findViewById(R.id.image_poster_detail);
        starButton = findViewById(R.id.star_button);

        if (getIntent() != null) {
            if (getIntent().hasExtra(EXTRA_TITLE)) {
                String nama = getIntent().getStringExtra(EXTRA_TITLE);
                tvJudul.setText(nama);
            }

            if (getIntent().hasExtra(EXTRA_AUTHORS)) {
                String penulis = getIntent().getStringExtra(EXTRA_AUTHORS);
                tvAuthor.setText(penulis);
            }

            if (getIntent().hasExtra(EXTRA_DESC)) {
                String desc = getIntent().getStringExtra(EXTRA_DESC);
                tvDesc.setText(desc);
            }

            if (getIntent().hasExtra(EXTRA_IMAGE)) {
                String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE);
                // Load the image using Glide or your preferred image loading library
                Glide.with(this)
                        .load(imageUrl)
                        .placeholder(R.drawable.placeholder_image)
                        .error(R.drawable.error_image)
                        .into(imgPoster);
            }
        }
    }
}
