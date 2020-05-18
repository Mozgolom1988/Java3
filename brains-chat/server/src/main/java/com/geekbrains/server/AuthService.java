package com.geekbrains.server;

public interface AuthService {
    void start();
    String getNicknameByLoginAndPassword(String login, String password);
    void changeNick(String login, String password, String NickName);
    void stop();
}
