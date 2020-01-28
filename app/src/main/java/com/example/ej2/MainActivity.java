package com.example.ej2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private TextView infoShow;
    private CheckBox license,years;
    private TextInputEditText[] fields=new TextInputEditText[3];
    private Button logIn,restoreData,generatePass;
    private RadioGroup group;
    private String[] sensitiveInfo=new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INIT
        final int[] fieldIds=new int[]{R.id.emailField,R.id.dniField,R.id.passField};
        infoShow=findViewById(R.id.outputInfo);
        logIn=findViewById(R.id.logButton);
        restoreData=findViewById(R.id.restoreDataButton);
        generatePass=findViewById(R.id.createPassButton);
        infoShow=findViewById(R.id.outputInfo);
        group=findViewById(R.id.radioGroup);
        license=findViewById(R.id.licenseCheckBox);
        years=findViewById(R.id.yearsCheckBox);

        for(int a=0;a!=fields.length;a++) {
            fields[a] = findViewById(fieldIds[a]);
        }

        //CONFIG OnClick

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data="";
                for(int a=0;a!=fields.length;a++){
                    data+="Field" + (a+1) + ":";
                    if(fields[a].getText().toString().isEmpty()){
                        Log.d("APPDebug","Data NULL on field " + (a+1));
                        data+="NULL";
                    }else{
                        data+=fields[a].getText();
                    }
                    data+="\n";
                }
                data+="RadioButtonSelection:";
                switch (group.getCheckedRadioButtonId()){
                    case R.id.studentButton:
                        data+="Student";
                        break;
                    case R.id.teacherButton:
                        data+="Teacher";
                        break;
                    default:
                        data+="NULL SELECTION";
                }
                data+="\n";
                data+="Has license:" + license.isChecked() + "\n";
                data+="+18?:" + years.isChecked() + "\n";
                infoShow.setText(data);

            }
        });
    }
    public void generatePassword(){

    }
}
