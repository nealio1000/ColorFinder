package com.example.neal.colorfinder;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class ColorFinder extends AppCompatActivity {
    private int red;
    private int green;
    private int blue;
    private Button submit_button;
    private SurfaceView ColorWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_finder);

        // Initialize UI Objects and attach to their xml id
        NumberPicker redNumberPicker = (NumberPicker) findViewById(R.id.RedNumPicker);
        NumberPicker greenNumberPicker = (NumberPicker) findViewById(R.id.GreenNumPicker);
        NumberPicker blueNumberPicker = (NumberPicker) findViewById(R.id.BlueNumPicker);
        ColorWindow = (SurfaceView) findViewById(R.id.ColorWindow);
        submit_button = (Button) findViewById(R.id.submit);

        // Set max/min values for NumberPickers
        redNumberPicker.setMaxValue(255);
        greenNumberPicker.setMaxValue(255);
        blueNumberPicker.setMaxValue(255);
        redNumberPicker.setMinValue(0);
        greenNumberPicker.setMinValue(0);
        blueNumberPicker.setMinValue(0);

        // Misc. NumberPicker Attributes
        redNumberPicker.setWrapSelectorWheel(true);
        greenNumberPicker.setWrapSelectorWheel(true);
        blueNumberPicker.setWrapSelectorWheel(true);
        redNumberPicker.setValue(red);
        greenNumberPicker.setValue(green);
        blueNumberPicker.setValue(blue);

        // Attach onValueChange Callbacks to NumberPickers
        redNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker picker, int oldValue, int newValue) {
                red = newValue;
                ColorWindow.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
        greenNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker picker, int oldValue, int newValue) {
                green = newValue;
                ColorWindow.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
        blueNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker picker, int oldValue, int newValue) {
                blue = newValue;
                ColorWindow.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
        submit_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view){
                Intent intent = getIntent();
                Bundle data = new Bundle();
                data.putInt("red", red);
                data.putInt("green", green);
                data.putInt("blue", blue);
                intent.putExtras(data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
