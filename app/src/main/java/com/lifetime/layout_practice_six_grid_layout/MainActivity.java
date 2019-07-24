package com.lifetime.layout_practice_six_grid_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        customTopBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        createSpinner1();
        createSpinner2();
        createSpinner3();
        createSpinner4();
        createSpinner5();
    }

    private void createSpinner5() {
        Spinner spinner = findViewById(R.id.spinner_five);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_five,R.layout.simple_spinner_item_spinner_5);
        adapter.setDropDownViewResource(R.layout.simple_dropdown_item_1line_spinner3);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void createSpinner4() {
        Spinner spinner = findViewById(R.id.spinner_four);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_four,R.layout.simple_spinner_item_spinner_4);
        adapter.setDropDownViewResource(R.layout.simple_dropdown_item_1line_spinner3);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private void createSpinner3() {
        Spinner spinner = findViewById(R.id.spinner_three);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_three,R.layout.simple_spinner_item_spinner_3);
        adapter.setDropDownViewResource(R.layout.simple_dropdown_item_1line_spinner3);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void createSpinner2() {
        Spinner spinner = findViewById(R.id.spinner_two);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_two,R.layout.simple_spinner_item_spinner_1_2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void createSpinner1() {
        Spinner spinner = findViewById(R.id.spinner_one);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers,R.layout.simple_spinner_item_spinner_1_2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void customTopBar() {
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on){
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if(on){
            winParams.flags |=bits;
        }else{
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
