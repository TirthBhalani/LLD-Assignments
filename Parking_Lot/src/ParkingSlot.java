public class ParkingSlot {
    private String slotId;
    private SlotType type;
    private boolean isOccupied;
    private int xCoordinate;
    private int yCoordinate;

    public ParkingSlot(String slotId, SlotType type, int xCoordinate, int yCoordinate) {
        this.slotId = slotId;
        this.type = type;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isOccupied = false;
    }

    public String getSlotId() { return slotId; }
    public SlotType getType() { return type; }
    public boolean isOccupied() { return isOccupied; }

    public void parkVehicle() {
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.isOccupied = false;
    }

    public double getDistance(Gate gate) {
        return Math.sqrt(Math.pow(this.xCoordinate - gate.getX(), 2) + 
                         Math.pow(this.yCoordinate - gate.getY(), 2));
    }
}
