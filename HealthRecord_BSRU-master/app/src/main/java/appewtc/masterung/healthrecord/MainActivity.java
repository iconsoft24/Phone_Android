package appewtc.masterung.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView section1ImageView, section2ImageView,
            section3ImageView, section4ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Image Controller
        imageController();

    }   // Main Method

    private void imageController() {
        section1ImageView.setOnClickListener(this);
        section2ImageView.setOnClickListener(this);
        section3ImageView.setOnClickListener(this);
        section4ImageView.setOnClickListener(this);
    }

    private void bindWidget() {
        section1ImageView = (ImageView) findViewById(R.id.imageView);
        section2ImageView = (ImageView) findViewById(R.id.imageView2);
        section3ImageView = (ImageView) findViewById(R.id.imageView3);
        section4ImageView = (ImageView) findViewById(R.id.imageView4);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView:
                startActivity(new Intent(MainActivity.this, MainHoldSection1.class));
                break;
            case R.id.imageView2:
                break;
            case R.id.imageView3:
                break;
            case R.id.imageView4:
                break;
        }   // switch

    }   // onClick

}   // Main Class
