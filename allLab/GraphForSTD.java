package test;

import java.util.*;

class Graphs<T> {

    // สร้าง HashMap ที่ใช้เก็บโครงสร้างของกราฟ โดย map จะเก็บ Vertex เป็น Key และ List ของ Vertex ที่เชื่อมต่อกับมันเป็น Value
    private Map<T, List<T>> map = new HashMap<>();

    // เพิ่ม Vertex ใหม่ลงในกราฟ โดยสร้าง Key ใหม่ใน map และกำหนด Value เป็น LinkedList ว่างสำหรับเก็บ Vertex ที่เชื่อมต่อกับมัน
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    // เพิ่ม Edge ระหว่าง source และ destination
    public void addEdge(T source, T destination, boolean bidirectional) {
    	
    	//ตรวจสอบว่ามี Vertex source และ destination หรือยัง ถ้ายังไม่มี จะเพิ่มเข้าไป
        if (!map.containsKey(source))
            addVertex(source);
        //เพิ่ม destination ใน List ของ Vertex source
        if (!map.containsKey(destination))
            addVertex(destination);
        //ถ้าเป็นกราฟแบบสองทิศทาง (bidirectional) ก็เพิ่ม source ใน List ของ Vertex destination
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // นับจำนวน Vertex โดยใช้ map.size() และแสดงข้อความว่าในกราฟมี Vertex กี่ตัว
    public void getVertexCount() {
        int vertexCount = map.size();
        if (vertexCount == 1) {
            System.out.println("The graph has 1 vertex.");
        } else {
            System.out.println("The graph has " + vertexCount + " vertices.");
        }
    }

    // นับจำนวน Edge
    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        //รวมจำนวน Edge ของ Vertex ทั้งหมดใน map
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2; // หากเป็นกราฟสองทิศทาง (bidirectional) จะหารสองเพื่อไม่นับ Edge ซ้ำ
        }
        if (count == 1) {
            System.out.println("The graph has 1 edge.");
        } else {
            System.out.println("The graph has " + count + " edges.");
        }
    }

    // ตรวจสอบว่ามี Vertex s ในกราฟหรือไม่
    public void hasVertex(T s) {
        if (map.containsKey(s)) { //ถ้ามี แสดงข้อความว่ากราฟมี Vertex นั้น
            System.out.println("The graph contains " + s + " as a vertex.");
        } else { //ถ้าไม่มี แสดงข้อความว่ากราฟไม่มี Vertex นั้น
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    // ตรวจสอบว่าในกราฟมี Edge ระหว่าง Vertex s และ d หรือไม่
    public void hasEdge(T s, T d) {
        if (map.get(s).contains(d)) { //ถ้ามี แสดงข้อความว่ามีการเชื่อมต่อ
            System.out.println("The graph has an edge between vertex " + s + " and " + d + ".");
        } else { //ถ้าไม่มี แสดงข้อความว่าไม่มีการเชื่อมต่อ
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    // แปลงโครงสร้างของกราฟเป็นข้อความ (String) เพื่อแสดงผล
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //แต่ละ Vertex (Key) จะตามด้วย List ของ Vertex ที่เชื่อมต่อกับมัน (Value)
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}

public class GraphForSTD {
    public static void main(String args[]) {

        // สร้างออบเจกต์ Graphs ที่ใช้ Integer เป็นชนิดข้อมูลของ Vertex
        Graphs<Integer> g = new Graphs<Integer>();

        // เพิ่ม Edge ระหว่าง Vertex ต่างๆ:
        // ตัวอย่างเช่น g.addEdge(0, 1, true) จะเชื่อม Vertex 0 กับ 1 ในทิศทางทั้งสอง
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // แสดงโครงสร้างของกราฟ
        System.out.println("Graph:");
        System.out.println(g.toString());

        // แสดงจำนวน Vertex ในกราฟ
        g.getVertexCount();

        // แสดงจำนวน Edge ในกราฟ (นับแบบสองทิศทาง)
        g.getEdgesCount(true);

        // ตรวจสอบว่ามี Edge ระหว่าง Vertex 3 และ 4 หรือไม่
        g.hasEdge(3, 4);

        // ตรวจสอบว่ามี Vertex 5 อยู่ในกราฟหรือไม่
        g.hasVertex(5);
    }
}
