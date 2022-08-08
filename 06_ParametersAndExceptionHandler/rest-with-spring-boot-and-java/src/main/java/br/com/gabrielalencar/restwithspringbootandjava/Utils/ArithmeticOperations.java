package br.com.gabrielalencar.restwithspringbootandjava.Utils;

public class ArithmeticOperations {
    public Double sum (Double numberOne, Double numberTwo){

        return numberOne + numberTwo;
    }

    public Double subtraction (Double numberOne, Double numberTwo){

        return numberOne - numberTwo;
    }

    public Double multiplication (Double numberOne, Double numberTwo){

        return numberOne * numberTwo;
    }

    public Double division (Double numberOne, Double numberTwo){

        return numberOne / numberTwo;
    }

    public Double sqrt (Double numberOne){

        return Math.sqrt(numberOne);
    }

    public Double media (Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }
}
