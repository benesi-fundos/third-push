package com.example.medicalsupportsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.veiwHolder> {
    ArrayList<Model> mlist;
    Context context;
    MyAdapter(Context context, ArrayList<Model> mlist){
        this.mlist = mlist;
        this.context = context;
    }
    @NonNull
    @Override
    public veiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.iterms, parent, false);
        return new veiwHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull veiwHolder holder, int position) {
        Model model = mlist.get(position);
        holder.FULLNAME.setText(model.getFullName());
        holder.IDNUM.setText(model.getIdNum());
        holder.DISTRICT.setText(model.getDistict());
        holder.TA.setText(model.getTA());
        holder.PSIGN1.setText(model.getVillage());
        holder.VILLAGE.setText(model.getVillage());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class veiwHolder extends RecyclerView.ViewHolder{
        TextView FULLNAME, IDNUM, DISTRICT, TA, VILLAGE, PSIGN1, PSIGN2, PSIGN3, PSIGN4;

        public veiwHolder(@NonNull View itemView) {
            super(itemView);
            FULLNAME = itemView.findViewById(R.id.ffname);
            IDNUM = itemView.findViewById(R.id.iidnum);
            DISTRICT = itemView.findViewById(R.id.pdist);
            TA = itemView.findViewById(R.id.ptta);
            VILLAGE = itemView.findViewById(R.id.pvllg);
            PSIGN1 = itemView.findViewById(R.id.pss1);
            PSIGN2 = itemView.findViewById(R.id.pss2);
            PSIGN3 = itemView.findViewById(R.id.pss3);
            PSIGN4 = itemView.findViewById(R.id.pss4);
        }























    }
}
