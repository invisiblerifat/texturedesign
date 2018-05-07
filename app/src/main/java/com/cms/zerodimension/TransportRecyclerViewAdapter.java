package com.cms.zerodimension;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import model.Item;
import model.Transport;

/**
 * Created by ADMIN on 5/6/2018.
 */

public class TransportRecyclerViewAdapter extends RecyclerView.Adapter<TransportRecyclerViewAdapter.TransportViewHolder>  {
    private Context context;
    private List<Transport> itemList;

    public TransportRecyclerViewAdapter(Context context, List<Transport> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public TransportRecyclerViewAdapter.TransportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.transport_item,parent,false);
        return new TransportRecyclerViewAdapter.TransportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TransportRecyclerViewAdapter.TransportViewHolder holder, final int position) {
        holder.textViewItemTitle.setText(itemList.get(position).transportName);
        holder.imageViewItem.setImageResource(itemList.get(position).thumbnail);
        holder.textViewDesc.setText(itemList.get(position).description);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ItemActivity.class);
                intent.putExtra("ITEM_NAME",itemList.get(position).transportName);
                intent.putExtra("ITEM_THUMBNAIL",itemList.get(position).thumbnail);
                intent.putExtra("DESCRIPTION",itemList.get(position).description);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    Bundle bundle= ActivityOptions.makeScaleUpAnimation(view, 0,
//                            0, view.getWidth(), view.getHeight()).toBundle();
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                            holder.textViewItemTitle,   // The view which starts the transition
                            "TextView"    // The transitionName of the view we’re transitioning to
                    );
                    context.startActivity(intent,options.toBundle());
                }else{
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class TransportViewHolder extends RecyclerView.ViewHolder{
        TextView textViewItemTitle;
        ImageView imageViewItem;
        CardView cardView;
        TextView textViewDesc;
        public TransportViewHolder(View itemView) {
            super(itemView);
            textViewItemTitle=itemView.findViewById(R.id.item_title_id);
            imageViewItem=itemView.findViewById(R.id.item_image_id);
            cardView=itemView.findViewById(R.id.cardview_id);
            textViewDesc=itemView.findViewById(R.id.item_desc);
        }
    }
}
