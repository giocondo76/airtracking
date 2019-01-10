package com.nc.service;

public interface SecurityService {
    //поиск залогиненных пользователей
    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
