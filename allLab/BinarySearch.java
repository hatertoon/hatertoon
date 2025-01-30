import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        // อาร์เรย์ที่จัดเรียงลำดับไว้ล่วงหน้า
        int[] numbers = {0, 11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999};

        Scanner scanner = new Scanner(System.in);

        // รับค่าที่ต้องการค้นหา
        System.out.print("Search ID: ");
        int searchID = scanner.nextInt();

        // เรียกใช้ฟังก์ชัน Binary Search
        int result = binarySearch(numbers, searchID);

        // แสดงผลลัพธ์
        if (result == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found at Number[" + result + "] : " + numbers[result]);
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int target) {
        int first = 0;
        int last = array.length - 1; //first และ last เพื่อบอกขอบเขตของช่วงที่ต้องค้นหาภายในอาร์เรย์

        while (first <= last) { //เริ่มลูป while ที่จะทำงานต่อเนื่องจนกว่าตำแหน่งแรก (first) จะไม่เกินตำแหน่งสุดท้าย (last)
            System.out.println("first : " + first + " last : " + last);
            int mid = (first + last) / 2; //คำนวณตำแหน่งกลาง (mid)

            if (array[mid] == target) {
                return mid; // เจอค่าแล้ว
            } else if (array[mid] < target) {
                first = mid + 1; // เลื่อนไปค้นหาทางขวา
            } else {
                last = mid - 1; // เลื่อนไปค้นหาทางซ้าย
            }
        }

        return -1; // ค้นหาไม่พบ
    }
}
