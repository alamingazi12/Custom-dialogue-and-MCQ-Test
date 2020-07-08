package com.example.mcqtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    public AnswerAdapter(ArrayList<Question> questionsList, Context context) {
        this.questionsList = questionsList;
        this.context = context;
    }

    ArrayList<Question> questionsList;
    Context context;
    @NonNull
    @Override
    public AnswerAdapter.AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.answer_item_list,parent,false);
        return  new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerAdapter.AnswerViewHolder holder, int position) {
        Question item_question=questionsList.get(position);
       if( item_question.isAnswered.equals("1")) {
            if(item_question.getAnswer().equals(item_question.getGivenAns()))  {
                holder.imag_check.setImageResource(R.drawable.check_right_ans);
            }
        }
        holder.question.setText(item_question.getQuestion());
        holder.option1.setText(item_question.getOption1());
        holder.option2.setText(item_question.getOption2());
        holder.option3.setText(item_question.getOption3());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {

        ImageView imag_check;
        TextView question,option1,option2,option3;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            question=itemView.findViewById(R.id.text_question);
            option1=itemView.findViewById(R.id.radio_one);
            option2=itemView.findViewById(R.id.radio_two);
            option3=itemView.findViewById(R.id.radio_three);
            imag_check=itemView.findViewById(R.id.image_ans);
        }
    }
}
