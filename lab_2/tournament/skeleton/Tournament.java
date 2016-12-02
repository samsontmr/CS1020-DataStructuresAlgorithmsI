/*
Name: Tan Min Rong Samson
Matric Number: A0140060A
*/
import java.util.*;
public class Tournament {
	private int M, N;
	private Participant[] pList;

	Tournament(){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		pList = new Participant[M];

		for (int i = 0; i < M; i++) {
			String name = sc.next();
			int card = sc.nextInt();
			pList[card] = new Participant(name, card);
		}
	}

	private int modulo(int x, int y) {
		int result = x % y;
		if (result < 0) {
			result += y;
		}
		return result;
	}

	public void changeSeats() {
		Participant[] newSeating = new Participant[M];
		for (int i = 0; i < M; i++) {
			int X = modulo(i * N, M);
			newSeating[X] = pList[i];
		}
		pList = newSeating;
	}

	public void newTurn() {
		changeSeats();
		for (int j = 0; j < M; j++) {
			Participant p = pList[j];
			Participant prev = pList[modulo(j-1,M)];
			Participant next = pList[modulo(j+1,M)];
			p.setScore(prev.getCard(), next.getCard());
		}
	}

	public void printWinner() {
		Participant winner = pList[0];
		for (Participant p: pList) {
			if (p.getScore() > winner.getScore()) {
				winner = p;
			}
		}
		System.out.println(winner.getName() + " " + winner.getScore());
	}

	public void run() {
		int turns = N;
		while (turns-- > 0) {
			newTurn();
		}
		printWinner();
	}


	public static void main(String[] args) {
		Tournament t = new Tournament();
		t.run();
	}
}

class Participant {
    //define the appropriate attributes and constructor
	private String _name;
	private int _card;
	private int _score;

	Participant(String name, int card) {
		_name = name;
		_card = card;
		_score = 0;
	}

	public String getName() {
		return _name;
	}

	public int getCard() {
		return _card;
	}

	public int getScore() {
		return _score;
	}

	public void setScore(int prevCard, int nextCard) {
		_score += prevCard + nextCard;
	}

}


