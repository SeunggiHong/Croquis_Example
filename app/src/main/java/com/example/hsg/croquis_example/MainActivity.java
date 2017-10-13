package com.example.hsg.croquis_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private int sum;
    private String number = "";
    private TextView text;
    private EditText edit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.txt);
        edit = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = edit.getText().toString();

                for (int i = 0; i < str.length(); i++) {

                    Log.e("TAG", "current char : " + str.charAt(i));

                    if (isNumeric(str.charAt(i))) {
                        number += str.charAt(i);
                        if (i + 1 < str.length()) {
                            if (!isNumeric(str.charAt(i + 1))) {
                                int temp = Integer.parseInt(number);
                                if (temp % 2 != 0) {
                                    Log.e("TAG", "tem p  : " + temp);
                                    sum += Math.pow(temp, 2);
                                }
                                number = "";
                            }
                        } else {
                            int temp = Integer.parseInt(number);
                            if (temp % 2 != 0) {
                                Log.e("TAG", "tem p  : " + temp);
                                sum += Math.pow(temp, 2);
                            }
                            number = "";
                        }
                    }
                }

                text.setText("Result : " + sum);
                sum = 0;


            }
        });

    }

    public static boolean isNumeric(char s) {
        return String.valueOf(s).matches("[-+]?\\d*\\.?\\d+");
    }


}
