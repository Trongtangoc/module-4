package com.codegym.currenttimegradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
@RequestMapping("/home")
public class CurrentTimeGradleController {

    @RequestMapping("/show-home-page")
    public String showHomePage(){
        return "home";
    }

    @RequestMapping("/current-time")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);

        // Tính thời gian hiện tại của một thành phố cụ thể
        long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(localeTime);
        // Chuyển dữ liệu va gửi qua view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "current-time";
    }
}
