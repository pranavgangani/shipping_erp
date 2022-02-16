package com.shipping.model.crew;

public class Nominee {
	private int nomineeId;
	private String nomineeName;
	private RelationType relationType;
	
	
	public enum RelationType{
		MOTHER(1,""),
		FATHER(2,""),
		SISTER(3,""),
		BROTHER(4,""),
		DAUGHTER(5,""),
		SON(6,""),
		WIFE(7,""),
		HUSBAND(8,""),
		COUSIN(9,""),
		GRANDMOTHER(10,""),
		GRANDFATHER(11,"");
		
		private int relationTypeId;
		private String relationTypeName;
		
		RelationType(int relationTypeId, String relationTypeName) {
			this.relationTypeId = relationTypeId;
			this.relationTypeName = relationTypeName;
		}

		public int getRelationTypeId() {
			return relationTypeId;
		}

		public String getRelationTypeName() {
			return relationTypeName;
		}
		
	}
}
