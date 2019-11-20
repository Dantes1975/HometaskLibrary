package repository;

import bean.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDaoImpl extends AbstractDao<Genre> implements GenreDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM GENRES";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM GENRES WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Genre genre) {
        return "INSERT INTO GENRES (GENRE) VALUES ('" + genre.getGenrename() + "')";
    }

    @Override
    protected String getUpdateQuery(Genre genre) {
        return "UPDATE GENRES SET GENRE='" + genre.getGenrename() + "' WHERE ID =" + genre.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM GENRES WHERE id=" + id;
    }

    @Override
    protected Genre resultSetMapper(ResultSet k) throws SQLException {

        while (k.next()) {
            Genre genre = new Genre();
            genre.setId(k.getLong("id"));
            genre.setGenrename(k.getString("genre"));
            return genre;
        }
        return null;
    }
}
