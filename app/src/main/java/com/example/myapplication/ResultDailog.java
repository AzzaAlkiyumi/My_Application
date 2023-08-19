package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultDailog extends Dialog {
    private final String message;
    private TicTacToe ticTacToe;

    public ResultDailog(@NonNull Context context, String message , TicTacToe ticTacToe) {
        super(context);
        this.message=message;
        this.ticTacToe=ticTacToe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dailog);
        TextView messageText =findViewById(R.id.messageText);
        Button statAgainButton =findViewById(R.id.statAgainButton);

        messageText.setText(message);
        statAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticTacToe.restartMatch();
                dismiss();
            }
        });
    }
}