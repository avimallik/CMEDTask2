package com.cmed.task2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.cmed.task2.databinding.MyListBinding;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<MyListViewModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(ArrayList<MyListViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        MyListBinding myListBinding= DataBindingUtil.inflate(layoutInflater,R.layout.mylist,parent,false);
        return new ViewHolder(myListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyListViewModel myListViewModel=arrayList.get(position);
        holder.bind(myListViewModel);
        holder.lex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, arrayList.get(position).actorname, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("intent_name", arrayList.get(position).actorname);
                intent.putExtra("intent_artistName", arrayList.get(position).artistname);
                intent.putExtra("intent_artistImage", arrayList.get(position).artistimage);
                intent.putExtra("intent_artistGender", arrayList.get(position).artistgender);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout lex;
        private MyListBinding myListBinding;
        public ViewHolder(@NonNull MyListBinding myListBinding) {
            super(myListBinding.getRoot());
            this.myListBinding=myListBinding;
            lex = myListBinding.max;
        }
        public void bind(MyListViewModel myli){
            this.myListBinding.setMylistmodel(myli);
            myListBinding.executePendingBindings();
        }
        public MyListBinding getMyListBinding(){
            return myListBinding;
        }


    }

}
