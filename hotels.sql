-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2022 at 04:27 PM
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
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `idH` int(11) NOT NULL,
  `id_contactH` int(11) DEFAULT NULL,
  `nomH` varchar(30) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telH` int(11) NOT NULL,
  `equipement` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`idH`, `id_contactH`, `nomH`, `categorie`, `adresse`, `email`, `telH`, `equipement`) VALUES
(36, 0, 'malek', 'malek', 'malek', '', 0, 'malzk'),
(37, 0, 'aa', 'aaa', 'aa', '', 0, 'AAA'),
(40, NULL, 'xcfvgbhn', '1111ggg ', 'bnoi,', 'hbni,', 12354321, 'a'),
(41, NULL, 'retret', 'TQYHSTJDYKTQYSTJDK', 'QYSUJ', 'QTYHSJ@QGHS.com', 234567, 'SHJDKF'),
(50, NULL, 'jk;', 'hk;', 'kn', 'azedfghkj@gmail.com', 87654333, ';jb'),
(51, NULL, 'malek', 'malek', 'malek', 'malek@malek.com', 23456789, 'malek'),
(54, NULL, 'one', 'one', 'one', 'one@one.one', 55555555, 'one'),
(55, NULL, 'ib', 'ib', 'ib', 'ib@gamail.com', 22334455, 'ib');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`idH`),
  ADD KEY `id_contactH` (`id_contactH`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `idH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotels`
--
ALTER TABLE `hotels`
  ADD CONSTRAINT `hotels_ibfk_1` FOREIGN KEY (`id_contactH`) REFERENCES `user` (`id_c`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
