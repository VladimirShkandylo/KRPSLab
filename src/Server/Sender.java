package Server;

import DateBase.DatabaseHandler;

public class Sender {

    private DatabaseHandler dbHandler;

    public Sender() {
        dbHandler = new DatabaseHandler();
    }

    public String getGroup(String id){
        return dbHandler.getNameGroup(Integer.parseInt(id));
    }
}
