package model;

import model.entidade.Entidade;

public class Pessoa extends Entidade implements Comparable<Pessoa> {

    private String nome;
    private String descricao;
    private String sufixoImagem;
    private String sufixo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSufixoImagem() {
        return sufixoImagem;
    }

    public void setSufixoImagem(String sufixoImagem) {
        this.sufixoImagem = sufixoImagem;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    @Override
    public String toString() {
        String retorno = "";

        retorno += "Nome: " + nome + ";\nDescrição: " + descricao + ";\nSufixo de Imagem: " + sufixoImagem
                + ";\nSufixo: " + sufixo + "\n\n";

        return retorno;
    }

    @Override
    public int compareTo(Pessoa pessoaAComparar) {
        return nome.compareTo(pessoaAComparar.getNome());
    }
}
