package com.cyt.todayinformation.main.shanghai.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseActivity;
import com.cyt.todayinformation.base.ViewInject;
import com.cyt.todayinformation.main.shanghai.module.ShanghaiDetailHttpTask;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {

    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";

    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnim();
        initGetNewData();
    }

    /**
     * 发送网络请求数据
     */
    private void initGetNewData() {
        Object desc = new ShanghaiDetailHttpTask().getXiaoHuaList("desc","1","1");
    }

    private void initAnim() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ViewCompat.setTransitionName(ivShanghaiDetail,mActivityOptionsCompat);

            // 开启转场动画
            startPostponedEnterTransition();
        }
    }

    /**
     * 用于Android 5.0系统过的界面转场动画：共享元素动画
     */
    public static void start(Activity activity, View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent intent = new Intent(activity,ShanghaiDetailActivity.class);
            Pair pair = new Pair(view,mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,pair);
            ActivityCompat.startActivity(activity,intent,optionsCompat.toBundle());
        }
    }
}
