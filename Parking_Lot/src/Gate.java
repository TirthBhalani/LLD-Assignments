public class Gate {
    private String gateId;
    private int xCoordinate;
    private int yCoordinate;

    public Gate(String gateId, int xCoordinate, int yCoordinate) {
        this.gateId = gateId;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public String getGateId() { return gateId; }
    public int getX() { return xCoordinate; }
    public int getY() { return yCoordinate; }
}
