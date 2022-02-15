public class Player {
    private int m_score = 0;
    private final String name;

    public Player(String name){
        this.name = name;
    }

    public void sumPoint(){
        m_score += 1;
    }

    public int getScore(){
        return m_score;
    }

    public boolean isNamedAs(String name){
        return this.name.contentEquals(name);
    }
}
