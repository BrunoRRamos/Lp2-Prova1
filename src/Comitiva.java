public class Comitiva {
    private int numeroPessoas;
    private int codigoIdentificacao;
    private String telefone;
    private  String descricao;

    public Comitiva(int numeroPessoas, int codigoIdentificacao, String telefone, String descricao) {
        this.numeroPessoas = numeroPessoas;
        this.codigoIdentificacao = codigoIdentificacao;
        this.telefone = telefone;
        this.descricao = descricao;
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
