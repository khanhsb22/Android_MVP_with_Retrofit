package com.example.demoapp.presenter;

import android.util.Log;

import com.example.demoapp.model.User;
import com.example.demoapp.utils.RetrofitService;
import com.example.demoapp.utils.UserContract;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements UserContract.Presenter {
    private static final String TAG = "UserPresenter";
    private UserContract.View view;

    public UserPresenter(UserContract.View view) {
        this.view = view;
    }

    @Override
    public void getAllUser() {
        Call<List<User>> call = RetrofitService.builder().getAllUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(TAG, "Get all user response code: " + response.code());
                if (response.code() == 200) {
                    List<User> users = response.body();
                    view.retrieveUsers(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getOneUser() {
        Call<User> user = RetrofitService.builder().getOneUser("3");
        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "Get one user response code: " + response.code());
                if (response.code() == 200) {
                    User result = response.body();
                    view.retrieveSingleUser(result);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    @Override
    public void addOneUser() {
        User user = new User("John", "USA");
        Call<User> call = RetrofitService.builder().addOneUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Add one user response code: " + response.code());
                    if (response.code() == 201) {
                        User result = response.body();
                        view.addOneUserResult(result);
                    }
                } else {
                    Log.d(TAG, "Cannot add a user !");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public void updateOneUser() {
        User user = new User("Marry", "Tokyo");
        Call<User> call = RetrofitService.builder().updateOneUser("2", user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "Update one user response code: " + response.code());
                if (response.code() == 200) {
                    User result = response.body();
                    view.updateOneUserResult(result);
                } else {
                    Log.d(TAG, "Cannot update a user !");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public void deleteOneUser() {
        Call<User> call = RetrofitService.builder().deleteOneUser("4");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "Delete one user response code: " + response.code());
                if (response.code() == 200) {
                    User result = response.body();
                    view.deleteOneUserResult(result);
                } else {
                    Log.d(TAG, "Cannot delete a user !");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });
    }
}
