package model.auxiliar;

import model.Pessoa;

public class CasasAuxiliar2 {

    private String nomeCasa;
    private Double quantidadePessoas;
    private Pessoa primeiraPessoa;

    public String getNomeCasa() {
        return nomeCasa;
    }

    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }

    public Double getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Double quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Pessoa getPrimeiraPessoa() {
        return primeiraPessoa;
    }

    public void setPrimeiraPessoa(Pessoa primeiraPessoa) {
        this.primeiraPessoa = primeiraPessoa;
    }

    @Override
    public String toString() {
        String retorno = "Casa: ";

        retorno += nomeCasa + ". Quantidade Pessoas: " + quantidadePessoas + ". Primeira Pessoa: " + primeiraPessoa.getNome() + "\n\n";

        return retorno;
    }
}
