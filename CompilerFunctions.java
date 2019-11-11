public interface CompilerFunctions {

    void parseMorseCode();

    //el morse para decir es : -.. . -.-. .. .-.
    void decir(String cosaADecir);

    //el morse para sumar es : ... ..- -- .- .-.
    int sumar(int cosa1, int cosa2);

    //el morse para multiplicar es : -- ..- .-.. - .. .---. .-.. .. -.-. .- .-.
    int multiplicar(int cosa1, int cosa2);

    //el morse para dividir es : -.. .. ...- .. -.. .. .-.
    int dividir(int dividendo, int divisor);

    //el morse para traducir es : - .-. .- -.. ..- -.-. .. .-.
    String traducir(String traduccion);

}
