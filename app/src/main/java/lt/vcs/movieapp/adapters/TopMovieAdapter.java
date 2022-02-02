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
import lt.vcs.movieapp.apimodels.items.ItemTopMovies;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.ViewHolder> {

    List<ItemTopMovies> list;
    Context context;

    public TopMovieAdapter(List<ItemTopMovies> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TopMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_movies_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieAdapter.ViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);

        holder.rankTextView.setText("Rank: " + list.get(position).getRank());
        holder.scoreTextView.setText("IMDB Score: " + list.get(position).getImDbRating());

        if (list.get(position).getTitle().length() < 25){
            holder.titleTextView.setText(list.get(position).getTitle());
        } else {
            holder.titleTextView.setText(list.get(position).getTitle().substring(0,25) + "...");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView titleTextView;
        TextView scoreTextView;
        TextView rankTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.topMovieImageView);
            rankTextView = itemView.findViewById(R.id.topMovieRankTextView);
            scoreTextView = itemView.findViewById(R.id.topMovieIMDBScoreTextView);
            titleTextView = itemView.findViewById(R.id.topMovieTitleTextView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
