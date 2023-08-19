package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//import com.example.myapplication.dataBinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityTicTacToeBinding;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends AppCompatActivity {

    ActivityTicTacToeBinding binding;
    private final List<int[]> compinationList = new ArrayList<>();
    private int[] boxPostion = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectboxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        binding = ActivityTicTacToeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        compinationList.add(new int[]{0, 1, 2});
        compinationList.add(new int[]{3, 4, 5});
        compinationList.add(new int[]{6, 7, 8});
        compinationList.add(new int[]{0, 3, 6});
        compinationList.add(new int[]{1, 4, 7});
        compinationList.add(new int[]{2, 5, 8});
        compinationList.add(new int[]{2, 4, 6});
        compinationList.add(new int[]{0, 4, 8});


        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });
        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }


//this method called when player selects box
    private void performAction(ImageView imageView, int selectedBoxPostion) {
        boxPostion[selectedBoxPostion] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x);

            if (checkResults()) {
                ResultDailog resultDailog = new ResultDailog(TicTacToe.this, binding.playerOneName.getText().toString()
                        + "  is winner!", TicTacToe.this);
                resultDailog.setCancelable(false);
                resultDailog.show();

        } else if (totalSelectboxes == 9) {
            ResultDailog resultDialog = new ResultDailog(TicTacToe.this, "Match Draw", TicTacToe.this);
            resultDialog.setCancelable(false);
            resultDialog.show();
        } else {
            changePlayerTurn(2);
            totalSelectboxes++;
        }
    }else {
            imageView.setImageResource(R.drawable.o);

            if (checkResults()) {
                ResultDailog resultDailog = new ResultDailog(TicTacToe.this, binding.playerTwoName.getText().toString()
                        + "  is winner!",TicTacToe.this);
                resultDailog.setCancelable(false);
                resultDailog.show();

            } else if (totalSelectboxes == 9) {
                ResultDailog resultDialog = new ResultDailog(TicTacToe.this, "Match Draw", TicTacToe.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectboxes++;
            }
        }

    }



    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.PlayeroneLayout.setBackgroundResource(R.drawable.black__border);
            binding.PlayerTwoLayout.setBackgroundResource(R.drawable.white_box);
        } else {
            binding.PlayerTwoLayout.setBackgroundResource(R.drawable.black__border);
            binding.PlayeroneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResults(){
        boolean response = false;
        for (int i = 0; i < compinationList.size(); i++){
            final int[] combination = compinationList.get(i);
            if (boxPostion[combination[0]] == playerTurn && boxPostion[combination[1]] == playerTurn &&
                    boxPostion[combination[2]] == playerTurn) {
                response = true;
            }
        }
        return response;
    }
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPostion[boxPosition] == 0) {
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxPostion = new int[] {0,0,0,0,0,0,0,0,0}; //9 zero
        playerTurn = 1;
        totalSelectboxes = 1;
        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}
