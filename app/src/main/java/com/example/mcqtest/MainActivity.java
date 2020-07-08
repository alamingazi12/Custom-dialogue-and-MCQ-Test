package com.example.mcqtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  public static   ArrayList<Question> questionList;
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
            }
        });
    }

    private void initArrayList() {
        btn_submit=findViewById(R.id.submit);
        questionList=new ArrayList<>();
        question_item_list_Container=findViewById(R.id.q_container);
        question_item_list_Container.setHasFixedSize(true);
        question_item_list_Container.setLayoutManager(new LinearLayoutManager(this));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","01"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","01"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","01"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","01"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","02"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","02"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","02"));
        questionList.add(new Question("He argued --- me about the merrage","with","for","to","from","with","02"));

        QuestionAdapter questionAdapter=new QuestionAdapter(this,questionList);
        question_item_list_Container.setAdapter(questionAdapter);
    }


}