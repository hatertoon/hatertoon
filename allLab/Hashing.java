import java.util.Scanner;

class Hashing {
    private int[] hash_table = new int[10]; //hash_table เป็นอาเรย์ขนาด 10 ที่เก็บค่า Integer

    // Constructor: กำหนดค่าเริ่มต้นของ Hash Table เป็น -1 (หมายถึงว่าง)
    Hashing() {
        for (int j = 0; j < 10; j++) {
            hash_table[j] = -1; //hash_table จะถูกตั้งค่าเริ่มต้นเป็น -1 ทุกตำแหน่ง
        }// -1 หมายความว่าแต่ละตำแหน่งในตารางยังไม่มีข้อมูล (เป็นช่องว่าง)
    }

    // Method สำหรับแทรกค่าเข้าใน Hash Table
    public void insert(int key) {
        int index = key % 10; // เราจะหาตำแหน่ง index โดยใช้ mod 10
        //ตัวอย่าง: ถ้า key = 45 → 45 % 10 = 5 → ค่า index จะเป็น 5
        
        while (hash_table[index] != -1) { // ตรวจสอบว่าช่องนี้ว่างหรือไม่
            index = (index + 1) % 10; // ถ้าไม่ว่าง ให้เลื่อนไปยังช่องถัดไป (Linear Probing)
        }
        hash_table[index] = key; // เมื่อเจอช่องที่ว่าง (ค่า -1), เราจะเก็บค่า key ลงในช่องนั้น
    }

    // Method สำหรับแสดงผลข้อมูลใน Hash Table
    public void display() {
        System.out.print("Table: ");
        for (int i = 0; i < 10; i++) {
            if (hash_table[i] == -1) {
                System.out.print("* "); // ถ้าช่องนั้นว่าง (ค่า -1), จะแสดง *
            } else {
                System.out.print(hash_table[i] + " "); // ถ้ามีข้อมูลในช่องนั้น (ค่าไม่เป็น -1), จะแสดงค่าของโหนดในช่องนั้น
            }
        }
        System.out.println(); // ขึ้นบรรทัดใหม่
    }

    // Main Method
    public static void main(String[] args) {
        Hashing hashtab = new Hashing();
        Scanner input = new Scanner(System.in); // รับค่า input จากผู้ใช้

        for (int i = 0; i < 7; i++) { // ป้อนค่าผู้ใช้ 7 ตัว
            int num = Integer.parseInt(input.nextLine()); 
            // ทำหน้าที่รับข้อมูลจากผู้ใช้ที่เป็นข้อความ (String) แล้วแปลงข้อความนั้นให้เป็นตัวเลขจำนวนเต็ม (Integer) และเก็บไว้ในตัวแปร num
            hashtab.insert(num); // แทรกค่าลงใน Hash Table
        }

        hashtab.display(); // แสดงผล Hash Table
    }
}
