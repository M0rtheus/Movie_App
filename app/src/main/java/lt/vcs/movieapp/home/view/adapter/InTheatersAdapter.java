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
import lt.vcs.movieapp.home.model.item.ItemInTheaters;

public class InTheatersAdapter extends RecyclerView.Adapter<InTheatersAdapter.InTheatersViewHolder> {

    private static ClickListener clickListener;
    private List<ItemInTheaters> list;
    private Context context;

    public InTheatersAdapter(List<ItemInTheaters> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<ItemInTheaters> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InTheatersAdapter.InTheatersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InTheatersAdapter.InTheatersViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_theaters, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InTheatersAdapter.InTheatersViewHolder holder, int position) {
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

    protected class InTheatersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView yearTextView;
        private TextView dateTextView;

        public InTheatersViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.inTheatersImageView);
            titleTextView = itemView.findViewById(R.id.inTheatersTitleTextView);
            yearTextView = itemView.findViewById(R.id.inTheatersYearTextView);
            dateTextView = itemView.findViewById(R.id.inTheatersDateTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            InTheatersAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        InTheatersAdapter.clickListener = clickListener;
    }
}
