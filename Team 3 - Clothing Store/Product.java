package module;
import java.util.*;

public class Product {
	public String gender;
	public String category;
	public String productType;
	public String brand;
	public float productPrice;
	public String productName;
	public String productSize;
	
	public HashMap<String,HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>> createData(){
		
		//Sweaters
		HashMap<String,ArrayList<Item>> sweaters = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> hm = new ArrayList<Item>();
	    Item i = new Item("Black Sweater","M",1495);
	    hm.add(i);
	    i = new Item("Teal Sweater","L",1499);
	    hm.add(i);
	    
		
		ArrayList<Item> f21 = new ArrayList<Item>();
		i = new Item("Orange Sweater","M",1100);
		f21.add(i);
		i = new Item("Yellow Sweater","M",1000);
		f21.add(i);
		
		
		ArrayList<Item> j21 = new ArrayList<Item>();
		i = new Item("Gray Sweater","L",800);
		j21.add(i);
		
		sweaters.put("H&M", hm);
		sweaters.put("Forever 21", f21);
		sweaters.put("Jealous 21", j21);
		
		
		//Hoodies
		HashMap<String,ArrayList<Item>> hoodies = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> puma = new ArrayList<Item>();
		i = new Item("Neon Hoodie","M",2500);
		puma.add(i);
		i = new Item("Crimson Hoodie","L",2350);
		puma.add(i);
		i = new Item("Red Hoodie","M",2400);
		puma.add(i);
		
		
		ArrayList<Item> nike = new ArrayList<Item>();
		i = new Item("Turqoise Hoodie","M",3200);
		nike.add(i);
		i = new Item("Ocean Green Hoodie","M",3100);
		nike.add(i);
		
		hoodies.put("Puma", puma);
		hoodies.put("Nike", nike);
		
		
		//Club Sweaters and Hoodies into TopWear
		HashMap<String,HashMap<String,ArrayList<Item>>> topWear = new HashMap<String,HashMap<String,ArrayList<Item>>>();
		topWear.put("Sweaters",sweaters);
		topWear.put("Hoodies",hoodies);
		
		
		//Chinos
		HashMap<String,ArrayList<Item>> chinos = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> lp = new ArrayList<Item>();
		i = new Item("Army Green Chinos","S",1300);
		lp.add(i);
		
		ArrayList<Item> jj = new ArrayList<Item>();
		i = new Item("Brown Chinos","S",1400);
		jj.add(i);
		i = new Item("OffWhite Chinos","M",1500);
		jj.add(i);
			
		chinos.put("Louis Philippe", lp);
		chinos.put("Jack & Jones", jj);
		
			
		//Formals
		HashMap<String,ArrayList<Item>> formals = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> pe = new ArrayList<Item>();
		i = new Item("Black Formal Trousers","M",1700);
		pe.add(i);
		i = new Item("Blue Formal Trousers","L",1750);
		pe.add(i);
		
		
		ArrayList<Item> ray = new ArrayList<Item>();
		i = new Item("Cream Formal Trousers","M",1800);
		ray.add(i);
				
		formals.put("Peter England", pe);
		formals.put("Raymond", ray);
				
			
		//Club Chinos and Formals into BottomWear
		HashMap<String,HashMap<String,ArrayList<Item>>> bottomWear = new HashMap<String,HashMap<String,ArrayList<Item>>>();
		bottomWear.put("Chinos",chinos);
		bottomWear.put("Formals",formals);
		
		
		//Tops
		HashMap<String,ArrayList<Item>> tops = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> zara = new ArrayList<Item>();
		i = new Item("Lilac Top","XS",1950);
		zara.add(i);
		i = new Item("Pink Floral Top","L",1800);
		zara.add(i);
		i = new Item("White Lace Top","M",1850);
		zara.add(i);
		
		ArrayList<Item> gucci = new ArrayList<Item>();
		i = new Item("Black Off-Shoulder Top","S",5400);
		gucci.add(i);
		i = new Item("Brown Leather Top","S",5100);
		gucci.add(i);
		
		ArrayList<Item> and = new ArrayList<Item>();
		i = new Item("Drop-Shoulder Lavender Top","M",1200);
		and.add(i);
		i = new Item("Turqoise Netted Top","S",1100);
		and.add(i);
				
		tops.put("Zara", zara);
		tops.put("Gucci", gucci);
		tops.put("AND", and);
		
		
		//T-shirts
		HashMap<String,ArrayList<Item>> tees = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> on = new ArrayList<Item>();
		i = new Item("Lilac Tee","S",600);
		on.add(i);
		i = new Item("Pink Floral Tee","XS",499);
		on.add(i);
		
		
		ArrayList<Item> ho = new ArrayList<Item>();
		i = new Item("Black Graphic Tee","S",300);
		ho.add(i);
		i = new Item("Teal Solid Tee","M",399);
		ho.add(i);
		
		tees.put("ONLY", on);
		tees.put("Honey", ho);
		
		
		//Club Tops and T-shirts into F_Top
		HashMap<String,HashMap<String,ArrayList<Item>>> f_top = new HashMap<String,HashMap<String,ArrayList<Item>>>();
		f_top.put("Tops",tops);
		f_top.put("Tees",tees);
		
		//Shorts
		HashMap<String,ArrayList<Item>> shorts = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> v = new ArrayList<Item>();
		i = new Item("Denim Shorts","L",1200);
		v.add(i);
		i = new Item("White Cotton Shorts","M",1000);
		v.add(i);
		
		ArrayList<Item> m = new ArrayList<Item>();
		i = new Item("Black Denim Shorts","S",1200);
		m.add(i);
		i = new Item("Blue Denim Shorts","S",1100);
		m.add(i);
		
		shorts.put("Veromoda", v);
		shorts.put("MANGO", m);
		
		
		//Skirts
		HashMap<String,ArrayList<Item>> skirts = new HashMap<String,ArrayList<Item>>();
		
		ArrayList<Item> bi = new ArrayList<Item>();
		i = new Item("Red Long Skirt","M",1100);
		bi.add(i);
		i = new Item("Yellow Pleated Skirt","M",1200);
		bi.add(i);
		
		ArrayList<Item> db = new ArrayList<Item>();
		i = new Item("Red Mini Skirt","S",700);
		db.add(i);
		i = new Item("Black Skirt","M",800);
		db.add(i);
		
		skirts.put("Biba", bi);
		skirts.put("DressBerry", db);
		
		
		//Club Shorts and Skirts into F_Bottom
		HashMap<String,HashMap<String,ArrayList<Item>>> f_bottom = new HashMap<String,HashMap<String,ArrayList<Item>>>();
		f_bottom.put("Shorts",shorts);
		f_bottom.put("Skirts",skirts);
		
		
		//Club TopWear and BottomWear into MensProduct
		HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>> mensProduct = new HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>();
		mensProduct.put("Top Wear",topWear);
		mensProduct.put("Bottom Wear",bottomWear);
		
		//Club F_Top and F_Bottom into WomensProduct
		HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>> womensProduct = new HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>();
		womensProduct.put("Top Wear",f_top);
		womensProduct.put("Bottom Wear",f_bottom);
		
		//Club MensProduct and F_WomenProduct into Product(Gender wise)
		HashMap<String,HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>> gen = new HashMap<String,HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>>();
		gen.put("Men",mensProduct);
		gen.put("Women",womensProduct);
		return gen;
	}
	
