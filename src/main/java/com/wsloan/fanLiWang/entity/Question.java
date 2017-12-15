package com.wsloan.fanLiWang.entity;

public class Question {

    /**
     * 问题序号
     * */
    private  int ID;
    /**
     * 常见问题标题
     * */
    private String questionTitle;

    /**
     * 常见问题内容
     * */
    private String questionContent;


    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + ID +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                '}';
    }
}
