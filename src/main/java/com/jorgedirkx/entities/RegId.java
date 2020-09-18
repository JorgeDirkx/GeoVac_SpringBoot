package com.jorgedirkx.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegId implements Serializable {

    private final long serialVersionUID = 1L;

    private int clientId;
    private int vaccineId;


    public RegId(){}

    public RegId(int clientId, int vaccineId) {
        this.clientId = clientId;
        this.vaccineId = vaccineId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegId other = (RegId) obj;
        return Objects.equals(getClientId(), other.getClientId()) && Objects.equals(getVaccineId(), other.getVaccineId());
    }


}
