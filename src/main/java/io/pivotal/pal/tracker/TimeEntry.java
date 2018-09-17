package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {

    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int i) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = i;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this(1L, projectId, userId, date, hours);
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {

        boolean isEqual = false;

        if (obj instanceof TimeEntry) {
            TimeEntry entry = (TimeEntry) obj;
            isEqual = entry.getId() == getId()
                    && entry.getProjectId() == getProjectId()
                    && entry.getDate().isEqual(getDate())
                    && entry.getUserId() == getUserId()
                    && entry.getHours() == getHours();
        }

        return isEqual;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
