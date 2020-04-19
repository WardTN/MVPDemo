package com.example.mvpdemo.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.book.model.Book;
import com.example.mvpdemo.book.presenter.BookPresenter;
import com.example.mvpdemo.book.view.BookView;


public class BookActivity extends AppCompatActivity {
    private TextView text;
    private Button button;
    private BookPresenter mBookPresenter = new BookPresenter(this);

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book books) {
            Toast.makeText(BookActivity.this, books.name, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(String s) {
            Toast.makeText(BookActivity.this, s, Toast.LENGTH_SHORT).show();
            Log.e("CHEN", s);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getBook();
            }
        });
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
