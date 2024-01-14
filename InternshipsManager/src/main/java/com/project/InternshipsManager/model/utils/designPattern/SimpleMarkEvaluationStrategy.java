package com.project.InternshipsManager.model.utils.designPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.InternshipsManager.model.Review;

public class SimpleMarkEvaluationStrategy implements ReviewMarkEvaluationStrategy {
	
	@Override
	public Map<Double, String> evaluateMark(List<Review> reviews) {
		Map<Double, String> performenceByCriteriaMap = new HashMap<>();
		double performance = reviews.stream().mapToDouble(review -> review.getMark()).average().orElse(0.0);
		String criteria = String.join(",", reviews.stream().map(Review::getCriteria).toArray(String[]::new));
		performenceByCriteriaMap.put(performance, criteria);
		return performenceByCriteriaMap;
	}

}
