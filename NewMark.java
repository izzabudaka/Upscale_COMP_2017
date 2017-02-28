import java.util.*;

public class NewMark{
	private static Map<String, Double> SCALING_FACTOR = new HashMap<String, Double>(){{
		put("28112L", 82.0);
		put("26122L", 78.0);
		put("26121L", 78.0);
		put("25212L", 72.0);
		put("25111L", 77.0);
		put("24111L", 89.0);
		put("23422L", 92.0);
		put("23421L", 81.0);
		put("23111L", 80.0);
		put("28411L", 88.0);
	}};

	private static Map<String, Double> LAB_PERCENTAGE = new HashMap<String, Double>(){{
		put("28112L", 20.0);
		put("26122L", (25.0/60)* 100);
		put("26121L", 62.5);
		put("25212L", 20.0);
		put("25111L", 30.0);
		put("24111L", 50.0);
		put("23422L", 20.0/50.5);
		put("23421L", 15.0/49.5);
		put("23111L", 30.0);
		put("28411L", 30.0);
	}};

	public static void main(String[] args){
		Map<String, Double> marks = new HashMap(SCALING_FACTOR.keySet().size());
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter -1 for courses that you didn't take");
		System.out.print("Whats your current 2nd Year Mark: ");
		double currentMark = sc.nextDouble();

		for(String course : SCALING_FACTOR.keySet()){
			System.out.printf("%s: ", course);
			marks.put(course, sc.nextDouble());
		}

		for(String course : SCALING_FACTOR.keySet()){
			double courseMark = marks.get(course);
			if(courseMark != -1){
				double nMark = marks.get(course)/SCALING_FACTOR.get(course) * 100;
				System.out.printf("Your mark for %s increased from %.2f to %.2f\n", course, marks.get(course), nMark);
				currentMark += (nMark - marks.get(course)) * 1.0/12.0 * LAB_PERCENTAGE.get(course)/100.0;
			}
		}

		System.out.printf("Your new mark is: %.2f\n", currentMark);
	}
}