package com.example.ta_prakppb_ihsanh.fragment_class;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ta_prakppb_ihsanh.R;
import com.example.ta_prakppb_ihsanh.activity_class.FavoriteActivity;
import com.example.ta_prakppb_ihsanh.activity_class.LoginActivity;
import com.example.ta_prakppb_ihsanh.activity_class.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    Button signOutBtn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        String userName = null;
        String userEmail = null;

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(getActivity(),gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());


        CircleImageView profileImage = view.findViewById(R.id.profile_image);
        if (account != null) {
            String photoUrl = account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : null;
            if (photoUrl != null) {
                // Load the profile image using Glide or any other image loading library
                Glide.with(this)
                        .load(photoUrl)
                        .placeholder(R.drawable.placeholder_image) // Placeholder image while loading
                        .error(R.drawable.error_image) // Image to show in case of an error
                        .into(profileImage);
            }
            userName = account.getDisplayName();
            userEmail = account.getEmail();
        }



            // Explicit casting to TextView
        TextView userNameTextView = (TextView) view.findViewById(R.id.text_user_name);
        TextView userEmailTextView = (TextView) view.findViewById(R.id.text_user_email);

        userNameTextView.setText(userName);
        userEmailTextView.setText(userEmail);

        MaterialButton logoutButton = view.findViewById(R.id.logout_button);
        FloatingActionButton homeFab = view.findViewById(R.id.home_appbar);
        FloatingActionButton bookmarkFab = view.findViewById(R.id.bookmark_appbar);
        FloatingActionButton profileFab = view.findViewById(R.id.profile_appbar);



        homeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle home FAB click
                animateButton(v);
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();}
                }
        });

        bookmarkFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle bookmark FAB click
                animateButton(v);
                Intent intent = new Intent(getActivity(), FavoriteActivity.class);
                startActivity(intent);
            }
        });

        profileFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle profile FAB click
                animateButton(v);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout action
                // For example, you can sign out the user and navigate to the login screen
                showToast("Logout Success!");
                signOut();
            }
        });

        return view;

//        gsc = GoogleSignIn.getClient(this,gso);
//        signOutBtn = findViewById(R.id.signout);
//        signOutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signOut();
//            }
//        }
    }


    private void animateButton(View v) {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.button_click_animation);
        v.startAnimation(animation);
    }


    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    void signOut(){

        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                getActivity().finish();
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

}
