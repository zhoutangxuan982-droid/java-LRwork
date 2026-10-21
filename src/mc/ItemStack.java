package mc;

public class ItemStack {

    private Item item;        // 物品类型（指向一个 Item 对象）
    private int quantity;     // 当前数量

    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** 这一堆是不是满了*/
    public boolean isFull() {
        return item != null && quantity >= item.getMaxStackSize();
    }

    /** 这一堆是不是空的*/
    public boolean isEmpty() {
        return quantity <= 0;
    }

    /** 还能再放多少个 */
    public int remainingSpace() {
        if (item == null) return 0;
        return Math.max(0, item.getMaxStackSize() - quantity);
    }

    /** 打印时显示成 "石头 x30" */
    @Override
    public String toString() {
        return (item == null ? "未知" : item.getName()) + " x" + quantity;
    }
}
