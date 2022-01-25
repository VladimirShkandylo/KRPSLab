package Server;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        //Запуск сервера
        new ServerProcess(8080);
    }
}
