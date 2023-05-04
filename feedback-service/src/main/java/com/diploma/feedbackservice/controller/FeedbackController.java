package com.diploma.feedbackservice.controller;

import com.diploma.feedbackservice.dto.FeedbackDTO;
import com.diploma.feedbackservice.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackDTO createFeedback(@RequestBody FeedbackDTO feedbackDto) {
        return feedbackService.createFeedback(feedbackDto);
    }

    @GetMapping("/{id}")
    public FeedbackDTO getFeedbackById(@PathVariable("id") Long feedbackId) {
        return feedbackService.getFeedbackById(feedbackId);
    }

    @PutMapping("/{id}")
    public FeedbackDTO updateFeedback(@PathVariable("id") Long feedbackId, @RequestBody FeedbackDTO feedbackDto) {
        return feedbackService.updateFeedback(feedbackId, feedbackDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeedback(@PathVariable("id") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }
}
