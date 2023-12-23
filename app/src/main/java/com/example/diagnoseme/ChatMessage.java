package com.example.diagnoseme;

public class ChatMessage {
    private String message;
    private MessageType messageType;

    public ChatMessage(String message, MessageType messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public MessageType getMessageType() {
        return messageType;
    }

    enum MessageType{
        OUTGOING,
        INCOMING
    }
}



