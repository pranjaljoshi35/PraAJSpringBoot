package src;


public class Item {
	private String name,type;
	private int price,quantity;
	private double salesTax;
	private double effectiveCost;
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public void setType(String type) throws Exception {
		if(!(type.equals("Raw") || type.equals("Manufactured") ||  type.equals("Imported"))) {
			throw new Exception("The type of the item seems to be incorrect,please enter one of the following options \n 1. RAW \n 2.Manufactured \n 3.Imported");
		}
		else {
			this.type=type;
		}
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String getTypeName() {
		return this.type;
	}
	
	public double getSalesTax() {
		return this.salesTax;
	}
	public double getEffectiveCost() {
		return this.effectiveCost;
	}
	public void setsalesTaxandEffectiveCost() {
		if (this.type.equals("Raw")) {
			this.effectiveCost=this.price+(0.125*this.price);
			this.salesTax=(0.125*this.price);

		}
		else if(this.type.equals("Manufactured")) {
			this.salesTax=(0.125*this.price)+0.02*(this.price+0.125*this.price);
			this.effectiveCost=this.price+(0.125*this.price)+0.02*(this.price+0.125*this.price);

		}
		else if (this.type.equals("Imported")) {
			this.effectiveCost=this.price+(0.1*this.price);
			this.salesTax=(0.1*this.price);

			if(this.effectiveCost<=100) {
				this.salesTax+=5;
				this.effectiveCost+=+5;
			}
			else if(this.effectiveCost>100 && this.effectiveCost<=200) {
				this.salesTax+=10;
				this.effectiveCost+=+10;


			}
			else {
				this.salesTax+=0.05*this.effectiveCost;
				this.effectiveCost+=0.05*this.effectiveCost;

			}
		}
		}
		
		
	}

