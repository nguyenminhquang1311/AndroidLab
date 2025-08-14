package com.example.ex10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Lấy bundle chứa dữ liệu từ Intent
        Bundle extras = intent.getExtras();
        if (extras != null) {
            // Lấy mảng PDU từ extras
            Object[] smsExtra = (Object[]) extras.get("pdus");
            for (int i = 0; i < smsExtra.length; i++) {
                // Chuyển đổi PDU thành SmsMessage
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);
                String address = sms.getOriginatingAddress();
                String body = sms.getMessageBody();

                // Hiển thị nội dung tin nhắn
                String message = "Có 1 tin nhắn từ " + address + "\n" + body + " via gọi đến";
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}