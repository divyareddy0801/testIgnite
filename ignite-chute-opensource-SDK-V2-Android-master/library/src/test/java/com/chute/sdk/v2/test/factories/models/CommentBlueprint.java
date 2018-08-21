package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.CommentModel;

public class CommentBlueprint {

	public static CommentModel create() {
		CommentModel model = new CommentModel();
		model.setCommentText("This is my comment");
		model.setName("Comment Name");
		model.setEmail("olga@getchute.com");
		return model;
	}
}