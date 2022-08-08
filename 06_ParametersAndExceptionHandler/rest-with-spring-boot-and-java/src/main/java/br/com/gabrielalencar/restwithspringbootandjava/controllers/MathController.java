package br.com.gabrielalencar.restwithspringbootandjava.controllers;

import br.com.gabrielalencar.restwithspringbootandjava.Utils.ArithmeticOperations;
import br.com.gabrielalencar.restwithspringbootandjava.Utils.Converters;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    private ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
/***********************************************************************************************************/
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum( @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!Converters.isNumeric(numberOne) || !Converters.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.sum( Converters.convertToDouble(numberOne),
                Converters.convertToDouble(numberTwo) );
    }
/***********************************************************************************************************/
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction( @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!Converters.isNumeric(numberOne) || (!Converters.isNumeric(numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.subtraction(Converters.convertToDouble(numberOne),
                Converters.convertToDouble(numberTwo));
    }
/***********************************************************************************************************/

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication( @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!Converters.isNumeric(numberOne) || (!Converters.isNumeric(numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.multiplication(Converters.convertToDouble(numberOne),
                Converters.convertToDouble(numberTwo));
    }
/**********************************************************************************************************/
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division( @PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!Converters.isNumeric(numberOne) || (!Converters.isNumeric(numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.division(Converters.convertToDouble(numberOne),
                Converters.convertToDouble(numberTwo));
    }
/*********************************************************************************************************/
    @RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
    public Double sqrt( @PathVariable(value = "numberOne") String numberOne
                       ) throws Exception {
        if (!Converters.isNumeric(numberOne)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.sqrt(Converters.convertToDouble(numberOne));
    }
/**********************************************************************************************************/
    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media( @PathVariable(value = "numberOne") String numberOne,
                               @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!Converters.isNumeric(numberOne) || (!Converters.isNumeric(numberTwo))) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return arithmeticOperations.media(Converters.convertToDouble(numberOne),
                Converters.convertToDouble(numberTwo));
    }
}
