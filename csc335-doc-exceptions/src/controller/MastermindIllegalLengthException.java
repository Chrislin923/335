package controller;


public class MastermindIllegalLengthException extends Exception{
		public MastermindIllegalLengthException(String message) {
			super(message);
		}
		public String toString() {
			return "MastermindIllegalLengthException:" + getMessage();
		}
	}