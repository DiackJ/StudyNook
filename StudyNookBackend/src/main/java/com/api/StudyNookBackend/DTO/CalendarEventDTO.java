package com.api.StudyNookBackend.DTO;

import java.util.Date;

public class CalendarEventDTO {
    private String title;
    private Date date;
    private String optionalDescription;

    public CalendarEventDTO(){}

    public String getTitle(){return this.title;}
    public String getOptionalDescription(){return this.optionalDescription;}
    public Date getDate(){return this.date;}
}
