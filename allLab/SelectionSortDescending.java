import java.util.Arrays;//เพื่อใช้ฟังก์ชันช่วยจัดการกับอาร์เรย์ 

public class SelectionSortDescending {
	public static void main(String[] arga) {
		int[] data = {120, 60, 20, 80, 79, 30, 45 };//ประกาศอาร์เรย์ data ซึ่งเก็บข้อมูลตัวเลขที่ต้องการเรียงลำดับ
		System.out.println("Unsorted Array: " + Arrays.toString(data)); //ใช้ Arrays.toString() เพื่อพิมพ์อาร์เรย์ก่อนและหลังการเรียงลำดับ
		
		selectionSortDescending(data);//เพื่อทำการเรียงลำดับข้อมูลในอาร์เรย์ data จากมากไปน้อย
		
		System.out.println("Sorted Array in Descending Order: " + Arrays.toString(data));//แสดงค่าของอาร์เรย์ data ที่เรียงลำดับแล้ว
	}
	public static void selectionSortDescending(int[] array) {
		for (int i = 0; i < array.length -  1; i++) {//วนลูปเริ่มต้นจากตำแหน่งแรก (i = 0) ไปจนถึงตำแหน่งก่อนสุดท้าย (array.length - 1)
			int maxIndex = i; //หาตำแหน่งค่าสูงสุด
			for (int j = i + 1; j < array.length; j++) {//วนลูปจากตำแหน่งถัดไป (i + 1) จนถึงตำแหน่งสุดท้ายของอาร์เรย์
				if (array[j] > array[maxIndex]) { //ตรวจสอบว่าค่าที่ตำแหน่ง j (array[j]) มีค่ามากกว่าค่าที่ตำแหน่ง maxIndex หรือไม่
					maxIndex = j;//ถ้าใช่ ให้ปรับปรุง maxIndex เป็นตำแหน่ง j
				}
			}
			// สลับค่าระหว่างตำแหน่งปัจจุบันกับตำแหน่งค่าสูงสุด
        int temp = array[i];//เก็บค่าที่ตำแหน่ง i ไว้ในตัวแปร temp
        array[i] = array[maxIndex];//นำค่าที่ตำแหน่ง maxIndex ไปไว้ที่ตำแหน่ง i
        array[maxIndex] = temp;//นำค่าที่เก็บใน temp ไปไว้ที่ตำแหน่ง maxIndex
		}
	}

}
