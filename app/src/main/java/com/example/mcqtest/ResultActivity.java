package com.example.mcqtest;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    RecyclerView result_container;
    ArrayList<Question> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initAll();
    }

    private void initAll() {
        result_container=findViewById(R.id.result_container);
        result_container.setHasFixedSize(true);
        result_container.setLayoutManager(new LinearLayoutManager(ResultActivity.this));

        AnswerAdapter answerAdapter=new AnswerAdapter(MainActivity.questionList,this);
        result_container.setAdapter(answerAdapter);
    }
}