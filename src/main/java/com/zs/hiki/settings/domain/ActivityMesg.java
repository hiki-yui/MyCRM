package com.zs.hiki.settings.domain;

import java.util.List;

/**
 * 活动信息表
 */
public class ActivityMesg {
    private String id;//活动的id

    private String head;//负责人

    private String message;//信息

    private List<Comments> comments;//评论

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public ActivityMesg() {
    }



    public ActivityMesg(String id, String head, String message, List<Comments> comments) {
        this.id = id;
        this.head = head;
        this.message = message;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ActivityMesg{" +
                "id='" + id + '\'' +
                ", head='" + head + '\'' +
                ", message='" + message + '\'' +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityMesg)) return false;

        ActivityMesg that = (ActivityMesg) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (head != null ? !head.equals(that.head) : that.head != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return comments != null ? comments.equals(that.comments) : that.comments == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
