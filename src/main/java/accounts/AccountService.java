package accounts;

import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;


public class AccountService {
//    private final Map<String, UserProfile> loginToProfile;
//    private final Map<String, UserProfile> sessionIdToProfile;

//    public AccountService() {
//        loginToProfile = new HashMap<>();
//        sessionIdToProfile = new HashMap<>();
//    }

    private Executor executor;
    public AccountService (Connection connection) {this.executor = new Executor(connection); }

    public static DBService dbService = new DBService();

    public AccountService() {

    }

    public DBService getDbService() {
        return dbService;
    }

    public UsersDataSet get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new UsersDataSet(result.getLong(1), result.getString(2));
        });
    }
//    public UserProfile getUserByLogin(String login) {
//        return dbService.get(login);
//    }


    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    /*public void insertUser(String userProfile) throws SQLException {
        executor.execUpdate("insert into users (user_name, user_password) values ('" + userProfile.getLogin() + userProfile.getPass() + "')");
    }*/

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }


//    public void addNewUser(UserProfile userProfile) {
//        loginToProfile.put(userProfile.getLogin(), userProfile);
//    }
//
//    public UserProfile getUserByLogin(String login) {
//        return loginToProfile.get(login);
//    }
//
//    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//
//    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
//    }
//
//    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
//    }
}
