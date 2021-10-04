// record_shop2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include<stdlib.h>
#include<fstream>
#include<string.h>
#include "Music.h"
#include"Movies.h"
Music M;
Movies M1;
using namespace std;
void admin();
void customer();
void add()
{ 
	system("cls");
	fstream F, F1;
	char choice;
	int a;
	int ans;
	cout << "Enter your choice" << endl;
	cout << "1.Music" << "                                " << "2.Movies";
	cin >> ans;
	system("cls");
	if (ans == 1)
	{
		F.open("Musics.txt", ios::app);
		A:
		M.getmusic();
		F.write((char*)&M, sizeof(M));
		
		cout << endl << "Do you want to add more music?(Y/N)" << endl;
		cin >> choice;
		if ((choice == 'y') || (choice == 'Y'))
		{
			goto A;
		}
		else
		{

			
			F.close();
			system("cls");
			cout << "1.Admin" << "             " << "2.Customer" << endl;
			cout << "3.Exit" << endl;
			cin >> a;
			switch (a)
			{
			case 1: admin();
				break;
			case 2: customer();
				break;
			case 3: cout << "Thank you for choosing us"; exit(0);
				break;
			}
		}
	}
	else if (ans == 2)
	{
		F1.open("Movies.txt", ios::app);
		B:
		M1.getmovie();
		F1.write((char*)&M1, sizeof(M1));
		cout << endl << "Do you want to add more movies?(Y/N)" << endl;
		cin >> choice;
		if ((choice == 'y') || (choice == 'Y'))
		{
			goto B;
		}
		else
		{

			
			F1.close();
			system("cls");
			cout << "1.Admin" << "             " << "2.Customer" << endl;
			cout << "3.Exit" << endl;
			cin >> a;
			switch (a)
			{
			case 1: admin();
				break;
			case 2: customer();
				break;
			case 3: cout << "Thank you for choosing us"; exit(0);
				break;
			}
		}
	}
}
void display()
{
	system("cls");
	ifstream F,F1;
	int a;
	int ans;
	cout << "1.Music" << "               " << "2.Movies" << endl;
	cin >> ans;
	if (ans == 1)
	{
		F.open("Musics.txt", ios::in);
		cout << "Record"<< "\t\t\t\t\t\t\tArtist";
		cout <<"\t\t\t\t\t\tRelease year" << endl;
		while (F)
		{
			M.showmusic();
			F.read((char*)&M, sizeof(M));

			
		}
		F.close();
	}
	else if (ans == 2)
	{
		F1.open("Movies.txt", ios::in);
	

		cout << "Record"<< "\t\t\t\t\t\t\t\Release year" << endl;
		while (F1)
		{
			M1.showmovie();
			F1.read((char*)&M1, sizeof(M1));

		}
		F1.close();
	}
	
	cout << endl << endl << endl << endl;
	cout << "1.Admin" << "             " << "2.Customer" << endl;
	cout << "3.Exit" << endl;
	cin >> a;
	switch (a)
	{
	case 1: admin();
		break;
	case 2: customer();
		break;
	case 3: cout << "Thank you for choosing us"; exit(0);
		break;
	}

}
void search()
{
	system("cls");
	fstream F,F1;
	int ans,a;
	char searcha[50];
	cout << "1.Music" << "                           " << "2.Movies" << endl;
	cin >> ans;
	if (ans == 1)
	{
		F.open("Musics.txt", ios::in);
		cout << "Enter the album name you want to search for" << endl;
		gets_s(searcha);
		gets_s(searcha);
		while (F)
		{
			F.read((char*)&M, sizeof(M));
			if (M.compares(searcha) == 1)
			{
				cout << endl << "The album found" << endl;
				M.showmusic();
				break;
			}

		}
		F.close();
	}
	else if (ans == 2)
	{
		F1.open("Movies.txt", ios::in);
		cout << "Enter the movie name you want to search for" << endl;
		gets_s(searcha);
		gets_s(searcha);
		while (F1)
		{
			F1.read((char*)&M1, sizeof(M1));
			if (M1.compares(searcha) == 1)
			{
				cout << endl << "The album found" << endl;
				M1.showmovie();
				break;
			}

		}
		F1.close();
	}
	cout << endl << endl << endl << endl;
	cout << "1.Admin" << "             " << "2.Customer" << endl;
	cout << "3.Exit" << endl;
	cin >> a;
	switch (a)
	{
	case 1: admin();
		break;
	case 2: customer();
		break;
	case 3: cout << "Thank you for choosing us"; exit(0);
		break;
	}
	

}
void rent()
{

	system("cls");
	fstream F,F1;
	char choice;
	int ans, a;
	A:
	cout << "1.Music" << "                           " << "2.Movies" << endl;
	cin >> ans;
	if (ans == 1)
	{
		F.open("Rented.txt", ios::app);
		M.rentmusic();
		F.write((char*)&M, sizeof(M));
		cout << endl << "Do you want to rent more?(Y/N)" << endl;
		cin >> choice;
		if ((choice == 'y') || (choice == 'Y'))
		{
			goto A;
		}
		else
		{

			F.close();
		}
	}
	else if (ans == 2)
	{
		F1.open("Rented.txt", ios::app);
		M1.rentmovie();
		F1.write((char*)&M1, sizeof(M1));
		cout << endl << "Do you want to rent more?(Y/N)" << endl;
		cin >> choice;
		if ((choice == 'y') || (choice == 'Y'))
		{
			goto A;
		}
		else
		{

		
			F1.close();
		}
	}
	cout << "1.Admin" << "             " << "2.Customer" << endl;
	cout << "3.Exit" << endl;
	cin >> a;
	switch (a)
	{
	case 1: admin();
		break;
	case 2: customer();
		break;
	case 3: cout << "Thank you for choosing us"; exit(0);
		break;
	}
}
void donate()
{
	fstream F,F1;
	char choice;
	int ans, a;
	A:
	system("cls");
	cout << "1.Music" << "                       " << "2.Movies" << endl;
	cin >> ans;
	if (ans == 1)
	{
		F.open("Musics.txt", ios::app);
		M.getmusic();
		F.write((char*)&M, sizeof(M));
	
		F.close();
	}
	else if (ans == 2)
	{
		F1.open("Movies.txt", ios::app);
		M1.getmovie();
		F1.write((char*)&M1, sizeof(M1));
	
		F1.close();
		
	}
	cout << endl << "Do you want to donate more?(Y/N)" << endl;
	cin >> choice;
	if ((choice == 'y') || (choice == 'Y'))
	{
		goto A;
	}
	else
	{
		cout << "1.Admin" << "             " << "2.Customer" << endl;
		cout << "3.Exit" << endl;
		cin >> a;
		switch (a)
		{
		case 1: admin();
			break;
		case 2: customer();
			break;
		case 3: cout << "Thank you for choosing us"; exit(0);
			break;
		}
	}
	
}
void disply_rent()
{
	system("cls");
	ifstream F7;
	F7.open("Rented.txt", ios::in);
	
	int a;
	cout << "Record" << "                                            " << "Rented date";
	cout << "                                             " << "Due date" << endl;
	while (F7)
	{
		M.show_rent();
		F7.read((char*)&M, sizeof(M));

	}
	F7.close();
	cout << "1.Admin" << "             " << "2.Customer" << endl;
	cout << "3.Exit" << endl;
	cin >> a;
	switch (a)
	{
	case 1: admin();
		break;
	case 2: customer();
		break;
	case 3: cout << "Thank you for choosing us"; exit(0);
		break;
	}
}
void deelete()
{
	system("cls");
	char searchb[50];
	fstream F1,F2, F4, F5;
	int ans, a;
	cout << "1.Music" << "                              " << "2.Movies" << endl;
	cin >> ans;
	if (ans == 1)
	{
		cout << "Enter the name of record you want to delete" << endl;
		gets_s(searchb);
		gets_s(searchb);
		F4.open("Musics.txt", ios::in);
		F5.open("temp.txt", ios::app);
		while (F4)
		{
			F4.read((char*)&M, sizeof(M));
			if (M.compares(searchb) == 1)
			{
				cout << "The album being deleted" << endl;
				M.showmusic();
			}
			else
			{
				F5.write((char*)&M, sizeof(M));
			}
		}
		F4.close();
		F5.close();
		remove("Musics.txt");
		(void) rename("temp.txt", "Musics.txt");
	}
	else if (ans == 2)
	{
		cout << "Enter the name of record you want to delete" << endl;
		F1.open("Movies.txt", ios::in);
		F2.open("temp.txt", ios::app);
		gets_s(searchb);
		gets_s(searchb);
		while (F1)
		{
			F1.read((char*)&M1, sizeof(M1));
			if (M1.compares(searchb) == 1)
			{
				cout << "The album being deleted" << endl;
				M1.showmovie();
			}
			else
			{
				F2.write((char*)&M1, sizeof(M1));
			}
		}
		F1.close();
		F2.close();
		remove("Movies.txt");
		(void) rename("temp.txt", "Movies.txt");
	}
	cout << endl << "Record has been deleted" << endl;
	cout << "1.Admin" << "             " << "2.Customer" << endl;
	cout << "3.Exit" << endl;
	cin >> a;
	switch (a)
	{
	case 1: admin();
		break;
	case 2: customer();
		break;
	case 3: cout << "Thank you for choosing us"; exit(0);
		break;
	}
	
}
void customer()
{
	int ans;
	system("cls");
	cout << "1. All available records/movies" << "                  " << "2. Search for a record/movie" << endl;
	cout << "3. Check availability" << "                            " << "4. Donate a movie/record" << endl;
	cout << "5. Rent an item" <<"                                 "<<  "6.Exit"<< endl;
	cin >> ans;
	if (ans == 1)
	{
		display();
	}
	else if (ans == 2)
	{
		search();
	}
	else if (ans == 3)
	{
		disply_rent();
	}
	else if (ans == 4)
	{
		donate();
	}
	else if (ans == 5)
	{
		rent();
	}
	else if (ans == 6)
	{
		exit(0);
	}
}
void admin()
{
	system("cls");
	int ans;
	int choice;
	cout << "1. All available records/movies" << "                  " << "2. Search for a record/movie" << endl;
	cout << "3. Add a new record/movie" << "                        " << "4. Delete a movie/record" << endl;
	cout << "5. Items due" << "                                     " << "6. Exit" << endl;
	cin >> ans;
	if (ans == 1)
	{
		display();
	}
	else if (ans == 2)
	{
		search();
	}
	else if (ans == 3)
	{
		add();
	}
	else if (ans == 4)
	{
		deelete();
	}
	else if (ans == 5)
	{
		disply_rent();
	}
	else if (ans == 6)
	{
		exit(0);
	}
}
int main()
{
	
	int a;
	
	cout << "                                         WELCOME TO THE RECORD SHOP" << endl;
	cout << "                           1. ADMIN";
	cout <<endl<< "                           2. CUSTOMER";
	cout <<endl<< "                           3. EXIT"<<endl;
	cin >> a;
	if (a == 1)
	{
		cout << "Admin"<<endl;
		admin();
	}
	else if (a == 2)
	{
		cout << "Customer"<<endl;
		customer();		
	}
	else
		exit(0);

}


