package org.dmitrysulman.rest.RestAppProject.dto;

public class RainyDaysCountDto {
    private long rainyDaysCount;

    public RainyDaysCountDto() {
    }

    public RainyDaysCountDto(long rainyDaysCount) {
        this.rainyDaysCount = rainyDaysCount;
    }

    public long getRainyDaysCount() {
        return rainyDaysCount;
    }

    public void setRainyDaysCount(long rainyDaysCount) {
        this.rainyDaysCount = rainyDaysCount;
    }
}
