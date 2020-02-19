package ru.iambelyaev.coincontolserver.restapi.model;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String name;
    private String subName;
}

