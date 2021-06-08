#include "Movies.h"
#include <iostream>
#include<cstdio>
using namespace std;
void Movies::getmovie()
{
	cout << "Enter name of album" << endl;
	gets_s(Movie_name);
	gets_s(Movie_name);
	cout << "Enter date released" << endl;
	gets_s(date_released);
}

void Movies::showmovie()
{
	cout << Movie_name <<"\t\t\t\t\t\t"<< date_released << endl;
}

void Movies::rentmovie()
{

	cout << "Enter name of movie" << endl;
	gets_s(Movie_name);
	gets_s(Movie_name);
	cout << "Enter the date of rent" << endl;
	gets_s(date_rented);
	cout << "Enter the return date" << endl;
	gets_s(return_date);
}

void Movies::show_rent()
{
	cout << Movie_name << "                                       " << date_rented;
	cout << "                                     " << return_date << endl;
}

int Movies::compares(char a[50])
{
	if (_strcmpi(Movie_name, a) == 0)
	{
		return 1;
	}
	else
		return 0;
}



