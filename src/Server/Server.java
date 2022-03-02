package Server;

import DateBase.DatabaseHandler;
import UpdateDB.ReadXML;
import UpdateDB.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) throws IOException {
        //Запуск сервера
        new ServerProcess(8081);

        /*DatabaseHandler db = new DatabaseHandler();

        boolean sl = false;

        ReadXML readXML = new ReadXML();
        Schedule[] schedules = readXML.getScheduleFromXML("schedule.xml");


        for (int i = 0; i < schedules.length; i++){
            if (db.getIdSchedule(schedules[i]) == 0){
                db.addSchedule(schedules[i]);
            }
            else
                System.out.println("У данной группы уже есть расписание на это время!");
        }*/

    }
}
