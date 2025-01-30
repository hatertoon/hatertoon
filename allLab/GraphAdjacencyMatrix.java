import java.util.Scanner;

public class GraphAdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // รับค่าจำนวนเวอร์เท็กซ์ (vertices) จากผู้ใช้
        System.out.print("How many vertices? ");
        int vertices = scanner.nextInt();
        // ถ้าจำนวนเวอร์เท็กซ์ไม่อยู่ในช่วง 1 ถึง 9 จะพิมพ์ข้อความเตือน และจบโปรแกรมทันที
        if (vertices > 9 || vertices < 1) {
            System.out.println("The number of vertices must be between 1 and 9.");
            return;
        }

        // สร้าง Adjacency Matrix เป็นอาเรย์ 2 มิติ (vertices x vertices) เพื่อเก็บความสัมพันธ์ระหว่างเวอร์เท็กซ์
        int[][] adjacencyMatrix = new int[vertices][vertices];

        // วนลูปเพื่อรับข้อมูลเวอร์เท็กซ์ข้างเคียง
        for (int i = 0; i < vertices; i++) {
            System.out.println("Adjacent of vertex " + i + ":"); //เริ่มวนซ้ำตามจำนวนเวอร์เท็กซ์ (i) และแสดงข้อความว่า "Adjacent of vertex i"
            while (true) {
                int adjacentVertex = scanner.nextInt(); //รับค่า adjacentVertex จากผู้ใช้
                if (adjacentVertex == -1) { //ลูป while (true) จะทำงานจนกว่าจะได้รับค่าที่ผู้ใช้ป้อนเป็น -1
                    break; //ถ้าผู้ใช้ป้อน -1 จะออกจากลูป while
                }
                if (adjacentVertex >= 0 && adjacentVertex < vertices) { //ตรวจสอบว่าค่า adjacentVertex อยู่ในช่วงที่ถูกต้องหรือไม่
                    adjacencyMatrix[i][adjacentVertex] = 1; // ถ้าถูกต้อง ให้ตั้งค่าใน adjacencyMatrix เป็น 1 เพื่อแสดงว่ามีการเชื่อมต่อ
                } else { //ถ้าผิด จะแสดงข้อความเตือน
                    System.out.println("Invalid vertex. Please enter a value between 0 and " + (vertices - 1));
                }
            }
        }

        // แสดง Adjacency Matrix
        System.out.println("Adjacency Matrix:");
        System.out.print("   |"); //พิมพ์หัวตารางสำหรับหมายเลขเวอร์เท็กซ์
        for (int i = 0; i < vertices; i++) {
            System.out.print(" " + i);
        }
        System.out.println();//วนลูปเพื่อพิมพ์หมายเลขเวอร์เท็กซ์ทั้งหมดในแถวแรก

        // สร้างเส้นแบ่งด้วยลูปแทน repeat()
        System.out.print("---"); //ใช้ลูปพิมพ์ --- ให้มีจำนวนเท่ากับจำนวนเวอร์เท็กซ์
        for (int i = 0; i < vertices; i++) { 
            System.out.print("---");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) { //วนลูปภายใน (for j) เพื่อพิมพ์ค่าในแต่ละเซลล์ของ adjacencyMatrix
            System.out.print(" " + i + " |"); //พิมพ์หมายเลขเวอร์เท็กซ์ (Index) ที่ตำแหน่งแรกของแต่ละแถว
            for (int j = 0; j < vertices; j++) {
                System.out.print(" " + adjacencyMatrix[i][j]);
            }
            System.out.println(); //ขึ้นบรรทัดใหม่เมื่อจบการพิมพ์แถว
        }

        scanner.close();
    }
}
