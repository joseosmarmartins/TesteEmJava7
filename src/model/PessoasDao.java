package model;

import model.auxiliar.CasasAuxiliar2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoasDao {

    public static int create(Pessoa pessoa) throws SQLException {
        Statement statement = Conexao.conectar().createStatement();
        String sql = "INSERT INTO PEOPLE(NOME, DESCRICAO, SUFIXO_IMAGEM, SUFIXO) VALUES('"
                + pessoa.getNome().replace("'", "") + "','" + pessoa.getDescricao().replace("'", "") + "','" + pessoa.getSufixoImagem() + "','" + pessoa.getSufixo() + "')";

        statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        pessoa.setId(resultSet.getLong("id"));

        return resultSet.getInt(1);
    }

    public static List<Pessoa> getStarksIniciaisB() throws SQLException {
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT P.ID, P.NOME, P.SUFIXO, P.SUFIXO_IMAGEM, P.DESCRICAO FROM HOUSES_PEOPLE H_P " +
                "INNER JOIN PEOPLE P ON H_P.PEOPLE_ID = P.ID WHERE H_P.HOUSE_ID = 1 AND P.NOME LIKE 'B%';" ;

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();

        List<Pessoa> pessoaList = new ArrayList<>();

        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa();

            pessoa.setId(resultSet.getLong("id"));
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setDescricao(resultSet.getString("descricao"));
            pessoa.setSufixoImagem(resultSet.getString("sufixo_imagem"));
            pessoa.setSufixo(resultSet.getString("sufixo"));

            pessoaList.add(pessoa);
        }

        return pessoaList;
    }

    public static List<CasasAuxiliar2> getPessoas() throws SQLException {
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT H_P.HOUSE_ID, H.NOME, COUNT(H_P.PEOPLE_ID), MIN(P.ID) FROM HOUSES_PEOPLE H_P INNER JOIN PEOPLE P ON H_P.PEOPLE_ID = P.ID " +
                "INNER JOIN HOUSES H ON H_P.HOUSE_ID = H.ID GROUP BY H_P.HOUSE_ID, H.NOME ORDER BY H_P.HOUSE_ID;" ;

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();

        List<CasasAuxiliar2> casasAuxiliar2List = new ArrayList<>();

        while (resultSet.next()) {
            CasasAuxiliar2 casasAuxiliar = new CasasAuxiliar2();

            casasAuxiliar.setNomeCasa(resultSet.getString("nome"));
            casasAuxiliar.setQuantidadePessoas(resultSet.getDouble("count"));
            casasAuxiliar.setPrimeiraPessoa(retreave(resultSet.getInt("min")));

            casasAuxiliar2List.add(casasAuxiliar);
        }

        return casasAuxiliar2List;
    }

    public static Pessoa retreave(int id) throws SQLException{
        Statement statement = Conexao.conectar().createStatement();

        String sql = "SELECT * FROM PEOPLE where ID = " + id;

        statement.executeQuery(sql);

        ResultSet resultSet = statement.getResultSet();
        resultSet.next();

        Pessoa pessoa = new Pessoa();

        pessoa.setId(resultSet.getLong("id"));
        pessoa.setNome(resultSet.getString("nome"));
        pessoa.setDescricao(resultSet.getString("descricao"));
        pessoa.setDescricao(resultSet.getString("sufixo_imagem"));
        pessoa.setSufixo(resultSet.getString("sufixo"));

        return pessoa;
    }
}
