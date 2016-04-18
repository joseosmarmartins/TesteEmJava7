import model.Casa;

import java.util.Collections;
import java.util.List;

public class Segunda {

    public static void main(String[] args) {
        CriarObjetos criarObjetos = new CriarObjetos();

        List<Casa> casaList = criarObjetos.criarObjetos();

        for (Casa casa : casaList) {
            if (casa.getNome().equals("Starks")) {
                Collections.sort(casa.getCasaPessoaList());
            }
        }

        System.out.println(casaList);
    }
}
