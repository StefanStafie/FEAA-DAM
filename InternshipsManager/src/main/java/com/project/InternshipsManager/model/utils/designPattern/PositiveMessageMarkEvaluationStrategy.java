package com.project.InternshipsManager.model.utils.designPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.InternshipsManager.model.Review;

public class PositiveMessageMarkEvaluationStrategy implements ReviewMarkEvaluationStrategy {
	
	@Override
	public Map<Double, String> evaluateMark(List<Review> reviews) {
		Map<Double, String> performenceByCriteriaMap = new HashMap<>();
		String criteria = String.join(",", reviews.stream().map(Review::getCriteria).toArray(String[]::new));
		double performance = reviews.stream().mapToDouble(review -> review.getMark()).average().orElse(0.0);
		String[] positiveMessages = reviews.stream().filter(review -> review.getPositiveMessage() != null).map(Review::getPositiveMessage).toArray(String[]::new);
		String[] negativeMessages = reviews.stream().filter(review -> review.getNegativeMessage() != null).map(Review::getNegativeMessage).toArray(String[]::new);
		double levelOfPositiveMessage = (double) (positiveMessages.length )/ (positiveMessages.length + negativeMessages.length);
		performenceByCriteriaMap.put(performance * levelOfPositiveMessage, criteria);
		return performenceByCriteriaMap;
	}

}
