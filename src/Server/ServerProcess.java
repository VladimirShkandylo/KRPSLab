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
    private Response response;

    public ServerProcess(int port) {
        this.port = port;
        response = new Response();

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            System.out.println("Подключился клиент");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        }catch (IOException ex){
            //Прерываем сессию
            downService();
            System.out.println("Порт " + port + " занят");
            System.exit(1);
        }
        //Запуск сервера
        start();
    }

    private void downService() {
        try {
            socket.close();
            in.close();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                String send = response.getMessage();
                out.println(send);
                out.flush();
                String str = in.readLine();
                System.out.println("client : " + str);
                response.setAnswer(str);
            }catch (IOException ex){
                System.out.println("1234");
                System.out.print(ex);
            }
        }
    }

}
