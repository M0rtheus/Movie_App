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
import lt.vcs.movieapp.home.model.item.ItemComingSoon;

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.ComingSoonViewHolder> {

    private static ClickListener clickListener;
    private List<ItemComingSoon> list;
    private Context context;

    public ComingSoonAdapter(List<ItemComingSoon> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<ItemComingSoon> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComingSoonAdapter.ComingSoonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComingSoonAdapter.ComingSoonViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_coming_soon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ComingSoonAdapter.ComingSoonViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);

        holder.yearTextView.setText(String.valueOf(list.get(position).getYear()));
        holder.dateTextView.setText(list.get(position).getReleaseState());

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


    protected class ComingSoonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView yearTextView;
        private TextView dateTextView;

        public ComingSoonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.comingSoonImageView);
            titleTextView = itemView.findViewById(R.id.comingSoonTitleTextView);
            yearTextView = itemView.findViewById(R.id.comingSoonYearTextView);
            dateTextView = itemView.findViewById(R.id.comingSoonDateTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ComingSoonAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ComingSoonAdapter.clickListener = clickListener;
    }
}

