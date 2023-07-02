package com.example.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/doctor")
    public String doctorAPI() {
        return "Hello doctor!";
    }

    @GetMapping("/deo")
    public String deoAPI() {
        return "Hello deo";
    }

    @GetMapping("/ceo")
    public String ceoAPI() {
        return "Hello CEO";
    }

    @GetMapping("/schedule/appointments")
    public String scheduleAppointment() {
        return "Hi! Your appointment is scheduled";
    }
}
