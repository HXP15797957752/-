package cn.bluedot.core.domain;

import cn.bluedot.core.service.user.validation.annotation.Email;
import cn.bluedot.core.service.user.validation.annotation.Length;
import cn.bluedot.core.service.user.validation.annotation.NotNull;

public class User{
    /**工号,ID号,账号*/
    @NotNull
    @Length(min=6, max=32)
    private String userNo;
    /**邮箱 */
    @Email
    private String email;
    /** */
    @NotNull
    @Length(min=11, max=11)
    private String phoneNumber;
    /** */
    @NotNull
    @Length(min=1, max=16)
    private String password;
    /** */
    private String trueName;
    /** */
    @NotNull
    private Integer sex;
    /**' COMMENT '身份证*/
    @NotNull
    @Length(min=18, max=18)
    private String IDCard;
    /**头像url*/
    private String headPortraitUrl;
    /**注册日期*/
    private java.util.Date createDate;
    /**生效日期*/
    private java.util.Date effectiveDate;
    /**个人简介*/
    private String personalProfile;
    /**密保问题*/
    private String question;
    /** */
    private String answer;
    /**审核状态*/
    private Integer state;
    /**审核批注*/
    private String reviewAnnotation;
    public void setUserNo(String userNo){
        this.userNo = userNo;
    }
    public String getUserNo(){
        return this.userNo;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setTrueName(String trueName){
        this.trueName = trueName;
    }
    public String getTrueName(){
        return this.trueName;
    }
    public void setSex(Integer sex){
        this.sex = sex;
    }
    public Integer getSex(){
        return this.sex;
    }
    public void setIDCard(String IDCard){
        this.IDCard = IDCard;
    }
    public String getIDCard(){
        return this.IDCard;
    }
    public void setHeadPortraitUrl(String headPortraitUrl){
        this.headPortraitUrl = headPortraitUrl;
    }
    public String getHeadPortraitUrl(){
        return this.headPortraitUrl;
    }
    public void setCreateDate(java.util.Date createDate){
        this.createDate = createDate;
    }
    public java.util.Date getCreateDate(){
        return this.createDate;
    }
    public void setEffectiveDate(java.util.Date effectiveDate){
        this.effectiveDate = effectiveDate;
    }
    public java.util.Date getEffectiveDate(){
        return this.effectiveDate;
    }
    public void setPersonalProfile(String personalProfile){
        this.personalProfile = personalProfile;
    }
    public String getPersonalProfile(){
        return this.personalProfile;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }
    public void setState(Integer state){
        this.state = state;
    }
    public Integer getState(){
        return this.state;
    }
    public void setReviewAnnotation(String reviewAnnotation){
        this.reviewAnnotation = reviewAnnotation;
    }
    public String getReviewAnnotation(){
        return this.reviewAnnotation;
    }
    @Override
    public String toString() {
        return "User [userNo=" + userNo + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
                + ", trueName=" + trueName + ", sex=" + sex + ", IDCard=" + IDCard + ", headPortraitUrl="
                + headPortraitUrl + ", createDate=" + createDate + ", effectiveDate=" + effectiveDate
                + ", personalProfile=" + personalProfile + ", question=" + question + ", answer=" + answer + ", state="
                + state + ", reviewAnnotation=" + reviewAnnotation + "]";
    }
    
}