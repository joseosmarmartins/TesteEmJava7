import model.Casa;
import model.CasaPessoa;
import model.CasasDao;
import model.auxiliar.CasasAuxiliar3;
import utils.JsonUtils;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Desafio {

    public static void main(String[] args) throws SQLException {
        List<Casa> casaList = CasasDao.getCasas();

        Collections.sort(casaList);

        for (Casa casa : casaList) {
            Collections.sort(casa.getCasaPessoaList());
        }

        CasasAuxiliar3 casasAuxiliar = geraObjetoAuxiliar(casaList);

        JsonUtils jsonUtils = new JsonUtils();

        String json2 = jsonUtils.gerarJson(casasAuxiliar);

        System.out.println(json2);
    }

    private static CasasAuxiliar3 geraObjetoAuxiliar(List<Casa> casaList) {
        CasasAuxiliar3 casasAuxiliar = new CasasAuxiliar3();

        for (Casa casa : casaList) {
            CasasAuxiliar3 house = new CasasAuxiliar3();

            house.setName(casa.getNome());
            house.setWikiSuffix(casa.getSufixo());
            house.setNumberPersons(casa.getCasaPessoaList().size());

            for (CasaPessoa casaPessoa : casa.getCasaPessoaList()) {
                CasasAuxiliar3 person = new CasasAuxiliar3();

                person.setName(casaPessoa.getPessoa().getNome());
                person.setWikiSuffix(casaPessoa.getPessoa().getSufixo());
                person.setDescription(casaPessoa.getPessoa().getDescricao());
                person.setImageSuffix(casaPessoa.getPessoa().getSufixoImagem());

                house.getPeople().add(person);
            }

            casasAuxiliar.getHouses().add(house);
        }

        return casasAuxiliar;
    }
}
