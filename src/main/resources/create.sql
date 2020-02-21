create table appointment(     
app_id number primary key,
patient_id number not null,
purpose varchar2(50)not null,
doctor_id number not null,
app_date date not null,
app_time varchar2(20) not null,
status varchar2(50) default 'pending',
visited varchar2(10) default 'no',
foreign key (patient_id) references patientReg(patient_id),
foreign key (doctor_id) references doctorlist(doctor_id)  
);


create table patientReg(
patient_id number primary key ,
patientname varchar2(50) not null,
adharcardno number ,
dob date,
gender varchar2(20) ,
phoneno number not null,
patientreg_date date 
);

create sequence patient_id start with 40 increment by 1;


create table rating(
patient_id number not null,
doctor_id number not null,
rating float not null,
foreign key (patient_id) references patientReg(patient_id),
foreign key (doctor_id) references doctorlist(doctor_id)
);

create table overallrating(
doctor_id number,
rating float,
foreign key(doctor_id) references doctorlist(doctor_id)
);

create table splzations(
splzation_id number primary key,
splzation_name varchar2(20) not null
);

create table doctorlist(
doctor_id number primary key,
doctor_name varchar2(40) not null,
splzation_id number not null,
consultingfee number not null,
foreign key (splzation_id) references splzations(splzation_id)
);

create table prescription(
prescription_id number primary key,
patient_name varchar2(50) not null,
doctorname varchar2(50) not null,
comments varchar2(100) not null,
total_amt number
);

create sequence patient_id start with 1 increment by 1;
