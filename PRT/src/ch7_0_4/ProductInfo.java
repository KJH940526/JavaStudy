//package ch7_0_4;
//
//import java.util.Scanner;
//
//public class ProductInfo {
//	   int productID = 0;
//	   int numberOfProduct = 0;
//	   Product[] p = new Product[10];
//	   
//	   public static void main (String[] args) { 
//	      Scanner sin = new Scanner(System.in);
//	      int choice = 0;
//	      while (choice != 3) { 
//	         int type;
//	         System.out.print("��ǰ �߰�(1), ��� ��ǰ ��ȸ(2), ������(3)>>");
//	         choice = sin.nextInt();
//	         switch (choice) {
//	            case 1:   // ��ǰ �߰�
//	               if (numberOfProduct >= p.length) {
//	                  System.out.println("�� �̻� �߰��� �� �����ϴ�.");
//	                  break;
//	               }
//	               System.out.print("��ǰ ���� å(1), ����CD(2), ȸȭå(3)>>");
//	               type = sin.nextInt();
//	               if (type < 1 || type > 3) {
//	                  System.out.println("�߸���  ��ǰ �����Դϴ�.");
//	                  break;
//	               }
//	               addProduct(type);
//	               break;
//	            case 2:   // ��� ��ǰ ��ȸ
//	               for (int i=0; i<numberOfProduct; i++)
//	                  p[i].showInfo();
//	               break;
//	            case 3:   // ������
//	               break;
//	            default:
//	               System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//	         }
//	      }
//	   }
//
//	   private static void addProduct(int type) {
//	      Scanner sin = new Scanner(System.in);
//	      System.out.print("��ǰ ����>>");
//	      String desc = sin.nextLine();
//	      System.out.print("������>>");
//	      String maker = sin.nextLine();
//	      System.out.print("����>>");
//	      int price = sin.nextInt();
//	      sin.nextLine();
//	      switch (type) {
//	         case 1: // å
//	            System.out.print("å ����>>");
//	            String title = sin.nextLine();
//	            System.out.print("����>>");
//	            String author = sin.nextLine();
//	            System.out.print("ISBN>>");
//	            int ISBN = sin.nextInt();
//	            p[numberOfProduct] = new Book(productID++, desc, maker, price, ISBN, title, author);
//	            break;
//	         case 2: // ���� CD
//	            System.out.print("�ٹ� ����>>");
//	            String albumTitle = sin.nextLine();
//	            System.out.print("����>>");
//	            String artist = sin.nextLine();
//	            p[numberOfProduct] = new CompactDisc(productID++, desc, maker, price, albumTitle, artist);
//	            break;
//	         case 3: // ȸȭå
//	            System.out.print("å ����>>");
//	            String title2 = sin.nextLine();
//	            System.out.print("����>>");
//	            String author2 = sin.nextLine();
//	            System.out.print("���>>");
//	            String language = sin.nextLine();
//	            System.out.print("ISBN>>");
//	            int ISBN2 = sin.nextInt();
//	            p[numberOfProduct] = new ConversationBook(productID++, desc, maker, price, ISBN2, title2, author2, language);
//	            break;
//	      }
//	      numberOfProduct++;
//	   }
//	}
//
