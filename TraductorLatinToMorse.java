import java.util.Scanner;

public class TraductorLatinToMorse
{
    //Arreglos globales donde se contiene el equivalente en cada alfabeto
    private static String[] latinAlphabet;
    private static String[] morseAlphabet;

    public static void main(String[] args) {
        String[] Input;
        String entradaEnMorse;
        String entradaLatin;
        //se cargan los alfabetos soportados a la memoria
        inicializarLenguajes();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Traductor alfabeto latino a código morse.");
        System.out.print("Introduzca la frase a convertir: ");
        //recibiendo la entrada del usuario a un arreglo
        entradaLatin = keyboard.nextLine().toLowerCase();
        System.out.println("Intentando convertir '" + entradaLatin + "' a morse.");
        Input = separarEnLetras(entradaLatin);
        //Se realiza la conversión de alfabeto
        entradaEnMorse = convertirAMorse(Input);
        //Mostrando resultados
        System.out.println("Resultado:");
        System.out.println(entradaEnMorse);
    }

    /**
     * Separa una cadena en un arreglo de cadenas caracter por caracter
     *
     * @param entradaASeparar que es la cadena a separar
     * @return entradaSeparada que es la cadena ya separada
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
     * En caso de no encontrar una letra en el alfabeto, inserta un espacio (entre palabras)
     *
     * @param cadenaAConvertir que es la cadena en el alfabeto latino
     * @return cadenaEnMorse que es la cadena en alfabeto morse
     */
    private static String convertirAMorse(String[] cadenaAConvertir) {
        String cadenaEnMorse = "";
        for (String s : cadenaAConvertir) {
            if (obtenerPosicionEnElAlfabeto(s) < 0) {
                //cualquier caracter que no exista en el alfabeto, se considera un espacio
                cadenaEnMorse += "   ";
            } else {
                cadenaEnMorse += morseAlphabet[obtenerPosicionEnElAlfabeto(s)] + " ";
            }
        }
        return cadenaEnMorse;
    }

    /**
     * Recibe una letra y la busca en el alfabeto latino.
     * Regresa la posición, -1 en caso de no encontrar el caracter
     * @param letra a buscar
     * @return la posicion en el alfabeto
     */
    private static int obtenerPosicionEnElAlfabeto(String letra) {
        for (int i = 0; i < latinAlphabet.length; i++) {
            if (latinAlphabet[i].equals(letra)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Carga los lenguajes en memoria
     */
    private static void inicializarLenguajes() {
        latinAlphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"};

        morseAlphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "--.--", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};

        //Se necesita la misma cantidad de caracteres en ambos alfabetos
        //No es un error que vaya a generar problema a menos que.. lo genere.
        if (latinAlphabet.length != morseAlphabet.length) {
            System.err.println("Los alfabetos difieren en tamaño.");
        }
    }
}