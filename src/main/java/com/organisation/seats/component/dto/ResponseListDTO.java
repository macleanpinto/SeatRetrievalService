package com.organisation.seats.component.dto;

import java.util.List;

public class ResponseListDTO<T> extends StatusDTO {

    private List<T> results;

    private Integer totalRecords;

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
        this.totalRecords = results.size();
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((totalRecords == null) ? 0 : totalRecords.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseListDTO other = (ResponseListDTO)obj;
        if (totalRecords == null) {
            if (other.totalRecords != null)
                return false;
        }
        else if (!totalRecords.equals(other.totalRecords))
            return false;
        return true;
    }

}
