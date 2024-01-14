package com.project.InternshipsManager.model.utils.designPattern;

import java.util.List;
import java.util.Map;

import com.project.InternshipsManager.model.Review;

public interface ReviewMarkEvaluationStrategy {
	Map<Double, String> evaluateMark(List<Review> reviews);
}
