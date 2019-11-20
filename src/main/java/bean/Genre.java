package bean;

import lombok.*;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Genre {
    private long id;
    private String genrename;



    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genrename + '\'' +
                '}';
    }
}
