package calculator.src;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        if (args.length < 1) {
            System.out.println("Input <hostname>:<port>");
            System.exit(-1);
        }

        String[] input = args[0].split(":");
        String host = input[0];
        Integer port = Integer.parseInt(input[1]);

        Socket socket = new Socket(host, port);

        Console cons = System.console();

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        while (true) {
            String command = cons.readLine("> ");
            dos.writeUTF(command);
            dos.flush();

            if (command.equals("end")) {
                dos.close();
                os.close();
                dis.close();
                is.close();
                break;
            }

            String result = dis.readUTF();
            System.out.println(result);
        }

        socket.close();
    }
}
