public class TraductorLatinToMorse
{
    //Arreglos globales donde se contiene el equivalente en cada alfabeto
    String[] latinAlphabet;
    String[] morse;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String userInput;

        int index;

        index = 0;

        System.out.println("Traductor de español a código morse.");

        userInput = keyboard.next();

        userInput = userInput.toLowerCase();

        for (index = 0; index < userInput.length(); index++)           
        {
            char [] chars = userInput.toCharArray();

            if (userInput.equals(latinAlphabet[index]))
            {    
                System.out.println(" Translated : " + morse[index]);       
            }
        }  
    }

    private static void iniciailzarLenguajes(){
        latinAlphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                  "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
                  "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                  ",", ".", "?" };

        morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };
    }
}