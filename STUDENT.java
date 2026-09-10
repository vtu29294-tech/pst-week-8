import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();
        
        for (int grade : grades) {
            if (grade >= 38 && grade % 5 >= 3) {
                result.add(grade + (5 - (grade % 5)));
            } else {
                result.add(grade);
            }
        }
        
        return result;
    }

}

public class Student {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number of grades:");
        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println("Enter grades (one per line):");
        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        System.out.println("\nOutput:");
        System.out.println(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
        );

        bufferedReader.close();
    }
}
