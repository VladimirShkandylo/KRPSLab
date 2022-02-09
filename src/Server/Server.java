package Server;

import DateBase.DatabaseHandler;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        //Запуск сервера
        new ServerProcess(8080);
    }
}
