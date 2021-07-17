

import java.io.*;

public class IdNumInspector {
	private String idNum;// 주민번호 멤버
	private BufferedReader br;
	private int[] total;// 정상 입력 횟수, 오류 입력 횟수, 비정상 입력횟수
	private boolean isRun;
	private int[] tempIdNum;// 주민번호 규격에 정확히 들어오면 담을 배열
	private final int[] CHECK_ARR = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

	public IdNumInspector() {
		br = new BufferedReader(new InputStreamReader(System.in));
		total = new int[3];// 결과창을 출력해줄 메서드에 결과 정보가 담긴 배열
		isRun = false;
		idNum = "";
		tempIdNum = new int[13];
	}

	public void start() throws IOException {
		printText();
		while (!isRun) {
			try {//비정상 입력 메시지(36번 라인)가 26번보다 늦게 호출되서 0.1초 지연걸어 보았습니다
				Thread.sleep(100);
				System.out.print(">> 데이터 입력: ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//입력받은 스트링에 공백을 지웁니다.
			idNum = br.readLine().replace(" ", "").replace("\t", "");
			if (idNum.equals("exit")) {// while문 탈출조건
				exitText();
				isRun = true;
			}else if (idNum.length() == 14) {
				inspectNum(idNum);
			} else {
				System.err.println("-을 제외하고 모두 0 ~ 9 숫자이어야 합니다.");
				total[2] += 1;
			}
			
		}

	}

	public void inspectNum(String idNum) {

		boolean idChAt6 = idNum.charAt(6) == '-' ? true : false;
		String sub1 = idNum.substring(0, 6);
		String sub2 = idNum.substring(7);

		if (idChAt6) {// 총글자수가 14글자이며, 하이픈 자리에 하이픈이 있나
			try {
				toIntChar(sub1, sub2);//자른 string을 int 형으로 변형하는 메서드
				// 어디까지했냐면 분해해서 배열까지 넣음
			} catch (NumberFormatException nfe) {
				System.err.println("-을 제외하고 모두 0 ~ 9 숫자이어야 합니다.");
				total[2] += 1;
			}
			int idEachNumTotal = 0;
			for (int i = 0; i < 12; i++) {
				idEachNumTotal += (CHECK_ARR[i] * tempIdNum[i]);
			}
			boolean finalBool = (11 - (idEachNumTotal % 11) == tempIdNum[12]) ? true : false;
			if (finalBool) {
				total[0] += 1;
				System.out.println("[검증 성공] 정상적인 주민번호이며 오류가 없습니다!");
			} else {
				total[1] += 1;
				System.err.println("[검증 실패] 주민 번호 수치상의 오류가 있습니다.");
			}

		} else {
			System.err.println("주민번호는 oooooo-ooooooo 하이픈 포함 14자리 입니다.");
			total[2] += 1;
		}
	}
	//자른 string을 int 형으로 변환하고, 유효한 주민번호인지 검사
	public void toIntChar(String sub1, String sub2) {

		for (int i = 0; i < sub1.length(); i++) {
			// tempIdNum[i] = Integer.parseInt(""+sub1.charAt(i));
			tempIdNum[i] = Integer.parseInt(Character.toString(sub1.charAt(i)));

		}
		for (int i = 0; i < sub2.length(); i++) {
			// tempIdNum[i] = Integer.parseInt(""+sub1.charAt(i));
			tempIdNum[i + 6] = Integer.parseInt(Character.toString(sub2.charAt(i)));
		}
	}

	public void printText() {
		System.out.println("==============================\r\n" + "미래크립토 주민번호 검증 및 집계 프로그램\r\n" + "-나일성\r\n"
				+ "==============================");
		System.out.println("* 주민번호 입력 (oooooo-ooooooo 하이픈 포함 14자리" + ", exit 입력시 종료)");
	}

	/**
	 * 결과창 출력 정상 주민 번호 배열의 0번지, 오류 주민번호 1번지, 비정상 입력 2번지, 총 입력 건수 배열의 3번지
	 */
	public void exitText() {
		int totalSum = 0;
		for (int i : total) {
			totalSum += i;
		}
		/*
		 * float fl1 = total[0]/(float)totalSum; float fl2 = total[1]/(float)totalSum;
		 * float fl3 = total[2]/(float)totalSum;
		 */
		System.out.println("-총 입력 건수: " + totalSum + "건");
		System.out.println("-정상 주민번호: " + total[0] + "건" + textPercent(total[0], totalSum));
		System.out.println("-오류 주민번호: " + total[1] + "건" + textPercent(total[1], totalSum));
		System.out.println("-비정상 입력: " + total[2] + "건" + textPercent(total[2], totalSum));
		System.out.println();

	}
	//결과를 퍼센트로 String으로 변환해줄 메서드
	public String textPercent(int total, int totalSum) {
		float percent = (total / (float) totalSum)*100f;
		String strPerc = String.format("%.2f", percent);
		return "(" + strPerc + "%)";
	}
	
	public static void main(String[] args) {
		try {
			new IdNumInspector().start();
		
		} catch (IOException e) {
				e.printStackTrace();
		}
	}

}
 