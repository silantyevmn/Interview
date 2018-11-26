package silantyevmn.ru.developerinterview.Lesson1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import silantyevmn.ru.developerinterview.R;

public class ConvertActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText sourceText;
    private EditText destText;
    private Button buttonToConvert;
    private RadioButton radioConvertCelsiusToFahrenheit;
    private RadioButton radioConvertFahrenheitToCelsius;
    private RadioButton radioConvertKilometrsToMile;
    private RadioButton radioConvertMileToKilometrs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        init();
    }

    private void init() {
        sourceText = findViewById(R.id.inputValue);
        destText = findViewById(R.id.outputValue);
        buttonToConvert = findViewById(R.id.buttonToConvert);
        radioConvertCelsiusToFahrenheit = findViewById(R.id.radio_convert_celsius_to_fahrenheit);
        radioConvertFahrenheitToCelsius = findViewById(R.id.radio_convert_fahrenheit_to_celsius);
        radioConvertKilometrsToMile = findViewById(R.id.radio_convert_kilometrs_to_mile);
        radioConvertMileToKilometrs = findViewById(R.id.radio_convert_mile_to_kilomenrs);

        radioConvertCelsiusToFahrenheit.setOnClickListener(this);
        radioConvertFahrenheitToCelsius.setOnClickListener(this);
        radioConvertKilometrsToMile.setOnClickListener(this);
        radioConvertMileToKilometrs.setOnClickListener(this);

        buttonToConvert.setOnClickListener(view -> {
            if (radioConvertCelsiusToFahrenheit.isChecked()) {
                convertTo(new ConvertToFahrenheit());
            } else if (radioConvertFahrenheitToCelsius.isChecked()) {
                convertTo(new ConvertToCelsius());
            } else if (radioConvertKilometrsToMile.isChecked()) {
                convertTo(new ConvertToMile());
            } else if (radioConvertMileToKilometrs.isChecked()) {
                convertTo(new ConvertToKilometers());
            }
        });
    }

    private void convertTo(ConvertTo convertTo) {
        float sourceValue = Float.parseFloat(sourceText.getText().toString());
        Converter converter = new Converter(sourceValue);
        float destValue = converter.Convert(convertTo).getResult();
        destText.setText(String.format("%.02f", destValue));
    }

    @Override
    public void onClick(View view) {
        destText.setText("");
    }
}
