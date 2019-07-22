package com.example.rootchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_status;
    private Button btn_check_root;
    private LinearLayout linearLayout;
    private boolean isRooted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_status = findViewById(R.id.tv_status);
        btn_check_root = findViewById(R.id.btn_check_root);
        linearLayout = findViewById(R.id.ll_background);


        btn_check_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRooted = RootUtil.isDeviceRooted();
                if(isRooted){
                    tv_status.setText("Rooted");
                    linearLayout.setBackground(getDrawable(R.color.green));
                }
                else{
                    tv_status.setText("Not Rooted");
                    linearLayout.setBackground(getDrawable(R.color.red));
                }

            }
        });

    }


}
