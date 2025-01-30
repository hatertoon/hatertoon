import java.util.Scanner;//Scanner เพื่อรับข้อมูลจากผู้ใช้ผ่านคีย์บอร์ด

public class BubbleSortDescending {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//สร้างออบเจ็กต์ Scanner เพื่อรับข้อมูลจากคีย์บอร์ด
		
		// รับจำนวนตัวเลขที่ต้องการเรียงลำดับ
		System.out.print("Input number of integers to sort: ");
		int n = scanner.nextInt();//อ่านค่าจำนวนเต็มจากผู้ใช้และเก็บในตัวแปร n ซึ่งใช้แทนจำนวนตัวเลขที่ต้องการเรียงลำดับ
		
		int[] data = new int[n];//ประกาศอาร์เรย์ data ขนาด n สำหรับเก็บตัวเลขที่ผู้ใช้ป้อน
		
		// รับค่าตัวเลขจากผู้ใช้
		System.out.println("Enter " + n + " integers");
		for (int i = 0; i < n; i++) { //วนลูปตั้งแต่ i = 0 ถึง i = n - 1 เพื่อรับค่าตัวเลขจากผู้ใช้
			System.out.print("Enter " + (i + 1) + ": "); //แสดงข้อความ "Enter X:" เพื่อบอกลำดับที่ของตัวเลขที่กำลังป้อน
			data[i] = scanner.nextInt(); //อ่านค่าจำนวนเต็มจากผู้ใช้แล้วเก็บในตำแหน่ง i ของอาร์เรย์ data
		}
		
		// เรียงลำดับด้วย Bubble Sort
        bubbleSortDescending(data); //เรียกใช้เมธอด bubbleSortDescending เพื่อเรียงลำดับข้อมูลในอาร์เรย์ data จากมากไปน้อย
        
        // แสดงผลลัพธ์
        System.out.println("Sorted list of numbers:");
        for (int i = 0; i < data.length; i++) { //วนลูปตั้งแต่ i = 0 ถึง i = data.length - 1 เพื่อพิมพ์ค่าทุกตำแหน่งในอาร์เรย์ data
        	System.out.println("Data " + (i + 1) + ": " + data[i]); //แสดงข้อความ "Data X: Y" โดย X คือหมายเลขลำดับ และ Y คือค่าที่ตำแหน่ง i ของอาร์เรย์
	}
	
	scanner.close(); //ปิด Scanner เพื่อป้องกันการรั่วไหลของทรัพยากร
	
}

	public static void bubbleSortDescending(int[] array) {
		int n = array.length; //เก็บขนาดของอาร์เรย์ในตัวแปร n
		for (int i = 0; i < n - 1; i++) { //วนลูปภายนอก i สำหรับกำหนดรอบการเปรียบเทียบ โดยลดจำนวนการเปรียบเทียบในแต่ละรอบ
			for (int j = 0; j < n - i - 1; j++) { //j สำหรับเปรียบเทียบค่าตัวเลขในอาร์เรย์แต่ละคู่ที่อยู่ติดกัน
				if (array[j] <array[j + 1]) { //ให้สลับค่าทั้งสองตำแหน่งเพื่อให้ค่าที่มากกว่ามาอยู่ด้านหน้า
					int temp = array[j]; // ใช้ตัวแปร temp เป็นตัวกลางสำหรับสลับค่าของ array[j] และ array[j + 1]
					array[j] =array[j + 1];
					array[j + 1] = temp; 
				}
			}
		}
	}
	}
