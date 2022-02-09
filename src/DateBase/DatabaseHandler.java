package DateBase;

import java.sql.*;
import java.util.HashMap;

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
     * Возвращает из таблицы группы, группы по с заданным курсом
     * @param course - курс
     * @return список групп
     */
    public HashMap<Integer,String> getNameGroups(int course){
        try {

            HashMap<Integer,String> out = new HashMap<>();

            //SQL запрос, считывающий из таблицы группы запись по ID
            String sql = "SELECT * FROM " + Const.GROUPS_TABLE + " WHERE " + Const.GROUPS_COURSE + " = " + course;
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                out.put(res.getInt(Const.GROUPS_ID),res.getString(Const.GROUPS_NAME));
            }

            return out;

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
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

    public String getSchedule(int group){

        try {

            String out = "";
            //SQL запрос
            String sql = "SELECT " + Const.WEEKDAY_NAME +
                    ", " + Const.SUBJECT_NAME +
                    ", " + Const.TYPESUBJECT_NAME +
                    ", " + Const.CLASSROOM_BUIDLING +
                    ", " + Const.CLASSROOM_NUMBER +
                    ", " + Const.TEACHER_NAME +
                    ", " + Const.SCHEDULE_START_TIME +
                    ", " + Const.SCHEDULE_END_TIME +

                    " FROM " + Const.WEEKDAY_TABLE +
                    ", " + Const.SUBJECT_TABLE +
                    ", " + Const.SCHEDULE_TABLE +
                    ", " + Const.TYPESUBJECT_TABLE +
                    ", " + Const.CLASSROOM_TABLE +
                    ", " + Const.TEACHER_TABLE +

                    " WHERE " + Const.SCHEDULE_STUDENTGROUP + " = " + group + " AND " +
                    Const.SCHEDULE_WEEKDAY + " = " + Const.WEEKDAY_ID + " AND " +
                    Const.SCHEDULE_SUBJECT + " = " + Const.SUBJECT_ID + " AND " +
                    Const.SCHEDULE_TYPESUBJECT + " = " + Const.TYPESUBJECT_ID + " AND " +
                    Const.SCHEDULE_CLASSROOM + " = " + Const.CLASSROOM_ID + " AND " +
                    Const.SCHEDULE_TEACHER + " = " + Const.TEACHER_ID +

                    " ORDER BY " + Const.SCHEDULE_WEEKDAY + ", " + Const.SCHEDULE_START_TIME;


            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            String day = "";

            while (res.next()) {
                //Приписываем к выходной строке день недели
                if (!day.equals(res.getString(1))) {
                    day = res.getString(1);
                    out += "\n" + day + "\n";
                }

                String sl = String.format("%-15s %-70s %-20s %-10s\n",
                        //Время пары
                        res.getString(7) + " - " + res.getString(8),
                        //Название дисциплины и тип занятия
                        res.getString(2) + "(" + res.getString(3) + ")",
                        //ФИО преподавателя
                        res.getString(6),
                        //Аудитория
                        res.getString(4) + "-" + res.getString(5));

                out += sl;

            }

            return out;

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;

    }


}
