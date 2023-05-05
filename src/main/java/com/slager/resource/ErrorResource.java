package com.slager.resource;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ErrorResource {

    @GetMapping("error")
    @ResponseBody
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("(╬▔皿▔)╯ Error!");
    }
}
