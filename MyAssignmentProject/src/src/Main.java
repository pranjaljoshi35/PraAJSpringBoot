package src;

import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		String name,type,option;
		int price,quantity;
		Item item;
		ArrayList<Item> bill=new ArrayList<Item>();
		Scanner scanner= new Scanner(System.in);
		String ans="y";
		while(ans.equals("y")) {
			item= new Item();
		
			for (int i=0;i<=3;i++)
			{
				option = scanner.next();
				if(option.equals("-name")) {
					name=scanner.next();
					item.setName(name);
				}
				else if(option.equals("-price")) {
					price=scanner.nextInt();
					item.setPrice(price);
				}
				else if(option.equals("-quantity")) {
					quantity=scanner.nextInt();
					item.setQuantity(quantity);
				}
				else if(option.equals("-type")) {
					boolean correct_type=false;
					while(!correct_type) {
					try {
					type=scanner.next();
					item.setType(type);
					correct_type=true;
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					}
					
			}
			}
			item.setsalesTaxandEffectiveCost();
			bill.add(item);
			System.out.println("Do you want to enter details of anyother item(y/n)");
			ans=scanner.next();
		}
		System.out.println("ItemName | Price | Sales Tax Liability | Final Price");
		for(Item i:bill) {
			System.out.println(i.getName());
			System.out.println(i.getPrice());
			System.out.println(i.getSalesTax());
			System.out.println(i.getEffectiveCost());
			System.out.println();

		}
		
		
	}

}
