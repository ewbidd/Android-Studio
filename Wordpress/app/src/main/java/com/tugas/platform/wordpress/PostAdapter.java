package com.tugas.platform.wordpress;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PostAdapter extends ArrayAdapter<PostModel> {
    private List<PostModel> listPosts;
    private Context mContext;
    private int layout;

    public PostAdapter(@NonNull Context context, int resource, @NonNull List<PostModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listPosts = objects;
        this.layout = resource;
    }

    static class PostHolder {
        ImageView thumbnail;
        TextView title;
        TextView excerpt;
        TextView author;
        TextView date;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        PostHolder holder;

        if (v == null) {
            LayoutInflater li = ((Activity) mContext).getLayoutInflater();
            v = li.inflate(layout, parent, false);
            holder = new PostHolder();
            holder.thumbnail = v.findViewById(R.id.ivThumbnail);
            holder.title = v.findViewById(R.id.tvTitle);
            holder.excerpt = v.findViewById(R.id.tvExcerpt);
            holder.author = v.findViewById(R.id.tvAuthor);
            holder.date = v.findViewById(R.id.tvDate);
            v.setTag(holder);
        } else {
            holder = (PostHolder) v.getTag();
        }

        PostModel post = listPosts.get(position);

        // Set title
        holder.title.setText(Html.fromHtml(post.getTitle(), Html.FROM_HTML_MODE_LEGACY));

        // Set excerpt (30 words)
        String excerpt = Html.fromHtml(post.getExcerpt(), Html.FROM_HTML_MODE_LEGACY).toString();
        String[] words = excerpt.split("\\s+");
        if (words.length > 30) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 30; i++) {
                sb.append(words[i]).append(" ");
            }
            excerpt = sb.toString().trim() + "...";
        }
        holder.excerpt.setText(excerpt);

        // Set author
        holder.author.setText("By: " + post.getAuthor());

        // Set date
        holder.date.setText(formatDate(post.getDate()));

        // Load image with Glide
        if (post.getImageUrl() != null && !post.getImageUrl().isEmpty()) {
            Glide.with(mContext)
                    .load(post.getImageUrl())
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.placeholder_image)
                    .into(holder.thumbnail);
        } else {
            holder.thumbnail.setImageResource(R.drawable.placeholder_image);
        }

        return v;
    }

    private String formatDate(String dateString) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            Date date = inputFormat.parse(dateString);
            return outputFormat.format(date);
        } catch (Exception e) {
            return dateString;
        }
    }
}