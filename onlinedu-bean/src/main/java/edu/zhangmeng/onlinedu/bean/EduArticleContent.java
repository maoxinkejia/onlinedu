package edu.zhangmeng.onlinedu.bean;

import java.io.Serializable;

public class EduArticleContent implements Serializable {
    private Integer articleId;

    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}