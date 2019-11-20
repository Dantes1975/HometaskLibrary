package repository;

import bean.Author;
import bean.Book;
import bean.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDaoImpl extends AbstractDao<Book> implements BookDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECT BOOKS.ID AS BID, BOOKNAME, AUTHORS.ID AS AID," +
                " FIRSTNAME, LASTNAME, GENRES.ID AS GID, GENRENAME, STOCK  FROM BOOKS" +
                " INNER JOIN AUTHORS ON BOOKS.AUTHORID=AUTHORS.ID INNER JOIN GENRES ON BOOKS.GENREID=GENRES.ID";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM BOOKS WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Book book) {
        return "INSERT INTO BOOKS (AUTHORID, BOOKNAME, GENREID) VALUES (" + book.getAuthor()
                + ", '" + book.getBookname() + "' ," + book.getGenre() + ")";
    }

    @Override
    protected String getUpdateQuery(Book book) {
        return "UPDATE BOOKS SET AUTHORID=" + book.getAuthor() + ", BOOKNAME= '" + book.getBookname() + "', GENRE=" +
                book.getGenre() + "WHERE ID =" + book.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM BOOKS WHERE id=" + id;
    }

    @Override
    protected Book resultSetMapper(ResultSet k) throws SQLException {

        while (k.next()) {
            Book book = new Book();
            book.setId(k.getLong("bid"));
            book.setBookname(k.getString("bookname"));
            book.setAuthor(new Author(k.getLong("aid"), k.getString("firstname"), k.getString("lastname")));
            book.setGenre(new Genre(k.getLong("gid"), k.getString("genrename")));
            book.setStock(k.getInt("stock"));
            return book;
        }
        return null;
    }
}
