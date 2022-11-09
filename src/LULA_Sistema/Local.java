package LULA_Sistema;

public class Local {
    private String nome;
    private String ramal;
    private String identificadorTextual;
    private int visitas;

    public Local(String identificadorTextual, String nome, String ramal) {
        this.identificadorTextual = identificadorTextual;
        this.nome = nome;
        this.ramal = ramal;

    }

    public int getVisitas() {
        return visitas;
    }

    public void registraVisitasLocal(int numeroVisitas) {
        if (numeroVisitas > 100) {
            throw new IllegalArgumentException("A comitiva ultrapassa 100 integrantes");
        }
        this.visitas += numeroVisitas;
    }

    public String getIdentificadorTextual() {
        return this.identificadorTextual;
    }

    @Override
    public String toString() {
        return this.identificadorTextual + " - " + this.nome + " - " + this.ramal;
    }
}
