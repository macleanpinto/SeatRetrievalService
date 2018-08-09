package com.seats.component.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "requests")
public class SeatRequestDTO {
    @Id
    private String requestId;

    private String buildingId;

    private Integer floorId;

    private String bayId;

    private Integer seatCount;

    private String projectName;

    private String requestInitiator;

    private String status;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getBayId() {
        return bayId;
    }

    public void setBayId(String bayId) {
        this.bayId = bayId;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRequestInitiator() {
        return requestInitiator;
    }

    public void setRequestInitiator(String requestInitiator) {
        this.requestInitiator = requestInitiator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bayId == null) ? 0 : bayId.hashCode());
        result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
        result = prime * result + ((floorId == null) ? 0 : floorId.hashCode());
        result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((requestInitiator == null) ? 0 : requestInitiator.hashCode());
        result = prime * result + ((seatCount == null) ? 0 : seatCount.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        SeatRequestDTO other = (SeatRequestDTO)obj;
        if (bayId == null) {
            if (other.bayId != null)
                return false;
        }
        else if (!bayId.equals(other.bayId))
            return false;
        if (buildingId == null) {
            if (other.buildingId != null)
                return false;
        }
        else if (!buildingId.equals(other.buildingId))
            return false;
        if (floorId == null) {
            if (other.floorId != null)
                return false;
        }
        else if (!floorId.equals(other.floorId))
            return false;
        if (projectName == null) {
            if (other.projectName != null)
                return false;
        }
        else if (!projectName.equals(other.projectName))
            return false;
        if (requestId == null) {
            if (other.requestId != null)
                return false;
        }
        else if (!requestId.equals(other.requestId))
            return false;
        if (requestInitiator == null) {
            if (other.requestInitiator != null)
                return false;
        }
        else if (!requestInitiator.equals(other.requestInitiator))
            return false;
        if (seatCount == null) {
            if (other.seatCount != null)
                return false;
        }
        else if (!seatCount.equals(other.seatCount))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SeatRequestDTO [requestId=" + requestId + ", buildingId=" + buildingId + ", floorId="
                + floorId + ", bayId=" + bayId + ", seatCount=" + seatCount + ", projectName=" + projectName
                + ", requestInitiator=" + requestInitiator + ", status=" + status + "]";
    }

}
