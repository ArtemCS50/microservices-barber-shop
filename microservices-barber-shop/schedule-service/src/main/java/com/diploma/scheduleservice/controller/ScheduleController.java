package com.diploma.scheduleservice.controller;

import com.diploma.scheduleservice.dto.ScheduleDTO;
import com.diploma.scheduleservice.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDto) {
        return scheduleService.createSchedule(scheduleDto);
    }

    @GetMapping("/{id}")
    public ScheduleDTO getScheduleById(@PathVariable("id") Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public ScheduleDTO updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleDTO scheduleDto) {
        return scheduleService.updateSchedule(id, scheduleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchedule(@PathVariable("id") Long id) {
        scheduleService.deleteSchedule(id);
    }
}
