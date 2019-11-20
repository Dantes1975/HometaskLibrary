package bean;

import lombok.*;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Message {

    private long id;
    private long sender;
    private long recipient;
    private String text;



    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", text='" + text + '\'' +
                '}';
    }
}
