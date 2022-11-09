package LULA_Sistema;

public class Comitiva {
    private int numeroPessoas;
    private int codigoIdentificacao;
    private String telefone;
    private  String descricao;

    public Comitiva(int codigoIdentificacao, String descricao, int numeroPessoas, String telefone) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.descricao = descricao;
        this.numeroPessoas = numeroPessoas;
        this.telefone = telefone;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public int getCodigoIdentificacao() {
        return this.codigoIdentificacao;
    }

    @Override
    public String toString() {
        return "ID: " + this.codigoIdentificacao + "\n" + "Comitiva: " + this.descricao +
                "\n" + "Integrantes: " +this.numeroPessoas + "\n" + "Contato: " + this.telefone;
    }
}
