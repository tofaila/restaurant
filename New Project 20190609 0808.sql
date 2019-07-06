-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema restaurant
--

CREATE DATABASE IF NOT EXISTS restaurant;
USE restaurant;

--
-- Definition of table `bookinginfo`
--

DROP TABLE IF EXISTS `bookinginfo`;
CREATE TABLE `bookinginfo` (
  `bookingid` varchar(255) default NULL,
  `bookingcharge` int(11) NOT NULL,
  `bookingdate` date default NULL,
  `bookingtime` time default NULL,
  `custid` varchar(255) default NULL,
  `orderdetails` varchar(255) default NULL,
  `tableid` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookinginfo`
--

/*!40000 ALTER TABLE `bookinginfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookinginfo` ENABLE KEYS */;


--
-- Definition of table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `custid` varchar(200) NOT NULL,
  `custfname` varchar(45) NOT NULL,
  `custlname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerinfo`
--

/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
INSERT INTO `customerinfo` (`custid`,`custfname`,`custlname`,`address`,`phone`,`emailid`,`gender`) VALUES 
 ('1','Shahin','Ahmed','Dhaka','0196857458','shahin@gmail.com','Male'),
 ('2','Mahin','Ahmed','Dhaka','01896574545','mahin@gmail.com','Male');
/*!40000 ALTER TABLE `customerinfo` ENABLE KEYS */;


--
-- Definition of table `customerorder`
--

DROP TABLE IF EXISTS `customerorder`;
CREATE TABLE `customerorder` (
  `orderid` varchar(255) NOT NULL,
  `custid` varchar(255) default NULL,
  `deliverytype` varchar(255) default NULL,
  `orderdate` date default NULL,
  `orderstatus` varchar(255) default NULL,
  `totalprice` double default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerorder`
--

/*!40000 ALTER TABLE `customerorder` DISABLE KEYS */;
INSERT INTO `customerorder` (`orderid`,`custid`,`deliverytype`,`orderdate`,`orderstatus`,`totalprice`) VALUES 
 ('1','1','cash on','2019-06-08','true',500);
/*!40000 ALTER TABLE `customerorder` ENABLE KEYS */;


--
-- Definition of table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `detailsid` varchar(255) NOT NULL,
  `orderid` varchar(255) default NULL,
  `pid` int(11) NOT NULL,
  `price` double default NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetails`
--

/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` (`detailsid`,`orderid`,`pid`,`price`,`quantity`) VALUES 
 ('1','1',1,100,5);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payid` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `custid` varchar(255) default NULL,
  `orderid` varchar(255) default NULL,
  `paydate` date default NULL,
  `paytype` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(255) default NULL,
  `price` double default NULL,
  `status` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pid`,`pname`,`price`,`status`,`type`) VALUES 
 (1,'Dessert',100,'very delicious','small'),
 (2,'Drink',150,'very delicious','liquid');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `tableinfo`
--

DROP TABLE IF EXISTS `tableinfo`;
CREATE TABLE `tableinfo` (
  `tableid` varchar(200) default NULL,
  `tableno` varchar(255) default NULL,
  `totalseat` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tableinfo`
--

/*!40000 ALTER TABLE `tableinfo` DISABLE KEYS */;
INSERT INTO `tableinfo` (`tableid`,`tableno`,`totalseat`) VALUES 
 ('1','1','3'),
 ('2','2','10');
/*!40000 ALTER TABLE `tableinfo` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `emailid` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `username` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `emailid` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  `status` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;


--
-- Definition of table `waiterinfo`
--

DROP TABLE IF EXISTS `waiterinfo`;
CREATE TABLE `waiterinfo` (
  `waiterid` int(10) unsigned NOT NULL auto_increment,
  `waitername` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`waiterid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waiterinfo`
--

/*!40000 ALTER TABLE `waiterinfo` DISABLE KEYS */;
INSERT INTO `waiterinfo` (`waiterid`,`waitername`,`address`,`phone`,`emailid`) VALUES 
 (1,'Samir','Khulna','01895623','samir@gmail.com'),
 (2,'Mahin','Dhaka','01587956','mahin@gmail.com');
/*!40000 ALTER TABLE `waiterinfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
