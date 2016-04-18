package model;

import model.entidade.Entidade;

public class CasaPessoa extends Entidade implements Comparable<CasaPessoa> {

    private Casa casa;
    private Pessoa pessoa;

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int compareTo(CasaPessoa casaPessoaAComparar) {
        return pessoa.getNome().compareTo(casaPessoaAComparar.getPessoa().getNome());
    }
}
