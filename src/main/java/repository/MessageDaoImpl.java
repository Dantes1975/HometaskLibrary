package repository;

import bean.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDaoImpl extends AbstractDao <Message> implements MessageDao {
    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM MESSAGES";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM MESSAGES WHERE ID =" + id;
    }

    @Override
    protected String getInsertQuery(Message message) {
        return "INSERT INTO MESSAGES (SENDER, RECIPIENT, TEXT) VALUES (" + message.getSender()
                + "," + message.getRecipient() + ", '" + message.getText() + "')";
    }

    @Override
    protected String getUpdateQuery(Message message) {
        return "UPDATE MESSAGES SET SENDER=" + message.getSender() + ", RECIPIENT= " + message.getRecipient() + ", TEXT='" +
                message.getText() + "' WHERE ID =" + message.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM MESSAGES WHERE id=" + id;
    }

    @Override
    protected Message resultSetMapper(ResultSet k) throws SQLException {

        while (k.next()){
            Message message = new Message();
            message.setId(k.getLong("id"));
            message.setSender(k.getLong("sender"));
            message.setRecipient(k.getLong("recipient"));
            message.setText(k.getString("text"));
            return message;
        }
        return null;
    }
}
