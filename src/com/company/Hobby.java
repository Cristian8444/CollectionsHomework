package com.company;

import java.util.List;
import java.util.Objects;

public class Hobby {
    public String nameOfHobby;
    public int frequency;
    public List<String> Addresses;


    public  Hobby(String nameOfHobby, int frequency, List<String> addresses){
        this.nameOfHobby = nameOfHobby;
        this.Addresses = addresses;
        this.frequency = frequency;

    }


    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<String> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<String> addresses) {
        Addresses = addresses;
    }


//    @Override
//    public int hashCode(){
//        return Objects.hash(nameOfHobby);
//    }
//    @Override
//    public int compareTo(Hobby o) {
//        return this.nameOfHobby.compareTo(o.nameOfHobby);
//    }

    @Override
    public boolean equals(Object b){
    if(this == b) return true;
        if(!(b instanceof Hobby)) return false;
    Hobby hb =(Hobby) b;
    return nameOfHobby.equals(hb.nameOfHobby);
    }
}
