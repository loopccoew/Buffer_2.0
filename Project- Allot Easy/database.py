from pywebio.input import *
from pywebio.output import *
from allotment_mechanism import * 
from csv import * 
import pandas as pd
import time

mymachine= Allotment_mechanism() #obj of class Allotment_machanism

# details of the user who is currently logged in. Initially set to Null.
user= None
name=""
surname=""
pwd=None

#validations
def pswd_match(data):
    global pwd
    if(data['org_pswd']!=pwd):
        return('org_pswd', "Password doesn't match!")
    if(data['new_pswd']!=data['new_pswd_1']):
        return('new_pswd', "Passwords don't match!")
    if(pwd==['new_pswd']):
        return('new_pswd', "New password cannot be same as old password!")
    
def confirm_pswd(data):
    if(data['pswd']!=data['confirm_pswd']):
        return('confirm_pswd', "Password doesn't match")

def acc_exists(data):
    with open ('datasheet.csv', 'r') as f_object: 
        reader_obj= reader(f_object)
        for row in reader_obj:
            if row[0]==data['name'] and row[1]==data['surname']:
                return('name', 'Account with this name already exists!')
            
def check_pswd(p):
    if(p!=pwd):
        return("Password doesn't match")
'''*******************************************************************************************'''
class Data:
      
    def __init__(self):
        #flag=1: user has withdrawn his application, record is deleted from datasheet.
        self.flag = 0  

        '''no. of vacant seats in each branch stored as dict. Initially all seats are vacant. 
        This no. will reduce when each allotment is completed.'''
        #self.vacancies={"Computer": 120, "IT": 60, "Mechanical": 60, "Electronics": 120}
        
        self.vacancies={
            "Computer": mymachine.vacancies[0],
            "IT": mymachine.vacancies[1],
            "Mechanical": mymachine.vacancies[2],
            "Electronics": mymachine.vacancies[3]
            }
        
        #A list of available branches that the student can choose from
        self.available_branches = [
            "Computer",
            "IT",
            "Mechanical",
            "Electronics"
            ]

        '''initially cutoffs for all branches are 0. These mks will be updated after 
        entire allotment process is completed.'''
        self.cutoff_marks={
            "Computer": 0,
            "IT": 0,
            "Mechanical": 0,
            "Electronics": 0
            }

    '''***************************************************************************************'''
    def set_userinfo(self, usr, usrnm, usrsurnm):
        '''sets the info of the currently logged-in user in global
        variables user(admin/student) and name and surname'''
        global user, name, surname
        user = usr
        name = usrnm
        surname =usrsurnm
        self.flag=0 # set flag to 0 whenever a user logs in.
     
    def set_cutoff_marks(self):
        
        # global comp_allotment, IT_allotment, mech_allotment, elec_allotment
        # cutoff marks= in the rankwise sorted table, find last row of each branch. Corresponding marks of that row is cutoff marks.
        # store cutoff marks of each branch using for loop
        
        self.cutoff_marks["Computer"]= mymachine.get_cutoffs("comp")
        self.cutoff_marks["IT"]= mymachine.get_cutoffs("it")
        self.cutoff_marks["Mechanical"]= mymachine.get_cutoffs("mech")
        self.cutoff_marks["Electronics"]= mymachine.get_cutoffs("entc")
        clear()
             
    def check_pswd(self, name, surname):
        password = input("Input password", type=PASSWORD)
        with open("datasheet.csv",'r') as f:
            reader_object = reader(f)
            for row in reader_object:
                if(row[0]==name) and (row[1]==surname) and row[8]==password:
                    global pwd
                    pwd= password
                    return(1)
        return 0 
    
    def find_record(self, nm, srname, pswd= None):
        #Helper function for edit_record
        with open("datasheet.csv",'r') as f:
            reader_object = reader(f)
            if pswd== None:
                for row in reader_object:
                    if(row[0]==nm and row[1]==srname):
                        # return the row no. where record is found, password of that record
                        return (reader_object.line_num)
            else:
                for row in reader_object:
                    if(row[0]==nm and row[1]==srname) and row[8]==pswd:
                        # return the row no. where record is found
                        return reader_object.line_num
        # if record not found, return 0           
        return 0
   
    '''*************************************************************************************'''
        
    def student_sign_up(self):
        data = input_group("Register",[
            input('Input your name', name='name',required=True),
            input('Input your Surname', name='surname',required=True)
            ], validate=acc_exists )
            
        name = data['name']
        surname = data['surname']
        #Check whether the person has already signed up
                        
        data = input_group("Enter details",[
            input('Set your password:', name ='pswd', type=PASSWORD,required=True),
            input('Confirm Password', name ='confirm_pswd', type=PASSWORD,required=True)
            ],validate = confirm_pswd)
             
        pswd = data['pswd']
        with open('datasheet.csv', 'a+', newline='') as f_object: 
            writer_object = writer(f_object) 
            email = "--"
            marks = 0
            pref1 = -1
            pref2 = -1
            pref3 = -1
            allotment = "--"
            record = [name, surname, email, marks, pref1, pref2, pref3, allotment,pswd]
            writer_object.writerow(record) 
            f_object.close()
        put_success("\nYou have signed up successfully!")
        data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()
        
    '''*******************STUDENT FUNCTIONS*************************************'''
    
    def view_seatmatrix(self):
        #print total no. of seats available in each branch of college.
        put_table([
        ['Branch','Vacancies'],
        ['Computer','120'],
        ['IT','60'],
        ['Mechanical','60'],
        ['Electronics','120']
        ])
        data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()
            
    #Common Function to Student and Admin
    
    def search_student(self):
        if user==2:
            #if user= student, show only his record.(all columns)
            global name,surname,pwd
            with open("datasheet.csv",'r') as f:
                reader_object = reader(f)
                for row in reader_object:
                    if(row[0]==name) and (row[1]==surname) and row[8]==pwd:
                        if(row[4] == '-1' and row[5] == '-1' and row[6] == '-1'):
                            put_error("Your Application is incomplete, please go to ' Edit Your Application' to complete your application")
                            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
                            clear()
                            return
                        else:
                            put_table([
                                [span('APPLICANT DETAILS', col=2)],
                                ['Name',put_text(row[0]," ",row[1])],
                                ['Email',row[2]],
                                ['Marks',row[3]],
                                ['Preference 1:',row[4]],
                                ['Preference 2:',row[5]],
                                ['Preference 3:',row[6]]                              
                                ])
                            
                            if mymachine.allotment_done== True:
                                put_success(f"\nYour alloted branch: {row[7]}")
                            else:
                                put_error("Allotment is not yet done.")
                            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
                            clear()
                            return
            put_error("Sorry! No record found")            
            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
            clear()
            
        if user==3:
            #if user= admin, show details of any student
            data = input_group("User info",[
                   input('Enter Name', name='name'),
                   input('Enter Surname', name='surname')
                   ])
            
            name = data['name']
            srname= data['surname']
            
            with open("datasheet.csv",'r') as f:
                reader_object = reader(f)
                for row in reader_object:
                    if row[0]==name and row[1]==srname:
                        if(row[4] == '-1' and row[5] == '-1' and row[6] == '-1'):
                            put_error("Application is incomplete")
                            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
                            clear()
                            return
                        else:
                            put_text("Applicant Details: ")
                            put_table([
                                ['Name',put_text(row[0]," ",row[1])],
                                ['Email',row[2]],
                                ['Marks',row[3]],
                                ['Preference 1:',row[4]],
                                ['Preference 2:',row[5]],
                                ['Preference 3:',row[6]]                                
                                ])
                            
                            if mymachine.allotment_done== True:
                                put_success(f"\nAlloted branch: {row[7]}")  
                            else:
                                put_error("Branch Not alloted")
                            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
                            clear()
                            return
            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
            put_error("Sorry! No record found")            
            clear()
          
    def edit_record(self): 
        #allow only if allotment is not yet done
        if(mymachine.allotment_done==True):
            put_error("Cannot edit application after allotment is done!")
        else:
            global name, surname, pwd
            row_to_edit = self.find_record(name, surname, pwd)
            if row_to_edit>0:
                with open("datasheet.csv",'r') as f:
                    lines= f.read().splitlines()
                    put_info('Cannot edit your Name and Surname')
                    surname=(lines[row_to_edit-1]).split(",")[1]
                    data = input_group('Enter Details',[
                                       input("Enter email: ", type=TEXT, name = 'email'),
                                       input("Enter marks: ", type=TEXT, name = 'marks')
                                       ])
                    email = data['email']
                    marks = data['marks']
                    
                    listBranches = [
                        'Computer',
                        'IT',
                        'Mechanical',
                        'Electronics'
                        ]
                    
                    ch1 = radio(label='SELECT PREFERENCE 1', options=listBranches, inline=False, validate=None, name=None, value=None, required=True, help_text=None)
                    ch2 = radio(label='SELECT PREFERENCE 2', options=listBranches, inline=False, validate=None, name=None, value=None, required=True, help_text=None)
                    ch3 = radio(label='SELECT PREFERENCE 3', options=listBranches, inline=False, validate=None, name=None, value=None, required=True, help_text=None)
                    
                    #Maps the branch choice to an integer
                    dictBranches = {
                        'Computer':0,
                        'IT':1,
                        'Mechanical':2,
                        'Electronics':3
                        }
                    
                    pref1 = dictBranches[ch1]
                    pref2 = dictBranches[ch2]
                    pref3 = dictBranches[ch3]
                    allotment = "--"
                    
                    lines[row_to_edit-1]=f"{name},{surname},{email},{marks},{pref1},{pref2},{pref3},--,{pwd}"
                    
                with open("datasheet.csv",'w') as f: #overwrite
                    for line in lines:
                        f.write(line+"\n")
                        
            else:
                put_error("Student Record not found. Please register yourself.")
        data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()

    def delete_record(self):
        #allow only if allotment is not yet done
        global name, surname, pwd
        if mymachine.allotment_done== True:
            put_error("Cannot withdraw the application now. Your registered details: ")
            with open("datasheet.csv",'r') as f:
                reader_object = reader(f)
                for row in reader_object:
                    if row[0]==name and row[1]==surname and row[8]==pwd:
                        for i in range(0,7):
                            put_text(row[i])
                        put_success(f"\nYour alloted branch: {row[7]}")  
        else:    
            confirmation = radio("Do you wish to remove your record permanently?", options= ['yes','no'])
            if confirmation == 'yes' :
                password= input("Enter your password: ", type=PASSWORD, validate=check_pswd)
                row_to_edit = self.find_record(name, surname, pwd)
                if row_to_edit>0:
                    with open("datasheet.csv",'r') as f:
                        lines= f.read().splitlines()
                        del lines[row_to_edit-1]
                    with open("datasheet.csv",'w') as f:
                        for line in lines:
                            f.write(line+"\n")
                    self.flag=1
                    time.sleep(2)
                    put_success("Your application was removed from list")
                else:
                    put_error("Student Record not found. Please register yourself.") 
            else:
                return
            clear()
     
    def view_cutoff_marks(self):
        #only if allotment is done, display this table
        if mymachine.allotment_done== False:
            put_error("Allotment is not yet done. Please check again later.")
            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        else:
            self.set_cutoff_marks()
            put_info("Cut off marks for each branch: ") 
            cutoff = []
            for key in self.cutoff_marks:
                newList = []
                newList.append(key)
                newList.append(self.cutoff_marks[key])
                cutoff.append(newList)     
            cutoff.insert(0,['Branch','CutOff'])
            put_table(cutoff, header=None) 
            data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        
        clear()
            
    def change_password(self):
        global name, surname
        data = input_group("Change Password", [
            input('Enter current password: ', name = 'org_pswd', required=True, type=PASSWORD),
            input('Enter current password: ', name = 'new_pswd', required=True, type=PASSWORD),
            input('Enter current password: ', name = 'new_pswd_1', required=True, type=PASSWORD),            
            ], validate = pswd_match)
        org_pswd = data['org_pswd']
        new_pswd = data['new_pswd']
        new_pswd_1 = data['new_pswd_1']
        
    
        df = pd.read_csv("datasheet.csv")
        row = df[(df['NAME'] == name) & (df['SURNAME'] == surname)].index[0]
        df.iat[row,8] = new_pswd_1    
        df.to_csv('datasheet.csv', index = False)
        put_success('Password successfully changed!')
    
        data = input_group("Return to Student Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        
        clear()
        
    '''**********************ADMIN MENU****************************************'''
    def view_all_registrations(self):
        # print table of all records (name, surname, email, marks)
        df = pd.read_csv('datasheet.csv')
        if (mymachine.allotment_done== True):
            registrations = df[["NAME", "SURNAME","EMAIL_ID", "MARKS", "ALLOTMENT"]]
            regList = registrations.values.tolist()
            regList.insert(0,['NAME','SURNAME','EMAIL_ID','MARKS','ALLOTMENT'])
            regList.insert(0,['NAME','SURNAME','EMAIL_ID','MARKS','ALLOTMENT'])
            put_table(regList,header=None)
        
        else:
            put_error("Allotment not yet done...")
            registrations = df[["NAME", "SURNAME","EMAIL_ID","MARKS","PREF1","PREF2","PREF3"]]
            regList = registrations.values.tolist()
            regList.insert(0,['NAME','SURNAME','EMAIL_ID','MARKS','PREF1','PREF2','PREF3'])
            regList = registrations.values.tolist()
            regList.insert(0,['NAME','SURNAME','EMAIL_ID','MARKS','PREF1','PREF2','PREF3'])
            put_table(regList,header=None)
        data = input_group("Return to Admin Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()
        
    def view_branchwise_allotment(self):
        '''if allotment_done is True, input the branch name, 
        print a list of all students in a particular class.'''
        
        if mymachine.allotment_done== False:
            put_error("Allotment is not yet done. Please check again later.")
            
        else:
            listBranches = [
                'Computer',
                'IT',
                'Mechanical',
                'Electronics'
                ]
            branch = radio(label='SELECT A BRANCH', options=listBranches, inline=False, validate=None, name=None, value=None, required=True, help_text=None)
            
            put_success(f"this is allotment result for {branch} engineering")
            df = pd.read_csv('datasheet.csv')
            filtered_df = df[df['ALLOTMENT'] == branch] #filter the data frame according to the branch alloted   
            filtered_df_1 = filtered_df[["NAME","SURNAME","MARKS"]] #new data frame with just name and marks of the filtered df
            studentList = filtered_df_1.values.tolist()
            studentList.sort(key = lambda x: x[2], reverse = True)
            cnt=0
            for i in range(0,len(studentList)):
                cnt=cnt+1
                studentList[i].insert(0,cnt)
            studentList.insert(0,['RANK','NAME','SURNAME','MARKS'])
            put_table(studentList, header=None)
            data = input_group("Return to Admin Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
            clear()
      
    def students_without_allotment(self):
        # allow only after allotment is done
        if mymachine.allotment_done== False:
            put_error("Allotment is not yet done. Please check again later.")
        else:   
            no_allot = []
            with open("datasheet.csv",'r') as f:
                cnt = 0
                reader_object = reader(f)
                for row in reader_object:
                    if(row[7]=="--"):
                        cnt = cnt+1
                        name = [row[0]+" "+row[1]]
                        name.insert(0,cnt)
                        name.append("NA")
                        no_allot.append(name)
            no_allot.insert(0,['No.','NAME', 'ALLOTMENT'])
            put_table(no_allot, header=None)   
        data = input_group("Return to Admin Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()
     
    def vacancies_left(self): 
        put_table([
            ('Course', 'Vacancies'),
            ('Computer',mymachine.vacancies[0]),
            ('IT',mymachine.vacancies[1]),
            ('Mechanical',mymachine.vacancies[2]),
            ('Electronics',mymachine.vacancies[3])
            ])
        data = input_group("Return to Admin Menu",[actions('', [ {'label': 'Back', 'value': 1},], name='action', help_text=None),])
        clear()
        
    
    '''***********FUNCTION LIST********************************************'''
    student_options=[
        view_seatmatrix,
        search_student,
        edit_record,
        delete_record,
        view_cutoff_marks,
        change_password
        ]
    
    admin_options=[
        mymachine.run_allotment,
        view_all_registrations,
        view_branchwise_allotment,
        search_student,
        students_without_allotment,
        vacancies_left
        ]   
    
