public class Compiler implements CompilerFunctions {

    @Override
    public void parseMorseCode() {

    }

    @Override
    public void decir(String cosaADecir) {

    }

    @Override
    public int sumar(int cosa1, int cosa2) {
        return 0;
    }

    @Override
    public int multiplicar(int cosa1, int cosa2) {
        return 0;
    }

    @Override
    public int dividir(int dividendo, int divisor) {
        return 0;
    }

    @Override
    public String traducir(String traduccion) {
        return TraductorLatinToMorse.convertirAMorseExterno(traduccion);
    }
}
