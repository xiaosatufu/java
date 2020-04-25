package com.example.calculation;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    private static String KEY_HIGH_SCORE = "key_high_score";
    private static String KEY_LEFT_NUMBER = "key_left_number";
    private static String KEY_RIGHT_NUMBER = "key_right_number";
    private static String KEY_OPERATOR = "key_operator";
    private static String KEY_ANSWER = "key_answer";
    private static String SAVE_SHP_DATA_NAME="save_shp_data_name";
    private static String KEY_CURRENT_SCORE = "key_current_score";

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)) {
            SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE,shp.getInt(KEY_HIGH_SCORE,0));
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATOR,"+");
            handle.set(KEY_ANSWER,0);
            handle.set(KEY_CURRENT_SCORE,0);
        }
        this.handle = handle;
    }
    MutableLiveData<Integer>getLeftNumber(){
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }
    MutableLiveData<Integer>getRightNumber(){
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }
    MutableLiveData<String>getOperator(){
        return handle.getLiveData(KEY_OPERATOR);
    }
    MutableLiveData<Integer>getHighScore(){
        return handle.getLiveData(KEY_HIGH_SCORE);
    }
    MutableLiveData<Integer>getCurrentScore(){
        return  handle.getLiveData(KEY_CURRENT_SCORE);
    }
    MutableLiveData<Integer>getAnswer(){
        return handle.getLiveData(KEY_ANSWER);
    }
}
