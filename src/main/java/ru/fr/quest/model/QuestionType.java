package ru.fr.quest.model;

public enum QuestionType {
    MULTI_ANSWER("multiAnswerQuestionMapperImpl", "userMultiAnswerMapperImpl"),
    SINGLE_ANSWER("answerQuestionMapperImpl", "userSingleAnswerMapperImpl"),
    TEXT_ANSWER("textAnswerMapperImpl", "userTextAnswerMapperImpl");

    private final String mapperName;
    private final String mapperAnswerName;

    QuestionType(String mapperName, String mapperAnswerName) {
        this.mapperName = mapperName;
        this.mapperAnswerName = mapperAnswerName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public String getMapperAnswerName() {
        return mapperAnswerName;
    }
}
