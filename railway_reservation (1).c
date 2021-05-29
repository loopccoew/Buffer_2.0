#include<stdio.h> 
#include<stdlib.h>
#define size 100
	
typedef struct NODE
{
	int reg_no	; 
	int age	;
	char name[20]	; 
	char bp[20]	;
	char destination[20];
	struct NODE *next	;
} node;

node *start;
node *front;
node *rear;
node* deq();
int create();
int reserve(node*); 
int  cancel(int); 
void enq(node*);
void display();
int count=0; 
int num=0;

int create( )
{
	node *newnode ;
	newnode=(node *)calloc(1,sizeof(node));
	newnode->reg_no=1;
	printf("Name: ");
	scanf("%s", newnode->name); 
	printf("Rajdhani Express's stop are :\n 1. chennai\n 2.Nagpur\n 3.Jhansi Junction\n");
	printf("Boarding loacation: ");
	scanf("%s",newnode->bp);
	printf("Enter your destination: ");
	scanf("%s",newnode->destination);
	printf("Age : ");
	scanf("%d", &newnode->age); 
	if(newnode->age>=65 || newnode->age<=10)
	{
		free(newnode); 
		return -1;
	}
	start=newnode; 
	newnode->next=NULL; 
	num++;
	return 1;
}


int reserve(node *start)
{
	int choice =0;    
	int c=0;
	printf("\n\n Available Train Name-\n 1.Rajdhani Express \n 2.Koyna Express \n 3.Aazad Hind Express \n 4.Deccan Express \n 5.exit\n\n");
	printf("enter your choice for available trains\n");
	scanf("%d",&c); 
	switch(c)
	{
		case 1:	printf("Chennai to Delhi\n");
				break;	
				
		case 2:	printf("Pune to Satara\n"); 
				break;
		
		case 3:	printf("Pune to Akola\n");
				break;
				
		case 4:	printf("Mumbai to Pune\n");
				break;
				
		case 0:	printf("thank you !!!");
				break;
	}

	printf("\n\n Train Class-\n 1.First AC(1A) Sleeper \n 2.AC(2A)Tier Sleeper \n 3.AC(3A) Sleeper/Chair car \n 4.Sleeper \n 5.General \n 6.Ladies \n 7.Exit \n\n");
	printf("enter your choice for train class\n");
	scanf("%d",&c); 
	switch(c)
	{
		case 1:	printf("First AC(1A) Sleeper\n");
				break;
				
		case 2:	printf("AC(2A)Tier Sleeper\n"); 
				break;
				
		case 3:	printf("Chair car\n");
				break;
				
		case 4:	printf("Sleeper\n"); 
				break;
				
		case 5:	printf("General\n"); 
				break;
				
		case 6:	printf("Ladies\n");
				break;
				
		case 0: printf("Thank You\n");//exit(0);
				break;

	}
	printf("\n\n Berth Preference-\n 1.No Preference \n 2.Upper Berth \n 3.Lower Berth \n 4.Middle \n 0.Exit\n\n"); 
	printf("enter your choice for berth perference\n");
	scanf("%d",&c);

	switch(c)
	{
		case 1:	printf("any available berth is okay !\n");
				break;
				
		case 2:	printf("Upper Berth\n");
				break;
				
		case 3:	printf("Lower Berth\n");
				break;
				
		case 4:	printf("Middle\n");
				break;
				
		case 0:	printf("Thank You \n");
				break;//exit(0);
	}
	int temp; 
	if(start==NULL)
	{
		temp = create(); 
		return temp;
 
	}
	else
	{
		node *temp, *new_node; 
		temp=start;

		while(temp->next!=NULL)
		{
			temp=temp->next;
		}	
		
		new_node=(node *)calloc(1,sizeof(node));
		printf("Name: ");
		scanf(" %s", new_node->name); 
		printf("Rajdhani Express's stop are :\n 1. chennai\n 2.Nagpur\n 3.Jhansi Junction\n");
		printf("Boarding Location ");
		scanf(" %s",new_node->bp);
		printf("Age : ");
		scanf("%d", &new_node->age); 
		if(new_node->age >=65 || new_node->age<=10) 
		{
			return -1;
		}
		new_node->next=NULL;
		if(num<=size)
		{
			num++;
			new_node->reg_no=num;
			temp->next=new_node;
			return 1;
		}
		else
		{
			enq(new_node);
			return 0;
		}
	}
}

