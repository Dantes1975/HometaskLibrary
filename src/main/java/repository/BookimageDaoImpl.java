package repository;

import bean.Bookimage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookimageDaoImpl extends AbstractDao<Bookimage> implements BookimageDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECN * FROM BOOKIMAGE";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM BOOKIMAGE WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Bookimage bookimage) {
        return "INSERT INTO BOOKIMAGE (BOOKID, BOOKIMAGE) VALUES (" + bookimage.getBookId()
                + "," + bookimage.getBookimage() + ")";
    }

    @Override
    protected String getUpdateQuery(Bookimage bookimage) {
        return "UPDATE BOOKIMAGE SET BOOKID=" + bookimage.getBookId() + ", BOOKIMAGE= '" + bookimage.getBookimage() +
                "WHERE ID =" + bookimage.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM BOOKIMAGE WHERE id=" + id;
    }

    @Override
    protected Bookimage resultSetMapper(ResultSet k) throws SQLException {

        while (k.next()) {
            Bookimage bookimage = new Bookimage();
            bookimage.setId(k.getLong("id"));
            bookimage.setBookId(k.getLong("bookid"));
            bookimage.setBookimage(k.getBytes("bookimage"));
            return bookimage;
        }
        return null;
    }
}
