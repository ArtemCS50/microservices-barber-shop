package com.diploma.feedbackservice.service;

import com.diploma.feedbackservice.dto.FeedbackDTO;
import com.diploma.feedbackservice.exeption.FeedbackNotFoundException;
import com.diploma.feedbackservice.model.Feedback;
import com.diploma.feedbackservice.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
//    private final EmailService emailService;

    public FeedbackDTO createFeedback(FeedbackDTO feedbackDto) {
        Feedback feedback = mapToFeedbackEntity(feedbackDto);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        sendFeedbackRequestEmail(savedFeedback.getClientId());
        return mapToFeedbackDto(savedFeedback);
    }

    public FeedbackDTO getFeedbackById(Long feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with ID: " + feedbackId));
        return mapToFeedbackDto(feedback);
    }

    public FeedbackDTO updateFeedback(Long feedbackId, FeedbackDTO feedbackDto) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback not found with ID: " + feedbackId));

        existingFeedback.setRating(feedbackDto.getRating());
        existingFeedback.setComment(feedbackDto.getComment());

        Feedback updatedFeedback = feedbackRepository.save(existingFeedback);
        return mapToFeedbackDto(updatedFeedback);
    }

    public void deleteFeedback(Long feedbackId) {
        if (!feedbackRepository.existsById(feedbackId)) {
            throw new FeedbackNotFoundException("Feedback not found with ID: " + feedbackId);
        }
        feedbackRepository.deleteById(feedbackId);
    }

    private Feedback mapToFeedbackEntity(FeedbackDTO feedbackDto) {
        return new Feedback(feedbackDto.getId(), feedbackDto.getClientId(), feedbackDto.getServiceId(),
                feedbackDto.getRating(),feedbackDto.getComment());
    }

    private FeedbackDTO mapToFeedbackDto(Feedback feedback) {
        return new FeedbackDTO(feedback.getId(), feedback.getClientId(), feedback.getServiceId(),
                feedback.getRating(), feedback.getComment());
    }

    private void sendFeedbackRequestEmail(Long clientId) {
        // Implement the logic to send a feedback request email to the client
        // using the EmailService or an external email service provider
    }

}
