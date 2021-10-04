package com.marius.valeyou.market_place.Drawer.Home.All_Ads;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marius.valeyou.R;
import com.marius.valeyou.market_place.Drawer.Home.PostAd.DataModel.Sub_cate_Get_Set;
import com.marius.valeyou.market_place.Volley_Package.API_LINKS;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Sub_Cate_hor_Adp extends RecyclerView.Adapter<Sub_Cate_hor_Adp.ViewHolder> {

    Context context;
    List<Sub_cate_Get_Set> Cate_Arr;

    onclick click;
    public interface onclick{
        void itemclick(int pos);
    }

    public Sub_Cate_hor_Adp (List<Sub_cate_Get_Set> Cate_Arr, Context context, onclick itemclick ) {
        this.context = context;
        this.Cate_Arr = Cate_Arr;
        this.click = itemclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_cate_horizontal, null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        // viewHolder.iv.setImageResource(list[i]);

        final Sub_cate_Get_Set Stories = Cate_Arr.get(i);

        Picasso.get()
                .load(API_LINKS.BASE_URL + Stories.getImage())
                .placeholder(R.drawable.round)
                .error(R.drawable.round)
                .into(viewHolder.sub_cate_img);

        viewHolder.cate_name.setText("" +  Html.fromHtml(Stories.getName()));
//
//        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent myIntent = new Intent(context, ViewStory.class);
//                myIntent.putExtra("user_id", Stories.getUser_id()); //Optional parameters
//                context.startActivity(myIntent);
//
//            }
//        });


//        if(Stories.getUser_id().equals("" + SharedPrefrence.get_user_id_from_json(context))){
//            // Methods.toast_msg(context,"Equl " );
//
//        }else{
//            //Methods.toast_msg(context,"Not Equl " );
//            viewHolder.add.setVisibility(View.GONE);
//
//        }

        viewHolder.onbind(i,click);
    }

    @Override
    public int getItemCount() {
        return Cate_Arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv,sub_cate_img;
        TextView cate_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //iv = itemView.findViewById(R.id.category_img_id);
            sub_cate_img = (ImageView) itemView.findViewById(R.id.sub_cate_img);
            cate_name = itemView.findViewById(R.id.name);

        }
        public void onbind(final int pos, final onclick listner){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.itemclick(pos);
                }

            });

        }
    }


}
