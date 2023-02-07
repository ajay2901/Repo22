package com.t2dev.repo2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private ArrayList<ResultModel> resultModels;

    public ResultAdapter(ArrayList<ResultModel> resultModels) {
        this.resultModels = resultModels;
    }



    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultModel resultModel = resultModels.get(position);
        holder.column1.setText(resultModel.getColumn1());
        holder.column2.setText(resultModel.getColumn2());
        holder.column3.setText(resultModel.getColumn3());
        holder.column4.setText(resultModel.getColumn4());
        holder.column5.setText(resultModel.getColumn5());
        holder.column6.setText(resultModel.getColumn6());
        holder.column7.setText(resultModel.getColumn7());
        holder.column8.setText(resultModel.getColumn8());
        holder.column9.setText(resultModel.getColumn9());
        holder.column10.setText(resultModel.getColumn10());
    }

    @Override
    public int getItemCount() {
        return resultModels.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {

        private TextView column1, column2, column3, column4, column5, column6, column7, column8, column9, column10,column11, column12, column13, column14, column15, column16;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            column1 = itemView.findViewById(R.id.column1);
            column2 = itemView.findViewById(R.id.column2);
            column3 = itemView.findViewById(R.id.column3);
            column4 = itemView.findViewById(R.id.column4);
            column5 = itemView.findViewById(R.id.column5);
            column6 = itemView.findViewById(R.id.column6);
            column7 = itemView.findViewById(R.id.column7);
            column8 = itemView.findViewById(R.id.column8);
            column9 = itemView.findViewById(R.id.column9);
            column10 = itemView.findViewById(R.id.column10);
            column11 = itemView.findViewById(R.id.column11);
            column12 = itemView.findViewById(R.id.column12);
            column13 = itemView.findViewById(R.id.column13);
            column14 = itemView.findViewById(R.id.column14);
            column15 = itemView.findViewById(R.id.column15);
            column16 = itemView.findViewById(R.id.column16);
        }
    }
}
