package com.project.InternshipsManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.InternshipsManager.dto.ReviewDTO;
import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.model.Review;
import com.project.InternshipsManager.model.utils.designPattern.MarkEvaluationContext;
import com.project.InternshipsManager.model.utils.designPattern.MarkEvaluationFacade;
import com.project.InternshipsManager.model.utils.designPattern.MarkEvaluationModel;
import com.project.InternshipsManager.repository.InternEmployeeRepository;
import com.project.InternshipsManager.repository.ReviewRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private InternEmployeeRepository internEmployeeRepository;
	
	@PostMapping("/addReview")
	public ResponseEntity<String> addReview(@RequestBody ReviewDTO reviewDTO){
		
			Review review = new Review(reviewDTO.getCreateDate(), reviewDTO.getPositiveMessage(),reviewDTO.getNegativeMessage(), 
									   reviewDTO.getMark(), reviewDTO.getComment(),reviewDTO.getCriteria(), 
									   reviewDTO.getInternEmployee());
			review = reviewRepository.save(review);
			return new ResponseEntity<String>(review.toString(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteReview/{id}")
	public void deleteReview(@PathVariable Integer id) {
		reviewRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getReview(@PathVariable Integer id) {
		return new ResponseEntity<String>(reviewRepository.findById(id).get().toString(), HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Review>> getReviews() {
		var x = reviewRepository.findAll();
		for(int i = 0; i<x.size(); i++) {
			if(x.get(i).getInternEmployee() != null) {
				x.get(i).getInternEmployee().setReviews(null);
				x.get(i).getInternEmployee().setTeam(null);
				x.get(i).getInternEmployee().setInternship(null);
				x.get(i).getInternEmployee().setEquipments(null);
			}
		}
		
		return new ResponseEntity<List<Review>>(reviewRepository.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/updateReview/{id}")
	public ResponseEntity<String> updateReview(@RequestBody ReviewDTO reviewDTO, @PathVariable Integer id){
		Review currentReview = reviewRepository.findById(id).get();
		if(currentReview == null) {
			return new ResponseEntity<String>("Update review operation is not posible!",HttpStatus.BAD_REQUEST);
		}
		if(!reviewDTO.getPositiveMessage().isEmpty()) {
			currentReview.setPositiveMessage(reviewDTO.getPositiveMessage());
		}
		if(!reviewDTO.getNegativeMessage().isEmpty()) {
			currentReview.setNegativeMessage(reviewDTO.getNegativeMessage());
		}
		if(reviewDTO.getMark() != null) {
			reviewDTO.setMark(reviewDTO.getMark());
		}
		if(!reviewDTO.getComment().isEmpty()) {
			reviewDTO.setComment(reviewDTO.getComment());
		}
		if(!reviewDTO.getCriteria().isEmpty()) {
			currentReview.setCriteria(reviewDTO.getCriteria());
		}
		if(reviewDTO.getCreateDate() != null) {
			currentReview.setCreateDate(reviewDTO.getCreateDate());
		}
		if(reviewDTO.getInternEmployee() != null) {
			currentReview.setInternEmployee(reviewDTO.getInternEmployee());
		}
		currentReview = reviewRepository.save(currentReview);
		return new ResponseEntity<String>(currentReview.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/simpleMarkEvaluation/{internId}")
	public ResponseEntity<String> getSimplePerformenceFromInternReviews(@PathVariable Integer internId){
		Map<Double, String> performenceByCriteriaMap = new HashMap<>();
		InternEmployee internEmployee = internEmployeeRepository.findById(internId).get();
		List<Review> reviews = reviewRepository.findByInternEmployee(internEmployee).get();
		
		MarkEvaluationContext context = new MarkEvaluationContext(reviews);
		MarkEvaluationFacade facade = new MarkEvaluationFacade();
		performenceByCriteriaMap = facade.getInternEmployeePerformance(context, MarkEvaluationModel.SIMPLE);
		
		return new ResponseEntity<String>(performenceByCriteriaMap.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/positiveMessageMarkEvaluation/{internId}")
	public ResponseEntity<String> getPositiveMessagePerformanceFromInternReviews(@PathVariable Integer internId) {
		Map<Double, String> performenceByCriteriaMap = new HashMap<>();
		InternEmployee internEmployee = internEmployeeRepository.findById(internId).get();
		List<Review> reviews = reviewRepository.findByInternEmployee(internEmployee).get();
		
		MarkEvaluationContext context = new MarkEvaluationContext(reviews);
		MarkEvaluationFacade facade = new MarkEvaluationFacade();
		performenceByCriteriaMap = facade.getInternEmployeePerformance(context, MarkEvaluationModel.POSITIVE_MESSAGE);
		
		return new ResponseEntity<String>(performenceByCriteriaMap.toString(), HttpStatus.OK);
		
	}

}