int cancel(int reg)
{	
	node *ptr, *preptr, *newnode;
	ptr=start;
	preptr=NULL;
	if(start==NULL)
	{
		return -1;	
	}
	if(ptr->next==NULL && ptr->reg_no==reg)
	{
		start=NULL;
		num--; 
		free(ptr); 
		return 1;
	}
	else
	{
		while(ptr->reg_no!=reg && ptr->next!=NULL)
		{
			preptr=ptr; 
			ptr=ptr->next;
		}
		if(ptr==NULL && ptr->reg_no!=reg)
		{
			return -1;
		}
		else
		{
			preptr->next=ptr->next; 
			free(ptr);
			
		}
		newnode=deq();
		while(preptr->next!=NULL)
		{
			preptr=preptr->next;
			preptr->next=newnode;
			num--;
		}
		return 1;
	}
}

void enq(node *new_node)
{
	if(rear==NULL)
	{
		rear=new_node;
		rear->next=NULL; 
		front=rear;
	}
	else
	{
		node *temp; 
		temp=new_node; 
		rear->next=temp; 
		temp->next=NULL;
 		rear=temp;

	}
	count++;
}


node* deq()
{
	node *front1; 
	front1=front; 
	if(front==NULL)
	{
		return NULL;
	}
	else
	{
		count-- ;
		if(front->next!=NULL)
		{
			front=front->next; 
			front1->next=NULL;
			return front1;
		}
		else
		{
			front=NULL;
			rear=NULL;
			return front1;
		}
	}
}



void display()
{
	node *temp;
	temp=start;
	while(temp!=NULL)
	{
		printf("\nRegistration Number: %d\n", temp->reg_no); 
		printf("Name : %s\n", temp->name);
		printf("Age : %d\n", temp->age);
		printf("boarding point : %s\n",temp->bp);
		printf("destination: %s\n",temp->destination);
		temp=temp->next;
	}
}


int main()
{
	int choice, status=0,canc=0, reg=0; 
	start=NULL;
	rear=NULL; 
	front=NULL;
	printf("\t\t************RAILWAY RESERVATION************\t\t\t\n"); 
	int ch =0;
	do
	{
 		printf("\n\nWe have this option for you- \n 1. Book a ticket \n 2. Cancel Booking \n 3. Display passenger details \n 4. exit\n\n");
		printf("which option from above list , you have chosen ?\t");
		scanf("%d", &choice);
		switch(choice)
		{
			case 1 :	status=reserve(start);
						if(status==0)
						{
							printf("\nBooking Full!! \nYou are added to waiting list. Waiting list number %d",count);
						}
						else if(status == -1) 
						{
							printf("\n age not eligible");
						}
						else
						{
							printf(" \nBooking Successful!!! Enjoy your journey! Your Reg No is %d\n\n", num);
						}

						break;

			case 2:		printf(" \n Give the Registration number to be cancelled\n"); 
						scanf(" %d", &reg);
						if(reg > num) 
						{
							printf("Invalid!!"); 
						}
						else
						{
							canc=cancel(reg); 
							if(canc==-1)
							{
								printf("\nRegistration number invalid!!\n"); 
							}
							else
							{
								printf("\nRegistration cancelled successfully\n");							
							}
						} 
						break;

			case 3: 	display();
						break;
						
			case 0: 	printf("Thank You!!!"); 
						break;
						
			default:	printf("\nWrong choice!\n");

		}
	}while(choice !=0);
}


