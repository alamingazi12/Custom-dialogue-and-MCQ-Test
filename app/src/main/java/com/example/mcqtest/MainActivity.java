package com.example.mcqtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  public static   ArrayList<Question> questionList;
    int write_ans=0,bangla=0,english=0;
    int wrong_ans=0,bangla_wrong=0,english_wrong=0;

    RecyclerView question_item_list_Container;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArrayList();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                startActivity(intent);
               filterArrayList();
               // Log.d("value",String.valueOf(bangla));
                //Log.d("value",String.valueOf(english));

               // Log.d("value",String.valueOf(bangla_wrong));
               // Log.d("value",String.valueOf(english_wrong));

            }
        });
    }
    public void filterArrayList(){
        for( Question question:questionList){
           if(question.getIsAnswered().equals("1") && question.getGivenAns().equals(question.getAnswer())) {
               write_ans++;
               if(question.getS_code().equals("01")){
                   bangla++;
               }
               else if(question.getS_code().equals("02")){
                   english++;
               }

           }
           else if(question.getIsAnswered().equals("1") && !question.getGivenAns().equals(question.getAnswer())){
                  wrong_ans++;
               if(question.getS_code().equals("01")){
                   bangla_wrong++;
               }
               else if(question.getS_code().equals("02")){
                   english_wrong++;
               }

           }

        }


    }
    private void initArrayList() {
        btn_submit=findViewById(R.id.submit);
        questionList=new ArrayList<>();
        question_item_list_Container=findViewById(R.id.q_container);
        question_item_list_Container.setHasFixedSize(true);
        question_item_list_Container.setLayoutManager(new LinearLayoutManager(this));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","01"));
        questionList.add(new Question("I count ---- your help","after","upon","for","with","upon","01"));
        questionList.add(new Question("He fantasized ----winnning the lottery","with","from","after","about","about","01"));
        questionList.add(new Question("Are you doing anything about special ----the weekend","in","for","on","at","at","01"));
        questionList.add(new Question("There is no reason for -----absent","of","for","to be ","for being","for being","01"));
        questionList.add(new Question("Be mindfull ----your duties","of","on","with","to","of","02"));
        questionList.add(new Question("His aunt bought him ----","grown","up","cover","off","up","02"));
        questionList.add(new Question("you should not run---dept","into","in","for","with","into","02"));
        questionList.add(new Question("She put a quilt---me","on","over","upon","above","over","02"));
        questionList.add(new Question("The girl takes---her mother","with","after","to","for","after","02"));
        questionList.add(new Question("My birthday is ---- March","in","on","at","by","in","03"));
        questionList.add(new Question("He passed-----but did not notice me","out","on","by","at","by","03"));
        questionList.add(new Question("He walked ----- the end of the read","to","in","on","at","at","03"));
        questionList.add(new Question("We must confirm---- the rules","of","on","by","to","to","03"));

        QuestionAdapter questionAdapter=new QuestionAdapter(this,questionList);
        question_item_list_Container.setAdapter(questionAdapter);
    }


}