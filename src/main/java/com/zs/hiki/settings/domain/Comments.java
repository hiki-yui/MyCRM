package com.zs.hiki.settings.domain;

/**
 * 评论表
 */
public class Comments {
    private String id;

    private String activityId;//所属活动的id

    private String comment;//评论内容

    private String outTime;//发表时间

    private Integer zan;//赞的数量

    private Integer cai;//踩的数量

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getCai() {
        return cai;
    }

    public void setCai(Integer cai) {
        this.cai = cai;
    }

    public Comments() {
    }

    public Comments(String id, String activityId, String comment, String outTime, Integer zan, Integer cai) {
        this.id = id;
        this.activityId = activityId;
        this.comment = comment;
        this.outTime = outTime;
        this.zan = zan;
        this.cai = cai;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id='" + id + '\'' +
                ", activityId='" + activityId + '\'' +
                ", comment='" + comment + '\'' +
                ", outTime='" + outTime + '\'' +
                ", zan=" + zan +
                ", cai=" + cai +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comments)) return false;

        Comments comments = (Comments) o;

        if (id != null ? !id.equals(comments.id) : comments.id != null) return false;
        if (activityId != null ? !activityId.equals(comments.activityId) : comments.activityId != null) return false;
        if (comment != null ? !comment.equals(comments.comment) : comments.comment != null) return false;
        if (outTime != null ? !outTime.equals(comments.outTime) : comments.outTime != null) return false;
        if (zan != null ? !zan.equals(comments.zan) : comments.zan != null) return false;
        return cai != null ? cai.equals(comments.cai) : comments.cai == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (zan != null ? zan.hashCode() : 0);
        result = 31 * result + (cai != null ? cai.hashCode() : 0);
        return result;
    }

}
