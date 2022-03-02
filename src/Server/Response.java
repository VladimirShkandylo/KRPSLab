package Server;

import DateBase.DatabaseHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Response {

    //Связь с БД
    private DatabaseHandler dbHandler;
    //Сообщения от сервера
    private String messages[];
    //Текущее сообщение
    private int tec;
    //Ответы пользователя
    private String answers[];
    //Группы по второму запросу
    private HashMap<Integer,String> req;
    //Тип(1 - группа, 2 - преподаватель, 3 - аудитория)
    private int type;
    //Сообщения для 1 типа
    private String mesGroup[];
    //Сообщения для 2 типа
    private String mesTeacher[];
    //Сообщения для 3 типа
    private String mesClassroom[];


    public Response() {
        dbHandler = new DatabaseHandler();
        tec = 0;
        messages = new String[6];
        makeMesGroup();
        makeMesTeacher();
        makeMesClassroom();
        messages[0] = "Категория расписания:\n1) Группа\n2) Преподаватель\n3) Аудитория";
        messages[1] = "";
        messages[2] = "";
        messages[3] = "По дате или на неделю?\n1) По дате\n2) На неделю";
        messages[4] = "Введите дату:\n";
        messages[5] = "Расписание на ";
        answers = new String[messages.length];
    }

    public String getList(String choice){

        if (type == 1)
            req = dbHandler.getNameGroups(Integer.parseInt(choice));
        else if (type == 2)
            if (choice.equals("1"))
                req = dbHandler.getListNameTeachers("Ж");
            else
                req = dbHandler.getListNameTeachers("М");
        else
            if (choice.equals("1"))
                req = dbHandler.getListNumberClassroom("А");
            else if (choice.equals("2"))
                req = dbHandler.getListNumberClassroom("Б");
            else if (choice.equals("3"))
                req = dbHandler.getListNumberClassroom("В");
            else if (choice.equals("4"))
                req = dbHandler.getListNumberClassroom("Г");
            else if (choice.equals("5"))
                req = dbHandler.getListNumberClassroom("Д");
            else
                req = dbHandler.getListNumberClassroom("Е");

        ArrayList<Integer> keys = new ArrayList<>(req.keySet());

        String out = "";

        for (int i = 0; i < req.size(); i++) {
            out += (i + 1) + ") " + req.get(keys.get(i)) + "\n";
        }

        return out;
    }

    public String getSchedule(String choice){

        int ch = Integer.parseInt(choice);

        ArrayList<Integer> keys = new ArrayList<>(req.keySet());

        return dbHandler.getSchedule(keys.get(ch - 1),type);
    }

    public String getScheduleDate(String choice, int week){

        int ch = Integer.parseInt(choice);

        ArrayList<Integer> keys = new ArrayList<>(req.keySet());

        return dbHandler.getSchedule_Date(keys.get(ch - 1),week,type);
    }

    public String getMessage(){

        if (tec >= messages.length){
            return "";
        }

        if (tec == 1) {

            try{
                type = Integer.parseInt(answers[tec - 1]);

                if (type < 1 || type > 3) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }

            if (type == 1) {
                messages[1] = mesGroup[0];
                messages[2] = mesGroup[1];
            }
            if (type == 2) {
                messages[1] = mesTeacher[0];
                messages[2] = mesTeacher[1];
            }
            if (type == 3) {
                messages[1] = mesClassroom[0];
                messages[2] = mesClassroom[1];
            }
            return messages[tec];
        }

        if (tec == 2) {

            int sl = 1;

            try{
                sl = Integer.parseInt(answers[tec - 1]);
                int gran = 5;
                if (type == 1) gran = 5;
                if (type == 2) gran = 2;
                if (type == 3) gran = 6;

                if (sl< 1 || sl > gran) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }
            return messages[tec] + getList(sl + "");
        }

        if (tec == 3) {
            try{

                int sl = Integer.parseInt(answers[tec - 1]);


                if (sl< 1 || sl > req.size()) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }
            return messages[tec];
        }

        if (tec == 4) {

            int sl = Integer.parseInt(answers[tec - 1]);

            try{

                if (sl< 1 || sl > 2) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }

            if (sl == 1)
                return messages[tec];
            if (sl == 2)
                return getSchedule(answers[tec - 2]);
        }

        if (tec == 5) {

            int dayweek = getId_DayWeek(answers[tec - 1]);

            return messages[tec] + answers[tec-1] + "\n" + getScheduleDate(answers[tec - 3],dayweek);
        }


        return messages[tec];
    }

    public void setAnswer(String str){

        if ("back".equalsIgnoreCase(str)){
            backMessage();
            return;
        }

        if (tec >= messages.length) return;

        answers[tec] = str;

        tec++;


    }

    public void backMessage(){
        if (tec > 0)
            tec--;
    }

    private int getId_DayWeek(String d){
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");

        Date date;
        try {
            date = ft.parse(d);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int id = cal.get(Calendar.DAY_OF_WEEK);
            if (id == 1) return 7;
            else return id - 1;
        }catch (ParseException e) {
            System.out.println("Дата введена не верно!");
            return 0;
        }
    }

    private void makeMesGroup(){

        mesGroup = new String[2];
        mesGroup[0] = "Выберите курс:\n1) 1\n2) 2\n3) 3\n4) 4\n5) 5";
        mesGroup[1] = "Выберите группу:\n";

    }

    private void makeMesTeacher(){

        mesTeacher = new String[2];
        mesTeacher[0] = "Выберите пол:\n1) Ж\n2) М";
        mesTeacher[1] = "Выберите преподавателя:\n";

    }

    private void makeMesClassroom(){

        mesClassroom = new String[2];
        mesClassroom[0] = "Выберите корпус:\n1) А\n2) Б\n3) В\n4) Г\n5) Д\n6) E";
        mesClassroom[1] = "Выберите аудиторию:\n";

    }


}
