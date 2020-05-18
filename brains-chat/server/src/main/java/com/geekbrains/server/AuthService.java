package com.geekbrains.server;

public interface AuthService {
    void start();
    String getNicknameByLoginAndPassword(String login, String password);
    void changeNick(String oldNickName, String NickName);
    void stop();
}
