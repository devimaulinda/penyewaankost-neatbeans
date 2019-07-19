-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2019 at 08:40 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kost`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `level`) VALUES
('admin', 'admin', 'Admin'),
('maulinda', 'maulinda', 'Pemilik');

-- --------------------------------------------------------

--
-- Table structure for table `tb_dtfasilitas`
--

CREATE TABLE `tb_dtfasilitas` (
  `id_dtfasilitas` char(5) NOT NULL,
  `nm_fasilitas` varchar(20) NOT NULL,
  `fasilitas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dtfasilitas`
--

INSERT INTO `tb_dtfasilitas` (`id_dtfasilitas`, `nm_fasilitas`, `fasilitas`) VALUES
('F001', 'DULUXE', '1 spring bed, kipas angin, kamar mandi luar'),
('F002', 'LUXURY', '1 spring bed, AC, kamar mandi dalam'),
('F003', 'LUXURY', '1 spring bed, AC, kamar mandi dalam'),
('F004', 'VIP', '2 spring bed, AC, kamar mandi dalam'),
('F005', 'LUXURY', '1 spring bed, AC, kamar mandi dalam'),
('F006', 'DULUXE', '1 spring bed, kipas angin, kamar mandi luar');

-- --------------------------------------------------------

--
-- Table structure for table `tb_fasilitas`
--

CREATE TABLE `tb_fasilitas` (
  `id_fasilitas` char(5) NOT NULL,
  `nm_fasilitas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_fasilitas`
--

INSERT INTO `tb_fasilitas` (`id_fasilitas`, `nm_fasilitas`) VALUES
('F001', 'DULUXE'),
('F002', 'LUXURY'),
('F003', 'LUXURY'),
('F004', 'VIP'),
('F005', 'LUXURY'),
('F006', 'DULUXE');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jenissewa`
--

