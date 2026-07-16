package br.com.jv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jv.exception.UnsupportedMathOperationException;



@RestController
public class MathController {
    
    @GetMapping("/math/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
            
        }
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/math/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    
    @GetMapping("/math/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/math/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @GetMapping("/math/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(required = true) String numberOne, @PathVariable(required = true) String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/math/squareRoot/{number}")
    public Double squareRoot(@PathVariable(required = true) String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }

    private boolean isNumeric(String number) {
        try {
            number = number.replaceAll(",", ".");
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }catch (Exception e) {
            return false;
        }
    }

    private double convertToDouble(String number) {
        if (number == null) {
            return 0D;
        }
        number = number.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }
    
    
}
