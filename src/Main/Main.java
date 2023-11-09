package Main;

import Model.Controller;
import Model.Tree;
import Model.TreeNode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(5);
        Controller<Integer> controller = new Controller<>(tree);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar dato");
            System.out.println("2. Buscar dato");
            System.out.println("3. Tamaño del árbol");
            System.out.println("4. Eliminar dato");
            System.out.println("5. Recorrido preorden");
            System.out.println("6. Recorrido inorden");
            System.out.println("7. Recorrido postorden");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    int insertData = scanner.nextInt();
                    controller.insertData(insertData);
                    break;
                case 2:
                    System.out.print("Ingrese el dato a buscar: ");
                    int searchData = scanner.nextInt();
                    TreeNode<Integer> foundNode = controller.lookUp(searchData);
                    if (foundNode != null) {
                        System.out.println("Elemento encontrado: " + foundNode.getData());
                    } else {
                        System.out.println("Elemento no encontrado");
                    }
                    break;
                case 3:
                    int size = controller.treeSize();
                    System.out.println("Tamaño del árbol: " + size);
                    break;
                case 4:
                    System.out.print("Ingrese el dato a eliminar: ");
                    int popData = scanner.nextInt();
                    controller.pop(popData);
                    break;
                case 5:
                    System.out.println("Recorrido preorden:");
                    controller.preOrder();
                    break;
                case 6:
                    System.out.println("Recorrido inorden:");
                    controller.inOrder();
                    break;
                case 7:
                    System.out.println("Recorrido postoder");
                    controller.postOrder();
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
