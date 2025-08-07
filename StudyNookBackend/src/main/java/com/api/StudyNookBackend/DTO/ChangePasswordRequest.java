package com.api.StudyNookBackend.DTO;

public class ChangePasswordRequest {
    private String newPassword;
    private String confirmNewPassword;

    public ChangePasswordRequest(){}

    public String getNewPassword(){return this.newPassword;}
    public String getConfirmNewPassword(){return this.confirmNewPassword;}
}
