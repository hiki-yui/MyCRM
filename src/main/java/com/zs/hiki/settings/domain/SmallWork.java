package com.zs.hiki.settings.domain;

/**
 * 分支任务表
 */
public class SmallWork {

    private String id;

    private String bigWorkId;

    private String name;

    private String head;

    private String introution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBigWorkId() {
        return bigWorkId;
    }

    public void setBigWorkId(String bigWorkId) {
        this.bigWorkId = bigWorkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public SmallWork() {
    }

    public SmallWork(String id, String bigWorkId, String name, String head, String introution) {
        this.id = id;
        this.bigWorkId = bigWorkId;
        this.name = name;
        this.head = head;
        this.introution = introution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmallWork)) return false;

        SmallWork smallWork = (SmallWork) o;

        if (id != null ? !id.equals(smallWork.id) : smallWork.id != null) return false;
        if (bigWorkId != null ? !bigWorkId.equals(smallWork.bigWorkId) : smallWork.bigWorkId != null) return false;
        if (name != null ? !name.equals(smallWork.name) : smallWork.name != null) return false;
        if (head != null ? !head.equals(smallWork.head) : smallWork.head != null) return false;
        return introution != null ? introution.equals(smallWork.introution) : smallWork.introution == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bigWorkId != null ? bigWorkId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (introution != null ? introution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SmallWork{" +
                "id='" + id + '\'' +
                ", bigWorkId='" + bigWorkId + '\'' +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", introution='" + introution + '\'' +
                '}';
    }
}
