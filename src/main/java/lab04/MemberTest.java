package lab04;

import java.util.ArrayList;

import lab04.Member;
import lab04.MemberDAO;

public class MemberTest {

	public static void main(String[] args) {
		try {
			MemberDAO memberDAO = new MemberDAO(); // สร้าง object DAO
			Member member = memberDAO.getMember("anocha"); // เรียกเมธอดจาก DAO
			
			
			ArrayList<Member> memberlist = memberDAO.getAllMember();
			
			for(Member list:memberlist) {
				System.out.println(list.getName()+ " " + list.getAddress());
			}
			
			System.out.println("ชอื่ : " + member.getName());
			System.out.println("ที่อยู่: " + member.getAddress());
			
//			Member newMember = new Member();
//			newMember.setUsername("anocha");
//			newMember.setPassword("1234");
//			newMember.setName("อโนชา");
//			newMember.setAddress("ยโสธร");
//			newMember.setMobile("089513214");
//			newMember.setEmail("test@example.com");
//		
//			memberDAO.createMember(newMember);
//			
//			

		
			
//			memberDAO.deleteMember("anocha");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}

