package com.servingwebcontent;

import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<BuddyInfo> buddyList = new ArrayList<BuddyInfo>();

    public AddressBook(){

    }

    public Long getId(){
        return id;
    }


    public List<BuddyInfo> getBuddyList(){
        return buddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList){
        this.buddyList = buddyList;
    }

    public int size(){
        return buddyList.size();
    }

    public void addBuddy(BuddyInfo buddy){
        this.buddyList.add(buddy);
    }

    public void deleteBuddy(BuddyInfo buddy){
        for(int i=0, len=buddyList.size(); i<len; i++){
            if(buddy.equals(buddyList.get(i))){
                buddyList.remove(i);
                len--;
                i--;
            }
        }
    }

    public void printBuddyInfo(){
        for(BuddyInfo b:buddyList){
            System.out.println(b.toString());
        }
    }

}

