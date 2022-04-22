package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //    private TextView titleTextView;
//    private TextView authorTextView;
    private ActivityMainBinding activityMainBinding;
    private MainActivityButtonsHandler mainActivityButtonsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        titleTextView = findViewById(R.id.titleTextView);
//        authorTextView = findViewById(R.id.authorTextView);
//
//        titleTextView.setText(getCurrentBook().getTitle());
//        authorTextView.setText(getCurrentBook().getAuthor());

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setBook(getCurrentBook());

        mainActivityButtonsHandler = new MainActivityButtonsHandler(this);
        activityMainBinding.setButtonHandler(mainActivityButtonsHandler);
    }

    private Book getCurrentBook() {
        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("Shakespeare");
        return book;
    }


    public class MainActivityButtonsHandler {
        Context context;

        public MainActivityButtonsHandler(Context context) {
            this.context = context;
        }

        public void onCancelClicked(View view) {
            startActivity(new Intent(MainActivity.this, TwoWayBindingActivity.class));
        }

        public void onOkClicked(View view) {
            startActivity(new Intent(MainActivity.this, OkActivity.class));
        }
    }
}