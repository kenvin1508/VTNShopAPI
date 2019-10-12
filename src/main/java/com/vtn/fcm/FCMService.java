package com.vtn.fcm;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FCMService {
    public String pushNotification(FCMRequest fcmRequest) {
        MulticastMessage multicastMessage = MulticastMessage.builder()
                .putData("title", fcmRequest.getTitle())
                .putData("body", fcmRequest.getBody())
                .putData("image", fcmRequest.getImageURL())
                .addAllTokens(fcmRequest.getListToken())
                .build();

        BatchResponse response = null;
        try {
            response = FirebaseMessaging.getInstance().sendMulticast(multicastMessage);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
