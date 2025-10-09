package cat.itacademy.s04.t01.userapi.controller;

import cat.itacademy.s04.t01.userapi.HealthStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
    @GetMapping("/health")
    public HealthStatus getHealth() {
        return new HealthStatus("OK");
    }
}
