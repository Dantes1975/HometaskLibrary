package bean;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private long id;
    private Author author;
    private String bookname;
    private Genre genre;
    private int stock;


}
