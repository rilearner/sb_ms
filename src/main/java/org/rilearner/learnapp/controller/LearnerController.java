package org.rilearner.learnapp.controller;

import lombok.AllArgsConstructor;
import org.rilearner.learnapp.controller.MyData;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class LearnerController {

    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name =  "myName") String myName) {
        System.out.println(new MyData("Hello", "bye").printMyData(myName));
        return String.format("Hey Der %s! ", myName);
    }

    @GetMapping("/helloEureka")
    public String helloEureka() {
        discoveryClient.getServices().stream().forEach(System.out::println);
        //discoveryClient.getInstances("learnapp").get(0).getMetadata();
        return discoveryClient.description();

    }

    @PostMapping("/saveBook")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MyBook book) {
        new BookUtil().save(book);
    }
}
record MyData(String start, String end) {
    String printMyData(String mid) {
        return start.concat(mid).concat(end);
    }
}
record MyBook(String booknm, String author, LocalDate publishedOn) {
}
class BookUtil{
    void save(MyBook mybook) {
        System.out.println("Saved Book" + mybook.toString());

    }
}
