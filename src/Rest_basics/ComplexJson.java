package Rest_basics;

import Base.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String args[]) {
		// TODO Auto-generated method stub	
		JsonPath js=new JsonPath(Payload.CoursePrice());
		//print no of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println("course size is "+count);
		//print purchase amount
		int purchaseamnt=js.getInt("dashboard.purchaseAmount");
		System.out.println("purchase amount "+purchaseamnt);
		//print title of first course
		String titlefirstcourse=js.get("courses[0].title");
		System.out.println("Title of first course-"+titlefirstcourse);
		
		
		//print all course title and their respective prices
		for(int i=0;i<count;i++)
		{
			String courseTitle=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			System.out.println(courseTitle);
			
			
		}
	}

}
