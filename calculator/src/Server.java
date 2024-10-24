package calculator.src;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Input <port>");
            System.exit(-1);
        }

        Integer port = Integer.parseInt(args[0]);

        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Got a connection");

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
    
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            while (true) {
                String command = dis.readUTF();
                if (command.equals("end")) {
                    dos.close();
                    os.close();
                    dis.close();
                    is.close();
                    break;
                }
                command = command.replace(" ", "");
                String[] numbers = command.split("[+-/*%^]");
                //System.out.println(Arrays.toString(numbers));
                String operator = command.replaceAll("[0-9]", "");
                //System.out.println(operator);
                Double result = null;
                
                switch (operator) {
                    case "+":
                        result = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                        break;
                    case "-":
                        result = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                        break;
                    case "*":
                        result = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                        break;
                    case "^":
                    case "**":
                        result = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                        break;
                    case "/":
                        result = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                        break;
                    case "%":
                        result = Double.parseDouble(numbers[0]) % Double.parseDouble(numbers[1]);
                        break;
                    default:
                        dos.writeUTF("Invalid Operation. Please try again.");
                        dos.flush();
                        continue;
                }

                dos.writeUTF(String.valueOf(result));
                dos.flush();
            }
            socket.close();
            break;
        }
        server.close();
    }
}
