package mc;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Inventory {

    private final List<ItemStack> items = new ArrayList<>();
    private final int capacity;

    public Inventory(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("容量不能为负数");
        }
        this.capacity = capacity;
    }

    public Inventory() {
        this(36);
    }

    public int addItem(ItemStack stack) {
        if (stack == null || stack.getItem() == null || stack.getQuantity() <= 0) {
            return capacity - items.size();          // 无效输入，直接返回剩余容量
        }

        Item item = stack.getItem();
        int rest = stack.getQuantity();

        // ① 堆叠：补进已有的、同类的、未满的堆
        for (ItemStack s : items) {
            if (rest == 0) break;
            if (!s.getItem().sameType(item)) continue;
            if (s.isFull()) continue;

            int put = Math.min(s.remainingSpace(), rest);
            s.setQuantity(s.getQuantity() + put);
            rest -= put;
        }

        // 开新格：一次加的量可能超过单堆上限，要拆成多堆
        while (rest > 0 && items.size() < capacity) {
            int put = Math.min(item.getMaxStackSize(), rest);
            items.add(new ItemStack(item, put));
            rest -= put;
        }

        // ③ 算返回值
        int spaceLeft = capacity - items.size();
        return rest == 0 ? spaceLeft : -rest;
    }
    /** 移除指定数量的某种物品，返回实际移除的数量 */
    public int removeItem(String itemName, int amount) {
        if (itemName == null || amount <= 0) return 0;

        int removed = 0;
        Iterator<ItemStack> it = items.iterator();

        while (it.hasNext() && removed < amount) {
            ItemStack s = it.next();
            if (!itemName.equals(s.getItem().getName())) continue;

            int take = Math.min(amount - removed, s.getQuantity());
            s.setQuantity(s.getQuantity() - take);
            removed += take;

            if (s.isEmpty()) {
                it.remove();
            }
        }
        return removed;
    }
    public List<ItemStack> getItems() { return items; }
    public int getCapacity() { return capacity; }
    /** 打印整个背包 */
    public void display() {
        System.out.println("  背包（" + items.size() + "/" + capacity + " 格）：");

        if (items.isEmpty()) {                       // 空背包就提示一下
            System.out.println("    （空）");
            return;                                   // 提前结束（void 方法里 return; 合法）
        }

        for (int i = 0; i < items.size(); i++) {
            ItemStack s = items.get(i);               // 取第 i 个格子
            System.out.println("    第" + (i + 1) + "格："
                    + s.getItem().getName() + " x" + s.getQuantity());
        }
    }
    /** 统计背包里某种物品的总数量 */
    public int getItemCount(String itemName) {
        int total = 0;
        for (ItemStack s : items) {
            if (itemName != null && itemName.equals(s.getItem().getName())) {
                total += s.getQuantity();
            }
        }
        return total;
    }
}