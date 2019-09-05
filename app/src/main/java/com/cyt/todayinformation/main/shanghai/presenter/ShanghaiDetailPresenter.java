package com.cyt.todayinformation.main.shanghai.presenter;

import com.cyt.http.result.IResult;
import com.cyt.todayinformation.base.BasePresenter;
import com.cyt.todayinformation.base.JHTask;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiDetailBean;
import com.cyt.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.cyt.todayinformation.main.shanghai.module.ShangHaiDetailHttpServer;


public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContract.Iview> implements IShanghaiDetailContract.IPresenter{

    public ShanghaiDetailPresenter(IShanghaiDetailContract.Iview view) {
        super(view);
    }

    @Override
    protected IShanghaiDetailContract.Iview getEmptyView() {
        return IShanghaiDetailContract.emptyView;
    }

    @Override
    public void getNetData() {

//        //1、数据的结果解析怎么来做
//        //2、相同任务的去重工作
//        submitTask(new LfTask() {
//            //一定要回调到主线程
//            @Override
//            public void onComplete(Object o) {
//                //获取网络结果
//                Log.e("getNetData", o.toString());
//
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                Log.e("getNetData",throwable.toString());
//            }
//
//            //运行与子线程
//            @Override
//            public Object onBackground() {
//                IResult desc = new ShangHaiDetailHttpServer().getXiaoHuaList("desc", "1", "1");
//
//                return desc;
//            }
//        });

        submitTask(new JHTask<ShanghaiDetailBean>() {
            @Override
            public IResult<ShanghaiDetailBean> onBackground() {
                return new ShangHaiDetailHttpServer<ShanghaiDetailBean>().getXiaoHuaList("desc", "1", "1");
            }

            @Override
            public void onSuccess(IResult<ShanghaiDetailBean> t) {
                ShanghaiDetailBean data = t.data();
//                Gson gson = new Gson();
//                String s = gson.toJson(data);
//                Log.e("ShanghaiDetailBean",s);

            }
        });
    }

}

