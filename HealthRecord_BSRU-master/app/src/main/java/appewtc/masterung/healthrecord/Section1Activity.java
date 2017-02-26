package appewtc.masterung.healthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Section1Activity extends AppCompatActivity {

    //Explicit
    private Spinner ageSpinner;
    private RadioGroup sexRadioGroup, pressureRadioGroup, diabetesRadioGroup;
    private RadioButton sexMaleRadioButton, sexFemaleRadioButton,
            pressureNoHaveRadioButton, pressureHaveRadioButton,
            diabetesNoHaveRadioButton, diabetesHaveRadioButton;
    private EditText heightEditText, weightEditText, widthEditText;
    private String heightString, weightString, widthString;
    private int ageAnInt, sexAnInt = 0, pressureAnInt = 0, diabetesAnInt = 0;
    private Double heightADouble, weightADouble, widthADouble;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        //Bind Widget
        bindWidget();

        //Create Age Spinner
        createAgeSpinner();

        //Sex Choose
        sexChoose();

        //Pressure Choose
        pressureChoose();

        //Diabeted Choose
        diabetesChoose();

    }   // Main Method

    private void diabetesChoose() {
        diabetesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton5:
                        diabetesAnInt = 0;
                        break;
                    case R.id.radioButton6:
                        diabetesAnInt = 4;
                        break;
                }
            }
        });
    }

    private void pressureChoose() {

        pressureRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton3:
                        pressureAnInt = 0;
                        break;
                    case R.id.radioButton4:
                        pressureAnInt = 2;
                        break;
                }
            }
        });

    }   // pressureChoose

    private void sexChoose() {

        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        sexAnInt = 0;
                        break;
                    case R.id.radioButton2:
                        sexAnInt = 2;
                        break;
                }   // switch
            }   // event
        });

    }   // sexChoose

    public void clickSection11(View view) {

        heightString = heightEditText.getText().toString().trim();
        weightString = weightEditText.getText().toString().trim();
        widthString = widthEditText.getText().toString().trim();

        if (heightString.equals("") || weightString.equals("") || widthString.equals("")) {

            //Have Space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(Section1Activity.this, R.drawable.icon_question,
                    "มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");

        } else {

            //No Space
            heightADouble = Double.parseDouble(heightString);
            weightADouble = Double.parseDouble(weightString);
            widthADouble = Double.parseDouble(widthString);

            //Intent to Result
            myIntentToResult();

        }   // if

        String tag = "section11";
        Log.d(tag, "ageAnInt = " + ageAnInt);
        Log.d(tag, "sexAnInt = " + sexAnInt);
        Log.d(tag, "pressureAnInt = " + pressureAnInt);
        Log.d(tag, "diatebedAnInt = " + diabetesAnInt);
        Log.d(tag, "height = " + heightADouble);
        Log.d(tag, "weight = " + weightADouble);
        Log.d(tag, "width = " + widthADouble);

    }   // clickSection11

    private void myIntentToResult() {

        Intent objIntent = new Intent(Section1Activity.this, ResultOfSection11.class);
        objIntent.putExtra("Age", ageAnInt);
        objIntent.putExtra("Sex", sexAnInt);
        objIntent.putExtra("Pressure", pressureAnInt);
        objIntent.putExtra("Diatebed", diabetesAnInt);
        objIntent.putExtra("Height", heightADouble);
        objIntent.putExtra("Weight", weightADouble);
        objIntent.putExtra("Width", widthADouble);
        startActivity(objIntent);


    }   // myIntentToResult


    private void createAgeSpinner() {

        String[] choiceStrings = new String[3];

        choiceStrings[0] = "0 - 44 ปี";
        choiceStrings[1] = "45 - 49 ปี";
        choiceStrings[2] = "50 ปี ขึ้นไป";

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, choiceStrings);
        ageSpinner.setAdapter(ageAdapter);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                ageAnInt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ageAnInt = 0;
            }
        });

    }   // createAgeSpinner

    private void bindWidget() {

        ageSpinner = (Spinner) findViewById(R.id.spinner);
        sexRadioGroup = (RadioGroup) findViewById(R.id.ragSex);
        pressureRadioGroup = (RadioGroup) findViewById(R.id.ragPressure);
        diabetesRadioGroup = (RadioGroup) findViewById(R.id.ragDiabetes);
        sexMaleRadioButton = (RadioButton) findViewById(R.id.radioButton);
        sexFemaleRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        pressureNoHaveRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        pressureHaveRadioButton = (RadioButton) findViewById(R.id.radioButton4);
        diabetesNoHaveRadioButton = (RadioButton) findViewById(R.id.radioButton5);
        diabetesHaveRadioButton = (RadioButton) findViewById(R.id.radioButton6);
        heightEditText = (EditText) findViewById(R.id.editText);
        weightEditText = (EditText) findViewById(R.id.editText2);
        widthEditText = (EditText) findViewById(R.id.editText3);


    }   // bindWidget

}   // Main Class
