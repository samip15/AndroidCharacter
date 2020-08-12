package com.example.androidcharacter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidcharacter.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListner{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // pass bundle to android character activity
        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        // attach to intent
        final Intent intent = new Intent(this,AndroidCharacterActivity.class);
        intent.putExtras(b);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked"+position, Toast.LENGTH_SHORT).show();

        // get the body part number
        //0-head
        //1-body
        //2-leg

        int bodyPartNumber = position/12;
        // list index
        int listIndex = position-12*bodyPartNumber;

        // selected image is placed on the body part fragment accordingly

        switch (bodyPartNumber){
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case  2:
                legIndex = listIndex;
                break;
            default: break;
        }

        // pass bundle to android character activity
        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        // attach to intent
        final Intent intent = new Intent(this,AndroidCharacterActivity.class);
        intent.putExtras(b);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}