package com.diploma.scheduleservice.service;

import com.diploma.scheduleservice.dto.ScheduleDTO;
import com.diploma.scheduleservice.exeption.ScheduleNotFoundException;
import com.diploma.scheduleservice.model.Schedule;
import com.diploma.scheduleservice.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDto) {
        Schedule schedule = mapDtoToSchedule(scheduleDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return mapScheduleToDto(savedSchedule);
    }

    public ScheduleDTO getScheduleById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found with id: " + scheduleId));
        return mapScheduleToDto(schedule);
    }

    public ScheduleDTO updateSchedule(Long scheduleId, ScheduleDTO scheduleDto) {
        Schedule existingSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found with id: " + scheduleId));

        Schedule updatedSchedule = mapDtoToSchedule(scheduleDto);
        updatedSchedule.setId(existingSchedule.getId());

        Schedule savedSchedule = scheduleRepository.save(updatedSchedule);
        return mapScheduleToDto(savedSchedule);
    }

    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    private Schedule mapDtoToSchedule(ScheduleDTO scheduleDto) {
        return new Schedule(
                scheduleDto.getId(),
                scheduleDto.getMasterId(),
                scheduleDto.getStartTime(),
                scheduleDto.getEndTime(),
                scheduleDto.getStatus()

        );
    }

    private ScheduleDTO mapScheduleToDto(Schedule schedule) {
        return new ScheduleDTO(
                schedule.getId(),
                schedule.getMasterId(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getStatus()
        );
    }
}

