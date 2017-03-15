-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 15 Mars 2017 à 09:31
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanque`
--

-- --------------------------------------------------------

--
-- Structure de la table `adviser`
--

CREATE TABLE `adviser` (
  `idadviser` int(11) NOT NULL,
  `idagence` varchar(11) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adviser`
--

INSERT INTO `adviser` (`idadviser`, `idagence`, `firstname`, `lastname`, `password`) VALUES
(1, '1', 'Jacques', 'Bonnafé', 'truc');

-- --------------------------------------------------------

--
-- Structure de la table `bankcard`
--

CREATE TABLE `bankcard` (
  `cardnumber` int(11) NOT NULL,
  `idcurrentaccount` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `cardpassword` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bankcard`
--

INSERT INTO `bankcard` (`cardnumber`, `idcurrentaccount`, `type`, `cardpassword`) VALUES
(1, 1, 'VISA', '1234'),
(2, 2, 'VISA', '1212'),
(3, 3, 'ELECTRON', '0007');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL,
  `idadviser` int(11) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `telnumber` varchar(12) NOT NULL,
  `zipcode` varchar(10) NOT NULL,
  `town` varchar(20) NOT NULL,
  `idcurrentaccount` int(11) DEFAULT NULL,
  `idsavingaccount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idclient`, `idadviser`, `firstname`, `lastname`, `address`, `telnumber`, `zipcode`, `town`, `idcurrentaccount`, `idsavingaccount`) VALUES
(1, 1, 'André', 'Dionne', '73 rue du gateau', '0142832678', '78400', 'Chatou', 1, 1001),
(2, 1, 'Arienne', 'Thibault', '71 rue du chateau', '0446374738', '42100', 'SAINT-ETIENNE', 2, 1002),
(3, 1, 'Daisi', 'Covillon', '37 avenue de l\'amandier', '0150720042', '93140', 'Bondy', 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `currentaccount`
--

CREATE TABLE `currentaccount` (
  `idcurrentaccount` int(11) NOT NULL,
  `sold` float NOT NULL,
  `opendate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `currentaccount`
--

INSERT INTO `currentaccount` (`idcurrentaccount`, `sold`, `opendate`) VALUES
(1, 5234.6, '18 juin 2000'),
(2, 523.78, '14 juillet 1789'),
(3, 24789.7, '30 février 2019');

-- --------------------------------------------------------

--
-- Structure de la table `savingaccount`
--

CREATE TABLE `savingaccount` (
  `idsavingaccount` int(11) NOT NULL,
  `sold` float NOT NULL,
  `opendate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `savingaccount`
--

INSERT INTO `savingaccount` (`idsavingaccount`, `sold`, `opendate`) VALUES
(1001, 4503.1, '22 juin 2000'),
(1002, 11111.1, '11 novembre 1111');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adviser`
--
ALTER TABLE `adviser`
  ADD PRIMARY KEY (`idadviser`);

--
-- Index pour la table `bankcard`
--
ALTER TABLE `bankcard`
  ADD PRIMARY KEY (`cardnumber`),
  ADD KEY `idcurrentaccount` (`idcurrentaccount`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idclient`),
  ADD KEY `idadviser` (`idadviser`),
  ADD KEY `idsavingaccount` (`idsavingaccount`),
  ADD KEY `idcurrentaccount` (`idcurrentaccount`);

--
-- Index pour la table `currentaccount`
--
ALTER TABLE `currentaccount`
  ADD PRIMARY KEY (`idcurrentaccount`);

--
-- Index pour la table `savingaccount`
--
ALTER TABLE `savingaccount`
  ADD PRIMARY KEY (`idsavingaccount`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `adviser`
--
ALTER TABLE `adviser`
  MODIFY `idadviser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `bankcard`
--
ALTER TABLE `bankcard`
  MODIFY `cardnumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `bankcard`
--
ALTER TABLE `bankcard`
  ADD CONSTRAINT `bankcard_ibfk_1` FOREIGN KEY (`idcurrentaccount`) REFERENCES `currentaccount` (`idcurrentaccount`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`idadviser`) REFERENCES `adviser` (`idadviser`),
  ADD CONSTRAINT `client_ibfk_2` FOREIGN KEY (`idsavingaccount`) REFERENCES `savingaccount` (`idsavingaccount`),
  ADD CONSTRAINT `client_ibfk_3` FOREIGN KEY (`idcurrentaccount`) REFERENCES `currentaccount` (`idcurrentaccount`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
