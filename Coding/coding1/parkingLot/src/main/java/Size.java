// Size.java
public enum Size {
    SMALL(1), // 小型车位
    MEDIUM(2), // 中型车位
    LARGE(3); // 大型车位

    private final int sizeValue;

    Size(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }
}