package com.ssm.entity;

import java.sql.Date;

public class Language {
    String language_id;
    String name;
    Date last_update;

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public Language(){}

    public Language(String language_id, String name, Date last_update) {
        this.language_id = language_id;
        this.name = name;
        this.last_update = last_update;
    }
}
