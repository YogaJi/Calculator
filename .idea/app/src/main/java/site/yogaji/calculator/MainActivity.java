package site.yogaji.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    private String input = "";
    private String num1 = "";
    private String num2 = "";
    private String operator = "";
    int count = 0;//for decimal count
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.get id
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button add = findViewById(R.id.add);
        Button minus = findViewById(R.id.minus);
        Button multi = findViewById(R.id.multi);
        Button divide = findViewById(R.id.divide);
        Button equal = findViewById(R.id.equal);
        Button decimal = findViewById(R.id.decimal);
        Button clearButton = findViewById(R.id.clearButton);
        Button power2 = findViewById(R.id.power2);
        Button power3 = findViewById(R.id.power3);
        TextView screen = findViewById(R.id.screen);

        //2. set Listener
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        multi.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        decimal.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        power2.setOnClickListener(this);
        power3.setOnClickListener(this);
    }

        //3.add onClick function
        @Override
        public void onClick (View view){

            switch(view.getId()){
                case R.id.button0:
                    input += "0";
                    break;
                case R.id.button1:
                    input += "1";
                    break;
                case R.id.button2:
                    input += "2";
                    break;
                case R.id.button3:
                    input += "3";
                    break;
                case R.id.button4:
                    input += "4";
                    break;
                case R.id.button5:
                    input += "5";
                    break;
                case R.id.button6:
                    input += "6";
                    break;
                case R.id.button7:
                    input += "7";
                    break;
                case R.id.button8:
                    input += "8";
                    break;
                case R.id.button9:
                    input += "9";
                    break;
                case R.id.clearButton:
                    input = "";
                    count = 0;
                    break;
                case R.id.power2:
                    power2Getnum1();
                    break;
                case R.id.power3:
                    power3Getnum1();
                    break;
                case R.id.decimal:
                    //set two decimal in num1 num2
                    if(count == 0){
                        input += ".";
                        count++;
                    }else if((input.contains("+")||input.contains("—")||input.contains("*")||input.contains("/"))&&(count == 1)){
                        input += ".";
                        count++;
                    }
                    break;
                //add
                case R.id.add:{
                    if (input.length() == 0){
                        break;
                    }
                    input += "+";

                    num1 = input.substring(0, input.indexOf("+"));
                    operator ="+";
                    }
                    break;
                //minus
                case R.id.minus:{
                    if (input.length() == 0){
                        break;
                    }
                    input += "—";
                    num1 = input.substring(0, input.indexOf("—"));
                    operator ="—";
                    }
                    break;
                //multi
                case R.id.multi:{
                    if (input.length() == 0){
                        break;
                    }
                    input += "*";
                    operator ="*";
                    num1 = input.substring(0, input.indexOf("*"));

                    }
                     break;
                //divide
                case R.id.divide:{
                    if (input.length() == 0){
                        break;
                    }
                    input += "/";
                    operator ="/";
                    num1 = input.substring(0, input.indexOf("/"));
                    }
                    break;

                case R.id.equal:
                    if (input.length() == 0){
                        break;
                    }
                    num2 = input.substring(num1.length()+1, input.length());

                    getResult();
                    break;
                default:
                input = "";

            }
            updateScreen();
        }

        //4.set updateScreen to update calculator screen
        public void updateScreen () {
            TextView screen = findViewById(R.id.screen);
            screen.setText(String.valueOf(input));
        }

        //5.calculation function
        public void getResult(){
            if(input == null||input.equals("")){return;};
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            double sum = 0;

            if (operator.equals("+")) {
                sum = n1 + n2;
            }
            if (operator.equals("—")) {
                sum = n1 - n2;
            }
            if (operator.equals("*")) {
                sum = n1 * n2;
            }
            if (operator.equals("/")) {
                sum = n1 / n2;
            }

            String sumString = String.valueOf(sum);
            //simplify the result from .0 to int
            if((sumString.contains("."))&&(sumString.charAt(sumString.length()-1)=='0')){
                int result = (int)sum;
                input = String.valueOf(result);
    //        }else if(!num1.contains(".")&&!num2.contains(".")&&!operator.equals("÷")) {
    //            int result = (int) sum;
    //            input = String.valueOf(result);
            }else{
                input = String.valueOf(sum);
                if (input.contains(".")) {
                    count = 1;
                    //set decimal count 1 for sum -> num1
                }
            }

        }//end of get result

        public void power2Getnum1(){
            double p = Double.parseDouble(input);
            p = p * p;
            String sumString = String.valueOf(p);

            if((sumString.contains("."))&&(sumString.charAt(sumString.length()-1)=='0')){
                int result = (int)p;
                input = String.valueOf(result);

            }else{
                input = String.valueOf(p);
            }
        }

        public void power3Getnum1(){
            double p = Double.parseDouble(input);
            p = p * p * p;
            String sumString = String.valueOf(p);

            if((sumString.contains("."))&&(sumString.charAt(sumString.length()-1)=='0')){
                int result = (int)p;
                input = String.valueOf(result);

            }else{
                input = String.valueOf(p);
            }
        }
    }


