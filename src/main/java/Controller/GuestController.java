package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

    @GetMapping(path = "/guest")
    public String home() {
        return "Hello Guest";
    }
}