package jp.techacademy.keita.ishizawa.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //変更箇所 「=」を追加
                        if((hourOfDay >= 2) && (hourOfDay < 10)){
                            textView.setText("おはよう");
                            //変更箇所 「=」を追加
                        } else if((hourOfDay >= 10) && (hourOfDay < 18)){
                            textView.setText("こんにちは");
                        } else {
                            textView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
