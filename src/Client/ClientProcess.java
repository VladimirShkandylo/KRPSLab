package Client;

import java.io.*;
import java.net.Socket;

public class ClientProcess {

    /**
     * Хост
     */
    private String host;
    /**
     * Порт
     */
    private int port;
    /**
     * Имя клиента
     */
    private String name;
    /**
     * Сокет
     */
    private Socket socket;
    /**
     * Ввод сообщения клиента
     */
    private BufferedReader inputUser;
    /**
     * Вывод сообщения от клиента
     */
    private PrintWriter out;
    /**
     * Чтение сообщения от сервера
     */
    private BufferedReader in;

    public ClientProcess(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            socket = new Socket(this.host, this.port);
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException ex){
            //Прерываем сессию
            ClientProcess.this.downService();
        }

        new ReadMsg().start();
        new WriteMsg().start();
    }


    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {

            while (true) {
                try {
                    String str = in.readLine();
                    System.out.println("server : " + str);
                } catch (IOException ex) {
                    //Прерываем сессию
                    ClientProcess.this.downService();
                }
            }
        }
    }

    public class WriteMsg extends Thread {

        @Override
        public void run() {

            while (true){
                try {
                    String message = inputUser.readLine();
                    out.println(message);
                    out.flush();
                }catch (IOException ex){
                    //Прерываем сессию
                    ClientProcess.this.downService();
                }
            }
        }
    }
}
