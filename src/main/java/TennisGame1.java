public class TennisGame1 implements TennisGame {
    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.isNamedAs(playerName)){
            player1.sumPoint();
        }
        if (player2.isNamedAs(playerName)){
            player2.sumPoint();
        }
    }

    public String getScore() {
        return Score.getScoreString(player1.getScore(), player2.getScore());
    }
}
