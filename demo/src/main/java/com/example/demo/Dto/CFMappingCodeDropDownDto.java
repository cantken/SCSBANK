package com.example.demo.Dto;


public class CFMappingCodeDropDownDto {
	
		private String codeType;

	    private String codeNo;

	    private String codeDesc;


		/**
		 * @return the codeNo
		 */
		public String getCodeNo() {
			return codeNo;
		}

		public String getCodeType() {
			return codeType;
		}

		public void setCodeType(String codeType) {
			this.codeType = codeType;
		}

		/**
		 * @param codeNo the codeNo to set
		 */
		public void setCodeNo(String codeNo) {
			this.codeNo = codeNo;
		}

		/**
		 * @return the codeDesc
		 */
		public String getCodeDesc() {
			return codeDesc;
		}

		/**
		 * @param codeDesc the codeDesc to set
		 */
		public void setCodeDesc(String codeDesc) {
			this.codeDesc = codeDesc;
		}
		
		@Override
		public String toString() {
		    return "FunctionDto{" +
		           "codeNo='" + codeNo + '\'' +
		           ", codeNo='" + codeNo + '\'' +
		           '}';
		}


}
