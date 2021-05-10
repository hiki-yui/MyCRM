package com.zs.hiki.settings.domain;

/**
 * 主任务
 */
public class BigWork {
    private String id;

    private String head;//负责人

    private String introution;//介绍

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

    public String getIntroution() {
        return introution;
    }

    public void setIntroution(String introution) {
        this.introution = introution;
    }

    public BigWork() {
    }

    public BigWork(String id, String head, String introution) {
        this.id = id;
        this.head = head;
        this.introution = introution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BigWork)) return false;

        BigWork bigWork = (BigWork) o;

        if (id != null ? !id.equals(bigWork.id) : bigWork.id != null) return false;
        if (head != null ? !head.equals(bigWork.head) : bigWork.head != null) return false;
        return introution != null ? introution.equals(bigWork.introution) : bigWork.introution == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (introution != null ? introution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BigWork{" +
                "id='" + id + '\'' +
                ", head='" + head + '\'' +
                ", introution='" + introution + '\'' +
                '}';
    }
}
