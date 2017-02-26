package appewtc.masterung.healthrecord;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ResultOfSection11 extends AppCompatActivity {

    //Explicit
    private int ageAnInt, sexAnInt, presureAnInt, diatebedAnInt,
            indexMassAnInt, widthAnInt, sumaryAnInt;

    private Double heightADouble, weightADouble,
            widthADouble, indexMassADouble;

    private TextView riskTextView, introTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_section11);

        //Bind Widget
        bindWidget();

        //Receive Value Intent
        receiveValueFromIntent();

        indexMassAnInt = findIndexMass();

        widthAnInt = findIndexWidth();

        sumaryAnInt = sumaryHealth();



        //Show Log
        showLog();

    }   // Main Method

    private void bindWidget() {
        riskTextView = (TextView) findViewById(R.id.txtShowRisk);
        introTextView = (TextView) findViewById(R.id.txtShowIntro);
    }

    private int sumaryHealth() {

        int intSumary = 0;

        intSumary = ageAnInt + sexAnInt + indexMassAnInt + widthAnInt + presureAnInt + diatebedAnInt;

        return intSumary;
    }

    private int findIndexWidth() {

        int intIndex = 0;

        if (sexAnInt == 0) {

            //Male
            if (widthADouble < 90.0) {
                intIndex = 0;
            } else {
                intIndex = 2;
            }


        } else {

            //Female
            if (widthADouble <80.0) {
                intIndex = 0;
            } else {
                intIndex = 2;
            }

        }   // if


        return intIndex;
    }

    private void showLog() {

        String tag = "Result";
        Log.d(tag, "indexDouble = " + indexMassADouble);
        Log.d(tag, "indexAnInt = " + indexMassAnInt);
        Log.d(tag, "indexWidth = " + widthAnInt);
        Log.d(tag, "indexHealth = " + sumaryAnInt);


    }   // showLog

    private int findIndexMass() {

        int intIndex = 0;

        indexMassADouble = weightADouble / Math.pow(heightADouble, 2);

        if (indexMassADouble < 23.0) {
            intIndex = 0;
        } else if (indexMassADouble < 27.5) {
            intIndex = 3;
        } else {
            intIndex = 5;
        }

        return intIndex;
    }

    private void receiveValueFromIntent() {

        ageAnInt = getIntent().getIntExtra("Age", 0);
        sexAnInt = getIntent().getIntExtra("Sex", 0);
        presureAnInt = getIntent().getIntExtra("Pressure", 0);
        diatebedAnInt = getIntent().getIntExtra("Diatebed", 0);
        heightADouble = getIntent().getDoubleExtra("Height", 0);
        weightADouble = getIntent().getDoubleExtra("Weight", 0);
        widthADouble = getIntent().getDoubleExtra("Width", 0);

    }   // receiveValueFromIntent

}   // Main Class
