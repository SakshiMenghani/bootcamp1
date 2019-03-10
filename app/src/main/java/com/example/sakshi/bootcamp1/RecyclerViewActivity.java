package com.example.sakshi.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter ;
    private List<RecyclerViewData> UserList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        setUpRecyclerView();
    }

    private void apicall() {
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        UserList.addAll(response.body().getRecyclerViewData());
                        Log.e("here=====","okay" );

                    }

                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });
    }



    private void setUpRecyclerView(){


        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewDataList(UserList);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
