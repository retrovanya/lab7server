package CommandsProcessing;

import AnswerSender.ServerAnswerNew;
import PersonData.AllException;
import AnswerSender.CommandToObjectServer;
import java.io.IOException;
import java.sql.SQLException;
import static CommandsProcessing.Commands.*;
import static CommandsProcessing.Receiver.*;

public class Control extends Thread {
    Thread thread;
    Commands comm = new Commands();
    public Control() throws IOException, AllException {
    }
    public void run() {
        try{
            sarray = s.trim().split(" ", 2);
            switch (sarray[0]) {
                case "help":
                    CommandToObjectServer help = new CommandToObjectServer("help", help());
                    ServerAnswerNew.commandToObjectServers.addLast(help);
                    new ServerAnswerNew();
                    break;
                case "info":
                    CommandToObjectServer info = new CommandToObjectServer("info", info());
                    ServerAnswerNew.commandToObjectServers.addLast(info);
                    new ServerAnswerNew();
                    break;
                case "show":
                    CommandToObjectServer show = new CommandToObjectServer("show", show());
                    ServerAnswerNew.commandToObjectServers.addLast(show);
                    new ServerAnswerNew();
                    break;
                case "updateId":
                    CommandToObjectServer updateId = new CommandToObjectServer("updateId", String.valueOf(comm.updateId(g, flattt)));//эти переменные считываются программой как нулевые
                    ServerAnswerNew.commandToObjectServers.addLast(updateId);
                    new ServerAnswerNew();
                    break;
                case "removeById":
                    CommandToObjectServer removeById = new CommandToObjectServer("removeById", comm.removeById(g));
                    ServerAnswerNew.commandToObjectServers.addLast(removeById);
                    break;
                case "add":
                    CommandToObjectServer add = new CommandToObjectServer("add",add(flattt));
                    ServerAnswerNew.commandToObjectServers.addLast(add);
                    new ServerAnswerNew();
                    break;
                case "removeGreater":
                    CommandToObjectServer removeGr = new CommandToObjectServer("removeGreater", comm.removeGreater(g));
                    ServerAnswerNew.commandToObjectServers.addLast(removeGr);
                    new ServerAnswerNew();
                    break;
                case "removeLower":
                    CommandToObjectServer removeLow = new CommandToObjectServer("removeLower", comm.removeLower(g));
                    ServerAnswerNew.commandToObjectServers.addLast(removeLow);
                    new ServerAnswerNew();
                    break;
                case "countByRooms":
                    CommandToObjectServer cbr = new CommandToObjectServer("countByRooms", comm.countByRooms(g));
                    ServerAnswerNew.commandToObjectServers.addLast(cbr);
                    new ServerAnswerNew();
                    break;
                case "history":
                    CommandToObjectServer hist = new CommandToObjectServer("history", historyR);
                    ServerAnswerNew.commandToObjectServers.addLast(hist);
                    new ServerAnswerNew();
                    break;
                case "removeByHouseAge":
                    CommandToObjectServer rbha  = new CommandToObjectServer("removeByHouseAge", comm.removeByHouseAge(g));
                    ServerAnswerNew.commandToObjectServers.addLast(rbha);
                    new ServerAnswerNew();
                    break;
                case "clear":
                    CommandToObjectServer clear = new CommandToObjectServer("clear", clear());
                    ServerAnswerNew.commandToObjectServers.addLast(clear);
                    new ServerAnswerNew();
                    break;
            }
        }catch (IOException | SQLException | AllException e){
            e.printStackTrace();
        }
    }
}