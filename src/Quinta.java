import model.PessoasDao;
import model.auxiliar.CasasAuxiliar2;

import java.sql.SQLException;
import java.util.List;

public class Quinta {

    public static void main(String[] args) throws SQLException {
        List<CasasAuxiliar2> casasAuxiliar2List = PessoasDao.getPessoas();

        System.out.println(casasAuxiliar2List);
    }
}
