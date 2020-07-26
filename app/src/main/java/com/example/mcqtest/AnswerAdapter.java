package com.example.mcqtest;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
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
           holder.imag_check.setVisibility(View.VISIBLE);
            if(item_question.getAnswer().equals(item_question.getGivenAns()))  {

                holder.imag_check.setImageResource(R.drawable.check_right_ans);

                if(item_question.getAnswer().equals(item_question.getOption1())){
                  holder.option1.setTextColor(Color.parseColor("#35a7ff"));
                  holder.option1.setChecked(true);

                }else if(item_question.getAnswer().equals(item_question.getOption2())){
                    holder.option2.setTextColor(Color.parseColor("#35a7ff"));
                    holder.option2.setChecked(true);
                }

                else if(item_question.getAnswer().equals(item_question.getOption3())){
                    holder.option3.setTextColor(Color.parseColor("#35a7ff"));
                    holder.option3.setChecked(true);
                }

            }else {
               if(item_question.getGivenAns().equals(item_question.getOption1())) {
                  holder.option1.setTextColor(Color.parseColor("#d62828"));
                  holder.option1.setChecked(true);
               }
               else if(item_question.getGivenAns().equals(item_question.getOption2())){
                   holder.option2.setTextColor(Color.parseColor("#d62828"));
                   holder.option2.setChecked(true);

               }
               else if(item_question.getGivenAns().equals(item_question.getOption3())){
                   holder.option3.setTextColor(Color.parseColor("#d62828"));
                   holder.option3.setChecked(true);

               }

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
        TextView question;
                RadioButton option1,option2,option3;
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
