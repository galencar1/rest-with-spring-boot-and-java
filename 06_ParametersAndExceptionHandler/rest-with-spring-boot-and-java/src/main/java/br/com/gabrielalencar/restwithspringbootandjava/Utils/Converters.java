package br.com.gabrielalencar.restwithspringbootandjava.Utils;

public class Converters {
    public static Double convertToDouble(String strNumber) {
        //Verifica se número é nulo
        if (strNumber == null) return 0D;
        //Faz a conversão da moeda. BRL 10,25   US 10.25
        String number = strNumber.replaceAll(",", ".");
        //Verifica se valor recebido é numerico e converte pra double
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll("," , ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
