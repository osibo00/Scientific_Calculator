package nyc.c4q.scientificcalculator;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.*;

import nyc.c4q.scientificcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;

    public static final char addition = '+';
    public static final char subtraction = '-';
    public static final char multiplication = '*';
    public static final char division = '/';
    public static final char mod = '%';
    public char calculations;
    public double valueFirst = Double.NaN;
    public double valueSecond = Double.NaN;

    public DecimalFormat decimalFormat;
    public String expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        }

    }

    public void numberSeven(View view) {
        expression += "7";
        binding.editText.setText((binding.editText.getText() + "7"));
    }

    public void numberEight(View view) {
        expression += "8";
        binding.editText.setText((binding.editText.getText() + "8"));
    }

    public void numberNine(View view) {
        expression += "9";
        binding.editText.setText((binding.editText.getText() + "9"));
    }

    public void numberFour(View view) {
        expression += "4";
        binding.editText.setText((binding.editText.getText() + "4"));
    }

    public void numberFive(View view) {
        expression += "5";
        binding.editText.setText((binding.editText.getText() + "5"));
    }

    public void numberSix(View view) {
        expression += "6";
        binding.editText.setText((binding.editText.getText() + "6"));
    }

    public void numberOne(View view) {
        expression += "1";
        binding.editText.setText((binding.editText.getText() + "1"));
    }

    public void numberTwo(View view) {
        expression += "2";
        binding.editText.setText((binding.editText.getText() + "2"));
    }

    public void numberThree(View view) {
        expression += "3";
        binding.editText.setText((binding.editText.getText() + "3"));
    }

    public void numberDot(View view) {
        expression += ",";
        binding.editText.setText((binding.editText.getText() + "."));
    }

    public void numberZero(View view) {
        expression += "0";
        binding.editText.setText((binding.editText.getText() + "0"));
    }

    public void numberEqual(View view) {
        unlimitedPower();
        Expression exp = new ExpressionBuilder(expression).build();
        double result = exp.evaluate();
        //binding.textView.setText(""+result);
        if (!Double.isNaN(valueSecond)) {
            if (result != 0.0d)
                binding.textView.setText(binding.textView.getText().toString() + " " + decimalFormat.format(valueSecond) + " = " + decimalFormat.format(result));
                valueFirst = Double.NaN;
                calculations = '0';
            } else {
            binding.textView.setText(binding.textView.getText().toString() + " " + decimalFormat.format(valueSecond) + " = " + decimalFormat.format(valueFirst));
            valueFirst = Double.NaN;
            calculations = '0';
        }
        }

    public void numberDivide(View view) {
        expression += division;
        unlimitedPower();
        calculations = division;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + " /");
            binding.editText.setText(null);
        }
    }

    public void numberMultiply(View view) {
        expression += multiplication;
        unlimitedPower();
        calculations = multiplication;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + " *");
            binding.editText.setText(null);
        }
    }

    public void numberAdd(View view) {
        expression += addition;
        unlimitedPower();
        calculations = addition;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + " +");
            binding.editText.setText(null);
        }
    }

    public void numberSubtract(View view) {
        expression += subtraction;
        unlimitedPower();
        calculations = subtraction;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + " -");
            binding.editText.setText(null);
        }
    }

    public void numberMod(View view) {
        expression += mod;
        unlimitedPower();
        calculations = mod;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + " %");
            binding.editText.setText(null);
        }
    }

    public void numberClear(View view) {
        expression = "";
        if (binding.editText.getText().length() > 0) {
            CharSequence currentText = binding.editText.getText();
            binding.editText.setText(currentText.subSequence(0, currentText.length() - 1));
        } else {
            valueFirst = Double.NaN;
            valueSecond = Double.NaN;
            binding.editText.setText("");
            binding.textView.setText("");
        }
    }

    public void sinOp(View view){
        expression+= getString(R.string.sin_operator);
        binding.textView.setText(expression);
    }

    public void cosOp(View view){
        expression+= getString(R.string.cos_operator);
        binding.textView.setText(expression);
    }

    public void tanOp(View view){
        expression += getString(R.string.tan_operator);
        binding.textView.setText(expression);
    }

    public void logOp(View view){
        expression+= getString(R.string.log_operator);
        binding.textView.setText(expression);
    }

    public void powOp(View view){
        expression+= "^";
        binding.textView.setText(expression);
        binding.editText.setText(null);
    }

    public void leftParen(View view){
        expression+= "(";
        binding.textView.setText(expression);
    }

    public void rightParen(View view){
        expression += ")";
        binding.textView.setText(expression);
    }

    public void sqrtOp(View view){
        expression += "sqrt";
        binding.textView.setText(expression);
    }

    public void ansOp(View view){
        String valueFirst = binding.textView.getText().toString();
        binding.editText.setText(valueFirst);
    }

    public void degOp(View view){
        double d = valueFirst;
        double deg = Math.toDegrees(d);
        binding.textView.setText(""+deg);
    }

    public void radOp(View view){
        double d = valueFirst;
        double rad = Math.toRadians(d);
        binding.textView.setText(""+rad);
    }

    public void piOp(View view){
        double d = valueFirst;
        double result = Math.PI * valueFirst;
        binding.textView.setText(""+result);
    }


    public void factOp(View view){
        double d = valueFirst;
        double result = 1;
        for(int i = 1;i <= d;i++ ){
            result = result * i;
        }
        binding.textView.setText(""+result);
    }


    private void unlimitedPower() {
        if (!Double.isNaN(valueFirst)) {
            valueSecond = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if (calculations == addition) {
                valueFirst = this.valueFirst + valueSecond;
            } else if (calculations == subtraction) {
                valueFirst = this.valueFirst - valueSecond;
            } else if (calculations == division) {
                valueFirst = this.valueFirst / valueSecond;
            } else if (calculations == multiplication) {
                valueFirst = this.valueFirst * valueSecond;
            } else if (calculations == mod) {
                valueFirst = this.valueFirst % valueSecond;
            }
        } else {
            try {
                valueFirst = Double.parseDouble(binding.editText.getText().toString());
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "The number you have entered is not a number.", Toast.LENGTH_LONG).show();
                binding.editText.setText(null);
            }
        }
    }
}