	public Product chooseProduct(HashMap<String,HashMap<String,HashMap<String,HashMap<String,ArrayList<Item>>>>> gen){
		int i = 1; //iterator
		String prod = " "; //temporary storage of productName
		
		System.out.println("\t ----------------Welcome To EmmaLove!----------------");
		System.out.println("\t");
		System.out.println("\t ---------------------Shop For-----------------------");
		System.out.println("\t 1. Men");
		System.out.println("\t 2. Women");
		System.out.println("\t 3. Exit");
		System.out.println("\t ----------------------------------------------------");
		
		Scanner s1 = new Scanner(System.in);  
	    System.out.println("\t Enter your choice : ");
		int ch1 = s1.nextInt();
		
		switch(ch1){
			case 1 : //set gender to Men
				this.gender = "Men";
				
				System.out.println("\t -------------------Choose Category------------------");
				for(String str : gen.get("Men").keySet()){
					System.out.printf("\t %d. ", i);
					System.out.print(str);
					System.out.println("\t");
					i++;
				}
				System.out.println("\t ----------------------------------------------------");
				
				System.out.println("\t Enter your choice : ");
				int ch2 = s1.nextInt();
				
				switch(ch2){
					case 1: //set category to TopWear
						this.category = "Top Wear";
						
						System.out.println("\t -----------------Pick Product Type------------------");
						i = 1;
						for(String str : gen.get("Men").get("Top Wear").keySet()){
							System.out.printf("\t %d. ", i);
							System.out.print(str);
							System.out.println("\t");
							i++;
						}
						System.out.println("\t ----------------------------------------------------");
						System.out.println("\t Enter your choice : ");
						int ch3 = s1.nextInt();
						
						switch(ch3){
							case 1 : //set productType to Hoodies
								this.productType = "Hoodies";
								
								System.out.println("\t ------------------Choose the brand------------------");
								i = 1;
								for(String str : gen.get("Men").get("Top Wear").get("Hoodies").keySet()){
									System.out.printf("\t %d. ", i);
									System.out.print(str);
									System.out.println("\t");
									i++;
								}
								System.out.println("\t ----------------------------------------------------");
								System.out.println("\t Enter your choice : ");
								int ch4 = s1.nextInt();
								
								switch(ch4){
									case 1 : //brand = Nike
										this.brand = "Nike";
										
										i = 0;
										for(Item it : gen.get("Men").get("Top Wear").get("Hoodies").get("Nike")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch51 = s1.nextInt();
										
										for(i = 0; i < 2; i++){
											if((ch51-1) == i){
												Item it = gen.get("Men").get("Top Wear").get("Hoodies").get("Nike").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
										
									case 2 : //brand = Puma	
										this.brand = "Puma";
										i = 0;
										for(Item it : gen.get("Men").get("Top Wear").get("Hoodies").get("Puma")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch52 = s1.nextInt();
										
										for(i = 0; i < 3; i++){
											if((ch52-1) == i){
												Item it = gen.get("Men").get("Top Wear").get("Hoodies").get("Puma").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
								}
								break;
						
							case 2 : //set productType to Sweaters
								this.productType = "Sweaters";
								
								System.out.println("\t ------------------Choose the brand------------------");
								i = 1;
								for(String str : gen.get("Men").get("Top Wear").get("Sweaters").keySet()){
									System.out.printf("\t %d. ", i);
									System.out.print(str);
									System.out.println("\t");
									i++;
								}
								System.out.println("\t ----------------------------------------------------");
								System.out.println("\t Enter your choice : ");
								int ch42 = s1.nextInt();
								
								switch(ch42){
									case 1 : //brand = F21
										this.brand = "Forever 21";
								        
										i = 0;
										for(Item it : gen.get("Men").get("Top Wear").get("Sweaters").get("Forever 21")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch53 = s1.nextInt();
										
										for(i = 0; i < 2; i++){
											if((ch53-1) == i){
												Item it = gen.get("Men").get("Top Wear").get("Sweaters").get("Forever 21").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
										
									case 2 : //brand = J21
										this.brand = "Jealous 21";
										
										i = 0;
										for(Item it : gen.get("Men").get("Top Wear").get("Sweaters").get("Jealous 21")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch54 = s1.nextInt();
										
										for(i = 0; i < 1; i++){
											if((ch54-1) == i){
												Item it = gen.get("Men").get("Top Wear").get("Sweaters").get("Jealous 21").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
										
									case 3 : //brand = H&M	
										this.brand = "H&M";
										
										i = 0;
										for(Item it : gen.get("Men").get("Top Wear").get("Sweaters").get("H&M")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch55 = s1.nextInt();
										
										for(i = 0; i < 2; i++){
											if((ch55-1) == i){
												Item it = gen.get("Men").get("Top Wear").get("Sweaters").get("H&M").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
								}
								break;
						}
						break;
						
					case 2 :
						this.category = "Bottom Wear";
						
						System.out.println("\t -----------------Pick Product Type------------------");
						i = 1;
						for(String str : gen.get("Men").get("Bottom Wear").keySet()){
							System.out.printf("\t %d. ", i);
							System.out.print(str);
							System.out.println("\t");
							i++;
						}
						System.out.println("\t ----------------------------------------------------");
						System.out.println("\t Enter your choice : ");
						int ch32 = s1.nextInt();
						
						switch(ch32){
							case 1 : //set productType to Chinos
								this.productType = "Chinos";
								
								System.out.println("\t ------------------Choose the brand------------------");
								i = 1;
								for(String str : gen.get("Men").get("Bottom Wear").get("Chinos").keySet()){
									System.out.printf("\t %d. ", i);
									System.out.print(str);
									System.out.println("\t");
									i++;
								}
								System.out.println("\t ----------------------------------------------------");
								System.out.println("\t Enter your choice : ");
								int ch43 = s1.nextInt();
								
								switch(ch43){
									case 1 : //brand = J&J
										this.brand = "Jack & Jones";
										
										i = 0;
										for(Item it : gen.get("Men").get("Bottom Wear").get("Chinos").get("Jack & Jones")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch56 = s1.nextInt();
										
										for(i = 0; i < 2; i++){
											if((ch56-1) == i){
												Item it = gen.get("Men").get("Bottom Wear").get("Chinos").get("Jack & Jones").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
										
									case 2 : //brand = LP
										this.brand = "Louis Philippe";
										
										i = 0;
										for(Item it : gen.get("Men").get("Bottom Wear").get("Chinos").get("Louis Philippe")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch57 = s1.nextInt();
										
										for(i = 0; i < 1; i++){
											if((ch57-1) == i){
												Item it = gen.get("Men").get("Bottom Wear").get("Chinos").get("Louis Philippe").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
								}
								break;
								
							case 2 : //set productType to Formals
								this.productType = "Formals";
								
								System.out.println("\t ------------------Choose the brand------------------");
								i = 1;
								for(String str : gen.get("Men").get("Bottom Wear").get("Formals").keySet()){
									System.out.printf("\t %d. ", i);
									System.out.print(str);
									System.out.println("\t");
									i++;
								}
								System.out.println("\t ----------------------------------------------------");
								System.out.println("\t Enter your choice : ");
								int ch44 = s1.nextInt();
								
								switch(ch44){
									case 1 : //brand = Raymond
										this.brand = "Raymond";
										
										i = 0;
										for(Item it : gen.get("Men").get("Bottom Wear").get("Formals").get("Raymond")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch58 = s1.nextInt();
										
										for(i = 0; i < 1; i++){
											if((ch58-1) == i){
												Item it = gen.get("Men").get("Bottom Wear").get("Formals").get("Raymond").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
										
									case 2 : //brand = Peter England, price = 1700
										this.brand = "Peter England";
										
										i = 0;
										for(Item it : gen.get("Men").get("Bottom Wear").get("Formals").get("Peter England")){
											System.out.printf("\t %d. ", i+1);
											System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
											System.out.println("\t");
											i++;
										}
										System.out.println("\t Choose Product : ");
										int ch59 = s1.nextInt();
										
										for(i = 0; i < 2; i++){
											if((ch59-1) == i){
												Item it = gen.get("Men").get("Bottom Wear").get("Formals").get("Peter England").get(i);
												this.productName = it.name;
												this.productPrice = it.price;
												this.productSize = it.size;
											}
										}
										break;
								}
								break;
						}
						break;
				}	
				
				break;
				
			case 2 : // set gender to Women
				this.gender = "Women";
				
				System.out.println("\t -------------------Choose Category------------------");
				for(String str : gen.get("Women").keySet()){
					System.out.printf("\t %d. ", i);
					System.out.print(str);
					System.out.println("\t");
					i++;
				}
				System.out.println("\t ----------------------------------------------------");
				
				System.out.println("\t Enter your choice : ");
				int ch22 = s1.nextInt();
				
				switch(ch22){
				case 1: //set category to TopWear
					this.category = "Top Wear";
					
					System.out.println("\t -----------------Pick Product Type------------------");
					i = 1;
					for(String str : gen.get("Women").get("Top Wear").keySet()){
						System.out.printf("\t %d. ", i);
						System.out.print(str);
						System.out.println("\t");
						i++;
					}
					System.out.println("\t ----------------------------------------------------");
					System.out.println("\t Enter your choice : ");
					int ch33 = s1.nextInt();
					
					switch(ch33){
						case 1 : //set productType to Tees
							this.productType = "Tees";
							
							System.out.println("\t ------------------Choose the brand------------------");
							i = 1;
							for(String str : gen.get("Women").get("Top Wear").get("Tees").keySet()){
								System.out.printf("\t %d. ", i);
								System.out.print(str);
								System.out.println("\t");
								i++;
							}
							System.out.println("\t ----------------------------------------------------");
							System.out.println("\t Enter your choice : ");
							int ch45 = s1.nextInt();
							
							switch(ch45){
								case 1 : //brand = Honey
									this.brand = "Honey";
									
									i = 0;
									for(Item it : gen.get("Women").get("Top Wear").get("Tees").get("Honey")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch510 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch510-1) == i){
											Item it = gen.get("Women").get("Top Wear").get("Tees").get("Honey").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
									
								case 2 : //brand = ONLY
									this.brand = "ONLY";
									
									i = 0;
									for(Item it : gen.get("Women").get("Top Wear").get("Tees").get("ONLY")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch511 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch511-1) == i){
											Item it = gen.get("Women").get("Top Wear").get("Tees").get("ONLY").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
							}
							break;
							
						case 2 : //set productType to Tops
							this.productType = "Tops";
							
							System.out.println("\t ------------------Choose the brand------------------");
							i = 1;
							for(String str : gen.get("Women").get("Top Wear").get("Tops").keySet()){
								System.out.printf("\t %d. ", i);
								System.out.print(str);
								System.out.println("\t");
								i++;
							}
							System.out.println("\t ----------------------------------------------------");
							System.out.println("\t Enter your choice : ");
							int ch46 = s1.nextInt();
							
							switch(ch46){
								case 1 : //brand = Gucci
									this.brand = "Gucci";
									
									i = 0;
									for(Item it : gen.get("Women").get("Top Wear").get("Tops").get("Gucci")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch512 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch512-1) == i){
											Item it = gen.get("Women").get("Top Wear").get("Tops").get("Gucci").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
									
								case 2 : //brand = AND
									this.brand = "AND";
									
									i = 0;
									for(Item it : gen.get("Women").get("Top Wear").get("Tops").get("AND")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch513 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch513-1) == i){
											Item it = gen.get("Women").get("Top Wear").get("Tops").get("AND").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
									
								case 3 : //brand = Zara
									this.brand = "Zara";
									
									i = 0;
									for(Item it : gen.get("Women").get("Top Wear").get("Tops").get("Zara")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch514 = s1.nextInt();
									
									for(i = 0; i < 3; i++){
										if((ch514-1) == i){
											Item it = gen.get("Women").get("Top Wear").get("Tops").get("Zara").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
							}
							break;
					}
					
					break;
					
				case 2 :
					this.category = "Bottom Wear";
					
					System.out.println("\t -----------------Pick Product Type------------------");
					i = 1;
					for(String str : gen.get("Women").get("Bottom Wear").keySet()){
						System.out.printf("\t %d. ", i);
						System.out.print(str);
						System.out.println("\t");
						i++;
					}
					System.out.println("\t ----------------------------------------------------");
					System.out.println("\t Enter your choice : ");
					int ch34 = s1.nextInt();
					
					switch(ch34){
						case 1 : //set productType to Skirts
							this.productType = "Skirts";
							
							System.out.println("\t ------------------Choose the brand------------------");
							i = 1;
							for(String str : gen.get("Women").get("Bottom Wear").get("Skirts").keySet()){
								System.out.printf("\t %d. ", i);
								System.out.print(str);
								System.out.println("\t");
								i++;
							}
							System.out.println("\t ----------------------------------------------------");
							System.out.println("\t Enter your choice : ");
							int ch47 = s1.nextInt();
							
							switch(ch47){
								
									
								case 1 : //brand = DressBerry
									this.brand = "DressBerry";
									
									i = 0;
									for(Item it : gen.get("Women").get("Bottom Wear").get("Skirts").get("DressBerry")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch515 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch515-1) == i){
											Item it = gen.get("Women").get("Bottom Wear").get("Skirts").get("DressBerry").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
									
								case 2 : //brand = Biba, price = 1200
									this.brand = "Biba";
									
									i = 0;
									for(Item it : gen.get("Women").get("Bottom Wear").get("Skirts").get("Biba")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch516 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch516-1) == i){
											Item it = gen.get("Women").get("Bottom Wear").get("Skirts").get("Biba").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
							}
							break;
						
						case 2 : //set productType to Shorts
							this.productType = "Shorts";
							
							System.out.println("\t ------------------Choose the brand------------------");
							i = 1;
							for(String str : gen.get("Women").get("Bottom Wear").get("Shorts").keySet()){
								System.out.printf("\t %d. ", i);
								System.out.print(str);
								System.out.println("\t");
								i++;
							}
							System.out.println("\t ----------------------------------------------------");
							System.out.println("\t Enter your choice : ");
							int ch48 = s1.nextInt();
							
							switch(ch48){
								case 1 : //brand = Veromoda
									this.brand = "Veromoda";
									
									i = 0;
									for(Item it : gen.get("Women").get("Bottom Wear").get("Shorts").get("Veromoda")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch517 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch517-1) == i){
											Item it = gen.get("Women").get("Bottom Wear").get("Shorts").get("Veromoda").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
									
								case 2 : //brand = MANGO
									this.brand = "MANGO";
									
									i = 0;
									for(Item it : gen.get("Women").get("Bottom Wear").get("Shorts").get("MANGO")){
										System.out.printf("\t %d. ", i+1);
										System.out.print(it.name+"["+it.size+"]"+"  Rs."+it.price);
										System.out.println("\t");
										i++;
									}
									System.out.println("\t Choose Product : ");
									int ch518 = s1.nextInt();
									
									for(i = 0; i < 2; i++){
										if((ch518-1) == i){
											Item it = gen.get("Women").get("Bottom Wear").get("Shorts").get("MANGO").get(i);
											this.productName = it.name;
											this.productPrice = it.price;
											this.productSize = it.size;
										}
									}
									break;
							}
							break;
							
					}
					break;
			}	
				
				
				break;
				
			case 3 : 
				System.out.println("\t Thank You!!! ");
				break;
		}
		return this;
	}
}
