package com.example.home_real_real_real;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder>{

    private ArrayList<Goal> gItems;
    private Context context;
    int lastPosition = -1;

    public GoalAdapter(ArrayList<Goal> gItems, Context context) {
        this.gItems = gItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.goal_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // 데이터 뷰 홀더에 바인딩
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        if (viewHolder.getAdapterPosition() > lastPosition) {
            Goal item = gItems.get(position);
            viewHolder.goalText.setText(item.getGoalText());
        }

    }

    @Override
    public int getItemCount() {
        return(gItems != null ? gItems.size() : 0);
    }

    //아이템 삭제
    public void removeItem(int position){
        if (position >= 0 && position < gItems.size()) {
            gItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, gItems.size()); // 아이템 위치 재조정
        }
    }


    public void removeAllItem(){
        gItems.clear();
        notifyDataSetChanged(); // 모든 아이템 삭제 후 화면 갱신
    }

    //아이템 추가
    public void addItem(int position, Goal item) {
        if (position >= 0 && position <= gItems.size()) {
            gItems.add(position, item);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, gItems.size()); // 아이템 위치 재조정
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView goalText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.goalText = itemView.findViewById(R.id.goalText);

        }

    }

}
