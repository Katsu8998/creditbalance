# Query: 
# Flags: CaseSensitive
# ContextLines: 1

package autoCalc;

public class Main {

	public static void main(String[] args) {
		balance c1 = new balance();

		c1.name = "Credit Card";
		c1.balance = 100000;
		c1.cancel = 0;

		Invoice in1 = new Invoice();
		in1.totalAmount = 0;

		System.out.println("カード名: " + c1.name);
		System.out.println("残高: " + c1.balance + "円");
		System.out.println("現在の請求額:" + in1.totalAmount + "円");
		System.out.println("現在の払い戻し金額は" + c1.cancel + "円");

		System.out.println("");
		System.out.println("残高を変更する場合は、希望の残高に変更して下さい。");
		System.out.println("変更がなければ、(100000)と入力してください。");
		c1.balance = new java.util.Scanner(System.in).nextInt();

		while (c1.balance >= 0) {
			System.out.println("購入金額を入力ください");

			int amount = new java.util.Scanner(System.in).nextInt();
			double tax = 1.1;
			double totalAmount = amount * tax;
			System.out.println("請求金額は" + Math.round(totalAmount) + "円");

			c1.balance -= totalAmount;
			System.out.println("現在の残高は" + Math.round(c1.balance) + "円");

			System.out.println("取引の取り消しがあれば金額を入力ください。なければ(0)と入力して下さい");
			c1.cancel = new java.util.Scanner(System.in).nextInt();
			c1.balance += c1.cancel;
			System.out.println("現在の残高は" + Math.round(c1.balance) + "円");
		}
		if (c1.balance < 0) {
			System.out.println("残高不足です。");
		}
	}
}