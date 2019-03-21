package jdbc.practice;
import java.util.*;
import jdbc.dao.*;
import jdbc.dto.*;
import java.util.List;

public class jdbcPractice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int member = (int)(Math.random()*4+1);
		StudyMemberDao smDao = new StudyMemberDao();
//		StudyMember sm = smDao.getId(member);
//		System.out.println(sm); //특정 id값 데이터 조회
		
//		StudyMember sm2 = new StudyMember(1,"sungjin","Anyang");
//		smDao.addMember(sm2);
		
//		StudyMember sm3 = new StudyMember();
//		smDao.delMember("seungmin");
		
		StudyMember sm4 = new StudyMember();
		List<StudyMember> list = smDao.selectAll();
		for(int i = 0 ; i < list.size();i++) {
			sm4 = list.get(i);
			
			System.out.println(sm4.toString());
		}
	}
	

}
