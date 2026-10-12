import java.util.Scanner;//引入scanner

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//启用一个监听键盘的sc
        long balance = 0;          // 余额
        String owner = "张三";          // 户主

        System.out.println("===== 欢迎使用银行账户管理系统 =====");
        System.out.println("户主：" + owner);

        while (true) {                 // 无限循环：菜单反复出现

            showMenu();                // 打印菜单

            // 读选项：不是整数就提示重输
            while (!sc.hasNextInt()) { // "下一个输入不是整数就进循环
                System.out.println("请输入数字 1-4");
                sc.next();             // 把这段非法输入吃掉，否则会死循环
            }
            int choice = sc.nextInt(); // 确定是整数了，安全读取

            if (choice == 1) {                       // 存款
                System.out.print("请输入存款金额：");
                long amount = readAmount(sc);
                if (amount <= 0) {
                    System.out.println("存款金额必须大于 0，本次操作已取消。");
                } else {
                    balance = balance + amount;
                    System.out.println("存款成功，当前余额：" + balance);
                }

            } else if (choice == 2) {                // 取款
                System.out.print("请输入取款金额：");
                long amount = readAmount(sc);
                if (amount <= 0) {
                    System.out.println("取款金额必须大于 0，本次操作已取消。");
                } else if (amount > balance) {       // 余额不够
                    System.out.println("余额不足");
                } else {
                    balance = balance - amount;
                    System.out.println("取款成功，当前余额：" + balance);
                }

            } else if (choice == 3) {                //  查询余额
                System.out.println("当前余额：" + balance);

            } else if (choice == 4) {                //  退出
                System.out.println("谢谢使用！");
                break;

            } else {                                 // 其它数字
                System.out.println("无效选项，请输入 1-4");
            }

            System.out.println();                    // 空一行
        }
    }

    /** 打印菜单 */
    private static void showMenu() {
        System.out.println("请选择操作：");
        System.out.println("1. 存款");
        System.out.println("2. 取款");
        System.out.println("3. 查询余额");
        System.out.println("4. 退出");
        System.out.print("请选择：");
    }

    /** 读一个金额：不是数字就提示重输 */
    private static long readAmount(Scanner sc) {
        while (!sc.hasNextLong()) {   // 下一个输入不是整数
            System.out.println("请输入数字金额");
            sc.next();                  // 吃掉非法输入
        }
        return sc.nextLong();         // 安全读取
    }
}
