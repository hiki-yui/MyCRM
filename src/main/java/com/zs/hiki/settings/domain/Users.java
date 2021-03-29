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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users that = (Users) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passWord != null ? !passWord.equals(that.passWord) : that.passWord != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
