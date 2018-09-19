package io.pivotal.pal.tracker.repository;

import io.pivotal.pal.tracker.TimeEntry;
import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry find(long id);

    List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry any);

    void delete(long id);
}
