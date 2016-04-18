import model.Casa;
import model.CasaPessoa;
import model.Pessoa;
import model.auxiliar.CasasAuxiliar;
import utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class CriarObjetos {

    private CasasAuxiliar casasAuxiliar;

    private List<Casa> casaList = new ArrayList<>();

    public List<Casa> criarObjetos() {
        JsonUtils jsonUtils = new JsonUtils();

        casasAuxiliar = jsonUtils.gerarCasas();

        return getPreencheCasas();
    }

    private List<Casa> getPreencheCasas() {
        List<Casa> casaList = new ArrayList<>();

        for (CasasAuxiliar casas : casasAuxiliar.getHouses()) {
            Casa casa = new Casa();

            casa.setNome(casas.getName());
            casa.setSufixo(casas.getWikiSuffix());

            for (CasasAuxiliar pessoas : casas.getPeople()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(pessoas.getName());
                pessoa.setSufixo(pessoas.getWikiSuffix());
                pessoa.setDescricao(pessoas.getDescription());
                pessoa.setSufixoImagem(pessoas.getImageSuffix());

                CasaPessoa casaPessoa = new CasaPessoa();

                casaPessoa.setCasa(casa);
                casaPessoa.setPessoa(pessoa);

                casa.getCasaPessoaList().add(casaPessoa);
            }

            casaList.add(casa);
        }

        return casaList;
    }

    public List<Pessoa> getPreenchePessoas() {
        if (casasAuxiliar == null) {
            JsonUtils jsonUtils = new JsonUtils();

            casasAuxiliar = jsonUtils.gerarCasas();
        }

        List<Pessoa> pessoaList = new ArrayList<>();

        for (CasasAuxiliar casas : casasAuxiliar.getHouses()) {
            for (CasasAuxiliar pessoas : casas.getPeople()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(pessoas.getName());
                pessoa.setSufixo(pessoas.getWikiSuffix());
                pessoa.setDescricao(pessoas.getDescription());
                pessoa.setSufixoImagem(pessoas.getImageSuffix());

                pessoaList.add(pessoa);
            }
        }

        return pessoaList;
    }

    public CasasAuxiliar getCasasAuxiliar() {
        return casasAuxiliar;
    }

    public void setCasasAuxiliar(CasasAuxiliar casasAuxiliar) {
        this.casasAuxiliar = casasAuxiliar;
    }

    public List<Casa> getCasaList() {
        return casaList;
    }

    public void setCasaList(List<Casa> casaList) {
        this.casaList = casaList;
    }
}
