-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2022 at 04:28 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pack&go`
--

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `idS` int(11) NOT NULL,
  `formule` varchar(50) NOT NULL,
  `prix` float NOT NULL,
  `sejours` varchar(50) DEFAULT NULL,
  `activite` varchar(50) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `id_hotel` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`idS`, `formule`, `prix`, `sejours`, `activite`, `etat`, `id_hotel`) VALUES
(7, 'dcfvgr', 131, 'ffce', 'DZCCEFDF', 'CFECCF', 0),
(9, 'zaed', 3488, 'aedfcz', 'tttùùùù', 'dsfdhm', 0),
(10, 'dfgd', 12309900, 'dsfvdg', 'DSFD', 'DFVGD', 0),
(11, 'hgvbknl', 13243, 'gbdfvd', 'fvscd', 'fvedvesv', 0),
(14, 'zzz', 11, 'zzz', 'zzz', 'zzzz', 40),
(16, 'aqq', 3488, 'aedfcz', 'tttùùùù', 'dsfdhm', 51),
(18, 'malek', 12222, 'malek', 'malek', 'malek', 51),
(19, 'TWO', 1, 'TWO', 'oneTT', 'oneTT', 54),
(20, 'ib', 22, 'ib', 'ib', 'ib', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`idS`),
  ADD KEY `fk_contact` (`id_hotel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `idS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `fk_contact` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`idH`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
