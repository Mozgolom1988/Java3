package com.geekbrains.client;

import java.io.*;
import java.util.LinkedList;

public class ChatLog {

    private BufferedReader chatLogReader;
    private FileWriter chatLogWriter;
    private LinkedList<String> chatlog;
    private String chatFileName;

    public ChatLog (String chatFileName, int chatlogSize) {
        this.chatlog = new LinkedList<>();
        this.chatFileName = chatFileName;

        try {
            chatLogReader = new BufferedReader(new FileReader(this.chatFileName));
            String str;
            while((str = chatLogReader.readLine()) != null) {
                chatlog.add(str);
                if(chatlog.size() > chatlogSize) chatlog.remove();
            }
            chatLogReader.close();
        } catch (FileNotFoundException e ) {

        } catch (IOException e) {
            e.printStackTrace();
        };

    }

    public String[] getStrings() {
        String[] strings = new String[chatlog.size()];
        chatlog.toArray(strings);
        return strings;
    }

    public boolean wrieString (String str) {
        try (FileWriter chatLogWriter = new FileWriter(chatFileName, true)) {
            chatLogWriter.write(str);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public void closeChat(){

        try {
            chatLogWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            chatLogWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
