package io.pivotal.pal.tracker.repository;

import io.pivotal.pal.tracker.TimeEntry;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> repository = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId() == 1L || !repository.containsKey(timeEntry.getId())) {
            long largestId = repository.size() > 0 ? repository.keySet().stream().max(Long::compare).get() : 0;
            timeEntry.setId(++largestId);
            repository.put(timeEntry.getId(), timeEntry);
        }

        return timeEntry;
    }

    public TimeEntry find(long id) {
        return repository.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(repository.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (repository.containsKey(id)) {
            repository.put(timeEntry.getId(), timeEntry);
            return timeEntry;
        }

        return null;
    }

    public void delete(long id) {
        repository.remove(id);
    }
}
