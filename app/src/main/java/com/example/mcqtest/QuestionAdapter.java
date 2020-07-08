package com.example.mcqtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

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
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, int position) {


        final Question item_question=questionList.get(position);
        holder.text_qn.setText(item_question.getQuestion());
        holder.option1.setText(item_question.getOption1());
        holder.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.option1.setClickable(false);
                holder.option2.setClickable(false);
                holder.option3.setClickable(false);
                item_question.setGivenAns(holder.option1.getText().toString());
                item_question.isAnswered="1";
                //MainActivity.questionList2.add(new Questions("He argued --- me about the merrage","with","for","to","from","with","01",holder.option3.getText().toString(),"1"));
            }
        });
        holder.option2.setText(item_question.getOption2());
        holder.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.option1.setClickable(false);
                holder.option2.setClickable(false);
                holder.option3.setClickable(false);
                item_question.setGivenAns(holder.option2.getText().toString());
                item_question.isAnswered="1";
                //MainActivity.questionList2.add(new Questions("He argued --- me about the merrage","with","for","to","from","with","01",holder.option3.getText().toString(),"1"));
            }
        });
        holder.option3.setText(item_question.getOption3());
        holder.option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.option1.setClickable(false);
                holder.option2.setClickable(false);
                holder.option3.setClickable(false);
                item_question.setGivenAns(holder.option3.getText().toString());
                item_question.isAnswered="1";
              //  MainActivity.questionList2.add(new Questions("He argued --- me about the merrage","with","for","to","from","with","01",holder.option3.getText().toString(),"1"));
            }
        });


    }


    @Override
    public int getItemCount() {
        return questionList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView text_qn,option1,option2,option3;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            text_qn=itemView.findViewById(R.id.text_question);
            option1=itemView.findViewById(R.id.radio_one);
            option2=itemView.findViewById(R.id.radio_two);
            option3=itemView.findViewById(R.id.radio_three);
        }
    }
}
