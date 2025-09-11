package com.cvs.pbm.adjudication.dto;

public class ErrorDetail {

    // Private fields to store the error details
    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;

    public ErrorDetail(String type, String title, int status, String detail, String instance) {
        this.type = type;
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.instance = instance;
    }

    // --- Getter Methods ---

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public String getInstance() {
        return instance;
    }

    // --- Setter Methods ---

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}

