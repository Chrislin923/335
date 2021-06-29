package controller;

public class MastermindIllegalColorException extends Exception{
		public MastermindIllegalColorException(String message) {
			super(message);
		}
		public String toString() {
			return "MastermindIllegalColorException:" + getMessage();
		}
	}