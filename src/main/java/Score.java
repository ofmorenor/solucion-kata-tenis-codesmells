public class Score {
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    private static final String WIN_PLAYER1 = "Win for player1";
    private static final String WIN_PLAYER2 = "Win for player2";
    private static final int POINTS_AFTER_FORTY = 4;
    private static final int MINIMUM_POINTS_FOR_DEUCE = 3;

    private Score(){ };

    public static String getScoreString(int pointsPlayer1, int pointsPlayer2){
        String score;
        int diff = getDiff(pointsPlayer1, pointsPlayer2);
        if (isDraw(diff))
        {
            score = getScoreForDrawGame(pointsPlayer1);
        }
        else if (isWin(pointsPlayer1, pointsPlayer2))
        {
            score = getScoreForWin(pointsPlayer1, pointsPlayer2);
        }
        else if (isAdvantage(pointsPlayer1, pointsPlayer2))
        {
            score = getScoreForAdvantage(pointsPlayer1, pointsPlayer2);
        }
        else {
            score = getScoreForNormalCase(pointsPlayer1, pointsPlayer2);
        }
        return score;
    }

    private static boolean isAnyPlayerNearToWinSet(int pointsPlayer1, int pointsPlayer2){
        return hasMoreThanForty(pointsPlayer1) || hasMoreThanForty(pointsPlayer2);
    }

    private static boolean hasMoreThanForty(int points){
        return points >= POINTS_AFTER_FORTY;
    }

    private static String getScoreName(int points){
        String[] scores = { LOVE, FIFTEEN, THIRTY, FORTY, DEUCE };
        return scores[points];
    }

    private static String getScoreForDrawGame(int points){
        String score;
        if (points >= MINIMUM_POINTS_FOR_DEUCE){
            score = DEUCE;
        }
        else{
            score = getScoreName(points)+"-All";
        }
        return score;
    }

    private static int getDiff(int pointsPlayer1, int pointsPlayer2){
        return pointsPlayer1 - pointsPlayer2;
    }

    private static boolean isDraw(int diff){
        return diff == 0;
    }

    private static boolean isAdvantage(int pointsPlayer1, int pointsPlayer2){
        int diff = getDiff(pointsPlayer1, pointsPlayer2);
        return isAnyPlayerNearToWinSet(pointsPlayer1, pointsPlayer2) && Math.abs(diff) == 1;
    }

    private static boolean isWin(int pointsPlayer1, int pointsPlayer2){
        int diff = getDiff(pointsPlayer1, pointsPlayer2);
        return isAnyPlayerNearToWinSet(pointsPlayer1, pointsPlayer2) && Math.abs(diff) >= 2;
    }

    private static String getScoreForNormalCase(int pointsPlayer1, int pointsPlayer2){
        return getScoreName(pointsPlayer1) + "-" + getScoreName(pointsPlayer2);
    }

    private static String getScoreForWin(int pointsPlayer1, int pointsPlayer2) {
        int diff = pointsPlayer1 - pointsPlayer2;
        return diff > 0 ? WIN_PLAYER1 : WIN_PLAYER2;
    }

    private static String getScoreForAdvantage(int pointsPlayer1, int pointsPlayer2) {
        int diff = pointsPlayer1 - pointsPlayer2;
        return diff > 0 ? ADVANTAGE_PLAYER1 : ADVANTAGE_PLAYER2;
    }
}
