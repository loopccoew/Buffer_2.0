#pragma once
class Movies
{
	char Movie_name[50];
	char date_released[20];
	char date_rented[20];
	char return_date[20];
public:
	void getmovie();
	void showmovie();
	void rentmovie();
	void show_rent();
	int compares(char[50]);
};

