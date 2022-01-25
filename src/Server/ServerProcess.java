package Server;

import java.io.*;
import java.net.*;

public class ServerProcess extends Thread{

    /**
     * Порт
     */
    private int port;
    /**
     * Сокет сервера
     */
    private ServerSocket serverSocket;
    /**
     * Сокет
     */
    private Socket socket;
    /**
     * Чтение сообщения от клиента
     */
    private BufferedReader in;
    /**
     * Отправка сообщения клиенту
     */
    private PrintWriter out;
    /**
     * Ответы от сервера*/
    private Sender sender;

    public ServerProcess(int port) {
        this.port = port;
        sender = new Sender();

        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            System.out.println("Подключился клиент");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        }catch (IOException ex){
            System.out.println(ex);
        }
        //Запуск сервера
        start();
    }

    @Override
    public void run() {

        while (true) {
            try {
                String str = in.readLine();
                System.out.println("client : " + str);
                String send = sender.getGroup(str);
                out.println(send);
                out.flush();
            }catch (IOException ex){
                System.out.print(ex);
            }
        }
    }

}
