import model.*;

import java.sql.SQLException;
import java.util.List;

public class Terceira {

    public static void main(String[] args) throws SQLException {
        criarTabelas();

        System.out.println("Tabelas criadas com sucesso!");

        persistirObjetos();

        System.out.println("Objetos salvos com sucesso!");
    }

    private static void criarTabelas() {
        try {
            CriarTabelas criarTabelas = new CriarTabelas();
            criarTabelas.criarTabelas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void persistirObjetos() {
        try {
            CriarObjetos criarObjetos = new CriarObjetos();

            List<Pessoa> pessoaList = criarObjetos.getPreenchePessoas();
            List<Casa> casaList = criarObjetos.criarObjetos();

            for (Pessoa pessoa : pessoaList) {
                PessoasDao.create(pessoa);
            }

            for (Casa casa : casaList) {
                for (CasaPessoa casaPessoa : casa.getCasaPessoaList()) {
                    for (Pessoa pessoa : pessoaList) {
                        if (casaPessoa.getPessoa().getNome().equals(pessoa.getNome())) {
                            casaPessoa.getPessoa().setId(pessoa.getId());
                        }
                    }
                }

                CasasDao.create(casa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
