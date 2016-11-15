package edu.jsu.mcis.gamegogy;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String[] greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new String[] {new Student("111111","Jerrod","Shields","jshields").getID()};
    }
}