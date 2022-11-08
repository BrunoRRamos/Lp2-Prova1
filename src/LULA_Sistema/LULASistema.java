package LULA_Sistema;

public class LULASistema {
    private final int NUMERO_DE_LOCAIS = 100;
    private final int NUMERO_DE_COMITIVAS = 100;
    private Local[] locais;
    private Comitiva[] comitivas;

    public LULASistema() {
        this.locais = new Local[NUMERO_DE_LOCAIS];
        this.comitivas = new Comitiva[NUMERO_DE_COMITIVAS];
    }

    public void cadastraLocal(String identificadorTextual,String nome, String ramal) {
        TrataErro.verificaStringVazia(ramal);
        TrataErro.verificaStringVazia(nome);
        TrataErro.verificaStringVazia(identificadorTextual);
        verificaExistenciaLocal(identificadorTextual);
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] == null) {
                locais[i] = new Local(identificadorTextual, nome, ramal);
                break;
            }
         }
    }

    public void cadastraComitiva(int codigoIdentificacao, String descricao, int numeroPessoas, String telefone) {
        TrataErro.verificaStringVazia(telefone);
        TrataErro.verificaStringVazia(descricao);
        TrataErro.verificaNumero(numeroPessoas);
        if (codigoIdentificacao > 99 || codigoIdentificacao < 0) {
            throw new IndexOutOfBoundsException("Codigo Invalido");
        }
        verificaExistenciaComitiva(codigoIdentificacao);
        comitivas[codigoIdentificacao] = new Comitiva(codigoIdentificacao, descricao, numeroPessoas, telefone);
    }

    public String exibeComitiva(int codigoIdentificador) {
        String comitiva = "";
        for (int i = 0; i < comitivas.length; i++) {
            if (comitivas[i] != null && comitivas[i].getCodigoIdentificacao() == codigoIdentificador) {
                comitiva = comitivas[i].toString();
            }
        }
        if (comitiva.isBlank()) {
            throw new IllegalArgumentException("Comitiva não existe");
        }
        return comitiva;
    }

    public String exibeLocal(String identificadorTextual) {
        StringBuilder local = new StringBuilder();
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == identificadorTextual) {
                local.append(locais[i].toString());
            }
        }
        if (local.toString().isBlank()) {
            throw new IllegalArgumentException("Local não existe");
        }
        return local.toString();
    }

    public void verificaExistenciaLocal(String identificadorTextual) {
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == identificadorTextual){
                throw new IllegalArgumentException("Local já cadastrado");
            }
        }
    }

    public void verificaExistenciaComitiva(int codigoIdentificacao) {
        if (comitivas[codigoIdentificacao] != null) {
            throw new IllegalArgumentException("Comitiva já existe com essa identificicação");
        }
    }

}

