package com.joe.hw.domain;

/**
 * 存储信息
 * 消费信息 账务
 */
public class Accounting {

    /**
     * id
      */
    private int accountid;
    /**
     * 分类名称
     */
    private String classifi;
    //    金额
    private double money;
    //    账户名称
    private String account;
    //创建时间
    private String createtime;
    //用途描述
    private String description;

    public Accounting() {
    }

    public Accounting(int accountid, String classifi, double money, String account, String createtime, String description) {
        this.accountid = accountid;
        this.classifi = classifi;
        this.money = money;
        this.account = account;
        this.createtime = createtime;
        this.description = description;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getClassifi() {
        return classifi;
    }

    public void setClassifi(String classifi) {
        this.classifi = classifi;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
