package com.example.vovabirthday;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnToBirthday, btnOld;
    TextView textView;
    LocalDate birthDate, currantDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnDate = findViewById(R.id.btnDate);
        btnOld = findViewById(R.id.btnOld);
        btnToBirthday = findViewById(R.id.btnToBirthday);
        textView = findViewById(R.id.textView);

        btnDate.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> {
                        birthDate = LocalDate.of(year, month+1, dayOfMonth);
                    },   2005, 6, 15);
            dialog.show();
        });

        btnOld.setOnClickListener(v -> howOld());
    }

    private void howOld() {
        if (birthDate == null)
            return;
        currantDate = LocalDate.now();
        textView.setText("Рік народження: " + birthDate.getYear() +  "\n" +
                         " місяць народження: " + birthDate.getMonth() + "\n" +
                        "день народження: " + birthDate.getDayOfMonth() +  "\n");
        textView.append("Поточний рік: " + currantDate.getYear() +  "\n" +
                " зараз місяць: " + currantDate.getMonth() + "\n" +
                " сьогодні день: " + currantDate.getDayOfMonth());
    }
}