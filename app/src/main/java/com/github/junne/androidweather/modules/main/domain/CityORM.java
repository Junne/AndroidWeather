package com.github.junne.androidweather.modules.main.domain;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by baijf on 15/01/2017.
 * Email: junnebai@163.com
 */
@Table("weather_city")
public class CityORM {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    @NotNull
    private String name;
    public CityORM(String name) { this.name = name;}
    public int getId() { return id;}
    public String getName() { return name; }
}
