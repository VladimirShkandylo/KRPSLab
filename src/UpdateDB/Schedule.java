package UpdateDB;

import java.util.Arrays;

/**
 * Класс расписание для хранения данных из XML файла
 */
public class Schedule {

    private String weekday;
    private String subject;
    private String group;
    private String type;
    private String[] classroom;
    private String teacher;
    private String starttime;
    private String endtime;

    public Schedule(String weekday, String subject, String group, String type, String classroom, String teacher, String starttime, String endtime) {
        this.weekday = weekday;
        this.subject = subject;
        this.group = group;
        this.type = type;
        this.teacher = teacher;
        this.starttime = starttime;
        this.endtime = endtime;

        this.classroom = classroom.split("-");

    }

    public String getWeekday() {
        return weekday;
    }

    public String getSubject() {
        return subject;
    }

    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }

    public String getClassRoomNumber() {
        return classroom[1];
    }

    public String getClassRoomBuilding() {
        return classroom[0];
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "weekday='" + weekday + '\'' +
                ", subject='" + subject + '\'' +
                ", group='" + group + '\'' +
                ", type='" + type + '\'' +
                ", classroom=" + Arrays.toString(classroom) +
                ", teacher='" + teacher + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}
