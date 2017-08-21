package us.mifeng.rxjavaandandroidandeventbus.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import us.mifeng.rxjavaandandroidandeventbus.R;
import us.mifeng.rxjavaandandroidandeventbus.utils.HttpLoper;

public class MainActivity extends AppCompatActivity {

    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mBtn2 = (Button) findViewById(R.id.mBtn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpLoper.getIntence().getUrl();
                finish();
            }
        });
    }
}
