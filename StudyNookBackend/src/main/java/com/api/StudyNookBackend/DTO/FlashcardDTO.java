package com.api.StudyNookBackend.DTO;

public class FlashcardDTO {
    private String term;
    private String definition;
    private boolean isCorrect;

    public FlashcardDTO(){}

    public String getTerm(){return this.term;}
    public String getDefinition(){return this.definition;}
    public boolean getIsCorrect(){return this.isCorrect;}
}
