package com.zs.hiki.settings.domain;

/**
 * 线索表
 */
public class Cule {

    private String id;

    private String name;//姓名

    private Long phone;//手机

    private String email;//邮箱

    private String cform;//所属公司/学校/班级

    public Cule() {
    }

    public Cule(String id, String name, Long phone, String email, String cform) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cform = cform;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCform() {
        return cform;
    }

    public void setCform(String cform) {
        this.cform = cform;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cule)) return false;

        Cule cule = (Cule) o;

        if (id != null ? !id.equals(cule.id) : cule.id != null) return false;
        if (name != null ? !name.equals(cule.name) : cule.name != null) return false;
        if (phone != null ? !phone.equals(cule.phone) : cule.phone != null) return false;
        if (email != null ? !email.equals(cule.email) : cule.email != null) return false;
        return cform != null ? cform.equals(cule.cform) : cule.cform == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cform != null ? cform.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cule{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", cform='" + cform + '\'' +
                '}';
    }
}
