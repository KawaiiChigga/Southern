-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2016 at 09:34 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrestoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `menulist`
--

CREATE TABLE `menulist` (
  `menu_id` int(5) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `category` varchar(15) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `price` double NOT NULL,
  `duration` int(11) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `explanation` varchar(256) DEFAULT NULL,
  `path` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menulist`
--

INSERT INTO `menulist` (`menu_id`, `menu_name`, `category`, `type`, `price`, `duration`, `available`, `explanation`, `path`) VALUES
(1, 'Fried Rice', 'Food', 'Main Course', 35000, 10, 1, 'Fried Rice that made from delicious pork', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `orderlist`
--

CREATE TABLE `orderlist` (
  `order_id` int(12) NOT NULL,
  `menu_id` int(5) NOT NULL,
  `table_id` varchar(5) NOT NULL,
  `isready` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderlist`
--

INSERT INTO `orderlist` (`order_id`, `menu_id`, `table_id`, `isready`) VALUES
(1, 1, 'T0001', 2);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` varchar(5) NOT NULL,
  `identity` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(256) NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(1) NOT NULL,
  `status` varchar(30) NOT NULL,
  `description` varchar(50) NOT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `identity`, `password`, `name`, `address`, `birthday`, `gender`, `status`, `description`, `available`) VALUES
('CA001', 'cashier1', 'cashier1', 'Cassy', 'Jalan Cassy 123', '1992-09-08', 'F', 'Cashier', 'dia... itu cashier', 1),
('CH001', 'chef1', 'chef1', 'Wati', 'Jalan Wati no 3', '1994-01-06', 'F', 'Chef', 'dia itu chef', 1),
('WA001', 'waiter1', 'waiter1', 'Jojon', 'Jalan Jojon 999', '1996-08-11', 'M', 'Waiter', 'ini waiter, bukan chef dan cashier', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_date` date NOT NULL,
  `menu_id` varchar(256) NOT NULL,
  `table_id` varchar(5) NOT NULL,
  `price` varchar(256) NOT NULL,
  `total` double NOT NULL,
  `pay` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menulist`
--
ALTER TABLE `menulist`
  ADD PRIMARY KEY (`menu_id`);

--
-- Indexes for table `orderlist`
--
ALTER TABLE `orderlist`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menulist`
--
ALTER TABLE `menulist`
  MODIFY `menu_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `orderlist`
--
ALTER TABLE `orderlist`
  MODIFY `order_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
