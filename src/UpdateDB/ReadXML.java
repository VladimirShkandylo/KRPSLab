package UpdateDB;

import java.io.*;
import org.xml.sax.SAXException;

public class ReadXML {

    private String pathXSD = "schedule.xsd";

    private String pathXML = "schedule.xml";

    public Schedule[] getScheduleFromXML(String pathXML){
        try {

            ValidatorSAX valid = new ValidatorSAX(pathXML, pathXSD);
            //Проверка на целостность
            boolean isValid = valid.isValid();

            if (isValid){
                //Вывод информации в xml файле в консоль
                ScheduleDOM scheduleDOM = new ScheduleDOM(pathXML);
                return scheduleDOM.readSchedule();
            }
            else return null;

            //обработчик ошибок
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
