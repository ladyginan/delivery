package com.app.controllers.rest;

public class MessageSendResponse {
    private String answer;

    public MessageSendResponse() {
    }

    public MessageSendResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "MessageSendResponse{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
