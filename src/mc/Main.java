package mc;

public class Main {

    public static void main(String[] args) {

        Item stone = new Item("石头", 64);
        Item plank = new Item("木板", 64);
        Item sword = new Item("钻石剑", 1);

        System.out.println("① 创建一个容量为 36 的背包");
        Inventory inv = new Inventory(36);
        inv.display();

        System.out.println("\n② 添加 30 个石头");
        inv.addItem(new ItemStack(stone, 30));
        inv.display();

        System.out.println("\n③ 再添加 40 个石头");
        int ret3 = inv.addItem(new ItemStack(stone, 40));
        System.out.println("  addItem 返回值：" + ret3);
        inv.display();

        System.out.println("\n④ 添加 1 把钻石剑");
        inv.addItem(new ItemStack(sword, 1));
        inv.display();

        System.out.println("\n⑤ 添加 35 个木板（每次 1 个，共 35 次）");
        for (int i = 0; i < 35; i++) {
            inv.addItem(new ItemStack(plank, 1));
        }
        inv.display();

        System.out.println("\n⑥ 移除 10 个石头");
        int removed = inv.removeItem("石头", 10);
        System.out.println("  实际移除：" + removed);
        inv.display();

        System.out.println("\n⑦ 统计数量");
        System.out.println("  石头=" + inv.getItemCount("石头")
                + "  木板=" + inv.getItemCount("木板")
                + "  钻石剑=" + inv.getItemCount("钻石剑"));
    }
}