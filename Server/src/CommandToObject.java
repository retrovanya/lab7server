import java.io.Serializable;

public class CommandToObject implements Serializable {
    private String command;
    String answer;
    public CommandToObject(String command, String answer){
        this.command = command;
        this.answer = answer;
    }
    public String getCommand(){
        return command;
    }
    public String getAnswer(){
        return answer;
    }
}