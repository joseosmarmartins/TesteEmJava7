import model.Conexao;

import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

    public void criarTabelas() throws SQLException {
        Statement statement = Conexao.conectar().createStatement();
        String sql = "CREATE TABLE HOUSES (ID BIGSERIAL PRIMARY KEY NOT NULL, NOME VARCHAR(250), SUFIXO VARCHAR(250));" +
                "CREATE TABLE PEOPLE (ID BIGSERIAL PRIMARY KEY NOT NULL, NOME VARCHAR(250), SUFIXO VARCHAR(250), " +
                "SUFIXO_IMAGEM VARCHAR(250), DESCRICAO VARCHAR(250));";

        sql += "CREATE TABLE HOUSES_PEOPLE (ID BIGSERIAL PRIMARY KEY NOT NULL, HOUSE_ID BIGSERIAL NOT NULL, " +
                "PEOPLE_ID BIGSERIAL NOT NULL, FOREIGN KEY (HOUSE_ID) REFERENCES HOUSES(ID)," +
                "FOREIGN KEY (PEOPLE_ID) REFERENCES PEOPLE(ID))";

        statement.execute(sql);
    }
}
