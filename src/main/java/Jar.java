import java.util.Random;

public class Jar{
    private String mItemName;
    private int mMaxNumber;
    private int mNumberOfItems;

    public Jar(String itemName, int maxNumber) {
        mItemName = itemName;
        mMaxNumber = maxNumber;
        mNumberOfItems = randomizeNumber();
    }

    public String getItemName() {
        return mItemName;
    }

    public int getNumberOfItems() {
        return mNumberOfItems;
    }

    public int getMaxNumber() {
        return mMaxNumber;
    }

    private int randomizeNumber() {
        Random random = new Random();
        return random.nextInt(mMaxNumber + 1);
        // this will be 1 to whatever mMaxNumber is
    }
}
