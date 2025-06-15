package com.myproject.model;

import lombok.Data;

public class Message {
    private String content;
    private boolean isUser;

    // 必须有默认构造函数
    public Message() {}

    public Message(String content, boolean isUser) {
        this.content = content;
        this.isUser = isUser;
    }

    // 必须有 getter 和 setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}