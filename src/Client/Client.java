package Client;

import DateBase.DatabaseHandler;

import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        //Запуск клиента
        new ClientProcess("localhost",8080);
    }

}
