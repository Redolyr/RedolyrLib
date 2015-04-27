package RedolyrLibrary.gameLib;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by redolyr on 2015/04/19.
 */
public class MoneySystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String username;
    private int money;
    private BankProperty bankProperty;

    private boolean useBank = false;

    public MoneySystem(String username) {
        this.username = username;
        this.bankProperty = new BankProperty(username, this);
    }

    public boolean isUseBank() {
        return this.useBank;
    }

    public int getMoney() {
        return this.money;
    }

    public void useMoney(int use) {
        if (this.money > 0) {
            this.money -= use;
        }
    }

    public void addMoney(int add) {
        this.money += add;
    }

    public BankProperty getBank() {
        return this.bankProperty;
    }

    public void setBankName(String nickname) {
        if (this.bankProperty != null) {
            this.bankProperty.nickname = nickname;
            this.useBank = true;
        }
    }

    public static class BankProperty implements Serializable {

        private static final long serialVersionUID = 1L;

        private String nickname;
        private int bankMoney;
        private DateProperty dateProperty;
        private final MoneySystem moneySystem;

        public BankProperty(String nickname, MoneySystem moneySystem) {
            this.nickname = nickname;
            this.moneySystem = moneySystem;
            this.dateProperty = new DateProperty();
        }

        public void pullMoney(int money) {
            if (this.moneySystem.useBank && this.bankMoney > 0 && this.moneySystem.money < money) {
                this.moneySystem.money += money;
                this.bankMoney -= money;
                this.dateProperty.addPull(money, this.bankMoney);
            }
        }

        public void pushMoney(int money) {
            if (this.moneySystem.useBank && this.moneySystem.money > 0 && this.bankMoney < money) {
                this.moneySystem.money -= money;
                this.bankMoney += money;
                this.dateProperty.addPush(money, this.bankMoney);
            }
        }

        public int getBankMoney() {
            return this.bankMoney;
        }

        @Override
        public String toString() {
            return "BankProperty{" +
                    "nickname='" + this.nickname + '\'' +
                    ", bankMoney=" + this.bankMoney +
                    ", dateProperty=" + this.dateProperty +
                    '}';
        }
    }

    public static class DateProperty implements Serializable {

        private static final long serialVersionUID = 1L;

        private Date[] dates;
        private int[] pull;
        private int[] push;
        private int[] money;

        public void add(int pull, int push, int money) {
            int size = 1;
            int length = this.dates != null ? this.dates.length + size : size;
            int index = this.dates != null ? this.dates.length : 0;
            if (this.dates == null) {
                this.dates = new Date[size];
                this.pull = new int[size];
                this.push = new int[size];
                this.money = new int[size];
            } else {
                this.dates = Arrays.copyOf(this.dates, length);
                this.pull = Arrays.copyOf(this.pull, length);
                this.push = Arrays.copyOf(this.push, length);
                this.money = Arrays.copyOf(this.money, length);
            }

            this.dates[index] = new Date();
            this.pull[index] = pull;
            this.push[index] = push;
            this.money[index] = money;
        }

        public void addPush(int push, int money) {
            this.add(0, push, money);
        }

        public void addPull(int pull, int money) {
            this.add(pull, 0, money);
        }

        @Override
        public String toString() {
            return "DateProperty{" +
                    "dates=" + Arrays.toString(this.dates) +
                    ", pull=" + Arrays.toString(this.pull) +
                    ", push=" + Arrays.toString(this.push) +
                    ", money=" + Arrays.toString(this.money) +
                    '}';
        }
    }

    public static class MoneyDataIO implements Serializable {

        public static long[] writeToMoney(MoneySystem moneySystem) throws IOException {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(moneySystem);
//            String base = Base64.encode(byteArrayOutputStream.toByteArray());
//            long out = 0L;
//            char[] chars = base.toCharArray();
//            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(chars.length * 4).order(ByteOrder.nativeOrder());
//            CharBuffer charBuffer = byteBuffer.asCharBuffer();
//            LongBuffer longBuffer = byteBuffer.asLongBuffer();
//            charBuffer.clear();
//            charBuffer.position(0);
//            charBuffer.put(chars);
//            long[] longs = new long[longBuffer.capacity() - longBuffer.position()];
//            System.out.println(longBuffer.capacity() + ", " + longBuffer.position() + ", " + longBuffer.limit() + ", " + longBuffer.remaining() + ", " + chars.length);
//            longBuffer.get(longs);
//            objectOutputStream.close();
//            byteArrayOutputStream.close();
            return new long[0];//longs;
        }

        public static long[] writeToMoneySystem(MoneySystem moneySystem) {
            try {
                return writeToMoney(moneySystem);
            } catch (IOException e) {
                e.printStackTrace();
                return new long[0];
            }
        }
    }

    @Override
    public String toString() {
        return "MoneySystem{" +
                "username='" + this.username + '\'' +
                ", money=" + this.money +
                ", bankProperty=" + this.bankProperty +
                ", isUseBank=" + this.useBank +
                '}';
    }
}
