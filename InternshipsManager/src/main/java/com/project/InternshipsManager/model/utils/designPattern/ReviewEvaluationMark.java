package com.project.InternshipsManager.model.utils.designPattern;

public class ReviewEvaluationMark {
private static ReviewEvaluationMark intance;
	
	private ReviewEvaluationMark() {}

	public static ReviewEvaluationMark getIntance() {
		if( intance == null ) {
			intance = new ReviewEvaluationMark();
		}
		return intance;
	}
	
	public ReviewMarkEvaluationStrategy getEvaluationStrategy(MarkEvaluationModel model) {
		switch (model) {
			case SIMPLE:
				return new SimpleMarkEvaluationStrategy();
			case POSITIVE_MESSAGE:
				return new PositiveMessageMarkEvaluationStrategy();
			default:
				throw new IllegalArgumentException("Unknown model of evaluation mark");
		}
	}

}
