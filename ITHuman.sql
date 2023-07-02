CREATE DATABASE [ITHuman]
GO
USE [ITHuman]
GO
CREATE TABLE Role(
    RoleID INT PRIMARY KEY CHECK(RoleID=0 or RoleID=1 or RoleID=2),
    --HRMANAGER 0. HRSTAFF 1, STAFF 2
    RoleName VARCHAR(255) NOT NULL
)
GO
CREATE TABLE Users (
        UserID VARCHAR(4) PRIMARY KEY NOT NULL CHECK(UserID LIKE 'ID[0-9][0-9]'),
        Username VARCHAR(255) NOT NULL,
        Fullname VARCHAR(255)  NOT NULL,
        Password VARCHAR(255)  NOT NULL,
        PhoneNumber CHAR(10) UNIQUE CHECK(PhoneNumber LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
        DateOfBirth DATE,
        RoleID INT FOREIGN KEY REFERENCES Role(RoleID)
    )
GO
    CREATE TABLE Payslip (
        PayslipID INT  PRIMARY KEY NOT NULL,
        Month DECIMAL(2,0),
        BasicSalary DECIMAL(6, 2),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
CREATE TABLE IncomeTax (
        IncomeTaxID INT  PRIMARY KEY NOT NULL,
        Month DECIMAL(2,0),
        Amount DECIMAL(5, 2),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
CREATE TABLE SocialTax (
        SocialTaxID INT PRIMARY KEY NOT NULL,
        Month DECIMAL(2,0),
        Amount DECIMAL(5, 2),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
CREATE TABLE Report (
        ReportID VARCHAR(10) PRIMARY KEY NOT NULL,
        ReportName VARCHAR(255),
        Content NVARCHAR(255),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
CREATE TABLE LogOT (
        LogOTID INT  PRIMARY KEY NOT NULL,
        Date DATE,
        Hours DECIMAL(2, 0),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
    CREATE TABLE Leave (
        LeaveID INT  PRIMARY KEY NOT NULL,
        LeaveStartDate DATE,
        LeaveEndDate DATE,
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
    CREATE TABLE Candidate (
        CandidateID VARCHAR(5) PRIMARY KEY NOT NULL CHECK(CandidateID LIKE 'CID[0-9][0-9]'),
        CandidateName VARCHAR(255),
        Position VARCHAR(255),
        ContactInformation VARCHAR(255) CHECK (ContactInformation LIKE '%@gmail.com'),
        Status INT CHECK(STATUS =0 or STATUS=1),
        --Not pass:0  , Pass:1
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO
    CREATE TABLE PersonalContract (
        ContractID INT PRIMARY KEY NOT NULL,
        StaffType VARCHAR(255),
        ContractStartDate DATE,
        ContractEndDate DATE,
        Salary DECIMAL(6, 2),
        UserID VARCHAR(4) FOREIGN KEY REFERENCES Users(UserID)
    )
GO

/*Role*/
INSERT [dbo].[Role] ([RoleID],[RoleName]) VALUES (0,'HRManager')
INSERT [dbo].[Role] ([RoleID],[RoleName]) VALUES (1,'HRStaff')
INSERT [dbo].[Role] ([RoleID],[RoleName]) VALUES (2,'Staff')
GO

/*Users*/
INSERT [dbo].[Users] ([UserID], [Username], [Fullname], [Password], [PhoneNumber], [DateOfBirth], [RoleID]) VALUES ('ID01', 'hoangtien', 'Van Hoang Tien', '12345','0192837465', '2003-02-15',0)
INSERT [dbo].[Users] ([UserID], [Username], [Fullname], [Password], [PhoneNumber], [DateOfBirth], [RoleID]) VALUES ('ID02', 'huuphuoc', 'Nguyen Huu Phuoc', '12345','0289732112', '2002-04-01',2)
INSERT [dbo].[Users] ([UserID], [Username], [Fullname], [Password], [PhoneNumber], [DateOfBirth], [RoleID]) VALUES ('ID03', 'phuchung', 'Nguyen Hoang Phuc Hung', '12345','0123455678', '2000-01-17',1)
INSERT [dbo].[Users] ([UserID], [Username], [Fullname], [Password], [PhoneNumber], [DateOfBirth], [RoleID]) VALUES ('ID04', 'truongiang', 'Le Truong Giang', '12345','0192837443', '2001-12-08',2)
GO

/*PaySlip*/
INSERT [dbo].[Payslip] ([PayslipID], [Month], [BasicSalary],[UserID]) VALUES (1,05,6765.45,'ID01')
INSERT [dbo].[Payslip] ([PayslipID], [Month], [BasicSalary],[UserID]) VALUES (2,05,5437.78,'ID02')
INSERT [dbo].[Payslip] ([PayslipID], [Month], [BasicSalary],[UserID]) VALUES (3,05,9876.14,'ID03')
INSERT [dbo].[Payslip] ([PayslipID], [Month], [BasicSalary],[UserID]) VALUES (4,05,2313.16,'ID04')
GO

/*incomeTax*/
INSERT [dbo].[IncomeTax] ([IncomeTaxID], [Month], [Amount],[UserID]) VALUES (1,05,456.65,'ID01')
INSERT [dbo].[IncomeTax] ([IncomeTaxID], [Month], [Amount],[UserID]) VALUES (2,05,543.65,'ID02')
INSERT [dbo].[IncomeTax] ([IncomeTaxID], [Month], [Amount],[UserID]) VALUES (3,05,678.65,'ID03')
INSERT [dbo].[IncomeTax] ([IncomeTaxID], [Month], [Amount],[UserID]) VALUES (4,05,261.65,'ID04')
GO
/*SocialTax*/

INSERT [dbo].[SocialTax] ([SocialTaxID], [Month], [Amount],[UserID]) VALUES (1,05,342.65,'ID01')
INSERT [dbo].[SocialTax] ([SocialTaxID], [Month], [Amount],[UserID]) VALUES (2,05,156.65,'ID02')
INSERT [dbo].[SocialTax] ([SocialTaxID], [Month], [Amount],[UserID]) VALUES (3,05,356.65,'ID03')
INSERT [dbo].[SocialTax] ([SocialTaxID], [Month], [Amount],[UserID]) VALUES (4,05,556.65,'ID04')
GO
/*Report*/
INSERT [dbo].[Report] ([ReportID], [ReportName],[Content],[UserID]) VALUES (1,'Target','Employee recruitment target report of the year','ID01')
INSERT [dbo].[Report] ([ReportID], [ReportName],[Content],[UserID]) VALUES (2,'Static','Detailed statistics of employees who have passed','ID02')
GO
/*LogOT*/

INSERT [dbo].[LogOT] ([LogOTID], [Date], [Hours],[UserID]) VALUES (1,'2022-09-15',02,'ID01')
INSERT [dbo].[LogOT] ([LogOTID], [Date], [Hours],[UserID]) VALUES (2,'2022-01-21',01,'ID02')
INSERT [dbo].[LogOT] ([LogOTID], [Date], [Hours],[UserID]) VALUES (3,'2022-09-15',02,'ID03')
INSERT [dbo].[LogOT] ([LogOTID], [Date], [Hours],[UserID]) VALUES (4,'2022-07-15',03,'ID04')
GO
/*Leave*/

INSERT [dbo].[Leave] ([LeaveID], [LeaveStartDate], [LeaveEndDate],[UserID]) VALUES (1,'2023-01-12','2023-01-15','ID01')
INSERT [dbo].[Leave] ([LeaveID], [LeaveStartDate], [LeaveEndDate],[UserID]) VALUES (2,'2022-04-12','2022-04-16','ID02')
INSERT [dbo].[Leave] ([LeaveID], [LeaveStartDate], [LeaveEndDate],[UserID]) VALUES (3,'2022-08-23','2022-08-27','ID03')
INSERT [dbo].[Leave] ([LeaveID], [LeaveStartDate], [LeaveEndDate],[UserID]) VALUES (4,'2023-02-12','2023-02-15','ID04')
GO
/*Candidate*/
INSERT [dbo].[Candidate] ([CandidateID], [CandidateName], [Position],[ContactInformation],[Status],[UserID]) VALUES ('CID01','Le Ba Trung','IT Support','batrung@gmail.com',0,'ID01')
INSERT [dbo].[Candidate] ([CandidateID], [CandidateName], [Position],[ContactInformation],[Status],[UserID]) VALUES ('CID02','Nguyen Hong Chanh','Marketing','hongchanh@gmail.com',1,'ID01')
GO

/*Personal Contract*/
INSERT [dbo].[PersonalContract] ([ContractID], [StaffType], [ContractStartDate],[ContractEndDate],[Salary],[UserID]) VALUES (1,'IT Support','2022-09-12','2024-09-12',4567.87,'ID01')
INSERT [dbo].[PersonalContract] ([ContractID], [StaffType], [ContractStartDate],[ContractEndDate],[Salary],[UserID]) VALUES (2,'Marketing','2022-05-15','2025-05-15',8765.48,'ID01')



