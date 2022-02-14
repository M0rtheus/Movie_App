package lt.vcs.movieapp.search.view.adapter;

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
import lt.vcs.movieapp.search.view.adapter.ClickListener;
import lt.vcs.movieapp.search.model.ItemSearch;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private static ClickListener clickListener;
    private List<ItemSearch> list;
    private Context context;

    public SearchAdapter(List<ItemSearch> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<ItemSearch> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchAdapter.SearchViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
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


    public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView descriptionTextView;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.searchImageView);
            titleTextView = itemView.findViewById(R.id.searchTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.searchDescriptionTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SearchAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        SearchAdapter.clickListener = clickListener;
    }

}