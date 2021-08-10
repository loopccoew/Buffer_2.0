#include<stdio.h>
#include<string.h>
struct medical
{
	int  id;
	char name[20];
	float cost;
	int stock;
};
void add_Record();
void delete_Record();
void modify_Record();
void display_All_Records();
void display_Specific_Record();
void place_Order();
void update_Stock(int,int);

int main(void)//main function
{			//used as a file pointer to the temporary file created
	int ch=0;
    int id=0;
    int stock=0;
	do
	{
		printf("\n\n**** WELCOME TO MEDICAL ****");			        //menu for performing operations
		printf("\n1.ADD A MEDICINE");
		printf("\n2.DELETE A MEDICINE");
		printf("\n3.MODIFY A MEDICINE DETAILS");
		printf("\n4.DISPLAY ALL MEDICINES");
		printf("\n5.DISPLAY A MEDICINE");
		printf("\n6.GENERATE BILL AMOUNT");
		printf("\n7.UPDATE STOCK");
		printf("\n0.EXIT");
		printf("\n\nEnter your choice: ");
		fflush(stdout);
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				add_Record();
				break;

			case 2:
				delete_Record();
				break;

			case 3:
				modify_Record();
				break;

			case 4:
				display_All_Records();
				break;

			case 5:
				display_Specific_Record();
				break;

			case 6:
				place_Order();
				break;

			case 7:
			    printf("\nEnter Medicine Id :");
                fflush(stdout);
                scanf("%d",&id);
                printf("\nEnter Additional Stock: ");
                fflush(stdout);
                scanf("%d",&stock);
				update_Stock(id,stock);
				break;

			case 0:
				printf("\nExiting the program");	      //exit from the program
				break;

			default:
				printf("\nEnter valid choice");

		}
	}while(ch!=0);
	return 0;
}

void add_Record()
{
	struct medical s={0};
	FILE *fout=NULL;	//file pointer fout for writing in file
	fout=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","ab");//open the file in append mode
	printf("\nEnter record to be added\n");			//accept records of book from user
	printf("Enter Medicine Id: ");
	fflush(stdout);
	scanf("%d",&s.id);
	printf("Enter name of medicine: ");
	fflush(stdout);
	scanf("%9s",s.name);
	printf("Enter cost: ");
	fflush(stdout);
	scanf("%f",&s.cost);
	printf("Enter stock: ");
	fflush(stdout);
	scanf("%d",&s.stock);
	if(fout==NULL)                                     //check if file is opened
	{
		printf("File not opened.No operation possible");
	}
	else
	{
		fwrite(&s,sizeof(struct medical),1,fout);             //write structure to file
		printf("Record added successfully!!..");
		fclose(fout);
		fout=NULL;
	}
}

void delete_Record()
{
	struct medical s={0};
	FILE *fin=NULL;			        //file pointer for reading from file
	FILE *ftemp=NULL;
	int rs=0,b1=0;
	fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open file book.txt in read mode
	ftemp=fopen("C:\\Users\\Lenovo\\Desktop\\temp.txt","wb");//open another file temp.txt in write mode
	if((fin==NULL) && (ftemp==NULL))			        //check if file opened
	{
		printf("File not opened.No operation possible");
	}
	else
	{							//accept from user the bookid for which record is to be deleted
		printf("Enter id of record to be deleted: ");
		fflush(stdout);
		scanf("%d",&b1);
		do
        {
			rs=fread(&s,sizeof(struct medical),1,fin);              //read data from book.txt
			if(rs==1)
			{
				if(b1!=s.id)
				{
					fwrite(&s,sizeof(struct medical),1,ftemp);              //if bookid does not match write contents to temp.txt
				}
				else
				{

				}
			}
		}while(rs==1);

		printf("\nRecord Deleted");

		fclose(ftemp);
		ftemp=NULL;
		fclose(fin);
		fin=NULL;
		unlink("C:\\Users\\Lenovo\\Desktop\\project.txt");	       //unlink book.txt
		rename("C:\\Users\\Lenovo\\Desktop\\temp.txt","C:\\Users\\Lenovo\\Desktop\\project.txt");//rename temp.txt as book.txt
	}
}

void modify_Record()
{
	struct medical s={0};
	FILE *fin=NULL;			        //file pointer for reading from file
	FILE *ftemp=NULL;
	int rs=0;
	fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open book.txt in read mode
	ftemp=fopen("C:\\Users\\Lenovo\\Desktop\\temp.txt","wb");//open temp.txt in write mode
	if(fin==NULL&&ftemp==NULL)
	{
		printf("File not opened.No operation possible");  //check if file opened
	}
	else
	{
		printf("Enter the modified record");//accept modified record from user
		struct medical ru={0};
	    printf("\nEnter id: ");
		fflush(stdout);
		scanf("%d",&ru.id);
		printf("\nEnter name: ");
		fflush(stdout);
		scanf("%9s",ru.name);
		printf("\nEnter Cost: ");
		fflush(stdout);
		scanf("%f",&ru.cost);
		printf("\nEnter current Stock: ");
		fflush(stdout);
		scanf("%d",&ru.stock);
		do
		{
			rs=fread(&s,sizeof(struct medical),1,fin);//read from book.txt
			if(rs==1)
			{                                      //modify the record
				if(s.id!=ru.id)
				{
					fwrite(&s,sizeof(struct medical),1,ftemp);
				}
				else
				{
					fwrite(&ru,sizeof(struct medical),1,ftemp);
				}
			}
		}while(rs==1);
		printf("\nRecord modified successfully!!..");
		fclose(ftemp);
		ftemp=NULL;
		fclose(fin);
		fin=NULL;
		unlink("C:\\Users\\Lenovo\\Desktop\\project.txt");
		rename("C:\\Users\\Lenovo\\Desktop\\temp.txt","C:\\Users\\Lenovo\\Desktop\\project.txt");
	}
}

