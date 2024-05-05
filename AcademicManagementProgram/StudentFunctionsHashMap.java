package Ch02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentFunctionsHashMap {
	private Map<String, Student> st = new HashMap<String, Student>();
	private List<String> key = new ArrayList<String>(); 
	private Scanner scanner = new Scanner(System.in);
	
	//등록 기능
	public void enrollStudent(){
		String studentID; 
		
		while(true) {
			studentID = sIDCheck("학번을 입력하세요");
			if(studentID.equals("취소")) return;
			key.add(studentID);
			st.put(studentID, new Student());
			st.get(studentID).setStudentID(studentID);
			
			st.get(studentID).setName(nameMajorCheck("이름을 입력하세요", st.get(studentID).getName()));
			st.get(studentID).setMajor(nameMajorCheck("전공을 입력하세요", st.get(studentID).getMajor()));
			st.get(studentID).setTelNumber(telCheck("연락처를 입력하세요", st.get(studentID).getTelNumber()));
			st.get(studentID).setGrade(gradeCheck("학년을 입력하세요", st.get(studentID).getGrade()));
			
			while(true) {
				boolean sex = true;
				
				System.out.print("성별(남/여): ");
				String sexString = scanner.nextLine();
				
				if(sexString.equals("남")) sex = true;
				else if(sexString.equals("여")) sex = false;
				else {
					System.out.println("'남/여'로 입력하세요.\n");
					continue;
				}
				st.get(studentID).setSex(sex);
				break;
			}
			System.out.println("등록완료!!!!\n");
		}
	}

	
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
	
	//조회 기능(전체)
	public void searchList() {
		if(st.isEmpty()) System.out.println("등록된 학생이 없습니다.");
		else {
			System.out.println("\n================현재 등록 학생================");
			System.out.println("학번\t\t이름\t\t전공");
			Collections.sort(key);
			for(int i = 0; i < key.size(); i++) {
				if(st.get(key.get(i)).getName().length() < 8) System.out.println(st.get(key.get(i)).getStudentID() + "\t" + st.get(key.get(i)).getName() + "\t\t" + st.get(key.get(i)).getMajor());
				else System.out.println(st.get(key.get(i)).getStudentID() + "\t" + st.get(key.get(i)).getName() + "\t" + st.get(key.get(i)).getMajor());
			}
		}
	}
	
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
	
	
	//조회 기능(특정)
	public void searchEach() {
		String studentID;
		
		while(true) {
			if(st.isEmpty()) {
				System.out.println("등록된 학생이 없습니다.");
				break;
			}
			studentID = sIDCheck("조회하고자하는 학생의 학번 입력");
			
			if(studentID.equals("취소")) return;
			
			if(st.containsKey(studentID)) {
				String sex;
	    		
	    		if(st.get(studentID).isSex()) sex = "남";
	    		else sex = "여";
	    		
	    		System.out.println();	
	    		System.out.println("학번: " + st.get(studentID).getStudentID());
	    		System.out.println("이름: " + st.get(studentID).getName());
	    		System.out.println("전공: " + st.get(studentID).getMajor());
	    		System.out.println("연락처: " + st.get(studentID).getTelNumber());
	    		System.out.println("학년: " + st.get(studentID).getGrade());
	    		System.out.println("성별: " + sex);
	    		System.out.println();
			}
			else System.out.println("\n해당 학번의 학생을 찾을 수 없습니다.");
		}
	}
	
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
		
	//삭제기능
	public void deleteStudent(){
		String studentID;
		char delCheck;
		boolean countCheck = false;
		
		while(true) {
			if(st.isEmpty()) {
				System.out.println("등록된 학생이 없습니다.");
				if(countCheck) System.out.println("메뉴로 돌아갑니다.......");
				break;
			}
			
			countCheck = true;
			
			studentID = sIDCheck("삭제하실 학생의 학번 입력");
			
			if(studentID.equals("취소")) return;
			
			if(st.containsKey(studentID)) {
				System.out.print("정말로 삭제하시겠습니까?(y/n)");
				delCheck = scanner.nextLine().charAt(0);
				
				if(delCheck == 'y') {
					st.remove(studentID);
					key.remove(studentID);
					System.out.println("삭제완료!!!!!\n");
				} else {
					System.out.println("삭제를 취소합니다.\n");
					continue;
				}
			}
			else {
				System.out.println("\n해당 학번의 학생을 찾을 수 없습니다.");
			}
		}
	}
	
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
	
	//수정기능
	public void editStudent() {
		String studentID;
		
		while(true) {
			if(st.isEmpty()) {
				System.out.println("등록된 학생이 없습니다.");
				break;
			}
			studentID = sIDCheck("변경하고자하는 학생의 학번 입력");
			
			if(studentID.equals("취소")) return;
			
			if(st.containsKey(studentID)) {
				st.get(studentID).setName(nameMajorCheck("새 이름을 입력하세요(건너뛰려면 엔터, 현재값: ", st.get(studentID).getName()));
				st.get(studentID).setMajor(nameMajorCheck("새 전공을 입력하세요(건너뛰려면 엔터, 현재값: ", st.get(studentID).getMajor()));
				st.get(studentID).setTelNumber(telCheck("새 연락처를 입력하세요(건너뛰려면 엔터, 현재값: ", st.get(studentID).getTelNumber()));
				st.get(studentID).setGrade(gradeCheck("새 학년을 입력하세요(건너뛰려면 엔터, 현재값: ", st.get(studentID).getGrade()));
				
				System.out.println("학생 정보가 수정되었습니다.\n");
			}
			else System.out.println("\n해당 학번의 학생을 찾을 수 없습니다.");
		}
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------	

	private String sIDCheck(String message) {
		String studentID;
		char check;
		
		while(true) {
			System.out.print(message + "(9자리, 취소하려면 '취소'입력): ");
			studentID = scanner.nextLine();
			
			if(studentID.equals("취소")) {
				System.out.println("메뉴로 돌아갑니다.......");
				return studentID;
			}
			if(!studentID.matches("\\d{9}")) {
				System.out.println("9자리 숫자를 입력해주세요.\n");
				continue;
			}
			
			if(message.equals("학번을 입력하세요")) {
				if(st.containsKey(studentID.substring(0, 4) + "-" + studentID.substring(4))) {
					System.out.println("이미 존재하는 학번 입니다. 다시 입력해주세요.\n");
					continue;
				}
				
				System.out.print("입력하신 학번이 " + studentID + " 맞습니까?(y/n): ");
				check = scanner.nextLine().charAt(0);
				
				if(check == 'y') {}
				else {
					System.out.println();
					continue;
				}
			}	
			break;
		}
		return studentID.substring(0,  4) + "-" + studentID.substring(4);
	}
	
	private String nameMajorCheck(String message, String valueInput) {
		String value;
		while(true) {
			
			if((message.equals("새 이름을 입력하세요(건너뛰려면 엔터, 현재값: ") || message.equals("새 전공을 입력하세요(건너뛰려면 엔터, 현재값: "))) {
				System.out.print(message + valueInput + "): ");
				value = scanner.nextLine();
				if(value.isEmpty()) {
					value = valueInput;
					break;
				}
			}
			else {
				System.out.print(message + ": ");
				value = scanner.nextLine();
				if(value.isEmpty()) {
					System.out.println("입력이 필요합니다.\n");
					continue;
				}
			}
			
			if(!Pattern.matches("[a-zA-Z가-힣]+", value)) {
				System.out.println("문자만 입력해주세요!!\n");
				continue;
			}	
			
			if(value.length() >= 16){
				System.out.println("입력이 너무 깁니다!!\n");
				continue;
			}
			break;
		}	
		return value;
    }
	
	private String telCheck(String message, String telNumberInput) {
		String telNumber;
		while(true) {
			if(message.equals("새 연락처를 입력하세요(건너뛰려면 엔터, 현재값: ")) {
				System.out.print(message + telNumberInput + "): 010-");
				telNumber = scanner.nextLine();
				if(telNumber.isEmpty()) {
					telNumber = telNumberInput;
					break;
				}
			}
			else {
				System.out.print(message + "(연속된 숫자로 입력): 010-");
				telNumber = scanner.nextLine();
				if(telNumber.isEmpty()) {
					System.out.println("입력이 필요합니다.\n");
					continue;
				}
			}
			
			if(!telNumber.matches("\\d{8}")) {
				System.out.println("8자리 숫자를 입력해주세요!!!!\n");
				continue;
			}
			
			telNumber = "010-" + telNumber.substring(0, 4) + "-" + telNumber.substring(4);
			break;
		}
		return telNumber;
	}
	
	private int gradeCheck(String message, int gradeInput) {
		String temp;
		int grade;
		while(true) {
			if(message.equals("새 학년을 입력하세요(건너뛰려면 엔터, 현재값: ")) {
				System.out.print(message + gradeInput +"): ");
				temp = scanner.nextLine();
				if(temp.isEmpty()) {
					grade = gradeInput;
					break;
				}
			}
			else {
				System.out.print(message + "(1~4): ");
				temp = scanner.nextLine();
				if(temp.isEmpty()) {
					System.out.println("입력이 필요합니다.\n");
					continue;
				}
			}
					
			try {
				grade = Integer.parseInt(temp);
				
				if(grade < 1 || grade > 4) System.out.println("학년은 1~4 사이의 숫자여야 합니다.");
				else break;
				
			} catch (Exception e) {
				System.out.println("학년은 숫자로만 입력해주세요.\n");
			}
		}
		return grade;
	}
}