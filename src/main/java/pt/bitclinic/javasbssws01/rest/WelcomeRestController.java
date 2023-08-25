package pt.bitclinic.javasbssws01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeRestController {

   @GetMapping
   public String getWelcomeMessage() {
       return "Welcome to my API!";
   }
}