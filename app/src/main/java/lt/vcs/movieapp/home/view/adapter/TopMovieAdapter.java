package lt.vcs.movieapp.home.view.adapter;

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
import lt.vcs.movieapp.home.view.adapter.ClickListener;
import lt.vcs.movieapp.home.model.item.ItemTopMovies;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.TopMoviesViewHolder> {

    private static ClickListener clickListener;
    private List<ItemTopMovies> list;
    private Context context;

    public TopMovieAdapter(List<ItemTopMovies> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<ItemTopMovies> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TopMoviesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopMoviesViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);

        holder.rankTextView.setText(String.valueOf(list.get(position).getRank()));
        holder.scoreTextView.setText(list.get(position).getImDbRating());
        holder.yearTextView.setText(String.valueOf(list.get(position).getYear()));
        if (list.get(position).getTitle().length() < 20) {
            holder.titleTextView.setText(list.get(position).getTitle());
        } else {
            holder.titleTextView.setText(list.get(position).getTitle().substring(0, 20) + "...");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class TopMoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView scoreTextView;
        private TextView rankTextView;
        private TextView yearTextView;

        public TopMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.topMovieImageView);
            rankTextView = itemView.findViewById(R.id.topMovieRankTextView);
            scoreTextView = itemView.findViewById(R.id.topMovieIMDBScoreTextView);
            titleTextView = itemView.findViewById(R.id.topMovieTitleTextView);
            yearTextView = itemView.findViewById(R.id.topMovieYearTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TopMovieAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        TopMovieAdapter.clickListener = clickListener;
    }
}
