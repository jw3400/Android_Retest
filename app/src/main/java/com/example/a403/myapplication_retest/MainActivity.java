package com.example.a403.myapplication_retest;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;
    Switch sw;
    LinearLayout Layout1;
    LinearLayout Layout2;
    Button bu1;
    Button bu2;
    Button bu3;
    Button bu4;
    EditText e1;
    EditText e2;
    EditText e3;
    TextView label1;
    TextView label2;
    TextView label3;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioButton r5;
    ImageView image;
    TimePicker ti;
    CalendarView ca;

    int year = 0;
    int month = 0;
    int day = 0;
    int hour = 0;
    int min = 0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        Layout1 = (LinearLayout) findViewById(R.id.layout1);
        Layout1.setVisibility(View.GONE);
        Layout2 = (LinearLayout) findViewById(R.id.layout2);
        Layout2.setVisibility(View.GONE);
        sw = (Switch) findViewById(R.id.switch1);
        label1 = (TextView) findViewById(R.id.textView6);
        label2 = (TextView) findViewById(R.id.textView8);
        label3 = (TextView) findViewById(R.id.textView10);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
        r5 = (RadioButton) findViewById(R.id.radioButton5);
        ch = (Chronometer) findViewById(R.id.chronometer);
        ti = (TimePicker) findViewById(R.id.timePicker);
        ca = (CalendarView) findViewById(R.id.calendarView);



        sw.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Layout1.setVisibility(View.VISIBLE);

                    flag = 1;
                    ch.setBase(SystemClock.elapsedRealtime());
                    ch.start();
                    ch.setTextColor(Color.BLUE);

                }

                else
                    Layout1.setVisibility(View.GONE);
            }
        });

                    image = (ImageView) findViewById(R.id.imageView);

                    image.setImageResource(R.drawable.a);
                    r1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (r1.isChecked() == true) {
                                image.setImageResource(R.drawable.a);
                            }
                        }
                    });

                    r2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (r2.isChecked() == true) {
                                image.setImageResource(R.drawable.b);
                            }
                        }
                    });

                    r3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (r3.isChecked() == true) {
                                image.setImageResource(R.drawable.c);
                            }
                        }
                    });

                    bu1 = (Button) findViewById(R.id.button);
                    bu1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String input1 = e1.getText().toString();
                            String input2 = e2.getText().toString();
                            String input3 = e3.getText().toString();

                            int result1;
                            double result2;
                            double result3;

                            if (input1.equals("") || input2.equals("") || input3.equals("")) {
                                Toast.makeText(getApplicationContext(), "인원을 입력하셔야 합니다.", Toast.LENGTH_SHORT).show();
                            } else if (Integer.parseInt(input1.toString()) < 0 || Integer.parseInt(input2.toString()) < 0 || Integer.parseInt(input3.toString()) < 0) {
                                Toast.makeText(getApplicationContext(), "양수를 입력하셔야 합니다.", Toast.LENGTH_SHORT).show();
                            } else {

                                result1 = Integer.parseInt(input1) + Integer.parseInt(input2) + Integer.parseInt(input3);
                                label1.setText(" " + result1);

                                if (r1.isChecked()) {
                                    result2 = (15000 * Double.parseDouble(input1)) + (12000 * Double.parseDouble(input2)) + (8000 * Double.parseDouble(input3));
                                    result3 = result2 * 0.05;
                                    label2.setText(" " + result2);
                                    label3.setText(" " + (result2 - result3));
                                } else if (r2.isChecked()) {
                                    result2 = (15000 * Double.parseDouble(input1)) + (12000 * Double.parseDouble(input2)) + (8000 * Double.parseDouble(input3));
                                    result3 = result2 * 0.1;
                                    label2.setText(" " + result2);
                                    label3.setText(" " + (result2 - result3));
                                } else if (r3.isChecked()) {
                                    result2 = (15000 * Double.parseDouble(input1)) + (12000 * Double.parseDouble(input2)) + (8000 * Double.parseDouble(input3));
                                    result3 = result2 * 0.2;
                                    label2.setText(" " + result2);
                                    label3.setText(" " + (result2 - result3));
                                }
                            }
                        }
                    });


                    bu2 = (Button) findViewById(R.id.button2);
                    bu2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Layout1.setVisibility(View.GONE);
                            Layout2.setVisibility(View.VISIBLE);
                        }
                    });


        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r4.isChecked() == true)
                {
                    ti.setVisibility(View.INVISIBLE);
                    ca.setVisibility(View.VISIBLE);
                }
            }
        });

        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r5.isChecked() == true)
                {
                    ca.setVisibility(View.INVISIBLE);
                    ti.setVisibility(View.VISIBLE);
                }
            }
        });


        ca.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int j, int k) {
                 year=i;
                 month=j;
                 day=k;
            }
        });

        ti.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int j) {
                hour=i;
                min=j;
            }
        });

        bu3 = (Button) findViewById(R.id.button3);
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag!=1)
                {
                    Toast.makeText(getApplicationContext(),"인원예약을 먼저 하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(year==0 || hour==0)
                {
                    Toast.makeText(getApplicationContext(),"날짜 혹은 시간을 체크 하셔야합니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                ch.stop();
                ch.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(),year+"."+month+"."+day+"."+" "+hour+":"+min+""+" 예약이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                flag=0;
            }
        });

        bu4 = (Button) findViewById(R.id.button4);
        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Layout1.setVisibility(View.VISIBLE);
                Layout2.setVisibility(View.GONE);
            }
        });













    }
}
