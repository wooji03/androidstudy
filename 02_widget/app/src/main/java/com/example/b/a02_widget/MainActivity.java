package com.example.b.a02_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText myEdit = (EditText)findViewById(R.id.myEdit);
        Button btnHello = (Button) findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = myEdit.getText().toString();
                Log.d("Widget","Button Click+"+str);
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.myCheckBox1);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "Widget checkBox1: Checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Widget checkBox1: UnChecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.myCheckBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "Widget checkBox2: Checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Widget checkBox2: UnChecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {

                }else{

                }
            }
        });*/
        RadioGroup myRadioGroup = (RadioGroup) findViewById(R.id.myRadioG);
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.myRadio1:
                        Toast.makeText(MainActivity.this, "Radio1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio2:
                        Toast.makeText(MainActivity.this, "Radio3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio3:
                        Toast.makeText(MainActivity.this, "Radio3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_name,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_test1)
        {
            Toast.makeText(MainActivity.this, "menu 1 selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.menu_test2)
        {
            Toast.makeText(MainActivity.this, "menu 2 selected", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.menu_test3)
        {
            Toast.makeText(MainActivity.this, "menu 3 selected", Toast.LENGTH_SHORT).show();
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

}
