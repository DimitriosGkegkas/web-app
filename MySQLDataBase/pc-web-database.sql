-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2020 at 08:09 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pc-web-database`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `user` varchar(20) NOT NULL,
  `product` int(20) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`user`, `product`, `quantity`) VALUES
('el16004', 3265048, 1),
('el16004', 3425053, 1),
('el16004', 3265048, 1),
('el16004', 3425134, 1),
('el16004', 3265048, 1),
('el16004', 3532631, 1),
('el16004', 3265048, 1),
('el16004', 3532631, 1),
('el16004', 3357880, 1),
('el16004', 3425053, 1),
('el16004', 3425134, 1),
('el16004', 3357880, 1),
('el16004', 3425053, 1),
('el16004', 3425134, 1),
('el16004', 3265048, 1),
('el16004', 3357880, 1),
('el16004', 3425053, 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `title`, `price`) VALUES
(3265048, 'HP Omen 17 - cb0011nv Laptop (Core i7 9750H/16 GB/256GB SSD + 1TB HDD/GTX 1660 Ti 6 GB)', 1499),
(3357880, 'Asus TUF Gaming FX505DT Laptop ( Ryzen 7 3750H/8 GB/512 GB/GTX 1650 4 GB)', 849),
(3425053, 'Dell Inspiron 5593 i7/16G Laptop (Core i7 1065G7/16 GB/512 GB/Iris Plus Graphics)', 949),
(3425134, 'Asus VivoBook X512DA Laptop (Ryzen 5 3500U/12 GB/512 GB/Radeon Vega 8)', 649),
(3478688, 'HP 450 G7 i5 Laptop (Core i5 10210U/8 GB/256 GB/UHD Graphics 620)', 823),
(3498034, 'Lenovo Ideapad 3 15ARE05 Laptop (Ryzen 7 4700U/8 GB/256 GB/Radeon Graphics)', 649),
(3503569, 'Huawei MateBook D14 Laptop (Ryzen 5 3500U/8 GB/512 GB/Radeon Vega 8)', 579),
(3532631, 'Dell Inspiron 5501 Laptop (Core i7 1065G7/16 GB/512 GB/GeForce MX330 2 GB)', 1249);

-- --------------------------------------------------------

--
-- Table structure for table `tax`
--

CREATE TABLE `tax` (
  `country` varchar(15) NOT NULL,
  `tax` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tax`
--

INSERT INTO `tax` (`country`, `tax`) VALUES
('Albania', 0.2),
('China', 0.13),
('Croatia', 0.25),
('Greece', 0.24),
('UK', 0.2),
('USA', 0.1172),
('Vietnam', 0.1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(35) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `birthday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `name`, `surname`, `birthday`) VALUES
('dimitrisGk', '6789', 'Dimitrios', 'Gkegkas', '2018-11-16'),
('el16004', 'dimitris@', 'Dimitrios', 'Gkegkas', '1998-04-28');

-- --------------------------------------------------------

--
-- Table structure for table `vouchers`
--

CREATE TABLE `vouchers` (
  `voucher` varchar(15) NOT NULL,
  `discount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vouchers`
--

INSERT INTO `vouchers` (`voucher`, `discount`) VALUES
('studentdiscount', 0.8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD KEY `productId` (`product`),
  ADD KEY `userN` (`user`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tax`
--
ALTER TABLE `tax`
  ADD UNIQUE KEY `country` (`country`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `vouchers`
--
ALTER TABLE `vouchers`
  ADD UNIQUE KEY `voucher` (`voucher`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `productId` FOREIGN KEY (`product`) REFERENCES `products` (`id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `userN` FOREIGN KEY (`user`) REFERENCES `users` (`username`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
