package domains;

public enum Direction {
    NORTH(0),
    WEST(1),
    SOUTH(2),
    EAST(3);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public Direction turnLeft(){
        return getByValue((value+1) % 4);
    }

    public Direction turnRight(){
        if(value == 0) return Direction.EAST;
        return getByValue( (value-1) % 4);
    }

    public static Direction getByValue(int value) {
        for (Direction d : Direction.values()) {
            if (d.value == value) {
                return d;
            }
        }
        return null;
    }

}
