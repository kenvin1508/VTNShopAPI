package com.vtn;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VtnShopUtil {
    public static String formatDate(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
		
        try {
            return myFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getBaseUrl() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest req = ((ServletRequestAttributes) requestAttributes).getRequest();
            return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
            // build URL from request
        } else {
            // fallback logic if request won't work...
            return "Nothing";
        }
    }
}
