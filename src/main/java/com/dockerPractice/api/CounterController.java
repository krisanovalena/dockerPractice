package com.dockerPractice.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class CounterController {

    Integer counter = 0;

    @GetMapping("/about")
    public String getInfo(Model model) throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostName();
        model.addAttribute("name", host);
        return "hello";
    }

    @GetMapping
    public String getCounter(Model model) {
        model.addAttribute("counter", counter);
        return "counter";
    }

    @GetMapping("/stat")
    public String incrementAndGetCounter(Model model) {
        counter++;
        model.addAttribute("counter", counter);
        return "counter";
    }
}
