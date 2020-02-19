package ru.iambelyaev.coincontolserver.restapi.service;

import ru.iambelyaev.coincontolserver.restapi.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Создает нового клиента
     * @param Category - клиент для создания
     */
    void create(Category Category);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Category> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Category read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param Category - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Category Category, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);
}
