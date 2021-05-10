package com.zs.hiki.settings.domain;

/**
 * 缺席表
 */
public class NotArrivedL {
    private String id;//成员id

    private String why;//缺席理由

    private String date;//缺席时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NotArrivedL() {
    }

    public NotArrivedL(String id, String why, String date) {
        this.id = id;
        this.why = why;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotArrivedL)) return false;

        NotArrivedL that = (NotArrivedL) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (why != null ? !why.equals(that.why) : that.why != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (why != null ? why.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NotArrivedL{" +
                "id='" + id + '\'' +
                ", why='" + why + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
