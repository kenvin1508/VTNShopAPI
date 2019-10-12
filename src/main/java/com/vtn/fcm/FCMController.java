package com.vtn.fcm;

import com.vtn.VtnShopUtil;
import com.vtn.service.FCMServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fcm")
public class FCMController {
    @Autowired
    private FCMService fcmService;
    @Autowired
    private FCMServices fcmServices;

    @PostMapping("/sendAllNotify")
    public String sendSampleNotification(@RequestBody FCMRequest fcmRequest) {
        fcmRequest.setImageURL(VtnShopUtil.getBaseUrl() + fcmRequest.getImageURL());
        System.out.println(fcmRequest.getImageURL());
        fcmRequest.setListToken(fcmServices.getListToken());
        return fcmService.pushNotification(fcmRequest);
    }

    @PostMapping("/sendOrderNotify")
    public String sendOrderStatusNotify(@RequestBody FCMRequest fcmRequest) {
        if (fcmServices.getListTokenWithCustomerId(fcmRequest.getCustomerId()).size() > 0) {
            fcmRequest.setImageURL(VtnShopUtil.getBaseUrl() + fcmRequest.getImageURL());
            fcmRequest.setListToken(fcmServices.getListTokenWithCustomerId(fcmRequest.getCustomerId()));
            return fcmService.pushNotification(fcmRequest);
        }
        return "";
    }

    @GetMapping("/insert")
    public void insert(@RequestParam String deviceId, @RequestParam String token) {
        fcmServices.insert(deviceId, token);
    }

}
