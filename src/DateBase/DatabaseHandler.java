package DateBase;

import UpdateDB.Schedule;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    public String getNameGroup(String id){
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

    /**
     * Возвращает из таблицы группы id по названию, если такого нет, то 0
     * @param name - название группы
     * @return id группы
     */
    public int getIdGroup(String name){

        try {
            //SQL запрос, считывающий из таблицы группы запись по названию
            String sql = "SELECT * FROM " + Const.GROUPS_TABLE + " WHERE " + Const.GROUPS_NAME + " = "
                    + "\'" + name + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.GROUPS_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы дни недели id по названию
     * @param name - название недели
     * @return id недели
     */
    public int getIdWeekDay(String name){

        try {
            //SQL запрос, считывающий из таблицы дни недели запись по названию
            String sql = "SELECT * FROM " + Const.WEEKDAY_TABLE + " WHERE " + Const.WEEKDAY_NAME + " = "
                    + "\'" + name + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.WEEKDAY_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы дни недели название по id
     * @param id дня недели
     * @return название дня недели
     */
    public String getNameWeekDay(String id){

        try {
            //SQL запрос, считывающий из таблицы дни недели запись по названию
            String sql = "SELECT * FROM " + Const.WEEKDAY_TABLE + " WHERE " + Const.WEEKDAY_ID + " = "
                    + "\'" + id + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.WEEKDAY_NAME);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Возвращает из таблицы дисциплины и id по названию
     * @param name - название дисциплины
     * @return id дисциплины
     */
    public int getIdSubject(String name){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.SUBJECT_TABLE + " WHERE " + Const.SUBJECT_NAME + " = "
                    + "\'" + name + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.SUBJECT_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы дисциплины название по id
     * @param id - id дисциплины
     * @return название дисциплины
     */
    public String getNameSubject(String id){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.SUBJECT_TABLE + " WHERE " + Const.SUBJECT_ID + " = "
                    + "\'" + id + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.SUBJECT_NAME);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Возвращает из таблицы типов дисциплины и id по названию
     * @param name - тип
     * @return id типа дисциплины
     */
    public int getIdTypeSubject(String name){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.TYPESUBJECT_TABLE + " WHERE " + Const.TYPESUBJECT_NAME + " = "
                    + "\'" + name + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.TYPESUBJECT_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы типов дисциплины название по id
     * @param id - типа дисциплины
     * @return название типа дисциплины
     */
    public String getNameTypeSubject(String id){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.TYPESUBJECT_TABLE + " WHERE " + Const.TYPESUBJECT_ID + " = "
                    + "\'" + id + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.TYPESUBJECT_NAME);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Возвращает из таблицы аудитории и id по названию
     * @param number - номер аудитории
     * @param building - корпус аудитории
     * @return id аудитории
     */
    public int getIdClassroom(String number, String building){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.CLASSROOM_TABLE + " WHERE " + Const.CLASSROOM_NUMBER + " = "
                    + "\'" + number + "\'" + " AND " + Const.CLASSROOM_BUIDLING + " = " + "\'" + building + "\'";

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.CLASSROOM_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы аудитории название по id
     * @param id - аудитории
     * @return название аудитории
     */
    public String getNameClassroom(String id){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.CLASSROOM_TABLE + " WHERE " + Const.CLASSROOM_ID + " = "
                    + "\'" + id + "\'";

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.CLASSROOM_BUIDLING) + "-" + res.getString(Const.CLASSROOM_NUMBER);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Возвращает из таблицы преподавателей id по ФИО
     * @param name - ФИО
     * @return id преподавателя
     */
    public int getIdTeacher(String name){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.TEACHER_TABLE + " WHERE " + Const.TEACHER_NAME + " = "
                    + "\'" + name + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.TEACHER_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Возвращает из таблицы преподавателей ФИО по id
     * @param id - преподавателя
     * @return ФИО преподавателя
     */
    public String getNameTeacher(String id){

        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.TEACHER_TABLE + " WHERE " + Const.TEACHER_ID + " = "
                    + "\'" + id + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getString(Const.TEACHER_NAME);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";

    }

    /**
     * Функция для добавления записи в таблицу предметы
     * @param name Название предмета
     */
    public void addSubject(String name){
        try {
            //SQL добавляющий новую запись в таблицу предметы
            String sqlInsert = "INSERT INTO "+ Const.SUBJECT_TABLE+" " +
                    "("+Const.SUBJECT_NAME+ ") " +
                    "VALUES(?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sqlInsert);
            prSt.setString(1,name);

            prSt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Функция для добавления записи в таблицу группы
     * @param number номер аудитории
     * @param building корпус
     */
    public void addClassroom(String number, String building){
        try {
            //SQL добавляющий новую запись в таблицу аудитории
            String sqlInsert = "INSERT INTO "+ Const.CLASSROOM_TABLE+" " +
                    "("+Const.CLASSROOM_NUMBER+", " +
                    Const.CLASSROOM_BUIDLING+") " +
                    "VALUES(?,?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sqlInsert);
            prSt.setString(1,number);
            prSt.setString(2,building);

            prSt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Функция для добавления записи в таблицу преподаватели
     * @param name ФИО
     */
    public void addTeacher(String name){
        try {
            //SQL добавляющий новую запись в таблицу предметы
            String sqlInsert = "INSERT INTO "+ Const.TEACHER_TABLE+" " +
                    "("+Const.TEACHER_NAME+ ") " +
                    "VALUES(?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sqlInsert);
            prSt.setString(1,name);

            prSt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Функция вовзращает id расписания по объекту из XML файла
     * @return id расписания
     */
    public int getIdSchedule(Schedule schedule){
        try {
            //SQL запрос, считывающий из таблицы дисциплины запись по названию
            String sql = "SELECT * FROM " + Const.SCHEDULE_TABLE + " WHERE "
                    + Const.SCHEDULE_WEEKDAY + " = " + getIdWeekDay(schedule.getWeekday()) + " AND "
                    + Const.SCHEDULE_STUDENTGROUP + " = " + getIdGroup(schedule.getGroup()) + " AND "
                    + Const.SCHEDULE_START_TIME + " = " + "\'" + schedule.getStarttime() + "\'" + " AND "
                    + Const.SCHEDULE_END_TIME + " = " + "\'" + schedule.getEndtime() + "\'";
            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                return res.getInt(Const.SCHEDULE_ID);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Функция добавления записи в таблицу расписание по объекту из XML файла
     * @param schedule - объект расписание, считанный из XML файла
     */
    public void addSchedule(Schedule schedule){
        try {
            //SQL добавляющий новую запись в таблицу расписание
            String sqlInsert = "INSERT INTO "+ Const.SCHEDULE_TABLE+" " +
                    "("+Const.SCHEDULE_WEEKDAY+ ", " +
                    Const.SCHEDULE_SUBJECT + ", " +
                    Const.SCHEDULE_STUDENTGROUP + ", " +
                    Const.SCHEDULE_TYPESUBJECT + ", " +
                    Const.SCHEDULE_CLASSROOM + ", " +
                    Const.SCHEDULE_TEACHER + ", " +
                    Const.SCHEDULE_START_TIME + ", " +
                    Const.SCHEDULE_END_TIME+") " +
                    "VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sqlInsert);
            prSt.setString(1,getIdWeekDay(schedule.getWeekday()) + "");
            prSt.setString(2,getIdSubject(schedule.getSubject()) + "");
            prSt.setString(3,getIdGroup(schedule.getGroup()) + "");
            prSt.setString(4,getIdTypeSubject(schedule.getType()) + "");
            prSt.setString(5,getIdClassroom(schedule.getClassRoomNumber(),schedule.getClassRoomBuilding()) + "");
            prSt.setString(6,getIdTeacher(schedule.getTeacher()) + "");
            prSt.setString(7,schedule.getStarttime());
            prSt.setString(8, schedule.getEndtime());

            prSt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Возвращает расписание по id группы, учителя или аудитории
     * @param id группы, учителя или аудитории
     * @param type 1 - группа, 2 - учитель, 3 - аудитория
     * @return Строка с расписанием
     */
    public String getSchedule(int id, int type){
        try {
            String out = "";
            String sql = "SELECT * FROM " +  Const.SCHEDULE_TABLE + " WHERE ";

            //Если это запрос для группы
            if (type == 1)
                sql += Const.SCHEDULE_STUDENTGROUP;
            else if (type == 2)
                sql += Const.SCHEDULE_TEACHER;
            else
                sql += Const.SCHEDULE_CLASSROOM;

            sql += " = " + id + " ORDER BY " + Const.SCHEDULE_WEEKDAY + ", " + Const.SCHEDULE_START_TIME;

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            String day = "";

            while (res.next()) {
                //Приписываем к выходной строке день недели
                if (!day.equals(res.getString(Const.SCHEDULE_WEEKDAY))) {
                    day = res.getString(Const.SCHEDULE_WEEKDAY);
                    out += "\n" + getNameWeekDay(day) + "\n";
                }

                String sl = String.format("%-15s %-70s %-15s %-20s %-10s\n",
                        //Время пары
                        res.getString(Const.SCHEDULE_START_TIME) + " - " + res.getString(Const.SCHEDULE_END_TIME),
                        //Название дисциплины и тип занятия
                        getNameSubject(res.getString(Const.SCHEDULE_SUBJECT)) + "(" + getNameTypeSubject(res.getString(Const.SCHEDULE_TYPESUBJECT)) + ")",
                        //Группа
                        getNameGroup(res.getString(Const.SCHEDULE_STUDENTGROUP)),
                        //ФИО преподавателя
                        getNameTeacher(res.getString(Const.SCHEDULE_TEACHER)),
                        //Аудитория
                        getNameClassroom(res.getString(Const.SCHEDULE_CLASSROOM)));

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

    /**
     * Возвращает расписание по id дню недели и id группы, учителя или аудитории
     * @param id группы, учителя или аудитории
     * @param type 1 - группа, 2 - учитель, 3 - аудитория
     * @param dayweek id дня недели
     * @return Строка с расписанием
     */
    public String getSchedule_Date(int id, int dayweek ,int type){
        try {
            String out = "";
            String sql = "SELECT * FROM " +  Const.SCHEDULE_TABLE + " WHERE ";

            //Если это запрос для группы
            if (type == 1)
                sql += Const.SCHEDULE_STUDENTGROUP;
            else if (type == 2)
                sql += Const.SCHEDULE_TEACHER;
            else
                sql += Const.SCHEDULE_CLASSROOM;

            sql += " = " + id + " AND " + Const.SCHEDULE_WEEKDAY + " = " + dayweek + " ORDER BY " + Const.SCHEDULE_WEEKDAY + ", " + Const.SCHEDULE_START_TIME;

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            out = getNameWeekDay(dayweek + "") + "\n";

            while (res.next()) {

                String sl = String.format("%-15s %-70s %-15s %-20s %-10s\n",
                        //Время пары
                        res.getString(Const.SCHEDULE_START_TIME) + " - " + res.getString(Const.SCHEDULE_END_TIME),
                        //Название дисциплины и тип занятия
                        getNameSubject(res.getString(Const.SCHEDULE_SUBJECT)) + "(" + getNameTypeSubject(res.getString(Const.SCHEDULE_TYPESUBJECT)) + ")",
                        //Группа
                        getNameGroup(res.getString(Const.SCHEDULE_STUDENTGROUP)),
                        //ФИО преподавателя
                        getNameTeacher(res.getString(Const.SCHEDULE_TEACHER)),
                        //Аудитория
                        getNameClassroom(res.getString(Const.SCHEDULE_CLASSROOM)));

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

    /**
     * Возвращает из таблицы преподаватели, преподавателей с заданным полом
     * @param gender - пол
     * @return список преподавателей
     */
    public HashMap<Integer,String> getListNameTeachers(String gender){
        try {

            HashMap<Integer,String> out = new HashMap<>();

            //SQL запрос, считывающий из таблицы преподаватели запись по ID
            String sql = "SELECT * FROM " + Const.TEACHER_TABLE + " WHERE " + Const.TEACHER_GENDER + " = " + "\'" + gender + "\'" +
                    " ORDER BY " + Const.TEACHER_NAME;

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                out.put(res.getInt(Const.TEACHER_ID),res.getString(Const.TEACHER_NAME));
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
     * Возвращает из таблицы аудитории, аудитории с заданным корпусом
     * @param building - корпус
     * @return список номеров аудиторий
     */
    public HashMap<Integer,String> getListNumberClassroom(String building){
        try {

            HashMap<Integer,String> out = new HashMap<>();

            //SQL запрос, считывающий из таблицы преподаватели запись по ID
            String sql = "SELECT * FROM " + Const.CLASSROOM_TABLE + " WHERE " + Const.CLASSROOM_BUIDLING + " = " + "\'" + building + "\'" +
                    " ORDER BY " + Const.CLASSROOM_NUMBER;

            ResultSet res = getDbConnection().prepareStatement(sql).executeQuery();

            while (res.next()) {
                out.put(res.getInt(Const.CLASSROOM_ID),building + "-" +res.getString(Const.CLASSROOM_NUMBER));
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
