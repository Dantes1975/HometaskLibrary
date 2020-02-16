package bean;

import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private long id;
    private Book book;
    private long user;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(Book book, long user, Date borrowDate, Date returnDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

