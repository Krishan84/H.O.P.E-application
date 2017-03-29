package com.bsaitm.krishanpal.hope;

/**
 * Created by krishan pal on 3/29/2017.
 */

public class Users {
    String id;
    String username;
    String emailaddress;
    String address;
    String phonenumber;
    String description;
    public Users(){

    }
    public Users( String id,String username,String emailaddress,String address,String phonenumber,String description){
        this.username=username;
        this.id=id;
        this.emailaddress=emailaddress;
        this.address=address;
        this.phonenumber=phonenumber;
        this.description=description;
    }
    public String id(){
        return id;
    }
    public String getUsername(){
      return username;
    }
    public String getEmailaddress(){
        return emailaddress;
    }
    public String getAddress(){
        return address;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public String getDescription(){
        return description;
    }



}
