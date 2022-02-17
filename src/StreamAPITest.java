import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    public static void main(String[] args) {

        System.out.println("=============기존 정렬==============");

        String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
        List<String> nameList = Arrays.asList(nameArr);
        Arrays.sort(nameArr);
        Collections.sort(nameList);
        for (String str : nameArr) {
            System.out.println(str);
        }
        for (String str : nameList) {
            System.out.println(str);
        }

        System.out.println("============Stream API =============");

        // 원본의 데이터가 아닌 별도의 Stream을 생성함
        Stream<String> nameStream = nameList.stream();
        Stream<String> arrayStream = Arrays.stream(nameArr);


        // 복사된 데이터를 정렬하여 출력함
        nameStream.sorted().forEach(System.out::println);
        arrayStream.sorted().forEach(System.out::println);

        //일회용 이므로 아래 주석 코드처럼 닫힌 Stream을 사용 할 시 IllegalStateException이 발생한다.
        //arrayStream.sorted().forEach(System.out::println);

        //내부 반복으로 작업을 처리한다.

        //Stream을 이용하면 코드가 간결해지는 이유 중 하나는 '내부 반복' 때문이다.
        //기존에는 반복문을 사용하기 위해서 for이나 while 등과 같은 문법을 사용해야 했지만,
        //stream에서는 그러한 반복 문법을 메소드 내부에 숨기고 있기 때문에, 보다 간결한 코드의 작성이 가능하다.

        nameStream = nameList.stream();
        nameStream.forEach(System.out::println);


        List<String> myList = Arrays.asList();



    }
}
