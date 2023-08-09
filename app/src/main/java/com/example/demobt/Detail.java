package com.example.demobt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.demobt.databinding.ActivityDetailBinding;
import com.example.demobt.models.Comic;

public class Detail extends AppCompatActivity {

    private Comic comic;
    private ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        comic = (Comic) getIntent().getSerializableExtra("comic");

        initViews();
    }

    private void initViews() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());

        Glide.with(this).load(comic.getArt()).error(R.drawable.i8).into(binding.imgArt);
        binding.tvName.setText(comic.getNameComic());
        binding.tvAuthor.setText(comic.getAuthor());
        binding.tvContent.setText(comic.getStories());
    }
}