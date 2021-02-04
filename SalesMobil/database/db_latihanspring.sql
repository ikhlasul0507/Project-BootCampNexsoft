-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Feb 2021 pada 09.47
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_latihanspring`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_customer`
--

CREATE TABLE `tbl_customer` (
  `idCustomer` varchar(100) NOT NULL,
  `namaCustomer` varchar(100) NOT NULL,
  `tglTransaksi` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_customer`
--

INSERT INTO `tbl_customer` (`idCustomer`, `namaCustomer`, `tglTransaksi`) VALUES
('58346dc0-d8ab-4351-8a2e-de5e10650fee', 'Ikhlasul', '2021-02-03 07:53:59'),
('fded2e53-d8dc-41c3-901f-fe131af6bfdb', 'Amal', '2021-01-03 07:53:32');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_customerdetail`
--

CREATE TABLE `tbl_customerdetail` (
  `idCustomerDetail` varchar(100) NOT NULL,
  `idCustomer` varchar(100) NOT NULL,
  `idMobil` varchar(100) NOT NULL,
  `qty` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_customerdetail`
--

INSERT INTO `tbl_customerdetail` (`idCustomerDetail`, `idCustomer`, `idMobil`, `qty`) VALUES
('589b147b-83ae-4704-afa9-3ca3d5f11261', '58346dc0-d8ab-4351-8a2e-de5e10650fee', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 5),
('863592f9-f416-48a9-bb08-c61dcc436efe', '58346dc0-d8ab-4351-8a2e-de5e10650fee', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 50),
('b1791ed6-f990-44b3-9111-91ec6155beb1', '58346dc0-d8ab-4351-8a2e-de5e10650fee', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 52),
('b38aa3b4-f883-4ba4-af15-313939276c93', '58346dc0-d8ab-4351-8a2e-de5e10650fee', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 6),
('b5853aaa-554d-4c91-81e2-23dfd78b58d7', 'fded2e53-d8dc-41c3-901f-fe131af6bfdb', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 5),
('e1c9bbc5-5b35-4c70-a2c8-ceab3f29d849', 'fded2e53-d8dc-41c3-901f-fe131af6bfdb', 'e9855edc-72b4-4150-8b96-b5a13d91e5fe', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_merk`
--

CREATE TABLE `tbl_merk` (
  `idMerk` varchar(100) NOT NULL,
  `namaMerk` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_merk`
--

INSERT INTO `tbl_merk` (`idMerk`, `namaMerk`) VALUES
('29f9ca3c-30c8-4412-86db-d62453037a55', 'Honda'),
('315ebc5d-2ab2-4175-b692-bbd771f754d6', 'Wuling'),
('634d81bc-3dd9-4729-8995-3504dd48a175', 'Daihatsu'),
('aa49f29a-daaf-40de-ae47-da2778f61e8e', 'Suzuki'),
('fc72c409-2c11-4660-9e36-d86df86cce86', 'Mitsubishi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_mobil`
--

CREATE TABLE `tbl_mobil` (
  `idMobil` varchar(100) NOT NULL,
  `namaMobil` varchar(50) NOT NULL,
  `idMerk` varchar(100) NOT NULL,
  `idType` varchar(100) NOT NULL,
  `harga` int(20) NOT NULL,
  `Tahun` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_mobil`
--

INSERT INTO `tbl_mobil` (`idMobil`, `namaMobil`, `idMerk`, `idType`, `harga`, `Tahun`) VALUES
('282b7d8d-bfeb-4eab-994f-1932b0d6f884', 'Honda Acura NSX', '315ebc5d-2ab2-4175-b692-bbd771f754d6', '9c91eac0-4ed1-436c-85be-c71a6201def3', 69000000, '2016'),
('cacc7969-7216-4333-a86e-506adc8eccee', 'Ferrari 812 Superfast', '315ebc5d-2ab2-4175-b692-bbd771f754d6', '242a61d3-98f2-4142-a9cb-6b938ede4da0', 900000000, '2020'),
('e9855edc-72b4-4150-8b96-b5a13d91e5fe', 'Lamborghini Aventador', '29f9ca3c-30c8-4412-86db-d62453037a55', '9c91eac0-4ed1-436c-85be-c71a6201def3', 79000000, '2021'),
('ec6d897a-96dd-45bf-af13-f23165a39cdb', 'Bugatti Chiron', 'aa49f29a-daaf-40de-ae47-da2778f61e8e', '5dee4bdf-f7e4-4a96-b3b6-90e995be354d', 870000000, '2018');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_type`
--

CREATE TABLE `tbl_type` (
  `idType` varchar(100) NOT NULL,
  `namaType` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_type`
--

INSERT INTO `tbl_type` (`idType`, `namaType`) VALUES
('00915be9-0612-4d5e-b5a5-9e2536e245b9', 'Mobil SUV'),
('242a61d3-98f2-4142-a9cb-6b938ede4da0', 'Mobil Coupe'),
('5dee4bdf-f7e4-4a96-b3b6-90e995be354d', 'Mobil Station Wagon'),
('6aa1b562-8556-4bad-b2ae-36193771dc9d', 'Mobil Hatchback'),
('9c91eac0-4ed1-436c-85be-c71a6201def3', 'Mobil Sedan'),
('a304dac5-4149-45f6-901f-0ebec934fafb', 'Mobil Double Cabin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indeks untuk tabel `tbl_customerdetail`
--
ALTER TABLE `tbl_customerdetail`
  ADD PRIMARY KEY (`idCustomerDetail`);

--
-- Indeks untuk tabel `tbl_merk`
--
ALTER TABLE `tbl_merk`
  ADD PRIMARY KEY (`idMerk`);

--
-- Indeks untuk tabel `tbl_mobil`
--
ALTER TABLE `tbl_mobil`
  ADD PRIMARY KEY (`idMobil`);

--
-- Indeks untuk tabel `tbl_type`
--
ALTER TABLE `tbl_type`
  ADD PRIMARY KEY (`idType`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
