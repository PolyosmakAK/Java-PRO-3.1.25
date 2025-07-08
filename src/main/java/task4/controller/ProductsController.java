package task4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
    @GetMapping(value = "/")
    public String example() {
        return "Hello";
    }

}
