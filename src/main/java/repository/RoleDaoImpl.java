package repository;

import bean.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    @Override
    protected String getAllSqlQuery() {
        return "SELECT * FROM ROLES";
    }

    @Override
    protected String getByIdSqlQuery(long id) {
        return "SELECT * FROM ROLES WHERE ID = " + id;
    }

    @Override
    protected String getInsertQuery(Role role) {
        return "INSERT INTO ROLES (ROLE) VALUES (" + role.getRole() + ")";
    }

    @Override
    protected String getUpdateQuery(Role role) {
        return "UPDATE ROLES SET ROLE =" + role.getRole() + "WHERE ID = " + role.getId();
    }

    @Override
    protected String getDeleteQuery(long id) {
        return "DELETE FROM ROLES WHERE id =" + id;
    }

    @Override
    protected Role resultSetMapper(ResultSet k) throws SQLException {
        while (k.next()) {
            Role role = new Role();
            role.setId(k.getLong("id"));
            role.setRole(k.getString("role"));
            return role;
        }
        return null;
    }


}
