package com.example.b.a14_boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    //http://itmir.tistory.com/424
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //안드로이드가 내부에서 인턴트를 만들어서 넘겨준다.
        //추가적인 정보를 인턴트에 넘겨주겠지?
        //throw new UnsupportedOperationException("Not yet implemented");//구현은 니가해라라는 뜻으로...
//        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
//            // 부팅완료
//        }
//        if (Intent.ACTION_SCREEN_ON == intent.getAction()) {
//            // 화면 켜짐
//        }
//        if (Intent.ACTION_SCREEN_OFF == intent.getAction()) {
//            // 화면 꺼짐
//        }
//        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
//            // sms 수신
//        }
        String str ="";

        //가끔은 두개이상이 한꺼번에 올때도 있어서..
        //배열로 받는다.
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        SmsMessage[] msgs = new SmsMessage[pdus.length];
        for(int i=0;i<msgs.length;i++)
        {
            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            str += "SMS form : "+msgs[i].getOriginatingAddress();
            str += "/"+msgs[i].getMessageBody();
        }

        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();


    }

}
