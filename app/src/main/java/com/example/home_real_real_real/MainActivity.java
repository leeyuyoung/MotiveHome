package com.example.home_real_real_real;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ImageView checkbox;
    ImageView checkbox2;
    ImageView checkbox3;

    TextView textView2;
    private boolean isClicked = false;

    private RecyclerView recyclerView;
    private GoalAdapter adapter;
    private ArrayList<Goal> gItems;
//    private FirebaseDatabase database;
//    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // > 버튼 클릭 시 목표창 이동
        ImageButton movegoal = findViewById(R.id.movegoal);

        movegoal.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), mokpyochang.class);
            startActivity(intent);
        });

        //리사이클러뷰 설정
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 데이터 추가
        gItems = new ArrayList<>();

        // 어댑터 초기화 및 RecyclerView에 연결
        adapter = new GoalAdapter(gItems, this);
        recyclerView.setAdapter(adapter);

        // 샘플 데이터 추가
        for (int i = 0; i < 3; i++) {
            Goal item = new Goal();
            item.setGoalText("SampleTitle" + i);

            // 어댑터에 아이템 추가 및 노티파이
            adapter.notifyItemInserted(gItems.size() - 1);

            // 데이터 리스트에 아이템 추가
            gItems.add(item);
        }


        // 체크박스
//        checkbox = findViewById(R.id.checkbox);
//        checkbox.setOnClickListener(view -> {
//            isClicked = !isClicked;
//
//            if (isClicked)
//                checkbox.setImageResource(R.drawable.shape_clicked);
//            else
//                checkbox.setImageResource(R.drawable.shape_unclicked);
//        });


    }
}

