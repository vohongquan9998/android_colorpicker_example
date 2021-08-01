package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    int mDefaultColor;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    private void addControl() {
        layout = this.<LinearLayout>findViewById(R.id.layout_main);
        mDefaultColor = ContextCompat.getColor(MainActivity.this,R.color.design_default_color_primary);
        btnChange = this.<Button>findViewById(R.id.btnChange);


    }

    private void openColorPicker() {
        AmbilWarnaDialog warnaDialog = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                layout.setBackgroundColor(mDefaultColor);
            }
        });
        warnaDialog.show();
    }
}