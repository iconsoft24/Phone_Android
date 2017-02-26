package apppnc.udommeng.grade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowService extends AppCompatActivity {


    //ประกาศตัวแปร
    private TextView nameTextView,idTeacherTextView, positionTextView;
    private ImageView teacherImageView,hub1ImageView,hub2ImageView,hub3ImageView;
    private String[] myResultStrings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service);

        bindwidget();

        //รับค่าที่ส่งมาจากหน้าแรก
        myResultStrings = getIntent().getStringArrayExtra("Result");

        //show view
        showView();

        //check status
        checkStatus();

    }//main method

    private void checkStatus() {
        int intStatus = Integer.parseInt(myResultStrings[6]);
        if (intStatus == 1) {
            hub3ImageView.setVisibility(View.INVISIBLE);
            
        }


    } //checl status

    private void showView() {
        //show textview
        nameTextView.setText(myResultStrings[3]);
        idTeacherTextView.setText("รหัสครู  " + myResultStrings[4]);
        positionTextView.setText("ตำแหน่ง" +findPosition(myResultStrings[6]));


        //show image
        Picasso.with(this)
                .load(myResultStrings[5])
                .resize(150, 150).into(teacherImageView);

    }

    private String findPosition(String myResultString) {

        String strPositon = null;

        int intResult = Integer.parseInt(myResultString);
        switch (intResult) {
            case 0:
                strPositon = "ครูที่ปรึกษา";
            case 1 :
                strPositon="ครูผู้สอน";
            default:
                strPositon = "ไม่มี";
                break;
        }

        return strPositon;
    }

    private void bindwidget() {
        nameTextView = (TextView) findViewById(R.id.textView2);
        idTeacherTextView = (TextView) findViewById(R.id.textView3);
        positionTextView = (TextView) findViewById(R.id.textView4);
        teacherImageView = (ImageView) findViewById(R.id.imageView2);
        hub1ImageView = (ImageView) findViewById(R.id.imageView3);
        hub2ImageView = (ImageView) findViewById(R.id.imageView4);
        hub3ImageView = (ImageView) findViewById(R.id.imageView5);
    }



}   //main class
