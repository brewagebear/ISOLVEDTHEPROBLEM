package week1;

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