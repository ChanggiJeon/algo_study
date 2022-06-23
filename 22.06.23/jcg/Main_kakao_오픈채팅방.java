import java.io.IOException;
import java.util.*;

public class Main_kakao_오픈채팅방 {
	/**
	 * 
	 * 아놔... \" 이거 왜 안먹히는데?;;
	 * 프로그래머스 진짜;;
	 * 배운점 
	 * 1. hash맵에 넣으면 자동 변경됨
	 * 2. List에 넣고 toArray로 바꾸면 "가 붙는다.(프로그래머스에서만!)
	 * 
	 */

	public static void main(String[] args) throws IOException {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] orderList = {"님이 들어왔습니다.", "님이 나갔습니다."};
		
		ArrayList<String[]> announcement = new ArrayList<String[]>();
		HashMap<String, String> user = new HashMap<String, String>();
		
		for(int i=0; i<record.length; i++){
            String[] line = record[i].split(" ");
            String order = line[0];
            String userId = line[1];
            
            switch(order) {
	            case "Enter":
	            	announcement.add(new String[]{"0",userId});
	            	String nickName = line[2];
	                user.put(userId, nickName);
	            	break;
	            case "Leave":
	            	announcement.add(new String[]{"1",userId});
	            	break;
	            case "Change":
	            	nickName = line[2];
	            	user.put(userId, nickName);
	            	break;
            }
		}
		String[] answer = new String[announcement.size()];
		List<String> arr = new ArrayList<String>();
		for(int i=0; i<announcement.size(); i++) {
			int order = Integer.parseInt(announcement.get(i)[0]);
			String nickName = user.get(announcement.get(i)[1]);
			arr.add(nickName+orderList[order]);
		}
		arr.toArray(answer);
		System.out.println(Arrays.toString(answer));
	}

}
