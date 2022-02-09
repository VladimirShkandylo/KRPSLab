package DateBase;

public class Const {

    /*
     * Константы для таблицы "Группы"
     */
    public static String GROUPS_TABLE = "studentgroups";
    public static String GROUPS_ID = "studentgroups.idstudentgroups";
    public static String GROUPS_NAME = "studentgroups.name";
    public static String GROUPS_COURSE = "studentgroups.course";
    /*
     * Константы для таблицы "Аудитории"
     */
    public static String CLASSROOM_TABLE = "classroom";
    public static String CLASSROOM_ID = "classroom.idclassroom";
    public static String CLASSROOM_NUMBER = "classroom.number";
    public static String CLASSROOM_BUIDLING = "classroom.building";
    /*
     * Константы для таблицы "Дисциплины"
     */
    public static String SUBJECT_TABLE = "subject";
    public static String SUBJECT_ID = "subject.idsubject";
    public static String SUBJECT_NAME = "subject.name";
    /*
     * Константы для таблицы "Учителя"
     */
    public static String TEACHER_TABLE = "teacher";
    public static String TEACHER_ID = "teacher.idteacher";
    public static String TEACHER_NAME = "teacher.name";
    public static String TEACHER_SUBJECT = "teacher.subject";
    /*
     * Константы для таблицы "Тип занятия"
     */
    public static String TYPESUBJECT_TABLE = "typesubject";
    public static String TYPESUBJECT_ID = "typesubject.idtypesubject";
    public static String TYPESUBJECT_NAME = "typesubject.name";
    /*
     * Константы для таблицы "Дни недели"
     */
    public static String WEEKDAY_TABLE = "weekday";
    public static String WEEKDAY_ID = "weekday.idweekday";
    public static String WEEKDAY_NAME = "weekday.name";
    /*
     * Константы для таблицы "Расписание"
     */
    public static String SCHEDULE_TABLE = "schedule";
    public static String SCHEDULE_ID = "schedule.idschedule";
    public static String SCHEDULE_WEEKDAY = "schedule.idweekday";
    public static String SCHEDULE_SUBJECT = "schedule.idsubject";
    public static String SCHEDULE_STUDENTGROUP = "schedule.idstudentgroup";
    public static String SCHEDULE_TYPESUBJECT = "schedule.idtypesubject";
    public static String SCHEDULE_CLASSROOM = "schedule.idclassroom";
    public static String SCHEDULE_TEACHER = "schedule.idteacher";
    public static String SCHEDULE_START_TIME = "schedule.starttime";
    public static String SCHEDULE_END_TIME = "schedule.endtime";
}

