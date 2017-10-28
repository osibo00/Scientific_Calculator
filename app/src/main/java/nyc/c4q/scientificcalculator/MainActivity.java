package nyc.c4q.scientificcalculator;

import android.content.res.Resources;
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

        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });

        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "0"));
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "1"));
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "2"));
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "3"));
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "4"));
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "5"));
            }
        });

        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "6"));
            }
        });

        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "7"));
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "8"));
            }
        });

        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "9"));
            }
        });

        binding.buttonLParen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + "("));
            }
        });

        binding.buttonRParen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText((binding.editText.getText() + ")"));
            }
        });

        binding.buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculations = mod;
                if (!Double.isNaN(valueFirst)) {
                    binding.textView.setText(decimalFormat.format(valueFirst) + "%");
                    binding.editText.setText(null);
                }
            }
        });

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unlimtedPower();
                calculations = addition;
                if (!Double.isNaN(valueFirst)) {
                    binding.textView.setText(decimalFormat.format(valueFirst) + "+");
                    binding.editText.setText(null);
                }
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unlimtedPower();
                calculations = subtraction;
                if (!Double.isNaN(valueFirst)) {
                    binding.textView.setText(decimalFormat.format(valueFirst) + "-");
                    binding.editText.setText(null);
                }
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unlimtedPower();
                calculations = division;
                if (!Double.isNaN(valueFirst)) {
                    binding.textView.setText(decimalFormat.format(valueFirst) + "/");
                    binding.editText.setText(null);
                }
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unlimtedPower();
                calculations = multiplication;
                if (!Double.isNaN(valueFirst)) {
                    binding.textView.setText(decimalFormat.format(valueFirst) + "*");
                    binding.editText.setText(null);
                }
            }
        });


        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unlimtedPower();
                if (!Double.isNaN(valueSecond)) {
                    try {
                        binding.textView.setText(binding.textView.getText().toString() + decimalFormat.format(valueSecond) + " = " + decimalFormat.format(valueFirst));
                        valueFirst = Double.NaN;
                        calculations = '0';
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The number you have entered is not a number.", Toast.LENGTH_LONG).show();
                        binding.editText.setText(null);
                        binding.textView.setText(null);
                    }
                }
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
                } else {
                    valueFirst = Double.NaN;
                    valueSecond = Double.NaN;
                    binding.editText.setText("");
                    binding.textView.setText("");
                }
            }
        });
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
        }
        else {
            try {
                valueFirst = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "The number you have entered is not a number.", Toast.LENGTH_LONG).show();
                binding.editText.setText(null);
            }
        }
    }
}


