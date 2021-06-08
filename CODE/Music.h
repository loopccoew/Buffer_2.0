#pragma once
class Music
{
	char Album_name[50];
	char crap[9];
	char Musician[30];
	char date_released[20];
	char date_rented[20];
	char return_date[20];
public:
	void getmusic();
	void showmusic();
	void rentmusic();
	void show_rent();
	int compares(char[50]);
};

