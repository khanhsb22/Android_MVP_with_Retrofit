package com.example.demoapp.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.model.User;
import com.example.demoapp.presenter.UserPresenter;
import com.example.demoapp.utils.UserContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserContract.View {
    private ActivityMainBinding binding;
    private UserPresenter userPresenter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initUserPresenter();

        binding.buttonGetAll.setOnClickListener(view -> {
            userPresenter.getAllUser();
        });

        binding.buttonGetOne.setOnClickListener(view -> {
            userPresenter.getOneUser();
        });

        binding.buttonPost.setOnClickListener(view -> {
            userPresenter.addOneUser();
        });

        binding.buttonPut.setOnClickListener(view -> {
            userPresenter.updateOneUser();
        });

        binding.buttonDelete.setOnClickListener(view -> {
            userPresenter.deleteOneUser();
        });
    }

    private void initUserPresenter() {
        userPresenter = new UserPresenter(this);
    }

    @Override
    public void retrieveUsers(List<User> list) {
        for (User item : list) {
            Log.d(TAG, "{id: " + item.getId() + ", name: "
                    + item.getName() + ", country: " + item.getCountry() + "}");
        }
    }

    @Override
    public void retrieveSingleUser(User user) {
        Log.d(TAG, "{id: " + user.getId() + ", name: "
                + user.getName() + ", country: " + user.getCountry() + "}");
    }

    @Override
    public void addOneUserResult(User user) {
        // Id is auto increment when execute POST action
        Log.d(TAG, "Add one user result: " + "{id: " + user.getId() + ", name: "
                + user.getName() + ", country: " + user.getCountry() + "}");
    }

    @Override
    public void updateOneUserResult(User user) {
        // The returned id is the same as the id passed to the PUT method
        Log.d(TAG, "Update one user result: " + "{id: " + user.getId() + ", name: "
                + user.getName() + ", country: " + user.getCountry() + "}");
    }

    @Override
    public void deleteOneUserResult(User user) {
        Log.d(TAG, "Delete one user result: " + "{id: " + user.getId() + ", name: "
                + user.getName() + ", country: " + user.getCountry() + "}");
    }
}