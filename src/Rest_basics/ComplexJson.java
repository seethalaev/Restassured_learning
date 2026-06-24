package Rest_basics;

import Base.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String args[]) {
		// TODO Auto-generated method stub	
		JsonPath js=new JsonPath(Payload.CoursePrice());
		//print no of courses returned by API
		int coursesize=js.getInt("courses.size()");
		System.out.println("course size is "+coursesize);
		//print purchase amount
		int purchaseamnt=js.getInt("dashboard.purchaseAmount");
		System.out.println("purchase amount "+purchaseamnt);
		//print title of first course
		String titlefirstcourse=js.get("courses[0].title");
		System.out.println("Title of first course-"+titlefirstcourse);
	}

}
