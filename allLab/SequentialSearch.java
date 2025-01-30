import java.util.Scanner;

public class SequentialSearch {
	public static void main(String[] args) {
		int[] A = {10001, 10022, 10060, 11255, 15022, 20001, 21002, 23003, 25566, 30078, 40000, 50012, 66006};
		
		Scanner scanner = new Scanner(System.in); //ชื่อ scanner เพื่อรับข้อมูลจากแป้นพิมพ์
		System.out.println("ID: ");
		int id = scanner.nextInt(); //รับค่าจำนวนเต็มจากผู้ใช้ และเก็บไว้ในตัวแปร id
		
		int position = sequentialSearch(A, id); //A และค่า id ที่ผู้ใช้ป้อนเข้าไป และเก็บผลลัพธ์ในตัวแปร position
		if(position == -1) {
			System.out.println("Not Found!"); //position เท่ากับ -1หมายความว่าไม่พบ id ในอาเรย์
		}else {
			System.out.println("Found at A[" + position + "]"); //else ซึ่งจะทำงานเมื่อพบ id
		}
		
		scanner.close();
	}
	public static int sequentialSearch(int[] array, int key) { //ที่รับอาเรย์และคีย์เป็นพารามิเตอร์ และคืนค่าตำแหน่งของคีย์
		for(int i = 0; i <array.length; i++) { //เพื่อวนตรวจสอบแต่ละค่าของอาเรย์
			if(array[i] == key) { //ตรวจสอบว่าค่าปัจจุบันในอาเรย์เท่ากับคีย์หรือไม่
				return i; // คืนตำแหน่งที่พบ
			}
		}
		return -1; // คืน -1 ถ้าไม่พบ
	}
}
