package Ch02; 
import java.util.Scanner;

public class StudentManagementMain {

	public static void main(String[] args) {
		
		StudentFunctionsHashMap fun = new StudentFunctionsHashMap();
		
		String menuInput;
		int menuSelect; // 메뉴 선택번호
		boolean menuCheck = true; // 잘못된 메뉴 입력 확인
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("====================================================");
		System.out.println("\t\t   학사 관리 시스템");
		System.out.println("====================================================");
			
		while(true) {
			
			if(menuCheck) {
				System.out.println("1. 학생 등록");
				System.out.println("2. 학생 목록 조회");
				System.out.println("3. 학생 정보 조회");
				System.out.println("4. 학생 정보 수정(이름/연락처/전공/학년)");
				System.out.println("5. 학생 정보 삭제");
				System.out.println("6. 종료");
			}
			System.out.print("\n메뉴를 선택하세요: ");
			menuInput = scanner.nextLine();
			
			try {
				menuSelect = Integer.parseInt(menuInput);
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				menuCheck = false;
				continue;
			}
			
			
			switch (menuSelect) {
				case 1:
					fun.enrollStudent();
					System.out.println();
					break;
				case 2:
					fun.searchList();
					System.out.println();
					break;
				case 3:
					fun.searchEach();
					System.out.println();
					break;
				case 4:
					fun.editStudent();
					System.out.println();
					break;
				case 5:
					fun.deleteStudent();
					System.out.println();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					scanner.close();
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					menuCheck = false;
					continue;	
			}	
			menuCheck = true;
		}
	}
}
