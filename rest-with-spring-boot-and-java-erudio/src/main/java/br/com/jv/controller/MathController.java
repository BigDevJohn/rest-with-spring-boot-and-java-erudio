package br.com.jv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jv.service.MathService;



@RestController
public class MathController {

    @Autowired
    MathService mathService;

    @GetMapping("/math/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo)
            throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @GetMapping("/math/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable(required = true) String numberOne,
            @PathVariable(required = true) String numberTwo) {
        return mathService.subtraction(numberOne, numberTwo);
    }

    @GetMapping("/math/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(required = true) String numberOne,
            @PathVariable(required = true) String numberTwo) {
        return mathService.multiplication(numberOne, numberTwo);
    }

    @GetMapping("/math/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(required = true) String numberOne,
            @PathVariable(required = true) String numberTwo) {
        return mathService.division(numberOne, numberTwo);
    }

    @GetMapping("/math/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(required = true) String numberOne,
            @PathVariable(required = true) String numberTwo) {
        return mathService.mean(numberOne, numberTwo);
    }

    @GetMapping("/math/squareRoot/{number}")
    public Double squareRoot(@PathVariable(required = true) String number) {
        return mathService.squareRoot(number);
    }

    

}
