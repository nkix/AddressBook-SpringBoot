package com.servingwebcontent;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNum;

    public BuddyInfo(){

    }

    public BuddyInfo(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Long getId(){ return id; }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString(){
        return ("id: "+ id + ", name: " + name + ", phone number: " + phoneNum);
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null) return false;
        if(this==obj) return true;
        if(getClass() != obj.getClass()) return false;
        BuddyInfo b2 = (BuddyInfo)obj;
        if(b2.getName().equals(name) && b2.getPhoneNum().equals(phoneNum)) return true;
        return false;
    }

}