void display_All_Records()
{
	struct medical s={0};
	FILE *fin=NULL;			        //file pointer for reading from file
	int rs=0;
	fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open book.txt in read mode
	if(fin==NULL)
	{
		printf("File not opened.No operation possible");     //check if file can be opened
	}
	else
	{
		do
		{
			rs=fread(&s,sizeof(struct medical),1,fin);              //read from book.txt
			if(rs==1)					       //display all records
			{
				if(s.stock>0)
				{
					printf("\nMedical ID: %d",s.id);
					printf("\nName: %s",s.name);
					printf("\nCost: %f",s.cost);
					printf("\nStock: %d",s.stock);
				}
				else
				{

				}

			}
		}while(rs==1);
		fclose(fin);
		fin=NULL;
	}
}
void display_Specific_Record()
{
	struct medical s={0};
	int rs=0,b1=0;
	FILE *fin=NULL;		//file pointer for reading from file
	printf("Enter  id of record to be searched");//accept book id to be searched in b1
	fflush(stdout);
	scanf("%d",&b1);
	int flag=0;
	fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open book.txt in  read mode
	if(fin==NULL)
	{
		printf("File not opened.No operation possible");//check if file opened
	}
	else
	{
		do
		{
			rs=fread(&s,sizeof(struct medical),1,fin);        //read from book.txt
			if(rs==1)
			{
				if(s.id==b1)				//if book id matched print the record
				{
					flag=1;
					if(s.stock>0)
					{
						printf("\nid=%d",s.id);
						printf("\nName=%s",s.name);
						printf("\nCost=%f",s.cost);
						printf("\nStock=%d",s.stock);
					}
					else
					{
						printf("\nStock Not Available");
					}
				}
				else
				{

				}
			}
		}while(rs==1);
		if(flag==0)
		{
			printf("\nRecord Not Found..");
		}
		fclose(fin);
		fin=NULL;
	}
}
void place_Order()
{
    FILE *fin=NULL;
    struct medical s={0};
    int rs=0;
    char name[50]={'\0'};
    long int contact=0;
    char medname[50]={'\0'};
    int quantity=0;
    int id=0;
    double rate=0.0;
    double totalprice=0.0;
    int flag=0;
	printf("Enter record");
    printf("\nEnter Name: ");
	fflush(stdout);
	scanf("%19s",name);
	printf("\nEnter Phone No: ");
	fflush(stdout);
	scanf("%ld",&contact);
	printf("\nEnter Medicine Name: ");
	fflush(stdout);
	scanf("%19s",medname);
	printf("\nEnter Quantity to be Purchased: ");
	fflush(stdout);
	scanf("%d",&quantity);
    fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open book.txt in  read mode
	if(fin==NULL)
	{
		printf("File not opened.No operation possible");//check if file opened
	}
	else
	{
		do
		{
			rs=fread(&s,sizeof(struct medical),1,fin);        //read from book.txt
			if(rs==1)
			{
				if(strcmp(s.name,medname)==0)				//if book id matched print the record
				{
					flag=1;
					if(s.stock>0)
					{
					    rate=s.cost;
					    id=s.id;
					}
					else
					{
						printf("\nStock Not Available");
					}
				}
				else
				{

				}
			}
		}while(rs==1);
		fclose(fin);
		fin=NULL;
	}
update_Stock(id,(-1)*quantity);
totalprice=quantity*rate;
printf("\n\t THE TOTAL BILL AMOUNT IS %lf",totalprice);
}
void update_Stock(int id,int stock)
{
	struct medical s={0};
	struct medical ru={0};
	FILE *fin=NULL;			        //file pointer for reading from file
	FILE *ftemp=NULL;
	int rs=0;
	fin=fopen("C:\\Users\\Lenovo\\Desktop\\project.txt","rb");//open book.txt in read mode
	ftemp=fopen("C:\\Users\\Lenovo\\Desktop\\temp.txt","wb");//open temp.txt in write mode
	if(fin==NULL&&ftemp==NULL)
	{
		printf("File not opened.No operation possible");  //check if file opened
	}
	else
	{
		do
		{
			rs=fread(&s,sizeof(struct medical),1,fin);//read from book.txt
			if(rs==1)
			{                                      //modify the record
				if(s.id!=id)
				{
					fwrite(&s,sizeof(struct medical),1,ftemp);
				}
				else
				{
					strcpy(ru.name,s.name);
					ru.cost=s.cost;
					ru.id=s.id;
					ru.stock=s.stock+stock;

					fwrite(&ru,sizeof(struct medical),1,ftemp);
				}
			}
		}while(rs==1);
		printf("\nRecord modified successfully!!..");
		fclose(ftemp);
		ftemp=NULL;
		fclose(fin);
		fin=NULL;
		unlink("C:\\Users\\Lenovo\\Desktop\\project.txt");
		rename("C:\\Users\\Lenovo\\Desktop\\temp.txt","C:\\Users\\Lenovo\\Desktop\\project.txt");
	}
}
