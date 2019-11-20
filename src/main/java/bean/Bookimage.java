package bean;

import lombok.*;

import java.util.Arrays;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Bookimage {
    private long id;
    private long bookId;
    private byte[] bookimage;



    @Override
    public String toString() {
        return "Bookimage{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookimage=" + Arrays.toString(bookimage) +
                '}';
    }
}
