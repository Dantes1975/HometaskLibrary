package repository;

import bean.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowDaoImpl extends AbstractDao <Borrow> implements BorrowDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM BORROWS";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM BORROWS WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Borrow borrow) {
        return "INSERT INTO BORROWS (BOOKID, USERID, BORROWDATE, RETURNDATE) VALUES (" + borrow.getBook()
                + "," + borrow.getUser() + "," + borrow.getBorrowDate() + borrow.getReturnDate() + ")";
    }

    @Override
    protected String getUpdateQuery(Borrow borrow) {
        return "UPDATE BORROWS SET BOOKID=" + borrow.getBook() + ", USERID= '" + borrow.getUser() + "', BORROWDATE=" +
                borrow.getBorrowDate() + "RETURNDATE=" + borrow.getReturnDate() + "WHERE ID =" + borrow.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM BORROWS WHERE id=" + id;
    }

    @Override
    protected Borrow resultSetMapper(ResultSet k) throws SQLException {
        while (k.next()) {
            Borrow borrow = new Borrow();
            borrow.setId(k.getLong("id"));
            borrow.setBook(k.getLong("bookid"));
            borrow.setUser(k.getLong("userid"));
            borrow.setBorrowDate(k.getDate("borrowdate"));
            borrow.setReturnDate(k.getDate("returndate"));
            return borrow;
        }
        return null;
    }
}
