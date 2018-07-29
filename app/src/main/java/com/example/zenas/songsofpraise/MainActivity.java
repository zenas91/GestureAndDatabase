package com.example.zenas.songsofpraise;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private TextView zenas;
    private GestureDetectorCompat zeeGesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        EditText searchTitle = findViewById(R.id.searchTitle);
                        TextView result = findViewById(R.id.searchResult);
                        String songTitle = searchTitle.getText().toString().toUpperCase();

                        if (songTitle!=null){
                            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();

                            String songLyrics = databaseAccess.getLyrics(songTitle);

                            result.setText(songLyrics);
                            databaseAccess.close();
                        }

                    }
                }
        );

        searchButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView result = findViewById(R.id.searchResult);
                        result.setText(R.string.error);
                        return true;
                    }
                }
        );
        zenas = findViewById(R.id.zenasTest);
        this.zeeGesture = new GestureDetectorCompat(this, this);
        zeeGesture.setOnDoubleTapListener(this);

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        zenas.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        zenas.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        zenas.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        zenas.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        zenas.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        zenas.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        zenas.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        zenas.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        zenas.setText("onFling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.zeeGesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
