package com.zs.hiki.settings.domain;

public class T_newMember {
    private String id;

    private String applicationDate;

    private String recommender;

    private String introution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public String getIntroution() {
        return introution;
    }

    public void setIntroution(String introution) {
        this.introution = introution;
    }

    public T_newMember() {
    }

    public T_newMember(String id, String applicationDate, String recommender, String introution) {
        this.id = id;
        this.applicationDate = applicationDate;
        this.recommender = recommender;
        this.introution = introution;
    }

    @Override
    public String toString() {
        return "T_newMember{" +
                "id='" + id + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", recommender='" + recommender + '\'' +
                ", introution='" + introution + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof T_newMember)) return false;

        T_newMember that = (T_newMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applicationDate != null ? !applicationDate.equals(that.applicationDate) : that.applicationDate != null)
            return false;
        if (recommender != null ? !recommender.equals(that.recommender) : that.recommender != null) return false;
        return introution != null ? introution.equals(that.introution) : that.introution == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applicationDate != null ? applicationDate.hashCode() : 0);
        result = 31 * result + (recommender != null ? recommender.hashCode() : 0);
        result = 31 * result + (introution != null ? introution.hashCode() : 0);
        return result;
    }
}
