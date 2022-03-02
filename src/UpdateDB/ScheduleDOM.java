package UpdateDB;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ScheduleDOM {

    private DocumentBuilder docBuilder;
    private File fileXML;

    /**
     * @param pathXML - путь к xml файлу
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public ScheduleDOM(String pathXML) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            this.fileXML = new File(pathXML);
            // создание DOM-анализатора
            docBuilder = factory.newDocumentBuilder();
            //обработчик ошибок
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    /**
     * Метод для вывода информации из xml файла в консоль
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public void print() throws SAXException, IOException {
        try {

            // parsing XML-документа и нормализация
            Document doc = docBuilder.parse(fileXML);
            doc.getDocumentElement().normalize();
            //выводим root элемент
            System.out.println("\nКорневой элемент: " + doc.getDocumentElement().getNodeName());
            // получение списка дочерних элементов <schedule>
            NodeList schedule = doc.getElementsByTagName("schedule");
            //выводим результаты
            System.out.println("Расписание:\n");
            //получаем длину списка и выводим все эти элементы в цикле
            for (int i = 0; i < schedule.getLength(); i++) {
                //берем i-го пациента списка
                Node elNodeSchedule = schedule.item(i);
                // если его дочерние узлы типа ELEMENT_NODE
                if (elNodeSchedule.getNodeType() == elNodeSchedule.ELEMENT_NODE) {

                    Element elemSchedule = (Element) elNodeSchedule;
                    //Получаем день недели и отправляем в NodeList
                    NodeList weekday = elemSchedule.getElementsByTagName("weekday");
                    Element elWeekday = (Element) weekday.item(0);
                    NodeList ResultNodeWeekday = elWeekday.getChildNodes();
                    //Получаем название предмета и отправляем в NodeList
                    NodeList subject = elemSchedule.getElementsByTagName("subject");
                    Element elSubject = (Element) subject.item(0);
                    NodeList ResultNodeSubject = elSubject.getChildNodes();
                    //Получаем название группы и отправляем в NodeList
                    NodeList group = elemSchedule.getElementsByTagName("group");
                    Element elGroup = (Element) group.item(0);
                    NodeList ResultNodeGroup = elGroup.getChildNodes();
                    //Получаем тип пары и отправляем в NodeList
                    NodeList NLtype = elemSchedule.getElementsByTagName("type");
                    Element elType = (Element) NLtype.item(0);
                    NodeList ResultNodeType = elType.getChildNodes();
                    //Получаем номер аудитории и отправляем в NodeList
                    NodeList NLclassroom = elemSchedule.getElementsByTagName("classroom");
                    Element elСlassroom = (Element) NLclassroom.item(0);
                    NodeList ResultNodeClassroom = elСlassroom.getChildNodes();
                    //Получаем ФИО преподавателя и отправляем в NodeList
                    NodeList NLteacher = elemSchedule.getElementsByTagName("teacher");
                    Element elTeacher = (Element) NLteacher.item(0);
                    NodeList ResultNodeTeacher = elTeacher.getChildNodes();
                    //Получаем начало пары и отправляем в NodeList
                    NodeList NLstartTime = elemSchedule.getElementsByTagName("starttime");
                    Element elStartTime = (Element) NLstartTime.item(0);
                    NodeList ResultNodeStartTime = elStartTime.getChildNodes();
                    //Получаем конец пары и отправляем в NodeList
                    NodeList NLendTime = elemSchedule.getElementsByTagName("endtime");
                    Element elEndTime = (Element) NLendTime.item(0);
                    NodeList ResultNodeEndTime = elEndTime.getChildNodes();

                    //Выводим значения нулевых элементов всех NodeList
                    System.out.println(((Node) ResultNodeWeekday.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeSubject.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeGroup.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeType.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeClassroom.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeTeacher.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeStartTime.item(0)).getNodeValue() + "\n"
                                        + ((Node) ResultNodeEndTime.item(0)).getNodeValue() + "\n");

                    System.out.println("-----------------------------------------");

                }
            }
            //обработчик ошибок
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    /**
     * Метод, возвращающий список полей для таблицы расписание из xml файла
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     */
    public Schedule[] readSchedule() throws SAXException, IOException {
        try {
            // parsing XML-документа и нормализация
            Document doc = docBuilder.parse(fileXML);
            doc.getDocumentElement().normalize();

            // получение списка дочерних элементов <schedule>
            NodeList schedule = doc.getElementsByTagName("schedule");

            //Массив расписаний
            Schedule[] out = new Schedule[schedule.getLength()];

            //получаем длину списка и выводим все эти элементы в цикле
            for (int i = 0; i < schedule.getLength(); i++) {
                //берем i-го пациента списка
                Node elNodeSchedule = schedule.item(i);
                // если его дочерние узлы типа ELEMENT_NODE
                if (elNodeSchedule.getNodeType() == elNodeSchedule.ELEMENT_NODE) {

                    Element elemSchedule = (Element) elNodeSchedule;
                    //Получаем день недели и отправляем в NodeList
                    NodeList weekday = elemSchedule.getElementsByTagName("weekday");
                    Element elWeekday = (Element) weekday.item(0);
                    NodeList ResultNodeWeekday = elWeekday.getChildNodes();
                    //Получаем название предмета и отправляем в NodeList
                    NodeList subject = elemSchedule.getElementsByTagName("subject");
                    Element elSubject = (Element) subject.item(0);
                    NodeList ResultNodeSubject = elSubject.getChildNodes();
                    //Получаем название группы и отправляем в NodeList
                    NodeList group = elemSchedule.getElementsByTagName("group");
                    Element elGroup = (Element) group.item(0);
                    NodeList ResultNodeGroup = elGroup.getChildNodes();
                    //Получаем тип пары и отправляем в NodeList
                    NodeList NLtype = elemSchedule.getElementsByTagName("type");
                    Element elType = (Element) NLtype.item(0);
                    NodeList ResultNodeType = elType.getChildNodes();
                    //Получаем номер аудитории и отправляем в NodeList
                    NodeList NLclassroom = elemSchedule.getElementsByTagName("classroom");
                    Element elСlassroom = (Element) NLclassroom.item(0);
                    NodeList ResultNodeClassroom = elСlassroom.getChildNodes();
                    //Получаем ФИО преподавателя и отправляем в NodeList
                    NodeList NLteacher = elemSchedule.getElementsByTagName("teacher");
                    Element elTeacher = (Element) NLteacher.item(0);
                    NodeList ResultNodeTeacher = elTeacher.getChildNodes();
                    //Получаем начало пары и отправляем в NodeList
                    NodeList NLstartTime = elemSchedule.getElementsByTagName("starttime");
                    Element elStartTime = (Element) NLstartTime.item(0);
                    NodeList ResultNodeStartTime = elStartTime.getChildNodes();
                    //Получаем конец пары и отправляем в NodeList
                    NodeList NLendTime = elemSchedule.getElementsByTagName("endtime");
                    Element elEndTime = (Element) NLendTime.item(0);
                    NodeList ResultNodeEndTime = elEndTime.getChildNodes();


                    //Заполнение элемента массива расписания
                    out[i] = new Schedule( ResultNodeWeekday.item(0).getNodeValue(),
                            ResultNodeSubject.item(0).getNodeValue(),
                            ResultNodeGroup.item(0).getNodeValue(),
                            ResultNodeType.item(0).getNodeValue(),
                            ResultNodeClassroom.item(0).getNodeValue(),
                            ResultNodeTeacher.item(0).getNodeValue(),
                            ResultNodeStartTime.item(0).getNodeValue(),
                            ResultNodeEndTime.item(0).getNodeValue());

                }
            }
            return out;
            //обработчик ошибок
        } catch (IOException e) {
            System.out.println("File error or I/O error: " + e);
            return null;
        } catch (SAXException e) {
            System.out.println("Parsing failure: " + e);
            return null;
        }

    }
}
