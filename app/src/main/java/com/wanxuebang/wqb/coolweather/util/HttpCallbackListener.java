package com.wanxuebang.wqb.coolweather.util;

/**
 * Created by wanxuebang-ai-03 on 2018/1/9.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
