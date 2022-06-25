-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2022 at 10:51 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `food_and_beverage`
--

CREATE TABLE `food_and_beverage` (
  `itemID` char(5) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `itemPrice` int(11) NOT NULL,
  `itemSize` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_and_beverage`
--

INSERT INTO `food_and_beverage` (`itemID`, `itemName`, `itemPrice`, `itemSize`) VALUES
('FB001', 'French Fries', 10000, 'Small'),
('FB002', 'French Fries', 15000, 'Medium'),
('FB003', 'French Fries', 25000, 'Large');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `MemberID` varchar(255) NOT NULL,
  `MemberName` varchar(255) DEFAULT NULL,
  `MemberGender` varchar(100) NOT NULL,
  `MemberType` varchar(255) NOT NULL,
  `MemberPoints` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`MemberID`, `MemberName`, `MemberGender`, `MemberType`, `MemberPoints`) VALUES
('MB715', 'Aldo', 'Male', 'Gold', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `other_groceries`
--

CREATE TABLE `other_groceries` (
  `itemID` char(5) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `itemPrice` int(11) NOT NULL,
  `expiredDate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `other_groceries`
--

INSERT INTO `other_groceries` (`itemID`, `itemName`, `itemPrice`, `expiredDate`) VALUES
('PR001', 'Lifebuoy', 10000, '02-01-2024'),
('PR002', 'Pantene', 13000, '20-12-2025'),
('PR003', 'Facial Mask', 25000, '27-03-2023');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` char(5) NOT NULL,
  `itemID` char(5) NOT NULL,
  `customerName` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionID`, `itemID`, `customerName`, `quantity`) VALUES
('TR001', 'FB002', 'Hans', 2),
('TR002', 'FB001', 'Aldo', 1),
('TR003', 'FB003', 'Jeje', 1),
('TR004', 'FB001', 'Aldo', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food_and_beverage`
--
ALTER TABLE `food_and_beverage`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`MemberID`);

--
-- Indexes for table `other_groceries`
--
ALTER TABLE `other_groceries`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
