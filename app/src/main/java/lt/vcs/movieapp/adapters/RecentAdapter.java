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
import lt.vcs.movieapp.data.RecentItem;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentViewHolder> {

    private static ClickListener clickListener;
    private List<RecentItem> list;
    private Context context;

    public RecentAdapter(List<RecentItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<RecentItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecentAdapter.RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentAdapter.RecentViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentAdapter.RecentViewHolder holder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImage())
                .into(holder.imageView);
        holder.titleTextView.setText(list.get(position).getTitle());
        holder.descriptionTextView.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView descriptionTextView;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recentImageView);
            titleTextView = itemView.findViewById(R.id.recentTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.recentDescriptionTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            RecentAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecentAdapter.clickListener = clickListener;
    }

}
