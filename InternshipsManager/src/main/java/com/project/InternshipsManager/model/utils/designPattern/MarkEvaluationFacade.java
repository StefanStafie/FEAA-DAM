package com.project.InternshipsManager.model.utils.designPattern;

import java.util.Map;

public class MarkEvaluationFacade {
	public Map<Double, String> getInternEmployeePerformance(MarkEvaluationContext context, MarkEvaluationModel model){
		ReviewMarkEvaluationStrategy reviewMarkEvaluationStrategy = ReviewEvaluationMark.getIntance().getEvaluationStrategy(model);
		context.setStrategy(reviewMarkEvaluationStrategy);
		return  context.getMapWithMarksEvaluation();
	}

}
