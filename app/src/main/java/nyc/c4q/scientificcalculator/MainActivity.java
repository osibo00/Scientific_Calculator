package nyc.c4q.scientificcalculator;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

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
        binding.editText.setText((binding.editText.getText() + "7"));
    }

    public void numberEight(View view) {
        binding.editText.setText((binding.editText.getText() + "8"));
    }

    public void numberNine(View view) {
        binding.editText.setText((binding.editText.getText() + "9"));
    }

    public void numberFour(View view) {
        binding.editText.setText((binding.editText.getText() + "4"));
    }

    public void numberFive(View view) {
        binding.editText.setText((binding.editText.getText() + "5"));
    }

    public void numberSix(View view) {
        binding.editText.setText((binding.editText.getText() + "6"));
    }

    public void numberOne(View view) {
        binding.editText.setText((binding.editText.getText() + "1"));
    }

    public void numberTwo(View view) {
        binding.editText.setText((binding.editText.getText() + "2"));
    }

    public void numberThree(View view) {
        binding.editText.setText((binding.editText.getText() + "3"));
    }

    public void numberDot(View view) {
        binding.editText.setText((binding.editText.getText() + "."));
    }

    public void numberZero(View view) {
        binding.editText.setText((binding.editText.getText() + "0"));
    }

    public void numberEqual(View view) {
        unlimtedPower();
        if (!Double.isNaN(valueSecond)) {
            try {
                binding.textView.setText(binding.textView.getText().toString() + decimalFormat.format(valueSecond) + " = " + decimalFormat.format(valueFirst));
                valueFirst = Double.NaN;
                calculations = '0';
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Not a number.", Toast.LENGTH_LONG).show();
                binding.editText.setText(null);
                binding.textView.setText(null);
            }
        }
    }

    public void numberDivide(View view) {
        unlimtedPower();
        calculations = division;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + "/");
            binding.editText.setText(null);
        }
    }

    public void numberMultiply(View view) {
        unlimtedPower();
        calculations = multiplication;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + "*");
            binding.editText.setText(null);
        }
    }

    public void numberAdd(View view) {
        unlimtedPower();
        calculations = addition;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + "+");
            binding.editText.setText(null);
        }
    }

    public void numberSubtract(View view) {
        unlimtedPower();
        calculations = subtraction;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + "-");
            binding.editText.setText(null);
        }
    }

    public void numberLParen(View view) {
        binding.editText.setText((binding.editText.getText() + "("));
    }

    public void numberRParen(View view) {
        binding.editText.setText((binding.editText.getText() + ")"));
    }

    public void numberMod(View view) {
        calculations = mod;
        if (!Double.isNaN(valueFirst)) {
            binding.textView.setText(decimalFormat.format(valueFirst) + "%");
            binding.editText.setText(null);
        }
    }

    public void numberClear(View view) {
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

    private void unlimtedPower() {
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


