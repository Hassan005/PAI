package com.hassan.productai;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdaptorAliExpress extends RecyclerView.Adapter<RecyclerViewAdaptorAliExpress.MyViewHolderAliExpress>
{
    private Context ali_express_context;
    private List<Products> ali_express_products;

    RequestOptions option;
    public RecyclerViewAdaptorAliExpress(Context ali_express_context, List<Products> ali_express_products ) {
        this.ali_express_context = ali_express_context;
        this.ali_express_products = ali_express_products;

        option=new RequestOptions().centerCrop().placeholder(R.drawable.aliexpress).error(R.drawable.aliexpress);
    }

    @NonNull
    @Override
    public MyViewHolderAliExpress onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater_ali_express=LayoutInflater.from(ali_express_context);

        view=inflater_ali_express.inflate(R.layout.aliexpress,parent,false);


        return  new MyViewHolderAliExpress(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAliExpress holder, int position) {
        holder.tv_title_ali_express.setText(ali_express_products.get(position).getProduct_name());
        holder.tv_price_ali_express.setText(ali_express_products.get(position).getPrice());
        holder.tv_link_ali_express.setText(ali_express_products.get(position).getPrfile_link());

         final String model = ali_express_products.get(position).getPrfile_link();

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       // Toast.makeText(view.getContext(),"Position: ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+model));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
});

//        Uri uriOne= Uri.parse(ali_express_products.get(position).getImage_link());
//        holder.imageViewAliExpress.setImageURI(uriOne);
        Glide.with(ali_express_context).load(ali_express_products.get(position).getImage_link()).apply(option).into(holder.imageViewAliExpress);
//        holder.url = model.getPrfile_link();
//   Toast.makeText(holder.getApplicationContext(),ali_express_products.get(position).getPrfile_link(),Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        return ali_express_products.size();
    }

    public static class MyViewHolderAliExpress extends RecyclerView.ViewHolder
    {

//        public String url;
        TextView tv_title_ali_express;
        TextView tv_price_ali_express;
        TextView tv_link_ali_express;
        TextView tv_id_ali_express;
        ImageView imageViewAliExpress;
        public MyViewHolderAliExpress(@NonNull View itemView) {
            super(itemView);
            tv_title_ali_express=itemView.findViewById(R.id.product_nameae);
            tv_price_ali_express=itemView.findViewById(R.id.priceae);
            tv_link_ali_express=itemView.findViewById(R.id.product_linkae);
            imageViewAliExpress=itemView.findViewById(R.id.thumbnailae);
//
//itemView.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//
//        Toast.makeText(view.getContext(),"Position: "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        view.getContext().startActivity(intent);
//    }
//});
        }

        }
}
