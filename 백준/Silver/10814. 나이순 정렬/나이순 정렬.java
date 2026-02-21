
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] people = new Person[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[i] = new Person(age, name);
		}
		Arrays.sort(people, (p1, p2) -> p1.age - p2.age);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < people.length; i++) {
			sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
		}
		System.out.print(sb);
	}

}
