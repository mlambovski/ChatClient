/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myro
 */
public class Client {

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket socket;
    private ClientGUI gui;
    private String server, username;
    private int port;
    private int fileTransferPort;
    private ServerSocket fileInputSocket;
    private Socket fileOutputSocket;
    private ObjectInputStream fileInputStream;
    private ObjectOutputStream fileOutputStream;
    private Random rand = new Random();

    Client(String server, int port, String username, ClientGUI gui) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.gui = gui;
        this.fileTransferPort = rand.nextInt(100) + 1500;
    }

    public void runClient() {
        connectToServer();
        getStreams();
        processConnection();
    }

    private void connectToServer() {
        try {
            socket = new Socket(server, port);
        } catch (Exception ec) {
            display("Error connectiong to server:" + ec);
        }

        String msg = username + " Succesfully registered ";
        display(msg);
    }

    private void getStreams() {
        try {
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            display("Exception creating new Input/output Streams: " + eIO);
        }
    }

    private void processConnection() {
        new ServerListener().start();
        new FileTransferListener().start();
        try {
            output.writeObject(username + " " + fileTransferPort);
        } catch (IOException eIO) {
            display("Exception during login : " + eIO);
            closeConnection();
        }
    }

    public synchronized void receiveFile() throws IOException, ClassNotFoundException {
        Socket sendingClientSocket = fileInputSocket.accept();
        fileInputStream = new ObjectInputStream(sendingClientSocket.getInputStream());
        FileInfo receivedFile = (FileInfo) fileInputStream.readObject();
        FileOutputStream fos = new FileOutputStream(receivedFile.getFileName());
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] byteArr = new byte[receivedFile.getByteArr().length];
        byte[] receivingBytes = receivedFile.getByteArr();
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = receivingBytes[i];
        }
        bos.write(byteArr, 0, byteArr.length);
        bos.close();
        sendingClientSocket.close();
    }

    public void sendFile(File file, int recipientPort) throws IOException {
        fileOutputSocket = new Socket(server, recipientPort);
        byte[] byteArr = new byte[(int) file.length()];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        bis.read(byteArr, 0, byteArr.length);
        fileOutputStream = new ObjectOutputStream(fileOutputSocket.getOutputStream());
        FileInfo fileToSend = new FileInfo(byteArr, file.getName());
        fileOutputStream.writeObject(fileToSend);
        fileOutputStream.flush();
        fileOutputSocket.close();
    }

    private void display(String msg) {
        if (gui == null) {
            System.out.println(msg);
        } else {
            gui.append(msg + "\n");
        }
    }

    void sendMessage(ChatMessage msg) {
        try {
            output.writeObject(msg);
        } catch (IOException e) {
            display("Exception writing to server: " + e);
        }
    }

    private void closeConnection() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (Exception e) {
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (Exception e) {
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }
        gui.connectionFailed();
    }

    class ServerListener extends Thread {

        public void run() {
            while (true) {
                try {
                    String message = (String) input.readObject();
                    gui.append(message);
                } catch (IOException e) {
                    display("Server has close the connection: " + e);
                    if (gui != null) {
                        gui.connectionFailed();
                    }
                    break;
                } catch (ClassNotFoundException e2) {
                }
            }
        }
    }

    class FileTransferListener extends Thread {

        public void run() {
            try {
                fileInputSocket = new ServerSocket(fileTransferPort, 1);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (true) {
                try {
                    receiveFile();
                } catch (IOException e) {
                    display("Server has close the connection: " + e);
                    gui.connectionFailed();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
