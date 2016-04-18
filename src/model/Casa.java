package model;

import model.entidade.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Casa extends Entidade implements Comparable<Casa> {

    private String nome;
    private String sufixo;

    private List<CasaPessoa> casaPessoaList = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    public List<CasaPessoa> getCasaPessoaList() {
        return casaPessoaList;
    }

    public void setCasaPessoaList(List<CasaPessoa> casaPessoaList) {
        this.casaPessoaList = casaPessoaList;
    }

    @Override
    public String toString() {
        String retorno = "Casa {\n";

        retorno += "Nome: " + nome + ";\nSufixo: " + sufixo + ";\nPessoas {\n";

        for (CasaPessoa casaPessoa : casaPessoaList) {
            retorno += casaPessoa.getPessoa().toString();
        }

        return retorno;
    }

    @Override
    public int compareTo(Casa casaAComparar) {
        return nome.compareTo(casaAComparar.getNome());
    }
}
