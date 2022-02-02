package lt.vcs.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.data.FavoriteItem;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private List<FavoriteItem> list;
    private Context context;

    public FavoritesAdapter(List<FavoriteItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoritesAdapter.FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesAdapter.FavoritesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorites_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoritesViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);

        if (list.get(position).getTitle().length() < 25) {
            holder.titleTextView.setText(list.get(position).getTitle());
        } else {
            holder.titleTextView.setText(list.get(position).getTitle().substring(0, 25) + "...");
        }

        holder.scoreTextView.setText("IMDB Score: " + list.get(position).getImDbRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView scoreTextView;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.favoritesImageView);
            titleTextView = itemView.findViewById(R.id.favoritesTitleTextView);
            scoreTextView = itemView.findViewById(R.id.favoritesIMDBScoreTextView);
        }

        @Override
        public void onClick(View view) {

        }
    }

}
