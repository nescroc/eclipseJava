
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class PrimeNum {
	Random randNum;
	HashSet<Integer> randSet;
	int maxMin[];
	Iterator<Integer> iterKey;
	ArrayList<Integer> primeAr;

	public PrimeNum() {
		randNum = new Random();
		randSet = new HashSet<Integer>();
		maxMin = new int[2];
		primeAr = new ArrayList<Integer>();

	}

	// 0~부터 1000까지 랜덤한 값을 100개 중복안되게 HashSet을 통하여 전달
	public HashSet<Integer> randMaker() {
		// Random randNum = new Random();
		// HashSet<Integer> randSet = new HashSet<Integer>();
		boolean isRun = true;
		while (isRun) {
			randSet.add(randNum.nextInt(1001));
			if (randSet.size() == 100)
				isRun = false;
		}
		return randSet;
	}

	/**
	 * 최대 최소값 반환배열 메서드
	 * 
	 */
	public int[] rankPrimeNum(ArrayList<Integer> primeAr) {

		for (int i = 0; i < primeAr.size(); i++) {// 최대값, 최소값 구하는 for문

			for (int j = 0; j < primeAr.size(); j++) {
				
				if ((primeAr.get(i) - primeAr.get(j) < 0))
					break;
				if (j == primeAr.size() - 1)
					maxMin[0] = primeAr.get(i);
			}

			for (int j = 0; j < primeAr.size(); j++) {// 최소값
				if ((primeAr.get(i) - primeAr.get(j) > 0))
					break;
				if (j == primeAr.size() - 1)
					maxMin[1] = primeAr.get(i);
			}
		} // 최대값, 최소값 구하는 for문 종료
		return maxMin;
	}

	/**
	 * 출력할때 상단 부분
	 */
	public void printText() {
		System.out.println("=======================");
		System.out.println("미래크립토 소수 판단 프로그램");
		System.out.println("\t\t\t-나일성");
		System.out.println("=======================");

	}

	/**
	 * printText를 오버로딩해 결과값을 출력해주는 메서드
	 */
	public void printText(int arLength, int[] maxMin) {
		System.out.println("------------------");
		System.out.println("소수개수 : " + arLength);
		System.out.println("최대 소수 : " + maxMin[0] + "\n최소 소수 : " + maxMin[1]);
		System.out.println("------------------");
	}

	public void programRun() {
		randSet = randMaker();// Random값을 메서드에 담을 HashSet
		iterKey = randSet.iterator();// HashSet을 정렬하여 담을 공간
		// while문을 통하여 소수만 넣을 공간
		printText();// System.out.println을 빼서 따로 만듬
		while (iterKey.hasNext()) {// 랜덤메이커에서 받은 0부터 1000까지의 난수를 hashset으로 받고,iterator로 변환하여 while문으로 소수인지 확인
			int primeCount = 0;// 약수의 개수 총 구하는 지역변수
			int iterVal = iterKey.next();

			for (int i = 1; i <= iterVal; i++) {// 랜덤숫자 한개가 소수인지 확인
				if (iterVal % i == 0) // iterKey.next()가 1부터 iterKey.next() 자기 자신 까지 약수가 2개이면 소수이기때문에 카운트
					primeCount++;
				if (primeCount > 2)
					break;
			} // for문종료
			if (primeCount == 2) {// 소수일시 ArrayList에 담아준다
				primeAr.add(iterVal);
				System.out.println("소수 발견 : " + iterVal);
			} // 소수인
		} // while문 종료
		System.out.println("------------------");
		maxMin = rankPrimeNum(primeAr);// 최소값 최대값 반환 배열 메서드
		printText(primeAr.size(), maxMin);

	}

	public static void main(String[] args) {
		PrimeNum pn = new PrimeNum();
		pn.programRun();

	}

}
