package lt.vcs.movieapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.data.FavoriteItem;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private static ClickListener clickListener;
    private static DeleteClickListener deleteClickListener;
    private List<FavoriteItem> list;
    private Context context;

    public FavoritesAdapter(List<FavoriteItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<FavoriteItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoritesAdapter.FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesAdapter.FavoritesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorites, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.FavoritesViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);
        holder.titleTextView.setText(list.get(position).getTitle());
        holder.scoreTextView.setText(list.get(position).getImDbRating() + "/10");
        holder.yearTextView.setText(String.valueOf(list.get(position).getYear()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView scoreTextView;
        private TextView yearTextView;
        private FloatingActionButton floatingActionButton;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.favoritesImageView);
            titleTextView = itemView.findViewById(R.id.favoritesTitleTextView);
            scoreTextView = itemView.findViewById(R.id.favoritesIMDBScoreTextView);
            yearTextView = itemView.findViewById(R.id.favoritesYearTextView);
            floatingActionButton = itemView.findViewById(R.id.deleteButton);
            itemView.setOnClickListener(this);
            floatingActionButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == itemView) {
                FavoritesAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
            } else if (view == floatingActionButton) {
                FavoritesAdapter.deleteClickListener.onItemClick(getAbsoluteAdapterPosition(), view);
            }

        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        FavoritesAdapter.clickListener = clickListener;
    }

    public void setOnDeleteClickListener(DeleteClickListener clickListener) {
        FavoritesAdapter.deleteClickListener = clickListener;
    }

}