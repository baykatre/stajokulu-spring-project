package com.stajokulu.pick_down;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pick-down")
public class PickDownController {

    private final PickDownService pickDownService;

    @PostMapping
    public PickDownModel pickDown(PickDownModel pickDownModel){

        return pickDownService.pickDown(pickDownModel);
    }


    //Loglama - Çalışma
    //Exception Handling
    //Validation
}
