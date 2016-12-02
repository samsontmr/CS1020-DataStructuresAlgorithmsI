import java.util.*;

class Knob {

	// Data attributes
	boolean isOn;      // is the device on?
	String currPos;    // current position of knob
	String targetPos;  // target position of knob

	// Constructor
	public Knob(boolean state, String newCurrPos, String newTargetPos) { 
		isOn = state;
		currPos = newCurrPos;
		targetPos = newTargetPos;
		// fill in the code
	}

	// Determine whether the device is on or off after num moves
	public boolean deviceIsOn(int num) {
		// fill in the code
		if (num%2 == 0) {
			return isOn;
		} else {
			return !isOn;
		}
	}

	// Compute the least number of moves to turn the knob
	public int numOfMoves() {                       
		int numCurrPos = 0;
		int numTargetPos = 0;

		if (currPos.equals("up")) {
			numCurrPos = 1;
		} else if (currPos.equals("right")) {
			numCurrPos = 2;
		} else if (currPos.equals("down")) {
			numCurrPos = 3;
		} else if (currPos.equals("left")) {
			numCurrPos = 4;
		} 
		
		if (targetPos.equals("up")) {
			numTargetPos = 1;
		} else if (targetPos.equals("right")) {
			numTargetPos = 2;
		} else if (targetPos.equals("down")) {
			numTargetPos = 3;
		} else if (targetPos.equals("left")) {
			numTargetPos = 4;
		} 
		
		if (numTargetPos - numCurrPos < 0) {
			return 4 - Math.abs(numTargetPos - numCurrPos); // this is a stub
		} else if (numTargetPos - numCurrPos == 0) {
			return 4;
		} else {
			return numTargetPos - numCurrPos;
		}

	}
}

