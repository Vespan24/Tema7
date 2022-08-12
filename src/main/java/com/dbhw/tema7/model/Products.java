package com.dbhw.tema7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {

    @Id
    @GeneratedValue
    Integer Id;
    String name;
    String identificationCode;
    Type type;
    Integer stock;
    Boolean deleted;

    private boolean isDeleted(){
        if(this.deleted==true)
            return true;
        else
            return false;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
