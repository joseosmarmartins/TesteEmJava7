import model.Pessoa;
import model.PessoasDao;

import java.sql.SQLException;
import java.util.List;

public class Quarta {

    public static void main(String[] args) throws SQLException {
        List<Pessoa> pessoaList = PessoasDao.getStarksIniciaisB();

        System.out.println(pessoaList);
    }
}
