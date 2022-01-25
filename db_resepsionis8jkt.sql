-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Agu 2021 pada 11.30
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_resepsionis8jkt`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `guru`
--

CREATE TABLE `guru` (
  `nip` varchar(16) NOT NULL,
  `nm_guru` varchar(50) NOT NULL,
  `jk_guru` varchar(10) NOT NULL,
  `telp_guru` varchar(12) NOT NULL,
  `almt_guru` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `guru`
--

INSERT INTO `guru` (`nip`, `nm_guru`, `jk_guru`, `telp_guru`, `almt_guru`) VALUES
('2005083055', 'Juwita Herawan', 'Perempuan', '081274829212', 'Depok'),
('2012091011', 'Deni Caknan', 'Laki-Laki', '081247278912', 'Jagakarsa'),
('2014892212', 'Deswita Permata Ayu', 'Perempuan', '089652189153', 'Menteng'),
('2018771299', 'Sri Rumanasari', 'Perempuan', '087891829912', 'Menteng'),
('2019882211', 'Yudi Triagung', 'Laki-Laki', '085829105588', 'Lenteng Agung'),
('2021042911', 'Tejo Puroto', 'Laki-Laki', '085721218899', 'Depok');

-- --------------------------------------------------------

--
-- Struktur dari tabel `izinkeluarguru`
--

CREATE TABLE `izinkeluarguru` (
  `noizinguru` varchar(20) NOT NULL,
  `nip` varchar(16) NOT NULL,
  `nm_guru` varchar(50) NOT NULL,
  `jk_guru` varchar(10) NOT NULL,
  `telp_guru` varchar(12) NOT NULL,
  `alasan_guru` varchar(50) NOT NULL,
  `tglizin_guru` varchar(50) NOT NULL,
  `jamizin_guru` varchar(50) NOT NULL,
  `jamkem_guru` varchar(50) NOT NULL,
  `ket_guru` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `izinkeluarguru`
--

INSERT INTO `izinkeluarguru` (`noizinguru`, `nip`, `nm_guru`, `jk_guru`, `telp_guru`, `alasan_guru`, `tglizin_guru`, `jamizin_guru`, `jamkem_guru`, `ket_guru`) VALUES
('IZINGURU0001', '2012091011', 'Deni Caknan', 'Laki-Laki', '081247278912', 'LOMBA', '17-08-2021', 'JAM KE 2 (07:30 - 08:15)', 'JAM KE 10 (14:20 - 15:05)', 'Lomba Nyanyi '),
('IZINGURU0002', '2005083055', 'Juwita Herawan', 'Perempuan', '081274829212', 'SAKIT', '19-08-2021', 'JAM KE 5 (10:05 - 10:50)', 'JAM KE 10 (14:20 - 15:05)', 'harus kerumah sakit'),
('IZINGURU0003', '2019882211', 'Yudi Triagung', 'Laki-Laki', '085829105588', 'URUSAN PRIBADI/KELUARGA', '20-08-2021', 'JAM KE 9 (13:35 - 14:20)', 'JAM KE 10 (14:20 - 15:05)', 'Antar anak ke bandara'),
('IZINGURU0004', '2018771299', 'Sri Rumanasari', 'Perempuan', '087891829912', 'DINAS', '23-08-2021', 'JAM KE 2 (07:30 - 08:15)', 'JAM KE 6 (10:50 - 11:35)', 'Ke MGMP Bahasa Indonesia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `izinkeluarpesdik`
--

CREATE TABLE `izinkeluarpesdik` (
  `noizinpesdik` varchar(20) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `nm_pesdik` varchar(50) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `jk_pesdik` varchar(10) NOT NULL,
  `telp_pesdik` varchar(12) NOT NULL,
  `alasan_pesdik` varchar(50) NOT NULL,
  `tglizin_pesdik` varchar(50) NOT NULL,
  `jamizin_pesdik` varchar(50) NOT NULL,
  `jamkem_pesdik` varchar(50) NOT NULL,
  `ket_pesdik` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `izinkeluarpesdik`
--

INSERT INTO `izinkeluarpesdik` (`noizinpesdik`, `nis`, `nm_pesdik`, `kelas`, `jk_pesdik`, `telp_pesdik`, `alasan_pesdik`, `tglizin_pesdik`, `jamizin_pesdik`, `jamkem_pesdik`, `ket_pesdik`) VALUES
('IZINPESDIK0001', '20150802', 'Akbar Nur Hidayanto', 'XII-AP 1', 'Laki-Laki', '081248241823', 'LOMBA', '16-08-2021', 'JAM KE 4 (09:00 - 09:45)', 'JAM KE 8 (12:50 - 13:35)', 'Lomba di SMKN 47 Jakarta'),
('IZINPESDIK0002', '20120704', 'Hendra Sistanto', 'XI-AKL 3', 'Laki-Laki', '087823471254', 'TEKNIKAL MEETING', '18-08-2021', 'JAM KE 2 (07:30 - 08:15)', 'ISTIRAHAT 2 (12:20 - 12 :50)', 'Persiapan lomba puisi'),
('IZINPESDIK0003', '20210809', 'Bayu Adi Praja', 'X-UPW 2', 'Laki-Laki', '085672126678', 'SAKIT', '18-08-2021', 'JAM KE 1 (06:45 - 07:30)', 'JAM KE 4 (09:00 - 09:45)', 'Ke UKS Demam'),
('IZINPESDIK0004', '20180507', 'Novita Resmana', 'X-BDP 3', 'Perempuan', '081256893345', 'LATIHAN PRA LOMBA', '19-08-2021', 'JAM KE 8 (12:50 - 13:35)', 'JAM KE 10 (14:20 - 15:05)', 'Ke Lab Sastra latihan'),
('IZINPESDIK0005', '20207821', 'Yunita Maharani', 'XII-OTKP 3', 'Perempuan', '083728191211', 'DINAS', '21-08-2021', 'JAM KE 2 (07:30 - 08:15)', 'JAM KE 9 (13:35 - 14:20)', 'Ada acara seminar di kemendikbud'),
('IZINPESDIK0006', '20170577', 'Reni Tri Wulandari', 'XI-BDP 2', 'Perempuan', '085678124448', 'SAKIT', '23-08-2021', 'JAM KE 8 (12:50 - 13:35)', 'JAM KE 10 (14:20 - 15:05)', 'Pusing'),
('IZINPESDIK0007', '20150802', 'Akbar Nur Hidayanto', 'XII-OTKP 1', 'Laki-Laki', '081248241823', 'SAKIT', '24-08-2021', 'JAM KE 3 (08:15 - 09:00)', 'JAM KE 7 (11:35 - 12:20)', 'Ke Uks karna demam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kunjungan`
--

