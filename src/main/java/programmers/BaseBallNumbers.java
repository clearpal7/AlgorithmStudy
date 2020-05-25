package programmers;


public class BaseBallNumbers {

    public int solution(int[][] baseball) {
        int answer = 0;
        int N = baseball.length;
        BaseBall[] baseBalls = new BaseBall[N];

        for(int i = 0; i < baseball.length; i++) {
            int num = baseball[i][0];
            int strike = baseball[i][1];
            int ball = baseball[i][2];

            baseBalls[i] =  new BaseBall(num, strike, ball);
        }

        for(int i = 123; i <= 987; i++) {
            if(isCheck(String.valueOf(i), N, baseBalls)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isCheck(String s, int N, BaseBall[] baseBalls) {
        char[] number = s.toCharArray();

        //중복 체크
        //0 여부 체크
        for(int i = 0; i < N; i++) {
            int strike = isStrike(String.valueOf(baseBalls[i].number), number);
            int ball = isBall(String.valueOf(baseBalls[i].number), number);
            if(strike == baseBalls[i].strike && ball == baseBalls[i].ball) {
                return true;
            }
        }
        return false;
    }

    public int isStrike(String BaseBallNumber, char[] number) {
        int strikeCount = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(BaseBallNumber.charAt(i) == number[j]) {
                    if(i == j) strikeCount++;
                }
            }
        }
        return strikeCount;
    }

    public int isBall(String BaseBallNumber, char[] number) {
        int ballCount = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(BaseBallNumber.charAt(i) == number[j]) {
                    if(i!=j) ballCount++;
                }
            }
        }
        return ballCount;
    }

}
class BaseBall {
    int number;
    int strike;
    int ball;

    public BaseBall(int number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }

}
