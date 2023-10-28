-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2021 at 09:27 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

CREATE TABLE `donation` (
  `donation_id` int(255) NOT NULL,
  `donor_id` int(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `quantity` double NOT NULL,
  `donation_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donation`
--

INSERT INTO `donation` (`donation_id`, `donor_id`, `blood_group`, `quantity`, `donation_date`) VALUES
(1, 1, 'B+', 3.4, '29-11-2021'),
(2, 1, 'B+', 2.4, '29-11-2021'),
(3, 2, 'AB+', 2.4, '29-11-2021'),
(4, 2, 'AB+', 1.8, '29-11-2021'),
(5, 3, 'B+', 5.9, '29-11-2021');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `d_id` int(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` int(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`d_id`, `full_name`, `age`, `gender`, `phone`, `city`, `blood_group`) VALUES
(1, 'Shahin Shah', 18, 'MALE', 1794302620, 'GEC', 'B+'),
(2, 'Shamim Md Jony', 28, 'MALE', 1816357119, 'GEC', 'AB+'),
(3, 'Shahadat Hossain', 26, 'MALE', 1816357112, 'KHULSHI ', 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `hand_over`
--

CREATE TABLE `hand_over` (
  `handover_id` int(255) NOT NULL,
  `patient_id` int(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `quantity` double NOT NULL,
  `handover_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hand_over`
--

INSERT INTO `hand_over` (`handover_id`, `patient_id`, `blood_group`, `quantity`, `handover_date`) VALUES
(1, 2, 'B+', 3, '14-11-2021'),
(2, 2, 'B+', 2, '15-11-2021'),
(3, 3, 'B+', 4.4, '29-11-2021');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `p_id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` int(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `disease` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`p_id`, `name`, `age`, `gender`, `phone`, `city`, `blood_group`, `disease`) VALUES
(2, 'Sadat Hossain', 25, 'Male', 1874951204, 'GEC', 'A+', 'Heart Attack'),
(3, 'Kaisar Faravi', 24, 'MALE', 1841631041, 'AGRABAD', 'B+', 'Accident');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `blood_id` int(255) NOT NULL,
  `blood_group` varchar(255) NOT NULL,
  `quantity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`blood_id`, `blood_group`, `quantity`) VALUES
(1, 'A+', 0),
(2, 'A-', 0),
(3, 'B+', 5.9),
(4, 'B-', 0),
(5, 'O+', 0),
(6, 'O-', 0),
(7, 'AB+', 4.2),
(8, 'AB-', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donation`
--
ALTER TABLE `donation`
  ADD PRIMARY KEY (`donation_id`),
  ADD KEY `CK_DonorID` (`donor_id`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `hand_over`
--
ALTER TABLE `hand_over`
  ADD PRIMARY KEY (`handover_id`),
  ADD KEY `CK_PatientID` (`patient_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`blood_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donation`
--
ALTER TABLE `donation`
  ADD CONSTRAINT `CK_DonorID` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hand_over`
--
ALTER TABLE `hand_over`
  ADD CONSTRAINT `CK_PatientID` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
