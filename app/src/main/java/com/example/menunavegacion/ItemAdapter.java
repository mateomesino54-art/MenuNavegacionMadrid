package com.example.menunavegacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final List<ItemModel> listaItems;

    public ItemAdapter(List<ItemModel> listaItems) {
        this.listaItems = listaItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_madrid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = listaItems.get(position);
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescripcion.setText(item.getDescripcion());

        Picasso.with(holder.itemView.getContext())
                .load(item.getImagenResId())
                .fit()
                .centerCrop()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(holder.ivImagen);
    }

    @Override
    public int getItemCount() {
        return listaItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivImagen;
        TextView tvTitulo, tvDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagenMadrid);
            tvTitulo = itemView.findViewById(R.id.tvTituloMadrid);
            tvDescripcion = itemView.findViewById(R.id.tvDescMadrid);
        }
    }
}