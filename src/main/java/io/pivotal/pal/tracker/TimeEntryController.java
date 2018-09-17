package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @GetMapping("/create")
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        return new ResponseEntity<>(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<TimeEntry> read(long l) {
        TimeEntry foundEntry = timeEntryRepository.find(l);
        if (foundEntry != null) {
            return new ResponseEntity<>(foundEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity update(long l, TimeEntry expected) {
        TimeEntry updatedEntry = timeEntryRepository.update(l, expected);
        if (updatedEntry != null) {
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<TimeEntry> delete(long l) {
        timeEntryRepository.delete(l);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
