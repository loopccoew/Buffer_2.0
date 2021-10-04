#include "Music.h"
#include <iostream>
#include<cstdio>
using namespace std;
void Music::getmusic()
{
	cout << "Enter name of album" << endl;
	gets_s(Album_name);
	gets_s(Album_name);
	cout << "Enter name of singer" << endl;
	gets_s(Musician);
	cout << "Enter date released" << endl;
	gets_s(date_released);
}

void Music::showmusic()
{
	
	cout << Album_name <<"\t\t\t\t\t\t"<< Musician;
	cout<<"\t\t\t\t\t"<< date_released << endl;
}

void Music::rentmusic()
{

	cout << "Enter name of album" << endl;
	gets_s(Album_name);
	gets_s(Album_name);
	cout << "Enter the date of rent" << endl;
	gets_s(date_rented);
	cout << "Enter the return date" << endl;
	gets_s(return_date);
}

void Music::show_rent()
{
	cout << Album_name << "                                       " << date_rented;
	cout << "                                     " << return_date << endl;
}

int Music::compares(char a[50])
{
	if (_strcmpi(Album_name,a) == 0)
	{
		return 1;
	}
	else
		return 0;
}



