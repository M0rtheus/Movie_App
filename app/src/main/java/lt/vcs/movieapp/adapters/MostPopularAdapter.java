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
import lt.vcs.movieapp.api.apimodels.items.ItemMostPopular;

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    private List<ItemMostPopular> list;
    private Context context;

    public MostPopularAdapter(List<ItemMostPopular> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MostPopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MostPopularAdapter.MostPopularViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_most_popular, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MostPopularViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);

        holder.rankTextView.setText("Rank: " + list.get(position).getRank());

        holder.rankUpDownTextView.setText(list.get(position).getRankUpDown());

        holder.scoreTextView.setText("IMDB Score: " + list.get(position).getImDbRating());

        if (list.get(position).getTitle().length() < 25) {
            holder.titleTextView.setText(list.get(position).getTitle());
        } else {
            holder.titleTextView.setText(list.get(position).getTitle().substring(0, 25) + "...");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MostPopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView scoreTextView;
        private TextView rankTextView;
        private TextView rankUpDownTextView;

        public MostPopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mostPopularImageView);
            rankTextView = itemView.findViewById(R.id.mostPopularRankTextView);
            scoreTextView = itemView.findViewById(R.id.mostPopularIMDBScoreTextView);
            titleTextView = itemView.findViewById(R.id.mostPopularTitleTextView);
            rankUpDownTextView = itemView.findViewById(R.id.mostPopularRankUpDownTextView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
