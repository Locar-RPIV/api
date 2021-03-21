package com.apirestful.Locar.model;

public class Notification {
    private String emailToSend;
    private String partnerName;
    private String vehicleModel;
    private String vehiclePlate;
    private String branch;

    @Override
    public String toString() {
        return "{" +
            " emailToSend='" + getEmailToSend() + "'" +
            ", partnerName='" + getPartnerName() + "'" +
            ", vehicleModel='" + getVehicleModel() + "'" +
            ", vehiclePlate='" + getVehiclePlate() + "'" +
            ", branch='" + getBranch() + "'" +
            "}";
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getVehicleModel() {
        return this.vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehiclePlate() {
        return this.vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getPartnerName() {
        return this.partnerName;
    }

    public String getEmailToSend() {
        return this.emailToSend;
    }

    public void setEmailToSend(String emailToSend) {
        this.emailToSend = emailToSend;
    }
}
