package com.project.InternshipsManager.model.utils.designPattern;

import java.util.List;
import java.util.Map;

import com.project.InternshipsManager.model.Review;

public class MarkEvaluationContext {
	private ReviewMarkEvaluationStrategy strategy;
    private List<Review> reviews;
    
	public MarkEvaluationContext( List<Review> reviews ) {
		this.reviews = reviews;
	}

	public ReviewMarkEvaluationStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ReviewMarkEvaluationStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Map<Double, String> getMapWithMarksEvaluation(){
		return strategy.evaluateMark(reviews);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
