package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasasDao {

    public static int create(Casa casa) throws SQLException {
        Statement statement = Conexao.conectar().createStatement();
        String sql = "INSERT INTO HOUSES(NOME, SUFIXO) VALUES('"
                + casa.getNome() + "','" + casa.getSufixo() + "')";

        statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        casa.setId(resultSet.getLong("id"));

        createList(casa);

        return resultSet.getInt(1);
    }

    public static void createList(Casa casa) throws SQLException {
        for (CasaPessoa casaPessoa : casa.getCasaPessoaList()) {
            Statement statement = Conexao.conectar().createStatement();
            String sql = "INSERT INTO HOUSES_PEOPLE(HOUSE_ID, PEOPLE_ID) VALUES('"
                    + casaPessoa.getCasa().getId() + "','" + casaPessoa.getPessoa().getId() + "')";

            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();

            casaPessoa.setId(resultSet.getLong("id"));
        }
    }

    public static List<Casa> getCasas() throws SQLException {
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT * FROM HOUSES";

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();

        List<Casa> casaList = new ArrayList<>();

        while (resultSet.next()) {
            Casa casa = new Casa();

            casa.setId(resultSet.getLong("id"));
            casa.setNome(resultSet.getString("nome"));
            casa.setSufixo(resultSet.getString("sufixo"));

            casa.setCasaPessoaList(pessoasPorCasa(casa.getId()));

            casaList.add(casa);
        }

        return casaList;
    }

    public static List<CasaPessoa> pessoasPorCasa(Long houseId) throws SQLException {
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT * FROM HOUSES_PEOPLE WHERE HOUSE_ID = " + houseId;

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();

        List<CasaPessoa> casaPessoaList = new ArrayList<>();

        while (resultSet.next()) {
            CasaPessoa casaPessoa = new CasaPessoa();

            casaPessoa.setId(resultSet.getLong("id"));
            casaPessoa.setCasa(retreave(resultSet.getInt("house_id")));
            casaPessoa.setPessoa(PessoasDao.retreave(resultSet.getInt("people_id")));

            casaPessoaList.add(casaPessoa);
        }

        return casaPessoaList;
    }

    public static Casa retreave(int id) throws SQLException{
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT * FROM HOUSES where ID = " + id;

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();
        resultSet.next();

        Casa casa = new Casa();

        casa.setId(resultSet.getLong("id"));
        casa.setNome(resultSet.getString("nome"));
        casa.setSufixo(resultSet.getString("sufixo"));

        return casa;
    }
}
