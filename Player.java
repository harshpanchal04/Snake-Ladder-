public abstract class Player {
    protected final String name;
    protected final String id;
    protected int currentPosition;
    protected boolean hasStarted;
    
    public Player(String name, String id) {
        this.name = name;
        this.id = id;
        this.currentPosition = 0;
        this.hasStarted = false;
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
    public int getCurrentPosition() { return currentPosition; }
    public boolean hasStarted() { return hasStarted; }
    
    public void setPosition(int position) { 
        this.currentPosition = position; 
        if (position > 0) {
            this.hasStarted = true;
        }
    }
    
    public abstract String getPlayerType();
    
    @Override
    public String toString() {
        return name + " (" + getPlayerType() + ") at position " + currentPosition;
    }
}