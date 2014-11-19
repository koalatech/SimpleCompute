package com.koalatech.simplecompute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.koalatech.simplecompute.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ClickBtn = (Button) findViewById(R.id.Compute_Btn);
        Button ClearBtn = (Button) findViewById(R.id.Clear_Btn);

        final RadioGroup RGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
            final RadioButton RBtn_add = (RadioButton) findViewById(R.id.AddOper);
            final RadioButton RBtn_sub = (RadioButton) findViewById(R.id.SubOper);
            final RadioButton RBtn_mul = (RadioButton) findViewById(R.id.MulOper);
            final RadioButton RBtn_div = (RadioButton) findViewById(R.id.DivOper);

        final EditText InputTextBox1 = (EditText) findViewById(R.id.TextBox1);
        final EditText InputTextBox2 = (EditText) findViewById(R.id.TextBox2);
        final EditText InputTextBox_Result = (EditText) findViewById(R.id.TextBox_Result);

        InputTextBox_Result.setEnabled(false); //make the Result TextBox not editable


        //compute for contents
        ClickBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                int SelectedButtonId = RGroup.getCheckedRadioButtonId();
                try{

                   if(SelectedButtonId == RBtn_add.getId()) {
                        int x = Integer.parseInt(InputTextBox1.getText().toString());
                        int y = Integer.parseInt(InputTextBox2.getText().toString());
                        int result = x + y;
                        InputTextBox_Result.setText(Integer.toString(result));
                   }

                   else if(SelectedButtonId == RBtn_sub.getId()) {
                        int x = Integer.parseInt(InputTextBox1.getText().toString());
                        int y = Integer.parseInt(InputTextBox2.getText().toString());
                        int result = x - y;
                        InputTextBox_Result.setText(Integer.toString(result));
                    }
                   else if(SelectedButtonId == RBtn_mul.getId()) {
                        int x = Integer.parseInt(InputTextBox1.getText().toString());
                        int y = Integer.parseInt(InputTextBox2.getText().toString());
                        int result = x * y;
                        InputTextBox_Result.setText(Integer.toString(result));
                    }
                   else if(SelectedButtonId == RBtn_div.getId()) {
                        int x = Integer.parseInt(InputTextBox1.getText().toString());
                        int y = Integer.parseInt(InputTextBox2.getText().toString());
                        int result = x / y;
                        InputTextBox_Result.setText(Integer.toString(result));
                    }
                   else {
                       Toast.makeText(getApplicationContext(), "Please select an operation...",
                                                             Toast.LENGTH_SHORT).show();

                   }


                }catch(NumberFormatException ex){
                    Toast.makeText(getApplicationContext(), "Invalid values!",
                            Toast.LENGTH_SHORT).show();

                    InputTextBox1.setText("");
                    InputTextBox2.setText("");
                }
            }
        });


        //clear the contents
        ClearBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                InputTextBox1.setText("");
                InputTextBox2.setText("");
                InputTextBox_Result.setText("");
                RGroup.clearCheck();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.about_menu) {
            Intent intent = new Intent(this, About_Page.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
