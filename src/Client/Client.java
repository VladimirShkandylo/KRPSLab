package Client;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    public static void main(String[] args) throws IOException {
        //Запуск клиента
        new ClientProcess("localhost",8080);
    }

}
