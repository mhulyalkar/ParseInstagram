package com.codepath.parseinstagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.Date;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private final Context context;
    private final List<Post> posts;
    private final OnClickListener clickListener;
    public PostsAdapter(Context context, List<Post> posts, OnClickListener clickListener) {
        this.context = context;
        this.posts = posts;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.bind(post);
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onItemClicked(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvUsername;
        private final ImageView ivImage;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        public void bind(Post post) {
            // Bind the post data to the view elements
            final Date createdAt = post.getCreatedAt();
            final String timeAgo = Post.calculateTimeAgo(createdAt);
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername() + " * " + timeAgo);
            final ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClicked(getAdapterPosition());
                }
            });
        }
    }
}
