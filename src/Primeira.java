import model.Casa;

import java.util.List;

public class Primeira {

    public static void main(String[] args) {
        CriarObjetos criarObjetos = new CriarObjetos();

        List<Casa> casaList = criarObjetos.criarObjetos();

        System.out.println(casaList);
    }
}
