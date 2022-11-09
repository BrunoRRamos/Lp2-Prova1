package LULA_Sistema;

public class TrataErro {
    public static void verificaStringVazia(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("Dado invalido");
        }
    }

    public static void verificaNumero(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número de pessoas inválido");
        }
    }

    public static void verificaPosicaoValida(int posicao) {
        if (posicao > 99 || posicao < 0) {
            throw new IndexOutOfBoundsException("Codigo Invalido");
        }
    }
}
