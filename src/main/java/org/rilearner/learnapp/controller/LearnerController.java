package org.rilearner.learnapp.controller;

import org.rilearner.learnapp.controller.MyData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnerController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name =  "myName") String myName) {
        System.out.println(new MyData("Hello", "bye").printMyData(myName));
        return String.format("Hey Der %s! ", myName);
    }
}
record MyData(String start, String end) {
    String printMyData(String mid) {
        return start.concat(mid).concat(end);
    }
}
