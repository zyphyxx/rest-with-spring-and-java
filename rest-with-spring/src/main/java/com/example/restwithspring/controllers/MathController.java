package com.example.restwithspring.controllers;

import com.example.restwithspring.converter.Converter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Plese set a numeric value");
        }
        return Converter.convertToDouble(numberOne) + Converter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if (!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Plese set a numeric value");
        } else {
            return Converter.convertToDouble(numberOne) - Converter.convertToDouble(numberTwo);
        }
    }


}
