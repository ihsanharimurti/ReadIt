//package com.example.ta_prakppb_ihsanh.activity_class;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import com.example.ta_prakppb_ihsanh.R;
//
//public class FavoriteActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_favorite);
//    }
//}

package com.example.ta_prakppb_ihsanh.activity_class;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_prakppb_ihsanh.adapter.FavoriteAdapter;
import com.example.ta_prakppb_ihsanh.fragment_class.ProfileFragment;
import com.example.ta_prakppb_ihsanh.R;
import com.example.ta_prakppb_ihsanh.adapter.BookAdapter;
import com.example.ta_prakppb_ihsanh.api.ApiClient;
import com.example.ta_prakppb_ihsanh.api.DataImageLinks;
import com.example.ta_prakppb_ihsanh.api.DataItem;
import com.example.ta_prakppb_ihsanh.api.DataVolumeInfo;
import com.example.ta_prakppb_ihsanh.api.ListUserResponse;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteActivity extends AppCompatActivity {

    TextView name;

    RecyclerView rvListUser;
    private ListUserResponse listItem;
    private FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        rvListUser = findViewById(R.id.rv_list_fav);
        rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



        ApiClient.getService().getList("a", "relevance", "books", "paid-ebooks", 34, 0, "API_KEY")
                .enqueue(new Callback<ListUserResponse>() {
                    @Override
                    public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
//                            Log.d("TAG", "Udah masuk");
                            listItem = response.body();
                            List<DataVolumeInfo> volumeInfo = new ArrayList<>();
                            List<DataImageLinks> imageLinks = new ArrayList<>();
                            for (DataItem item : listItem.getItems()) {
                                volumeInfo.add(item.getVolumeInfoClass());
                                imageLinks.add(item.getVolumeInfoClass().getImageLinks());
                            }

                            adapter = new FavoriteAdapter(volumeInfo, imageLinks, FavoriteActivity.this);
                            rvListUser.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListUserResponse> call, Throwable t) {
                        Log.e("TAG", "Error fetching data", t);
                        Toast.makeText(getApplicationContext(), "Error Fetching Data", Toast.LENGTH_SHORT).show();
                    }
                });

        FloatingActionButton homeAppBar = findViewById(R.id.home_appbar);
        FloatingActionButton bookmarkAppBar = findViewById(R.id.bookmark_appbar);
        FloatingActionButton profileAppBar = findViewById(R.id.profile_appbar);

        homeAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateButton(view);
                Intent intent = new Intent(FavoriteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bookmarkAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateButton(view);
            }
        });

        profileAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateButton(view);
                loadFragment(new ProfileFragment());
            }
        });
    }

    private void animateButton(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        v.startAnimation(animation);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container2, fragment)
                .addToBackStack(null)
                .commit();
    }
}
