package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlineclothingshoppingapp.DescriptionActivity;
import com.example.onlineclothingshoppingapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.ItemsProperties;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>{
    Context mContext;
    List<ItemsProperties> itemsPropertiesList;

    public ItemsAdapter(Context mContext, List<ItemsProperties> itemsPropertiesList) {
        this.mContext = mContext;
        this.itemsPropertiesList = itemsPropertiesList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_properties,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder itemViewHolder, int i) {
        final ItemsProperties itemsProperties= itemsPropertiesList.get(i);


        itemViewHolder.itemImage.setImageResource(itemsProperties.getItemImage());
        itemViewHolder.tvItemName.setText(itemsProperties.getTvItemName());
        itemViewHolder.tvItemPrice.setText(itemsProperties.getTvItemPrice());

        itemViewHolder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(mContext, DescriptionActivity.class);
                intentt.putExtra("image", itemsProperties.getItemImage());
                intentt.putExtra("name", itemsProperties.getTvItemName());
                intentt.putExtra("price", itemsProperties.getTvItemPrice());
                intentt.putExtra("description", itemsProperties.getTvItemDescription());
                mContext.startActivity(intentt);
            }

        });
    }

    @Override
    public int getItemCount() {
        return itemsPropertiesList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CircleImageView itemImage;
        TextView tvItemName,tvItemPrice;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.itemImage);
            tvItemName=itemView.findViewById(R.id.tvItemName);
            tvItemPrice=itemView.findViewById(R.id.tvItemPrice);
        }
    }
    }
