package com.augmentis.ayp.aypcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_0;
    Button button_div;
    Button button_sub;
    Button button_sum;
    Button button_mul;
    Button button_equal;
    Button button_cancel;
    TextView textView_op1;
    TextView textView_op2;
    String op1 = "";
    String op2 = "";
    String text_op1 = "";
    String answer = "";
    String nextOperator;
    String currentOperator;
    boolean isCalculated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initializeComponent();
        handleButton();
        updateOp2();
    }

    private boolean isZero() {
        return op2.equals("0");
    }

    private String calculate(String op1, String op2, String operator) {
        Double temp_answer = null;
        if (operator.equals("+")) {
            temp_answer = Double.parseDouble(op1) + Double.parseDouble(op2);
            answer = Double.toString(temp_answer);
        } else if (operator.equals("-")) {
            temp_answer = Double.parseDouble(op1) - Double.parseDouble(op2);
            answer = Double.toString(temp_answer);
        } else if (operator.equals("X")) {
            temp_answer = Double.parseDouble(op1) * Double.parseDouble(op2);
            answer = Double.toString(temp_answer);
        } else if (operator.equals("÷")) {
            temp_answer = Double.parseDouble(op1) / Double.parseDouble(op2);
            answer = Double.toString(temp_answer);
        }
        if (temp_answer % 1 == 0 ) {
            op2 = answer.substring(0, answer.length()-2);
        }else{
            op2 = answer;
        }
        textView_op2.setText(op2);
        isCalculated = true;
        return answer;
    }

    private void prepareOp1(String operator) {
        nextOperator = operator;
        if (op1.equals("")) {
            currentOperator = nextOperator;
            op1 = op2;
            text_op1 = op2 + " " + operator + " ";
            textView_op1.setText(text_op1);
        } else {
            String temp_text_op1;
            if (!isCalculated) {
                text_op1 += op2 + " " + operator + " ";
                textView_op1.setText(text_op1);
            }
            else{
                temp_text_op1 = text_op1.substring(0, text_op1.length()-2) + operator + " ";
                textView_op1.setText(temp_text_op1);
                nextOperator = operator;
            }

            if (!isCalculated) op1 = calculate(op1, op2, currentOperator);
            currentOperator = nextOperator;
        }
        op2 = "";
    }

    private void updateOp2() {
        if (op2.equals("")) op2 = "0";
        textView_op2.setText(op2);
        isCalculated = false;
    }

    private void handleButton() {
        clickOnNumber();
        clickOnOperator();
        clickOnEqual();
        clickOnCancel();
    }

    private void clickOnNumber() {
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isZero()) op2 += "0";
                updateOp2();
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "1";
                else op2 += "1";
                updateOp2();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "2";
                else op2 += "2";
                updateOp2();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "3";
                else op2 += "3";
                updateOp2();
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "4";
                else op2 += "4";
                updateOp2();
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "5";
                else op2 += "5";
                updateOp2();
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "6";
                else op2 += "6";
                updateOp2();
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "7";
                else op2 += "7";
                updateOp2();
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "8";
                else op2 += "8";
                updateOp2();
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isZero()) op2 = "9";
                else op2 += "9";
                updateOp2();
            }
        });
    }

    private void clickOnOperator() {
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareOp1("÷");
            }
        });

        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareOp1("+");
            }
        });

        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareOp1("-");
            }
        });

        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareOp1("X");
            }
        });
    }

    private void clickOnEqual() {
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!op1.equals("")){
                    calculate(op1, op2, nextOperator );
                    isCalculated = false;
                }
            }
        });
    }

    private void initializeComponent() {
        textView_op1 = (TextView) findViewById(R.id.textViewOperand1);
        textView_op2 = (TextView) findViewById(R.id.textViewOperand2);
        button_0 = (Button) findViewById(R.id.buttonZero);
        button_1 = (Button) findViewById(R.id.buttonOne);
        button_2 = (Button) findViewById(R.id.buttonTwo);
        button_3 = (Button) findViewById(R.id.buttonThree);
        button_4 = (Button) findViewById(R.id.buttonFour);
        button_5 = (Button) findViewById(R.id.buttonFive);
        button_6 = (Button) findViewById(R.id.buttonSix);
        button_7 = (Button) findViewById(R.id.buttonSeven);
        button_8 = (Button) findViewById(R.id.buttonEight);
        button_9 = (Button) findViewById(R.id.buttonNine);
        button_sub = (Button) findViewById(R.id.buttonSub);
        button_sum = (Button) findViewById(R.id.buttonSum);
        button_div = (Button) findViewById(R.id.buttonDiv);
        button_mul = (Button) findViewById(R.id.buttonMul);
        button_cancel = (Button) findViewById(R.id.buttonCancel);
        button_equal = (Button) findViewById(R.id.buttonEqual);
    }

    private void clickOnCancel() {
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op2.length() > 0) {
                    String newOp2 = op2.substring(0, op2.length() - 1);
                    op2 = newOp2;
                    updateOp2();
                }

            }
        });
    }
}