CREATE TABLE `kunjungan` (
  `novisit` varchar(10) NOT NULL,
  `nik` varchar(16) NOT NULL,
  `nm_tamu` varchar(50) NOT NULL,
  `jk_tamu` varchar(10) NOT NULL,
  `keperluan` varchar(50) NOT NULL,
  `tgldtg` varchar(50) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kunjungan`
--

INSERT INTO `kunjungan` (`novisit`, `nik`, `nm_tamu`, `jk_tamu`, `keperluan`, `tgldtg`, `keterangan`) VALUES
('VISIT80001', '3174040602950002', 'Surandi', 'Laki-Laki', 'Janji Temu', '15-08-2021', 'Dengan Ibu Kokom Humas'),
('VISIT80002', '3174040906870005', 'Tia Harjani', 'Perempuan', 'Seminar/Event/Meeting', '15-08-2021', 'Acara Semteknologi 8'),
('VISIT80003', '3174041203900004', 'Hilda Dewata', 'Perempuan', 'Antar Barang', '16-08-2021', 'Antar Buku Matematika'),
('VISIT80004', '3174040602950002', 'Surandi', 'Laki-Laki', 'Janji Temu', '17-08-2021', 'Kepala Sekolah'),
('VISIT80005', '3175030709880001', 'Natalia', 'Perempuan', 'Antar Barang', '18-08-2021', 'Makan Siang buat Ayu'),
('VISIT80006', '3174040709900003', 'Herry Tiago', 'Laki-Laki', 'Eskul Trainer', '18-08-2021', 'Melatih Eksul Silat'),
('VISIT80007', '3174040612960003', 'Moh. Syakhir', 'Laki-Laki', 'Seminar/Event/Meeting', '19-08-2021', 'Acara Kewirausahaan'),
('VISIT80008', '3173030510870009', 'Syifa Sarjono', 'Perempuan', 'Janji Temu', '20-08-2021', 'Dengan Ibu Dewi'),
('VISIT80009', '3174040912870002', 'Martin Braitwaite', 'Laki-Laki', 'Lainnya', '20-08-2021', 'Ada Penelitian '),
('VISIT80010', '3175030709880001', 'Natalia', 'Perempuan', 'Janji Temu', '21-08-2021', 'Wakil Kepala Sekolah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesdik`
--

CREATE TABLE `pesdik` (
  `nis` varchar(10) NOT NULL,
  `nm_pesdik` varchar(50) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `jk_pesdik` varchar(10) NOT NULL,
  `telp_pesdik` varchar(12) NOT NULL,
  `almt_pesdik` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesdik`
--

INSERT INTO `pesdik` (`nis`, `nm_pesdik`, `kelas`, `jk_pesdik`, `telp_pesdik`, `almt_pesdik`) VALUES
('20120704', 'Hendra Sistanto', 'XI-AKL 3', 'Laki-Laki', '087823471254', 'Pasar Minggu'),
('20150802', 'Akbar Nur Hidayanto', 'XII-OTKP 1', 'Laki-Laki', '081248241823', 'Ragunan'),
('20160809', 'Galuh Renata', 'XI-AKL 3', 'Perempuan', '085678901234', 'Citayam'),
('20170577', 'Reni Tri Wulandari', 'XI-BDP 2', 'Perempuan', '085678124448', 'Ragunan'),
('20180507', 'Novita Resmana', 'X-BDP 3', 'Perempuan', '081256893345', 'Lenteng Agung'),
('20180892', 'Andreas Gustavo', 'XI-BDP 2', 'Laki-Laki', '081274845577', 'Depok'),
('20190609', 'Shela Yunita', 'X-UPW 2', 'Perempuan', '081247889012', 'Kemang'),
('20207821', 'Yunita Maharani', 'XII-OTKP 3', 'Perempuan', '083728191211', 'Mampang'),
('20210809', 'Bayu Adi Praja', 'X-UPW 2', 'Laki-Laki', '085672126678', 'Lenteng Agung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tamu`
--

CREATE TABLE `tamu` (
  `nik` varchar(16) NOT NULL,
  `nm_tamu` varchar(50) NOT NULL,
  `jk_tamu` varchar(10) NOT NULL,
  `telp_tamu` varchar(12) NOT NULL,
  `almt_tamu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tamu`
--

INSERT INTO `tamu` (`nik`, `nm_tamu`, `jk_tamu`, `telp_tamu`, `almt_tamu`) VALUES
('3173030510870009', 'Syifa Sarjono', 'Perempuan', '087890108899', 'Lenteng Agung'),
('3174040602950002', 'Surandi', 'Laki-Laki', '081267521876', 'Kebayoran Baru'),
('3174040612960003', 'Moh. Syakhir', 'Laki-Laki', '085678903465', 'Kebayoran Baru'),
('3174040709900003', 'Herry Tiago', 'Laki-Laki', '083898210787', 'Pasar Minggu'),
('3174040906870005', 'Tia Harjani', 'Perempuan', '085678926534', 'Pasar Minggu'),
('3174040912870002', 'Martin Braitwaite', 'Laki-Laki', '085789210122', 'Lenteng Agung'),
('3174041203900004', 'Hilda Dewata', 'Perempuan', '083874246755', 'Manggarai'),
('3175030709880001', 'Natalia', 'Perempuan', '081256789991', 'Manggarai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `izinkeluarguru`
--
ALTER TABLE `izinkeluarguru`
  ADD PRIMARY KEY (`noizinguru`);

--
-- Indeks untuk tabel `izinkeluarpesdik`
--
ALTER TABLE `izinkeluarpesdik`
  ADD PRIMARY KEY (`noizinpesdik`);

--
-- Indeks untuk tabel `kunjungan`
--
ALTER TABLE `kunjungan`
  ADD PRIMARY KEY (`novisit`);

--
-- Indeks untuk tabel `pesdik`
--
ALTER TABLE `pesdik`
  ADD PRIMARY KEY (`nis`);

--
-- Indeks untuk tabel `tamu`
--
ALTER TABLE `tamu`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
