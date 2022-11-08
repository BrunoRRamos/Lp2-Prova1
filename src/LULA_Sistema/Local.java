package LULA_Sistema;

public class Local {
    private String nome;
    private String ramal;
    private String identificadorTextual;

    public Local(String identificadorTextual, String nome, String ramal) {
        this.identificadorTextual = identificadorTextual;
        this.nome = nome;
        this.ramal = ramal;

    }

    public String getIdentificadorTextual() {
        return this.identificadorTextual;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.identificadorTextual + " - " + this.ramal;
    }
}
