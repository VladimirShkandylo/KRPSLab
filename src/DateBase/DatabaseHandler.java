package DateBase;

import java.sql.*;

/**
 * Класс, организующий подключение к БД
 */
public class DatabaseHandler extends Config{

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassCastException, SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    /**
     * Возвращает из таблицы группы название группы по id
     * @param id - id группы
     * @return название группы
     */
    public String getNameGroup(int id){
        try {
            //SQL запрос, считывающий из таблицы группы запись по ID
            String sql = "SELECT * FROM " + Const.GROUPS_TABLE + " WHERE " + Const.GROUPS_ID + " = " + id;
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.GROUPS_NAME);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "null";
    }

    /**
     * Функция для добавления записи в таблицу группы
     * @param name Название группы
     * @param course Курс
     */
    public void addGroup(String name, int course){
        try {
            //SQL добавляющий новую запись в таблицу групп
            String sqlInsert = "INSERT INTO "+ Const.GROUPS_TABLE+" " +
                    "("+Const.GROUPS_NAME+", " +
                    Const.GROUPS_COURSE+") " +
                    "VALUES(?,?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sqlInsert);
            prSt.setString(1,name);
            prSt.setInt(2,course);

            prSt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Функция для удаления записи из таблицы группы по id
     * @param id
     */
    public void deleteGroup(int id){

        try {
            //SQL запрос, удаляющий из группу по id
            String sqlDelete = "DELETE  FROM " + Const.GROUPS_TABLE + " WHERE " + Const.GROUPS_ID + " = " + id;
            //Удаление записи
            getDbConnection().prepareStatement(sqlDelete).executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Функция для обновления данных в записи таблицы группы
     * @param id id записи
     * @param name имя группы
     * @param course курс
     */
    public void updateGroup(int id,String name, int course){

        try {
            //Sql запрос для обновления данных в записи таблицы группы по id
            String sqlUpdate = "UPDATE " + Const.GROUPS_TABLE + " SET " +
                     Const.GROUPS_NAME + " = '" + name + "', " +
                    Const.GROUPS_COURSE  + " = " + course +
                    " WHERE " + Const.GROUPS_ID + " = " + id;

            //Обновляем
            getDbConnection().prepareStatement(sqlUpdate).executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
