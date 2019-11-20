package repository;

import bean.Authenticate;

import java.sql.*;
import java.util.List;

public class AuthenticateDaoImpl extends AbstractDao<Authenticate> implements AuthenticateDao {
    private DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();

    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM AUTHENTICATE";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM AUTHENTICATE WHERE id =" + id;
    }

    @Override
    protected String getInsertQuery(Authenticate authenticate) {
        return "INSERT INTO Authenticate (login, password) VALUES ('" + authenticate.getLogin() +
                "','" + authenticate.getPassword() + "')";
    }

    @Override
    protected String getUpdateQuery(Authenticate authenticate) {
        return "UPDATE Authenticate SET login=" + authenticate.getLogin() + "WHERE password=" +
                authenticate.getPassword();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM Authenticate WHERE id =" + id;
    }

    @Override
    protected Authenticate resultSetMapper(ResultSet k) throws SQLException {
        while (k.next()) {
            Authenticate authenticate = new Authenticate();
            authenticate.setId(k.getLong("id"));
            authenticate.setLogin(k.getString("login"));
            authenticate.setPassword(k.getString("password"));
            authenticate.setProfile_enable(k.getString("profile_enable"));
            return authenticate;
        }
        return null;
    }

    protected String getByLoginSql(String string) {
        return "SELECT * FROM AUTHENTICATE WHERE login =" + "'" + string + "'";
    }

    public Authenticate getByLogin(String login) {
        try (Connection cn = dataBaseConnector.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(getByLoginSql(login))) {
            return resultSetMapper(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean isExistByLogin(String login) {
        Authenticate authenticate = null;
        try (Connection cn = dataBaseConnector.getConnection();
             PreparedStatement st = cn.prepareStatement("SELECT * FROM AUTHENTICATE WHERE LOGIN = ?")) {
            st.setString(1, login);
            ResultSet resultSet = st.executeQuery();
            authenticate = resultSetMapper(resultSet);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        if (authenticate == null) {
            return false;
        }

        return true;
    }


    @Override
    public Authenticate insert(Authenticate authenticate) {
        try (Connection cn = dataBaseConnector.getConnection();
             PreparedStatement st = cn.prepareStatement("INSERT INTO AUTHENTICATE (LOGIN, PASSWORD) " +
                     "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, authenticate.getLogin());
            st.setString(2, authenticate.getPassword());
            st.executeUpdate();
            ResultSet resultSet = st.getGeneratedKeys();
            while (resultSet.next()) {
                authenticate.setId(resultSet.getLong(1));
                authenticate.setProfile_enable(resultSet.getString(4));
            }
            return authenticate;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Authenticate authOn(long id) {
        try (Connection cn = dataBaseConnector.getConnection();
             PreparedStatement st = cn.prepareStatement("UPDATE AUTHENTICATE SET PROFILE_ENABLE='ON' WHERE ID=?", Statement.RETURN_GENERATED_KEYS)) {
            st.setLong(1, id);
            st.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return getById(id);
    }

    public Authenticate authOff(long id) {
        try (Connection cn = dataBaseConnector.getConnection();
             PreparedStatement st = cn.prepareStatement("UPDATE AUTHENTICATE SET PROFILE_ENABLE='OFF' WHERE ID=?", Statement.RETURN_GENERATED_KEYS)) {
            st.setLong(1, id);
            st.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return getById(id);
    }

    public Authenticate authBlock(long id) {
        try (Connection cn = dataBaseConnector.getConnection();
             PreparedStatement st = cn.prepareStatement("UPDATE AUTHENTICATE SET PROFILE_ENABLE='BLOCK' WHERE ID=?", Statement.RETURN_GENERATED_KEYS)) {
            st.setLong(1, id);
            st.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return getById(id);
    }
}
