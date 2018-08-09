package com.organisation.seats.component.dto;

public class StatusDTO {

    private String msg;

    private Integer statusCd;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatusCd() {
        return this.statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((msg == null) ? 0 : msg.hashCode());
        result = prime * result + ((statusCd == null) ? 0 : statusCd.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StatusDTO other = (StatusDTO)obj;
        if (msg == null) {
            if (other.msg != null)
                return false;
        }
        else if (!msg.equals(other.msg))
            return false;
        if (statusCd == null) {
            if (other.statusCd != null)
                return false;
        }
        else if (!statusCd.equals(other.statusCd))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "StatusDTO [msg=" + msg + ", statusCd=" + statusCd + "]";
    }

}
