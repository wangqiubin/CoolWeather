package com.wanxuebang.wqb.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.wanxuebang.wqb.coolweather.service.AutoUpdateService;

/**
 * Created by wanxuebang-ai-03 on 2018/1/9.
 */

public class AutoUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startActivity(i);
    }
}
