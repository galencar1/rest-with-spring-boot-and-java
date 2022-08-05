package br.com.gabrielalencar.restwithspringbootandjava.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum( @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        //Verifica se número é nulo
        if (strNumber == null) return 0D;
        //Faz a conversão da moeda. BRL 10,25   US 10.25
        String number = strNumber.replaceAll(",", ".");
        //Verifica se valor recebido é numerico e converte pra double
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll("," , ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
