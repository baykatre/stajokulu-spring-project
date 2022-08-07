package com.stajokulu.pick_down;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pick-down")
public class PickDownController {

    private final PickDownService pickDownService;

    @PostMapping
    public ResponseEntity<PickDownModel> pickDown(@RequestBody PickDownModel pickDownModel){

        return ResponseEntity.ok(pickDownService.pickDown(pickDownModel));
    }


    //Loglama - Çalışma
    //Exception Handling
    //Validation
}
