import java.util.Scanner;

public class TraductorLatinToMorse
{
    //Arreglos globales donde se contiene el equivalente en cada alfabeto
    static String[] latinAlphabet;
    static String[] morseAlphabet;

    public static void main(String[] args) {
        String[] Input;
        String entradaEnMorse;
        String entradaLatin;

        //se cargan los alfabetos soportados a la memoria
        iniciailzarLenguajes();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Traductor de español a código morse.");
        System.out.print("Introduzca la frase a convertir: ");
        //recibiendo la entrada del usuario a un Array
        entradaLatin = keyboard.nextLine().toLowerCase();
        System.out.println("Intentando convertir '" + entradaLatin + "' a morse.");
        Input = separarEnLetras(entradaLatin);

        System.out.println("Resultado:");
        entradaEnMorse = convertirAMorse(Input);
        System.out.println(entradaEnMorse);
    }

    /**
     * Carga los lenguajes en memoria
     */
    private static void iniciailzarLenguajes(){
        latinAlphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"};

        morseAlphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};
    }

    /**
     * Separa una cadena en un arreglo de cadenas caracter por caracter
     *
     * @param entradaASeparar
     * @return
     */
    private static String[] separarEnLetras(String entradaASeparar) {
        String[] entradaSeparada = new String[entradaASeparar.length()];
        for (int i = 0; i < entradaSeparada.length; i++) {
            entradaSeparada[i] = "" + entradaASeparar.charAt(i);
        }
        return entradaSeparada;
    }

    /**
     * Realiza la conversión caracter por caracter
     * En caso de no encontrar una letra en el alfabeto, inserta el caracter directamente.
     *
     * @param cadenaAConvertir
     * @return
     */
    private static String convertirAMorse(String[] cadenaAConvertir) {
        String cadenaEnMorse = "";
        for (int i = 0; i < cadenaAConvertir.length; i++) {
            if (obtenerPosicionEnElAlfabeto(cadenaAConvertir[i]) < 0) {
                cadenaEnMorse += "   ";
            } else {
                cadenaEnMorse += morseAlphabet[obtenerPosicionEnElAlfabeto(cadenaAConvertir[i])] + " ";
            }
        }
        return cadenaEnMorse;
    }

    /**
     * Recibe una letra y la busca en el alfabeto latino.
     * Regresa la posición, -1 en caso de no encontrar el caracter
     *
     * @param letra a buscar
     * @return la posicion en el alfabeto
     */
    private static int obtenerPosicionEnElAlfabeto(String letra) {
        if (letra.equals(" ")) {
            return -2;
        }
        for (int i = 0; i < latinAlphabet.length; i++) {
            if (latinAlphabet[i].equals(letra)) {
                return i;
            }
        }
        return -1;
    }
}