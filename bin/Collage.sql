CREATE DATABASE  IF NOT EXISTS `collage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `collage`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: collage
-- ------------------------------------------------------
-- Server version	5.6.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignments` (
  `serialno` int(11) NOT NULL AUTO_INCREMENT,
  `semester` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `Assignment_title` varchar(45) DEFAULT NULL,
  `Assignment_body` varchar(45) DEFAULT NULL,
  `DateofUpload` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`serialno`),
  UNIQUE KEY `serialno_UNIQUE` (`serialno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,3,2,'IT','OOPs Assignment','Revise your all syllabus upto chapter 6','2015-07-22 00:00:00'),(2,1,1,'CSE','Physics Assignment','Prepare chapter 13 for test','2015-07-22 00:00:00'),(3,3,2,'IT','Ist assignment','revise your all syllabus','2015-07-22 23:28:00'),(4,3,2,'IT','Ist assignment','revise your all syllabus','2015-07-22 23:28:06');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `rollno` varchar(45) NOT NULL,
  `subject1t` int(11) DEFAULT NULL,
  `subject1p` int(11) DEFAULT NULL,
  `subject2t` int(11) DEFAULT NULL,
  `subject2p` int(11) DEFAULT NULL,
  `subject3t` int(11) DEFAULT NULL,
  `subject3p` int(11) DEFAULT NULL,
  `subject4t` int(11) DEFAULT NULL,
  `subject4p` int(11) DEFAULT NULL,
  `subject5t` int(11) DEFAULT NULL,
  `subject5p` int(11) DEFAULT NULL,
  `subject6t` int(11) DEFAULT NULL,
  PRIMARY KEY (`rollno`),
  UNIQUE KEY `rollno_UNIQUE` (`rollno`),
  CONSTRAINT `roll` FOREIGN KEY (`rollno`) REFERENCES `login` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('1311413',1,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL),('1311414',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311415',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311416',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311417',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311418',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311419',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311421',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311422',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311423',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311424',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311425',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311427',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311428',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311429',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311430',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311431',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311432',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311433',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1311436',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1311438',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1311440',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411321',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411322',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1411323',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411324',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411325',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1411326',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1411327',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411328',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411329',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('1411330',1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),('146001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146002',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146003',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146004',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146005',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146006',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146007',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146008',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146009',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('146010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` enum('teacher','student') NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('1311413','1311413','student'),('1311414','1311414','student'),('1311415','1311415','student'),('1311416','1311416','student'),('1311417','1311417','student'),('1311418','1311418','student'),('1311419','1311419','student'),('1311421','1311421','student'),('1311422','1311422','student'),('1311423','1311423','student'),('1311424','1311424','student'),('1311425','1311425','student'),('1311427','1311427','student'),('1311428','1311428','student'),('1311429','1311429','student'),('1311430','1311430','student'),('1311431','1311431','student'),('1311432','1311432','student'),('1311433','1311433','student'),('1311436','1311436','student'),('1311438','1311438','student'),('1311440','1311440','student'),('1411321','1411321','student'),('1411322','1411322','student'),('1411323','1411323','student'),('1411324','1411324','student'),('1411325','1411325','student'),('1411326','1411326','student'),('1411327','1411327','student'),('1411328','1411328','student'),('1411329','1411329','student'),('1411330','1411330','student'),('146001','146001','student'),('146002','146002','student'),('146003','146003','student'),('146004','146004','student'),('146005','146005','student'),('146006','146006','student'),('146007','146007','student'),('146008','146008','student'),('146009','146009','student'),('146010','146010','student'),('manpreet','manpreet','teacher'),('parminder','parminder','teacher'),('priyanka','priyanka','teacher'),('raninder','raninder','teacher'),('teacher','12345','teacher');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_details` (
  `rollno` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Fname` varchar(45) NOT NULL,
  `Mname` varchar(45) DEFAULT NULL,
  `phone` bigint(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `semester` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `residancetype` enum('hostel','day scholar') NOT NULL,
  `fee_status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`rollno`),
  UNIQUE KEY `rollno_UNIQUE` (`rollno`),
  KEY `semester_idx` (`semester`),
  CONSTRAINT `rollno` FOREIGN KEY (`rollno`) REFERENCES `login` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_details`
--

LOCK TABLES `student_details` WRITE;
/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
INSERT INTO `student_details` VALUES ('1311413','Neha ','Kumari','1995-04-12','Gouri Nath',NULL,9816034543,'Gndec,ludhiana','nehakumari@gmail.com',3,2,'IT','day scholar',''),('1311414','Paramvir','Singh','1995-04-13','Jeet Ram',NULL,9685435245,'Gndec,ludhiana','paramvirsingh@gmail.com',3,2,'IT','hostel',''),('1311415','Pardeep ','Brar','1995-11-12','Satvinder Singh Brar',NULL,8427004005,'Gndec,ludhiana','brar22@gmail.com',3,2,'IT','day scholar',''),('1311416','Parminder','Kaur','1995-12-05','Bhupinder Singh',NULL,9877654321,'Gndec,ludhiana','parminderkaur@gmail.com',3,2,'IT','day scholar',''),('1311417','Parvinder','Sekhon','1995-11-23','Surinder Singh',NULL,9915222967,'Gndec,ludhiana','parvindersekhon@gmail.com',3,2,'IT','day scholar',''),('1311418','Pavneet','Kaur','1995-07-11','Makhan Singh',NULL,9877685943,'Gndec,ludhian','pavneetkaur@gmail.com',3,2,'IT','day scholar',''),('1311419','Prabhash','Kumar','1995-05-08','Murari Kant Jha',NULL,9785644212,'Gndec,ludhiana','prabhashjha@gmail.com',3,2,'IT','hostel',''),('1311421','Prabhjot ','Kaur','1995-07-18','Rachpal Singh',NULL,9834512345,'Gndec,ludhiana','prabhjotkaur@gmail.com',3,2,'IT','day scholar',''),('1311422','Pushpinder ','Singh','1995-10-29','Ram Singh',NULL,8427272268,'Gndec,ludhiana','pushpindersingh@gmail.com',3,2,'IT','day scholar',''),('1311423','Rajan ','Ravi','1995-09-19','Ravindra Mahto',NULL,8675894657,'gndec,ludhiana','rajanravi@gmail.com',3,2,'IT','hostel',''),('1311424','Rajdeep ','Singh','1995-06-07','Ajit Singh',NULL,9856342678,'Gndec,ludhiana','rajdeepsingh@gmail.com',3,2,'IT','day scholar',''),('1311425','Raman','Chaudhary','1994-04-05','Bishamber Chaudhary',NULL,9785675432,'Gndec,ludhiana','ramanchaudhary@gmail.com',3,2,'IT','day scholar',''),('1311427','Ripudaman','Singh','1995-08-12','Bhupider Singh',NULL,8146654521,'Gndec,ludhiana','ripudamansingh@gmail.com',3,2,'IT','day scholar',''),('1311428','Rishab','Gupta','1995-05-02','Rajeev Gupta',NULL,8796547352,'Gndec,ludhiana','rishabgupta@gmail.com',3,2,'IT','day scholar',''),('1311429','Rishabh','Kunar','1995-08-23','Kishori Lal','Rekha Kumari',7589424637,'Q.no-421-D,Type-2,RCF,Kapurthala','rishabhbehl82@gmail.com',3,2,'IT','hostel',''),('1311430','Rishav ','Sadana','1995-07-01','Vinod Kumar',NULL,9653612598,'Gndec,ludhiana','rishavsadana@gmail.com',3,2,'IT','day scholar',''),('1311431','Sandeep','kumar','1995-07-11','Mundrika Kumar',NULL,8977554433,'Gndec,ludhiana','sandeepmaurya@gmail.com',3,2,'IT','day scholar',''),('1311432','Shagun','Gupta','1995-04-17','Ajay Gupta',NULL,8756645323,'Gndec,ludhiana','shagungupta@gmail.com',3,2,'IT','day scholar',''),('1311433','Sharanjit ','Kaur','1995-07-05','Sukhvinder Singh',NULL,7685943624,'Gndec,ludhian','sharanjitkaur@gmail.com',3,2,'IT','day scholar',''),('1311436','Shubham','Kumar','1995-11-26','Surjit Kumar',NULL,8790605543,'Gndec,ludhiana','shubhamkumar@gmail.com',3,2,'IT','hostel',''),('1311438','Tejvinder','Singh','1995-06-26','-',NULL,7685940213,'Gndec,ludhiana','tejvindersingh@gmail.com',3,2,'IT','day scholar',''),('1311440','Vijay','pal','1994-12-14','Ram adhar Pal',NULL,8687465342,'Gndec,ludhiana','vijaypal@gmail.com',3,2,'IT','day scholar',''),('1411321','Atinderpal','Singh','1995-04-08','Surjit Singh',NULL,8676756453,'Gndec,ludhiana','atinderpal@gmail.com',3,2,'IT','day scholar',''),('1411322','Deepak','Gabha','1995-12-17','Ashvani Kumar',NULL,9887653147,'Gndec,ludhiana','deepakgabha@gmail.com',3,2,'IT','hostel',''),('1411323','Gursevak','Singh','1994-05-05','Saroop Singh',NULL,8564544343,'Gndec,ludhiana','gursevaksingh@gmail.com',3,2,'IT','day scholar',''),('1411324','Jagdeep','Kaur','1995-06-05','Jasvir Singh',NULL,9875232781,'Gndec,ludhiana','jagdeepkaur@gmail.com',3,2,'IT','day scholar',''),('1411325','Jasvir ','Kaur','1995-12-23','Sukhminder singh',NULL,9363442718,'Gndec,ludhiana','jasvirkaur@gmail.com',3,2,'IT','day scholar',''),('1411326','Jaswinder','Singh','1995-04-23','Bahadur Singh',NULL,9534256328,'Gndec,ludhiana','jaswindersingh@gmail.com',3,2,'IT','day scholar',''),('1411327','Kamaljit','Kaur','1995-12-12','Harjit Singh',NULL,8934848413,'Gndec,ludhiana','kamaljitkaur@gmail.com',3,2,'IT','day scholar',''),('1411328','Kanav ','Jain','1994-07-14','Sunil Jain',NULL,9812403245,'Gndec,ludhiana','kanavjain@gmail,com',3,2,'IT','day scholar',''),('1411329','Khushwinder','Kaur','1995-04-12','Jaswant Singh ',NULL,7755444685,'Gndec,ludhiana','khuswinderkaur@gmail.com',3,2,'IT','day scholar',''),('1411330','Mamanpreet','Kaur','1995-06-23','Harjinder Singh',NULL,9438346736,'Gndec,ludhiana','mamanpreetkaur@gmail.com',3,2,'IT','day scholar',''),('146001','Adish','Mahajan','1996-06-13','Ram Mahajan','Monica Mahajan',9812345674,'Gndec,ludhiana','adishmahajan@gmail.com',1,1,'CSE','hostel',''),('146002','Navneet','Khanna','1997-08-18','Rajeev Khanna','Mini Khanna',9888456789,'Gndec,ludhiana','navneetkhanna@gmail.com',1,1,'CSE','day scholar',''),('146003','Sanya','Sehgal','1996-04-09','Rahul Sehgal','Shikha Sehgal',9876500033,'Gndec,ludhiana','sanyasehgal@gmail.com',1,1,'CSE','hostel',''),('146004','Devdeep','Arora','1995-04-01','Raj Arora','Rani Arora',7505776644,'Gndec,ludhiana','devdeeparora@gmail.com',1,1,'CSE','day scholar',''),('146005','Gagandeep','Singh','1996-05-15','Kuldeep Singh','Simranjeet Kaur',7307508665,'Gndec,ludhiana','gagandeepsingh@gmail.com',1,1,'CSE','hostel',''),('146006','Munish','Rana','1997-06-20','Manish Rana','Manisha Rana',9823465656,'Gndec,ludhiana','munishrana@gmail.com',1,1,'CSE','day scholar',''),('146007','Jugraj','Singh','1996-09-18','Kulwant Singh','Radhika Kaur',9417075656,'Gndec,ludhiana','jugrajsingh@gmail.com',1,1,'CSE','day scholar',''),('146008','Neha','Aggarwal','1997-03-12','Danish Aggarwal','Pooja Aggarwal',9888355345,'Gndec,ludhiana','nehaaggarwal@gmail.com',1,1,'CSE','day scholar',''),('146009','Anurag','Saini','1996-01-08','Anish Saini','Deepika Saini',8540498377,'Gndec,ludhiana','anuragsaini@gmail.com',1,1,'CSE','day scholar',''),('146010','Radhika','Mehra','1996-02-12','Navraj Mehra','Monica Mehra',9811223450,'Gndec,ludhiana','radhikamehra@gmail.com',1,1,'CSE','hostel','');
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_result`
--

DROP TABLE IF EXISTS `student_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_result` (
  `rollno` int(11) NOT NULL,
  `subject1t` double DEFAULT NULL,
  `subject1p` double DEFAULT NULL,
  `subject2t` double DEFAULT NULL,
  `subject2p` double DEFAULT NULL,
  `subject3t` double DEFAULT NULL,
  `subject3p` double DEFAULT NULL,
  `subject4t` double DEFAULT NULL,
  `subject4p` double DEFAULT NULL,
  `subject5t` double DEFAULT NULL,
  `subject5p` double DEFAULT NULL,
  `subject6t` double DEFAULT NULL,
  PRIMARY KEY (`rollno`),
  UNIQUE KEY `rollno_UNIQUE` (`rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_result`
--

LOCK TABLES `student_result` WRITE;
/*!40000 ALTER TABLE `student_result` DISABLE KEYS */;
INSERT INTO `student_result` VALUES (1311413,40,35,41,34,45,34,36,23,56,34,90),(1311414,30,31,34,32,35,22,29,19,28,24,80),(1311415,41,31,43,34,54,38,45,25,57,36,95),(1311416,35,24,54,24,35,24,45,27,51,31,80),(1311417,54,32,45,34,51,34,51,38,45,34,67),(1311418,45,31,43,35,32,24,40,38,40,28,78),(1311419,43,23,34,24,43,19,41,31,37,36,96),(1311421,34,31,41,23,25,23,44,23,45,34,76),(1311422,51,32,45,31,42,32,43,27,40,39,93),(1311423,45,31,24,32,43,32,34,28,46,24,89),(1311424,43,25,34,21,34,22,36,39,42,26,65),(1311425,42,24,34,22,43,23,34,32,43,21,87),(1311427,51,38,51,35,51,34,55,33,43,32,84),(1311428,50,36,52,36,43,33,43,35,54,36,89),(1311429,54,37,53,36,54,37,51,38,51,38,87),(1311430,55,36,54,31,54,38,39,35,54,35,90),(1311431,45,35,51,34,53,32,43,28,51,22,78),(1311432,45,35,51,24,51,28,43,26,30,31,90),(1311433,51,34,45,24,43,38,43,21,34,19,78),(1311436,47,22,43,34,36,25,32,25,41,23,88),(1311438,24,19,34,32,35,26,34,34,48,24,86),(1311440,51,31,43,35,34,27,30,24,54,27,80);
/*!40000 ALTER TABLE `student_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `serialno` int(11) NOT NULL AUTO_INCREMENT,
  `semester` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `subject1` varchar(45) NOT NULL,
  `subject2` varchar(45) NOT NULL,
  `subject3` varchar(45) NOT NULL,
  `subject4` varchar(45) NOT NULL,
  `subject5` varchar(45) NOT NULL,
  `subject6` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`serialno`),
  UNIQUE KEY `serialno_UNIQUE` (`serialno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,3,2,'IT','OOPs','DS','MATH','JAVA','CA','GF'),(2,1,1,'CSE','Physics','ED','OOPs','BEEE','MATH','HVPE');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_details`
--

DROP TABLE IF EXISTS `teacher_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_details` (
  `teacherid` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Mname` varchar(45) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacherid`),
  UNIQUE KEY `teacherid_UNIQUE` (`teacherid`),
  CONSTRAINT `teacherid` FOREIGN KEY (`teacherid`) REFERENCES `login` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_details`
--

LOCK TABLES `teacher_details` WRITE;
/*!40000 ALTER TABLE `teacher_details` DISABLE KEYS */;
INSERT INTO `teacher_details` VALUES ('manpreet','Manpreet','kaur','1977-04-12','',NULL,8756353423,'manpreetkaur@gmail.com','Gndec,ludhiana','JAVA'),('parminder','Parminder','kaur','1987-04-11',NULL,NULL,6574655444,'parminderkaur@gmail.com','Gndec,ludhiana','OOPs'),('priyanka','Priyanka','Arora','1987-07-11',NULL,NULL,9876543311,'priyankaarora@gmail.com','Gndec,ludhiana','MATH'),('raninder','Raninder','Dhillon','1984-04-14',NULL,NULL,9866344356,'raninderdhillon@gmail.com','Gndec,ludhiana','CA');
/*!40000 ALTER TABLE `teacher_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_lectures`
--

DROP TABLE IF EXISTS `total_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_lectures` (
  `Serialno` int(11) NOT NULL AUTO_INCREMENT,
  `semester` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `subject1t` int(11) DEFAULT NULL,
  `subject1p` int(11) DEFAULT NULL,
  `subject2t` int(11) DEFAULT NULL,
  `subject2p` int(11) DEFAULT NULL,
  `subject3t` int(11) DEFAULT NULL,
  `subject3p` int(11) DEFAULT NULL,
  `subject4t` int(11) DEFAULT NULL,
  `subject4p` int(11) DEFAULT NULL,
  `subject5t` int(11) DEFAULT NULL,
  `subject5p` int(11) DEFAULT NULL,
  `subject6t` int(11) DEFAULT NULL,
  PRIMARY KEY (`Serialno`),
  UNIQUE KEY `Serialno_UNIQUE` (`Serialno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_lectures`
--

LOCK TABLES `total_lectures` WRITE;
/*!40000 ALTER TABLE `total_lectures` DISABLE KEYS */;
INSERT INTO `total_lectures` VALUES (1,3,2,'IT',1,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL),(2,1,1,'CSE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `total_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_marks`
--

DROP TABLE IF EXISTS `total_marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `total_marks` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `semester` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `subject1t` int(11) DEFAULT '60',
  `subject1p` int(11) DEFAULT '40',
  `subject2t` int(11) DEFAULT '60',
  `subject2p` int(11) DEFAULT '40',
  `subject3t` int(11) DEFAULT '60',
  `subject3p` int(11) DEFAULT '40',
  `subject4t` int(11) DEFAULT '60',
  `subject4p` int(11) DEFAULT '40',
  `subject5t` int(11) DEFAULT '60',
  `subject5p` int(11) DEFAULT '40',
  `subject6t` int(11) DEFAULT '60',
  PRIMARY KEY (`serial`),
  UNIQUE KEY `serial_UNIQUE` (`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_marks`
--

LOCK TABLES `total_marks` WRITE;
/*!40000 ALTER TABLE `total_marks` DISABLE KEYS */;
INSERT INTO `total_marks` VALUES (1,1,1,'CSE',60,40,60,40,60,40,60,40,60,40,100),(2,3,2,'IT',60,40,60,40,60,40,60,40,60,40,100);
/*!40000 ALTER TABLE `total_marks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-23 10:35:43
