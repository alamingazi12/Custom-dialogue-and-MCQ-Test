package com.example.mcqtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ExampleViewHolder> {

    Context context;
   public  ArrayList<Question> questionList;

    public QuestionAdapter(Context context, ArrayList<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,parent,false);
       return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {

        final Question item_question=questionList.get(position);
        holder.text_qn.setText(item_question.getQuestion());
        holder.option1.setText(item_question.getOption1());
        holder.option1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    holder.option1.setClickable(false);
                    holder.option2.setClickable(false);
                    holder.option3.setClickable(false);
                    item_question.setGivenAns(holder.option1.getText().toString());
                    item_question.isAnswered="1";
                    Log.d("val",String.valueOf(position));
                }
            }
        });

        holder.option2.setText(item_question.getOption2());
        holder.option2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    holder.option2.setChecked(true);
                    holder.option1.setClickable(false);
                    holder.option2.setClickable(false);
                    holder.option3.setClickable(false);
                    item_question.setGivenAns(holder.option2.getText().toString());
                    item_question.isAnswered="1";
                    Log.d("val",String.valueOf(position));
                }
            }
        });

        holder.option3.setText(item_question.getOption3());
        holder.option3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    holder.option3.setChecked(true);
                    holder.option2.setClickable(false);
                    holder.option1.setClickable(false);
                    holder.option3.setClickable(false);
                    item_question.setGivenAns(holder.option3.getText().toString());
                    item_question.isAnswered="1";
                    Log.d("val",String.valueOf(position));
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return questionList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder {
           TextView text_qn;
           RadioButton option1,option2,option3;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            text_qn=itemView.findViewById(R.id.text_question);
            option1=itemView.findViewById(R.id.radio_one);
            option2=itemView.findViewById(R.id.radio_two);
            option3=itemView.findViewById(R.id.radio_three);
        }
    }
}
