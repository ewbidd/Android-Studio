package com.tugas.platform.wordpress;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class PostDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        // Get views
        ImageView headerImage = findViewById(R.id.ivHeaderImage);
        TextView contentText = findViewById(R.id.tvContent);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);

        // Get data from intent
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        // Set title
        if (title != null) {
            collapsingToolbar.setTitle(Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY));
        }

        // Set content
        if (content != null) {
            contentText.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY));
        }

        // Load header image
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.placeholder_image)
                    .into(headerImage);
        }
    }
}
