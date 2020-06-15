import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ServerAnswer  {
    private DatagramSocket datagramSocket = new DatagramSocket();
    public ServerAnswer() throws IOException {
    }
    public DatagramSocket getDatagramSocket(){
        return datagramSocket;
    }
    public void sendAnswer(CommandToObject commandToObjectServer) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(commandToObjectServer.answer);
        objectOutputStream.flush();
        byte[] bytes = new byte[16384];
        bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 7070);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);
        datagramSocket.close(); //не было строки этих строек
        objectOutputStream.close();

    }


}
