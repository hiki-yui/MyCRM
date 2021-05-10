package com.zs.hiki.settings.domain;

/**
 * 成员表
 */
public class Member {
    private String id;

    private String mName;

    private String gender;//性别

    private String regDate;//入团时间

    private String mWork;//当前职责

    private String classroom;//所在班级

    private String head;//领导人

    private String creator;//创建人

    private String editor;//修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getMWork() {
        return mWork;
    }

    public void setMWork(String mWork) {
        this.mWork = mWork;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Member() {
    }

    public Member(String id, String mName,String gender, String regDate, String mWork, String classroom, String head, String creator, String editor) {
        this.id = id;
        this.mName = mName;
        this.gender = gender;
        this.regDate = regDate;
        this.mWork = mWork;
        this.classroom = classroom;
        this.head = head;
        this.creator = creator;
        this.editor = editor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        if (id != null ? !id.equals(member.id) : member.id != null) return false;
        if (mName != null ? !mName.equals(member.mName) : member.mName != null) return false;
        if (gender != null ? !gender.equals(member.gender) : member.gender != null) return false;
        if (regDate != null ? !regDate.equals(member.regDate) : member.regDate != null) return false;
        if (mWork != null ? !mWork.equals(member.mWork) : member.mWork != null) return false;
        if (classroom != null ? !classroom.equals(member.classroom) : member.classroom != null) return false;
        if (head != null ? !head.equals(member.head) : member.head != null) return false;
        if (creator != null ? !creator.equals(member.creator) : member.creator != null) return false;
        return editor != null ? editor.equals(member.editor) : member.editor == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + (mWork != null ? mWork.hashCode() : 0);
        result = 31 * result + (classroom != null ? classroom.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", mName='" + mName + '\'' +
                ", gender='" + gender + '\'' +
                ", regDate='" + regDate + '\'' +
                ", mWork='" + mWork + '\'' +
                ", classroom='" + classroom + '\'' +
                ", head='" + head + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}
