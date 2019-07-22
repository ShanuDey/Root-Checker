package com.example.rootchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_status;
    private Button btn_check_root;
    private LinearLayout linearLayout;
    private boolean isRooted;
    private static final String superUserPermission = "su";

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
//                isRooted = RootUtil.isDeviceRooted();
//                if(isRooted){
//                    setStatus(isRooted);
//                }
                isRooted = executeShellCommand(superUserPermission);
                setStatus(isRooted);
            }
        });

    }

    public void setStatus(boolean isRooted){
        if(isRooted){
            tv_status.setText("Rooted");
            linearLayout.setBackground(getDrawable(R.color.green));
        }
        else{
            tv_status.setText("Not Rooted");
            linearLayout.setBackground(getDrawable(R.color.red));
        }
    }

    private boolean executeShellCommand(String command){
        Process process = null;
        try{
            process = Runtime.getRuntime().exec(command);
            //isRooted =true;
            Log.v("shanu","try rooted");
            return true;
        } catch (Exception e) {
            //isRooted = false;
            Log.v("shanu","catch not rooted");
            return false;
        } finally{
            if(process != null){
                try{
                    process.destroy();
                }catch (Exception e) {
                }
            }
        }
    }


}
