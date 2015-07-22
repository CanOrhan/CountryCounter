package uk.co.kiwisoft.tomtom;

/**
 * Created by Can Orhan on 22/07/15.
 */
public class Node {
    private final int x;
    private final int y;
    private final int color;
    private boolean isClaimed;

    public Node(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public boolean isClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (x != node.x) return false;
        return y == node.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
