package Server;

import DateBase.DatabaseHandler;

import java.util.ArrayList;
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
    //Группы по курсу
    private HashMap<Integer,String> groups;


    public Response() {
        dbHandler = new DatabaseHandler();
        tec = 0;
        messages = new String[3];
        messages[0] = "Введите свой курс, число от 1 до 5:";
        messages[1] = "Выберите свою группу:\n";
        messages[2] = "Расписание группы ";
        answers = new String[messages.length];
    }

    public String getGroups(String course){

        groups = dbHandler.getNameGroups(Integer.parseInt(course));

        ArrayList<Integer> keys = new ArrayList<>(groups.keySet());

        String out = "";

        for (int i = 0; i < groups.size(); i++) {
            out += (i + 1) + ") " + groups.get(keys.get(i));
        }

        return out;
    }

    public String getSchedule(String choice){

        int ch = Integer.parseInt(choice);

        ArrayList<Integer> keys = new ArrayList<>(groups.keySet());

        return dbHandler.getNameGroup(keys.get(ch - 1)) + "\n" + dbHandler.getSchedule(keys.get(ch - 1));
    }

    public String getMessage(){

        if (tec >= messages.length){
            return "";
        }

        if (tec == 1) {
            try{

                int course = Integer.parseInt(answers[tec - 1]);

                if (course < 1 || course > 5) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }
            return messages[tec] + getGroups(answers[tec - 1]);
        }
        if (tec == 2) {
            try{

                int group = Integer.parseInt(answers[tec - 1]);

                if (group< 1 || group > groups.size()) {
                    backMessage();
                    return "Введено не верное число! Повторите ввод";
                }

            }catch (NumberFormatException ex){
                backMessage();
                return "Введено не число! Повторите ввод!";
            }
            return messages[tec] + getSchedule(answers[tec - 1]);
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

}
