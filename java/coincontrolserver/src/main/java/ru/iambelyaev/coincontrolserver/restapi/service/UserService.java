package ru.iambelyaev.coincontrolserver.restapi.service;

import ru.iambelyaev.coincontrolserver.restapi.model.User;

import java.util.List;

public interface UserService {
    /**
     * Создает новую категорию
     * @param User - категория для создания
     */
    void create(User User);

    /**
     * Возвращает список всех имеющихся категорий
     * @return список категорий
     */
    List<User> readAll();

    /**
     * Возвращает категорию по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
//    User read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param User - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
//    boolean update(User User, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
//    boolean delete(int id);
}
