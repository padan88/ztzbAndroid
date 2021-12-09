package com.zsl.mylibrary.natsUtils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Message;
import io.nats.client.MessageHandler;
import io.nats.client.Nats;
import io.nats.client.Options;

/**
 * @Description:Mq 消息服务
 * @PackgeName: com.ztzb.zsllibrary.natsUtils
 * @ClassName: NatsManager
 * @Author: Zsl
 * @Date: 2021/8/20 15:05
 * @Version: V 1.0
 */
public class NatsManager {
    public static String start = "mob.start";
    public static String end = "mob.end";
    public static String request = "mob.request";
    private static Connection nc;
    private Boolean connect = false;
    private Context context;
    private String natsUrl = "nats://demo.nats.io:4222";  // 官网测试地址

    public NatsManager(Context content,String natsUrl) {
        this.context = content;
        connect(natsUrl);
    }

    private void connect(String natsUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Options options = new Options.Builder()
                        .server(natsUrl) // AppSettings.Base_Nats_Host
                        .build();
                try {
                    nc = Nats.connect(options);
                    connect = true;
                    mIDataCollector.setConnect(connect);
                    Dispatcher d = nc.createDispatcher(new MessageHandler() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onMessage(Message msg) throws InterruptedException {
                            if (!TextUtils.isEmpty(msg.getReplyTo())){
                                mIDataCollector.setAnswer(msg);
                            }else {
                                String response = new String(msg.getData(), StandardCharsets.UTF_8);
                                mIDataCollector.setResponse(response);
                            }
                        }
                    });
                    d.subscribe(start);
                    d.subscribe(end);
                    d.subscribe(request);
                } catch (Exception e) {
                    e.printStackTrace();
                    connect = false;
                    mIDataCollector.setConnect(connect);
                }
            }
        }).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void pub(String topic, String msg) {
        nc.publish(topic, msg.getBytes(StandardCharsets.UTF_8));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void request(String topic, String msg) {
        try {
            Message responseMsg = nc.request(topic, msg.getBytes(StandardCharsets.UTF_8), Duration.ofSeconds(2));
            if (responseMsg == null){
                mIDataCollector.getResponse("2");
            }else {
                mIDataCollector.getResponse(new String(responseMsg.getData(), StandardCharsets.UTF_8));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void close() {
        try {
            if (nc != null){
                nc.close();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface IDataCollector {
        //判断MQ是否连接
        void setConnect(boolean connect);
        //接收接收
        void setResponse(String response);
        //接收询问反馈信息
        void getResponse(String response);
        //询问信息
        void setAnswer(Message msg);
    }

    private static IDataCollector mIDataCollector;

    //对外设置item点击暴露的方法
    public void OnConnectlikListener(IDataCollector mIDataCollector) {
        this.mIDataCollector = mIDataCollector;
    }
}
