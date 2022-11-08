public class Local {
    private String nome;
    private String ramal;
    private String identificadorTextual;

    public Local(String nome, String ramal, String identificadorTextual) {
        this.nome = nome;
        this.ramal = ramal;
        this.identificadorTextual = identificadorTextual;
    }

    public String getIdentificadorTextual() {
        return this.identificadorTextual;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.identificadorTextual + " - " + this.ramal;
    }
}
