package com.codepath.parseinstagram;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

/**
 * Shows details of selected post
 */

public class DetailsActivity extends AppCompatActivity {

    TextView tvCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvCaption = findViewById(R.id.tvCaption);
        final Post post = (Post) getIntent().getExtras().get("post");
        final Date createdAt = post.getCreatedAt();
        final String timeAgo = Post.calculateTimeAgo(createdAt);
        tvCaption.setText("Time Stamp: " + timeAgo + "\nCaption:  " + post.getDescription());
    }

}