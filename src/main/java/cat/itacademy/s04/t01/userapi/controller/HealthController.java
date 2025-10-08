package cat.itacademy.s04.t01.userapi.controller;

import org.springframework.web.bind.annotation.*;

 @RestController
public class HealthController {
     @GetMapping("/health")
     public String getHealth(){
         return "OK";
     }
}
