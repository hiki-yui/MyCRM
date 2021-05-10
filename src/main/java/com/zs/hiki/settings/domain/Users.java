package com.zs.hiki.settings.domain;


public class Users {
    private String id;
    private String loginAct;//登录账号
    private String userName;
    private String email;
    private String passWord;
    private String phone;
    private String expireTime;//失效时间
    private String allowIps;//允许访问的ip
    private String createTime;//注册事件
    private String createBy;//创建人
    private String editTime;//修改时间
    private String editBy;//修改人
    private Member member;

    /*
     *一般验证登录不止需要验证账号的有无,还要验证其他信息例如(是否被封/过期/失效/该客户端ip是否允许访问)
     *验证失败一般抛出自定义的异常
     *一般密码不会以明文的方式保存在数据库表中,一般以加密的方式保存
     *我在这个项目下放置了一个工具包用于加密信息(MD5Utils),使用getMD5传入信息就可以获取加密信息
     *MD5是一种全世界普遍使用的加密算法,加密后的暗文不能转变为明文,加密信息不可被破解
     *加密属于数学界的应用
     *
     * */

    public Users() {
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (loginAct != null ? !loginAct.equals(users.loginAct) : users.loginAct != null) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (passWord != null ? !passWord.equals(users.passWord) : users.passWord != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (expireTime != null ? !expireTime.equals(users.expireTime) : users.expireTime != null) return false;
        if (allowIps != null ? !allowIps.equals(users.allowIps) : users.allowIps != null) return false;
        if (createTime != null ? !createTime.equals(users.createTime) : users.createTime != null) return false;
        if (createBy != null ? !createBy.equals(users.createBy) : users.createBy != null) return false;
        if (editTime != null ? !editTime.equals(users.editTime) : users.editTime != null) return false;
        if (editBy != null ? !editBy.equals(users.editBy) : users.editBy != null) return false;
        return member != null ? member.equals(users.member) : users.member == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginAct != null ? loginAct.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (expireTime != null ? expireTime.hashCode() : 0);
        result = 31 * result + (allowIps != null ? allowIps.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (editBy != null ? editBy.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        return result;
    }
}
