package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button[] buttons;
    Button btnC, btnAdd, btnEqual, btnSubstract, btnDivide, btnMultiply, btnComma;
    TextView txtResult;
    Double num1, num2;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            txtResult = findViewById(R.id.txt_result);
            buttons = new Button[]{
                findViewById(R.id.btn_0),
                findViewById(R.id.btn_1),
                findViewById(R.id.btn_2),
                findViewById(R.id.btn_3),
                findViewById(R.id.btn_4),
                findViewById(R.id.btn_5),
                findViewById(R.id.btn_6),
                findViewById(R.id.btn_7),
                findViewById(R.id.btn_8),
                findViewById(R.id.btn_9)
            };

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button pressedButton = (Button) v;
                    txtResult.append(pressedButton.getText());
                }
            });
        }

        btnC = findViewById(R.id.btn_c);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
            }
        });

        btnComma = findViewById(R.id.btn_comma);
        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtResult.getText().toString().contains(".")){
                    txtResult.append(".");
                }
            }
        });

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(txtResult.getText().toString());
                operation = "+";
                txtResult.setText("");
            }
        });

        btnSubstract = findViewById(R.id.btn_substract);
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(txtResult.getText().toString());
                operation = "-";
                txtResult.setText("");
            }
        });

        btnDivide = findViewById(R.id.btn_divide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(txtResult.getText().toString());
                operation = "/";
                txtResult.setText("");
            }
        });

        btnMultiply = findViewById(R.id.btn_multiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(txtResult.getText().toString());
                operation = "*";
                txtResult.setText("");
            }
        });

        btnEqual = findViewById(R.id.btn_equal);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(txtResult.getText().toString());
                Double result = 0.0;
                switch (operation){
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "/":
                        if(num2 == 0) {
                            txtResult.setText(getString(R.string.Divide0));
                            return;
                        }
                        result = num1 / num2;
                        break;

                    case  "*":
                        result = num1 * num2;
                        break;
                }
                txtResult.setText(String.valueOf(result));
            }
        });
    }
}