# 키패드 누르기

### 링크

[프로그래머스_키패드누르기](https://programmers.co.kr/learn/courses/30/lessons/67256)

```java
public class KeypadPressSolution {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        PressIndex leftIndex = new PressIndex(3, 0);        // 왼손 위치
        PressIndex rightIndex = new PressIndex(3, 2);       // 오른손 위치

        for (int i = 0; i < numbers.length; i++) {
            PressIndex bePressedIndex = Pad.findBePressedIndex(numbers[i]);

            if (bePressedIndex.getY() == 0) {           // 왼쪽 열 키패드 넘버일때
                leftIndex.press(bePressedIndex);
                answer += "L";
            } else if (bePressedIndex.getY() == 2) {    // 오른쪽 열 키패드 넘버일때
                rightIndex.press(bePressedIndex);
                answer += "R";
            } else {                                    // 가운대 열 키패드 넘버일때
                int leftDistance = leftIndex.getDistance(bePressedIndex);
                int rightDistance = rightIndex.getDistance(bePressedIndex);

                if (leftDistance < rightDistance) {             // 왼손이 더 가까울때
                    leftIndex.press(bePressedIndex);
                    answer += "L";
                } else if (leftDistance > rightDistance) {      // 오른손이 더 가까울때
                    rightIndex.press(bePressedIndex);
                    answer += "R";
                } else {                                        // 두손 거리가 같을때

                    switch (hand.charAt(0)) {
                        case 'l':
                            leftIndex.press(bePressedIndex);
                            answer += "L";
                            break;
                        case 'r':
                            rightIndex.press(bePressedIndex);
                            answer += "R";
                            break;
                    }
                }
            }
        }

        return answer;
    }
}

class PressIndex {
    private int x;
    private int y;

    public PressIndex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void press(PressIndex beforeIndex) {
        this.x = beforeIndex.x;
        this.y = beforeIndex.y;
    }

    public int getDistance(PressIndex anotherIndex) {
        return Math.abs(this.x - anotherIndex.getX()) + Math.abs(this.y - anotherIndex.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Pad {
    private static int[][] pad = new int[][] {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {-1, 0, -1}
    };

    public static PressIndex findBePressedIndex(int number) {
        for (int x = 0; x < pad.length; x++) {
            for (int y = 0; y < pad[x].length; y++) {
                if (pad[x][y] == number) {
                    return new PressIndex(x, y);
                }
            }
        }
        return null;
    }
}
```

### 풀이

1. 먼저 Pad 클래스에서 키패드 형상 구현
2. 왼손은 *(3,0), 오른손은 #(3,2)를 출발점으로 지정한다
3. 왼손으로 누를지, 오른손으로 누를지에 대해서 요구사항에 맞게 각 조건문으로 분기처리
4. 단, 눌러야할 키패드와의 거리가 왼손, 오른손이 모두 같을 땐 주 손으로 누르도록 처리한다.
5. 키패드를 누를때 마다 왼손, 오른손 각각 자신의 현재 위치 정보를 저장한다
6. 키패드를 누를때 마다 answer 문자열에 L/R 값을 append.

<br>
<br>

# 숫자 문자열과 영단어

### 링크

[프로그래머스_숫자 문자열과 영단어](https://programmers.co.kr/learn/courses/30/lessons/81301)

```java
public class NumberStringsAndEnglishWords {

    public int solution(String s) {
        String tempString = s;

        while (!isNumbers(tempString)) {
            for (Number type : Number.values()) {
                String numberString = type.name().toLowerCase();

                if (tempString.contains(numberString)) {
                    tempString = tempString.replaceAll(numberString, String.valueOf(type.getValue()));
                    break;
                }
            }
        }

        return Integer.parseInt(tempString);
    }

    public boolean isNumbers(String numberString) {
        return Pattern.matches("^[0-9]+$", numberString);
    }

}

enum Number {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

### 풀이

1. 숫자 영단어를 Number Enum 을 활용해 정수형 숫자 값을 매칭한다
2. 문자열에서 숫자 영단어를 포함하고 있을 때 해당 숫자값으로 replace
3. 정규식을 활용해 변환 처리된 문자열이 숫자로만 이루어져있는지 체크하고, 아직 영단어가 남아 있다면
위 과정을 반복한다
4. 반복 작업을 통해 숫자로만 이루어진 문자열이 만들어졌다면 해당 값을 정수형으로 변환하여 결과 return
