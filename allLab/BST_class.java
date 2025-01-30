import java.util.*;

class BST_class {
    Node root;

    // Node class 
    class Node { //สำหรับเก็บข้อมูลในแต่ละโหนด (Node)
        int key; //เก็บค่าของโหนด
        Node left, right; //เก็บข้อมูลของโหนดลูกซ้าย (left) และลูกขวา (right)

        public Node(int data) { //สำหรับสร้างโหนดใหม่
            key = data;
            left = right = null; //โดยกำหนดค่าเริ่มต้นและตั้งค่า left กับ right เป็น null
        }
    }

    // Constructor
    BST_class() {
        root = null;//กำหนดค่าเริ่มต้นของ root เป็น null = ค่าว่างเปล่า
    }

    // Insert method
    void insert(int key) {
        root = insert_Recursive(root, key); //ฟังก์ชันสำหรับแทรกค่าลงในต้นไม้
    }

    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key); //ให้สร้างโหนดใหม่
            return root; 
        }
        if (key < root.key) //ถ้าค่า key น้อยกว่า root.key ให้แทรกไปที่โหนดซ้าย
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key) //ถ้าค่า key มากกว่า root.key ให้แทรกไปที่โหนดขวา
            root.right = insert_Recursive(root.right, key);
        return root;
    }

    // Inorder traversal
    void inorder() {
        System.out.println("In order ... ");
        inorder_Recursive(root); //เรียกฟังก์ชัน inorder_Recursive เพื่อแสดงค่าตามลำดับ Inorder
        System.out.println();
    }

    void inorder_Recursive(Node root) {
        if (root != null) { //ฟังก์ชันแบบ recursive เดินทางโหนดซ้าย → โหนดราก → โหนดขวา
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        System.out.println("Post order ... ");
        postorder_Recursive(root); //เรียกฟังก์ชัน postorder_Recursive เพื่อแสดงค่าตามลำดับ Postorder
        System.out.println();
    }

    void postorder_Recursive(Node root) {
        if (root != null) { //ฟังก์ชันแบบ recursive เดินทางโหนดซ้าย → โหนดขวา → โหนดราก 
            postorder_Recursive(root.left);
            postorder_Recursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method
    public static void main(String[] args) {
        BST_class bst = new BST_class();
        Scanner input = new Scanner(System.in); //ใช้ Scanner เพื่อรับค่าจากผู้ใช้

        // รับค่าจำนวน 10 ค่า
        for (int i = 0; i < 10; i++) {
            int num = input.nextInt(); //รับค่าจำนวน 10 ค่า (num) จากผู้ใช้และแทรกลงใน BST ด้วยฟังก์ชัน insert
            bst.insert(num);
        }

        // แสดงผลลัพธ์ Inorder และ Postorder
        bst.inorder();
        bst.postorder();
    }
}
// ตัวแรก = root.key
// Inorder Traversal (โหนดซ้าย → ราก → โหนดขวา)
//Postorder Traversal (โหนดซ้าย → โหนดขวา → ราก)