CREATE TABLE `tb_jenissewa` (
  `id_jenissewa` char(5) NOT NULL,
  `nm_jenissewa` varchar(20) NOT NULL,
  `hari` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jenissewa`
--

INSERT INTO `tb_jenissewa` (`id_jenissewa`, `nm_jenissewa`, `hari`) VALUES
('S001', 'HARIAN', 2),
('S002', 'BULANAN', 30),
('S003', 'HARIAN', 7),
('S004', 'BULANAN', 30),
('S005', 'HARIAN', 10),
('S006', 'BULANAN', 30);

-- --------------------------------------------------------

--
-- Table structure for table `tb_jnskamar`
--

CREATE TABLE `tb_jnskamar` (
  `id_jnskamar` char(5) NOT NULL,
  `nm_jnskamar` varchar(20) NOT NULL,
  `harga` int(12) NOT NULL,
  `kapasitas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jnskamar`
--

INSERT INTO `tb_jnskamar` (`id_jnskamar`, `nm_jnskamar`, `harga`, `kapasitas`) VALUES
('K001', 'DULUXE', 10000, '1 orang'),
('K002', 'VIP', 20000, '1 Orang'),
('K003', 'LUXURY', 15000, '1 Orang'),
('K004', 'VIP', 20000, '1 Orang'),
('K005', 'LUXURY', 15000, '1 Orang'),
('K006', 'DULUXE', 10000, '1 Orang');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kamar`
--

CREATE TABLE `tb_kamar` (
  `id_kamar` char(5) NOT NULL,
  `id_jnskamar` char(5) NOT NULL,
  `id_fasilitas` char(5) NOT NULL,
  `harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kamar`
--

INSERT INTO `tb_kamar` (`id_kamar`, `id_jnskamar`, `id_fasilitas`, `harga`) VALUES
('KK001', 'K001', 'F001', 10000),
('KK002', 'K002', 'F002', 20000),
('KK003', 'K003', 'F003', 15000),
('KK004', 'K004', 'F004', 20000),
('KK005', 'K005', 'F005', 15000),
('KK006', 'K006', 'F006', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pemilik`
--

CREATE TABLE `tb_pemilik` (
  `id_pemilik` char(5) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nama_pemilik` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_tlp` varchar(12) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pemilik`
--

INSERT INTO `tb_pemilik` (`id_pemilik`, `username`, `nama_pemilik`, `alamat`, `no_tlp`, `email`) VALUES
('B001', 'maulinda', 'Maulinda Devi U', 'Jln. pulanggeni no 3 Surakarta', '085725368965', 'maulindadevi@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `id_penyewa` char(5) NOT NULL,
  `nm_penyewa` varchar(20) NOT NULL,
  `no_tlp` varchar(12) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penyewa`
--

INSERT INTO `tb_penyewa` (`id_penyewa`, `nm_penyewa`, `no_tlp`, `status`) VALUES
('P001', 'Fatma', '085672345666', 'Mahasiswi'),
('P002', 'Aziz', '089786578890', 'Mahasiswa'),
('P003', 'Herlina', '089023675889', 'Pelajar'),
('P004', 'Anggara', '082124568980', 'Karyawan'),
('P005', 'Bayu', '087658906755', 'Mahasiswa'),
('P006', 'Ayu', '087723145689', 'Karyawan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `id_transaksi` char(5) NOT NULL,
  `id_penyewa` char(5) NOT NULL,
  `id_kamar` char(5) NOT NULL,
  `id_jenissewa` char(5) NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id_transaksi`, `id_penyewa`, `id_kamar`, `id_jenissewa`, `total`, `bayar`, `kembalian`) VALUES
('T001', 'P001', 'KK001', 'S001', 20000, 50000, 30000),
('T002', 'P002', 'KK002', 'S002', 600000, 600000, 0),
('T003', 'P003', 'KK003', 'S003', 105000, 110000, 5000),
('T004', 'P004', 'KK004', 'S004', 600000, 600000, 0),
('T005', 'P005', 'KK005', 'S005', 150000, 200000, 50000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_dtfasilitas`
--
ALTER TABLE `tb_dtfasilitas`
  ADD PRIMARY KEY (`id_dtfasilitas`);

--
-- Indexes for table `tb_fasilitas`
--
ALTER TABLE `tb_fasilitas`
  ADD PRIMARY KEY (`id_fasilitas`);

--
-- Indexes for table `tb_jenissewa`
--
ALTER TABLE `tb_jenissewa`
  ADD PRIMARY KEY (`id_jenissewa`);

--
-- Indexes for table `tb_jnskamar`
--
ALTER TABLE `tb_jnskamar`
  ADD PRIMARY KEY (`id_jnskamar`);

--
-- Indexes for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD PRIMARY KEY (`id_kamar`),
  ADD KEY `id_jeniskamar` (`id_jnskamar`);

--
-- Indexes for table `tb_pemilik`
--
ALTER TABLE `tb_pemilik`
  ADD PRIMARY KEY (`id_pemilik`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indexes for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_penyewa` (`id_penyewa`),
  ADD KEY `id_jenissewa` (`id_jenissewa`),
  ADD KEY `id_kamar` (`id_kamar`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_dtfasilitas`
--
ALTER TABLE `tb_dtfasilitas`
  ADD CONSTRAINT `tb_dtfasilitas_ibfk_1` FOREIGN KEY (`id_dtfasilitas`) REFERENCES `tb_fasilitas` (`id_fasilitas`);

--
-- Constraints for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD CONSTRAINT `tb_kamar_ibfk_1` FOREIGN KEY (`id_jnskamar`) REFERENCES `tb_jnskamar` (`id_jnskamar`);

--
-- Constraints for table `tb_pemilik`
--
ALTER TABLE `tb_pemilik`
  ADD CONSTRAINT `tb_pemilik_ibfk_1` FOREIGN KEY (`username`) REFERENCES `login` (`username`);

--
-- Constraints for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD CONSTRAINT `tb_transaksi_ibfk_1` FOREIGN KEY (`id_penyewa`) REFERENCES `tb_penyewa` (`id_penyewa`),
  ADD CONSTRAINT `tb_transaksi_ibfk_2` FOREIGN KEY (`id_jenissewa`) REFERENCES `tb_jenissewa` (`id_jenissewa`),
  ADD CONSTRAINT `tb_transaksi_ibfk_3` FOREIGN KEY (`id_kamar`) REFERENCES `tb_kamar` (`id_kamar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
