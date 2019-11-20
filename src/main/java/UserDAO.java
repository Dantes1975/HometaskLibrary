import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static UserDAO instance = new UserDAO();

    private List<User> users;

    public static UserDAO getInstance() {
        return instance;
    }

    private UserDAO() {
        users = new ArrayList<>();
    }

    public boolean isUserExist(String login, String password) {
        for (User u : users) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password))
                return true;
            }
        return false;
    }



        public boolean add (User user){
            return users.add(user);
        }


        public Roles getRoleByLoginPassword(String login, String password){
            Roles result = null;
            for (User user1 : users) {
                if (user1.getLogin().equals(login) && user1.getPassword().equals(password)) {
                    result = user1.getRole();
                }
            }
            return result;
        }

        public User getUser (String login, String password){
            User user = null;
            for (User u : users) {
                if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                    user = u;
                }
            }
            return user;
        }

        public List<User> userList () {
            List<User> list = new ArrayList<>();
            for (User u : users) {
                list.add(u);
            }
            return list;
        }

    public boolean delete(User user) {
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword()))
                return users.remove(user);
        }
        return false;
    }
    }
