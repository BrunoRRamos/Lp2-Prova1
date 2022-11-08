public class LULASistema {
    private final int NUMERO_DE_LOCAIS = 100;
    private final int NUMERO_DE_COMITIVAS = 100;
    private Local[] locais;
    private Comitiva[] comitivas;

    public LULASistema() {
        this.locais = new Local[NUMERO_DE_LOCAIS];
        this.comitivas = new Comitiva[NUMERO_DE_COMITIVAS];
    }

    public void cadastraLocal(String nome, String ramal, String identificadorTextual) {
        TrataErro.verificaStringVazia(ramal);
        TrataErro.verificaStringVazia(nome);
        TrataErro.verificaStringVazia(identificadorTextual);
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] == null) {
                locais[i] = new Local(nome, ramal, identificadorTextual);
            }
         }
    }

    public void cadastraComitiva(int numeroPessoas, int codigoIdentificacao, String telefone, String descricao) {
        TrataErro.verificaStringVazia(telefone);
        TrataErro.verificaStringVazia(descricao);
        TrataErro.verificaNumero(numeroPessoas);
        if (codigoIdentificacao > 99 || codigoIdentificacao < 0) {
            throw new IndexOutOfBoundsException("Codigo Invalido");
        }
        comitivas[codigoIdentificacao] = new Comitiva(numeroPessoas, codigoIdentificacao, telefone, descricao);
    }

    public String exibeComitiva(int codigoIdentificador) {
        String comitiva = "";
        for (int i = 0; i < comitivas.length; i++) {
            if (comitivas[i] != null && comitivas[i].getCodigoIdentificacao() == codigoIdentificador) {
                comitiva = comitivas[i].toString();
            }
        }
        return comitiva;
    }

    public String exibeLocal(String identificadorTextual) {
        String local = "";
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == identificadorTextual) {
                local = locais[i].toString();
            }
        }
        return local;
    }
}

