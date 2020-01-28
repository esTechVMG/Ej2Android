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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView infoShow;
    private CheckBox license,years;
    private TextInputEditText[] fields=new TextInputEditText[3];
    private Button logIn,restoreData,generatePass;
    private RadioGroup group;
    private String[] sensitiveInfo=new String[6];
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
        setDataNull();
        updateTextView();
        //CONFIG ONCLICKS
        logIn.setOnClickListener(this);
        restoreData.setOnClickListener(this);
        generatePass.setOnClickListener(this);
    }
    public void generatePassword(){

    }

    @Override
    public void onClick(View v) {
        String tempData;
        switch (v.getId()){
            case R.id.logButton:
                for(int a=0;a!=fields.length;a++){
                    tempData=fields[a].getText().toString();
                    if(tempData.isEmpty()){
                       sensitiveInfo[a]="NULL";
                    }else{
                        sensitiveInfo[a]=tempData;
                    }
                }
                boolean exit=false;
                switch (group.getCheckedRadioButtonId()){
                    case R.id.teacherButton:
                        sensitiveInfo[3]="Student";
                        break;
                    case R.id.studentButton:
                        sensitiveInfo[3]="Profesor";
                        break;
                    default:
                        displayToast("Seleccione alumno o estudiante");
                        setDataNull();
                        exit=true;

                }
                if(exit){
                    break;
                }
                if(license.isChecked()){
                    sensitiveInfo[4]="Tiene Carnet";
                }else {
                    sensitiveInfo[4]="No tiene Carnet";
                }
                if(years.isChecked()){
                    sensitiveInfo[5]="Es mayor de edad";
                }else{
                    sensitiveInfo[5]="No es mayor de edad";
                }


                break;
            case R.id.createPassButton:
                sensitiveInfo[2]="Patata1234";
                break;
            case R.id.restoreDataButton:
                    setDataNull();
                break;

        }
        updateTextView();
    }
    public void displayToast(String text){
        Toast toast= Toast.makeText(getApplicationContext(),text,Toast. LENGTH_SHORT);
        toast.show();
    }
    public void updateTextView(){
        String output="";
        for(int a=0;a!=sensitiveInfo.length;a++){
            output+=sensitiveInfo[a]+"\n";
        }
        infoShow.setText(output);
    }
    public void setDataNull(){
        for(int a=0;a!=sensitiveInfo.length;a++){
            sensitiveInfo[a]="NULL";
        }
    }
}
