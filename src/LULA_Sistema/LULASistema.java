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
        verificaDisponibilidadeLocal(identificadorTextual);
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
        TrataErro.verificaPosicaoValida(codigoIdentificacao);
        verificaExistenciaComitiva(codigoIdentificacao);
        comitivas[codigoIdentificacao] = new Comitiva(codigoIdentificacao, descricao, numeroPessoas, telefone);
    }

    public String exibeComitiva(int codigoIdentificador) {
        String comitiva = "";
        TrataErro.verificaPosicaoValida(codigoIdentificador);
        if (comitivas[codigoIdentificador] == null) {
            throw new NullPointerException("Comitiva não existe");
        }
        comitiva = comitivas[codigoIdentificador].toString();
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

    public String listaLocais() {
        String listagemLocais = "";
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null) {
                listagemLocais += locais[i].toString() + "\n";
            }
        }
        if (listagemLocais.isBlank()) {
            throw new IllegalArgumentException("Não ha locais cadastrados");
        }
        return listagemLocais;
    }

    public String listaComitivas() {
        String listagemComitivas = "";
        for (int i = 0; i < comitivas.length; i++) {
            if (comitivas[i] != null) {
                listagemComitivas += comitivas[i].toString() + "\n";
            }
        }
        if (listagemComitivas.isBlank()) {
            throw new IllegalArgumentException("Não ha comitivas cadastradas");
        }
        return listagemComitivas;
    }

    public void registraVisita(String idLocal, int idComitiva) {
        verificaExistenciaLocal(idLocal);
        TrataErro.verificaPosicaoValida(idComitiva);
        verificaComitivaNull(idComitiva);
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == idLocal) {
                locais[i].registraVisitasLocal(comitivas[idComitiva].getNumeroPessoas());
            }
        }
    }

    public int exibeVisistasLocal(String idLocal) {
        int numVistas = 0;
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == idLocal) {
                numVistas += locais[i].getVisitas();
            }
        }
        return numVistas;
    }

    private void verificaDisponibilidadeLocal(String identificadorTextual) {
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i].getIdentificadorTextual() == identificadorTextual){
                throw new IllegalArgumentException("Local já cadastrado");
            }
        }
    }

    private void verificaExistenciaComitiva(int codigoIdentificacao) {
        if (comitivas[codigoIdentificacao] != null) {
            throw new IllegalArgumentException("Comitiva já existe com essa identificicação");
        }
    }

    private void verificaExistenciaLocal(String identificadorTextual) {
        boolean isVazio = true;
        for (int i = 0; i < locais.length; i++) {
            if (locais[i] != null && locais[i]. getIdentificadorTextual() == identificadorTextual) {
                isVazio = false;
            }
        }
        if (isVazio) {
            throw new IllegalArgumentException("Esse Id de local nao existe");
        }
    }

    private void verificaComitivaNull(int idComitiva) {
        if (comitivas[idComitiva] == null) {
            throw new NullPointerException("Essa comitiva nao existe");
        }
    }
}

