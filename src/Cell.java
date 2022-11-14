import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private boolean odkryta;
    private boolean bomba;
    public Cell() {
        this.odkryta = false;
        this.bomba = ThreadLocalRandom.current().nextBoolean();
    }
    public boolean getOdkryta() { return odkryta; }
    public void setOdkryta(boolean odkryta) { this.odkryta = odkryta; }
    public boolean getBomba() { return bomba; }
    public void setBomba(boolean bomba) { this.bomba = bomba; }


}
