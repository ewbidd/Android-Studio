package com.tugas.platform.wordpress;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String API_URL = "https://www.motoreview.web.id/wp-json/wp/v2/posts?page=1&per_page=25";

    private ListView listView;
    private ArrayList<PostModel> postList;
    private PostAdapter adapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvPosts);
        postList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        adapter = new PostAdapter(this, R.layout.single_post, postList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            PostModel selectedPost = postList.get(position);
            Intent intent = new Intent(MainActivity.this, PostDetailActivity.class);
            intent.putExtra("title", selectedPost.getTitle());
            intent.putExtra("content", selectedPost.getContent());
            intent.putExtra("imageUrl", selectedPost.getImageUrl());
            startActivity(intent);
        });

        fetchPosts();
    }

    private void fetchPosts() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                API_URL,
                null,
                response -> {
                    try {
                        parsePostsResponse(response);
                    } catch (JSONException e) {
                        Log.e(TAG, "JSON parsing error: " + e.getMessage());
                        Toast.makeText(MainActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e(TAG, "Volley error: " + error.getMessage());
                    Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                }
        );

        requestQueue.add(jsonArrayRequest);
    }

    private void parsePostsResponse(JSONArray response) throws JSONException {
        postList.clear();

        for (int i = 0; i < response.length(); i++) {
            JSONObject postObj = response.getJSONObject(i);

            String title = postObj.getJSONObject("title").getString("rendered");
            String content = postObj.getJSONObject("content").getString("rendered");
            String excerpt = postObj.getJSONObject("excerpt").getString("rendered");
            String date = postObj.getString("date");
            String slug = postObj.getString("slug");

            String imageUrl = "";
            if (postObj.has("jetpack_featured_media_url") && !postObj.isNull("jetpack_featured_media_url")) {
                imageUrl = postObj.getString("jetpack_featured_media_url");
            }

            // Get author from yoast_head_json
            String authorName = "Unknown";
            if (postObj.has("yoast_head_json")) {
                JSONObject yoastJson = postObj.getJSONObject("yoast_head_json");
                authorName = yoastJson.optString("author", "Unknown");
            }

            PostModel post = new PostModel(title, content, excerpt, imageUrl, authorName, date, slug);
            postList.add(post);
        }

        adapter.notifyDataSetChanged();
    }
}
