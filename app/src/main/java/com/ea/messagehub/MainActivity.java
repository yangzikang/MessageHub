package com.ea.messagehub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ea.messagelibrary.messageDistribute.SCMessage;
import com.ea.messagelibrary.messageDistribute.SCResponser;
import com.ea.messagelibrary.messageDistribute.SCSender;
import com.ea.messagelibrary.messageDistribute.Tag;

import java.util.Date;

import static com.ea.messagelibrary.messageDistribute.SCThreadModeType.MAINTHREAD;


public class MainActivity extends AppCompatActivity{
    TextView textView;
    Button button ;

    @Tag(tag = "login",threadMode = MAINTHREAD)
    SCResponser responser = new SCResponser() {
        @Override
        public void onReceive(SCMessage message) {
            Date date = new Date();

            textView.setText(date.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);


        responser.register(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCSender.sendMessage("login");

            }
        });


    }

}
