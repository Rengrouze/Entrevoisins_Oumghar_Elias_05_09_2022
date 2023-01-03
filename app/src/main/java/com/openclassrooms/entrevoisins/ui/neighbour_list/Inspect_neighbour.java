package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class Inspect_neighbour extends AppCompatActivity {

    private NeighbourApiService mApiService;
    private ImageView profilePic;
    private TextView neighbourName1;
    private FloatingActionButton favButton;
    private TextView neighbourName2;
    private TextView location;
    private TextView phoneNumber;
    private TextView website;
    private TextView aboutMe;
    private TextView aboutMeLyt;
    private FloatingActionButton returnButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApiService = DI.getNeighbourApiService();
        setContentView(R.layout.activity_inspect_neighbour);

        long id = getIntent().getLongExtra("id",0);

        Neighbour neighbour = mApiService.getNeighbour(id);
        profilePic = findViewById(R.id.profilePic);
        neighbourName1 = findViewById(R.id.neighbourName1);
        favButton = findViewById(R.id.favButton);
        neighbourName2 = findViewById(R.id.neighbourName2);
        location = findViewById(R.id.location);
        phoneNumber = findViewById(R.id.phoneNumber);
        website = findViewById(R.id.website);
        aboutMe = findViewById(R.id.aboutMe);
        aboutMeLyt = findViewById(R.id.aboutMeLyt);
        returnButton = findViewById(R.id.returnButton);



        String name = getIntent().getStringExtra("name");
        String location = getIntent().getStringExtra("address");
        String phoneNumber = getIntent().getStringExtra("phone");
        String website = getIntent().getStringExtra("website");
        String aboutMe = getIntent().getStringExtra("about");


        String avatar = getIntent().getStringExtra("avatar");

        Glide.with(this)
                .load(avatar)
                .into(profilePic);

        this.neighbourName1.setText(name);
        this.neighbourName2.setText(name);
        this.location.setText(location);
        this.phoneNumber.setText(phoneNumber);
        this.website.setText(website);
        this.aboutMeLyt.setText(aboutMe);


        // fav button system




      if (getIntent().getBooleanExtra("favorite", false)) {
            favButton.setImageResource(R.drawable.ic_star_yellow_24dp);
        } else {
            favButton.setImageResource(R.drawable.ic_star_border_yellow_24dp);
             
            }


        favButton.setOnClickListener(v -> {
            if (getIntent().getBooleanExtra("favorite", false)) {
                mApiService.removeFavoriteNeighbour(neighbour);
                favButton.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                getIntent().putExtra("favorite", false);
            } else {
                mApiService.addFavoriteNeighbour(neighbour);
                favButton.setImageResource(R.drawable.ic_star_yellow_24dp);
                getIntent().putExtra("favorite", true);

            } 
        });

        returnButton.setOnClickListener(v -> finish());




    }


}