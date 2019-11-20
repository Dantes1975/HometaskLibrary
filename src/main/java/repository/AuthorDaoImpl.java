package repository;

import bean.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDaoImpl extends AbstractDao <Author> implements AuthorDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM AUTHORS";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM AUTHORS WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Author author) {
        return "INSERT INTO AUTHORS (FIRSTNAME, LASTNAME) VALUES (" + author.getName()+
                "', '" + author.getSurname() + "')";
    }

    @Override
    protected String getUpdateQuery(Author author) {
        return "UPDATE AUTHORS SET FIRSTNaME='" + author.getName() + "', BOOKNAME= '" + author.getSurname() +
                "' WHERE ID =" + author.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM AUTHORS WHERE id=" + id;
    }

    @Override
    protected Author resultSetMapper(ResultSet k) throws SQLException {
        Author author =new Author();
        while (k.next()) {
            author.setName(k.getString("firstname"));
            author.setSurname(k.getString("lastname"));
        }
        return author;
    }
}
