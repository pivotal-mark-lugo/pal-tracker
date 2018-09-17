package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> repository = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {
        if (repository.containsKey(timeEntry.getId())) {
            long largestId = repository.keySet().stream().max(Long::compare).get();
            timeEntry.setId(++largestId);
        }
        repository.put(timeEntry.getId(), timeEntry);

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
