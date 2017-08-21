package us.mifeng.rxjavaandandroidandeventbus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import us.mifeng.rxjavaandandroidandeventbus.R;
import us.mifeng.rxjavaandandroidandeventbus.utils.FirstEvent;

/**
 * Created by shido on 2017/8/21.
 */

public class AActivity extends Activity {

    private Button mBtn1;
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aactivity);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {

        mTv = (TextView) findViewById(R.id.mTv);
        mBtn1 = (Button) findViewById(R.id.mBtn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AActivity.this, MainActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEvent(FirstEvent event) {
        String msg = event.getMsg();
        mTv.setText(msg);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}
