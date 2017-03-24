-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 24 Mars 2017 à 15:34
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_eni`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_ville` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`id`, `libelle`, `id_ville`) VALUES
(1, '48, route de Lacroix Falgarde', 3);

-- --------------------------------------------------------

--
-- Structure de la table `langue`
--

CREATE TABLE `langue` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `langue`
--

INSERT INTO `langue` (`id`, `nom`) VALUES
(1, 'Français'),
(2, 'Anglais');

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `monnaie` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `population` bigint(20) NOT NULL,
  `continent` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id`, `monnaie`, `nom`, `population`, `continent`) VALUES
(1, 'euro', 'France', 66000000, 'Europe');

-- --------------------------------------------------------

--
-- Structure de la table `pays_langue`
--

CREATE TABLE `pays_langue` (
  `id_langue` int(11) NOT NULL,
  `id_pays` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pays_langue`
--

INSERT INTO `pays_langue` (`id_langue`, `id_pays`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `date_naissance` date NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `date_naissance`, `nom`, `prenom`) VALUES
(1, '1985-07-14', 'Duvinage', 'Gaël'),
(2, '1985-04-12', 'Duvinage', 'Christelle');

-- --------------------------------------------------------

--
-- Structure de la table `personne_adresse`
--

CREATE TABLE `personne_adresse` (
  `id_adresse` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date DEFAULT NULL,
  `principale` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne_adresse`
--

INSERT INTO `personne_adresse` (`id_adresse`, `id_personne`, `debut`, `fin`, `principale`) VALUES
(1, 1, '2016-09-01', NULL, b'1'),
(1, 2, '2016-09-01', NULL, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `personne_detail`
--

CREATE TABLE `personne_detail` (
  `num_secu` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne_detail`
--

INSERT INTO `personne_detail` (`num_secu`, `sexe`, `id`, `id_personne`) VALUES
('185078619415516', 'Homme', 1, 1),
('285043119415516', 'Femme', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `telephone`
--

CREATE TABLE `telephone` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `telephone`
--

INSERT INTO `telephone` (`id`, `libelle`, `numero`, `id_personne`) VALUES
(1, 'Portable', '0616936490', 1),
(2, 'Portable', '0788224642', 2),
(3, 'Bureau', '1352', 1);

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `id` int(11) NOT NULL,
  `capital` bit(1) NOT NULL,
  `code_postal` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `id_pays` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ville`
--

INSERT INTO `ville` (`id`, `capital`, `code_postal`, `nom`, `id_pays`) VALUES
(1, b'1', '75000', 'Paris', 1),
(2, b'0', '31000', 'Toulouse', 1),
(3, b'0', '31120', 'Pinsaguel', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_adresse_ville_id` (`id_ville`);

--
-- Index pour la table `langue`
--
ALTER TABLE `langue`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pays_langue`
--
ALTER TABLE `pays_langue`
  ADD KEY `fk_pays_langue_pays_id` (`id_pays`),
  ADD KEY `fk_pays_langue_langue_id` (`id_langue`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nom` (`nom`,`prenom`);

--
-- Index pour la table `personne_adresse`
--
ALTER TABLE `personne_adresse`
  ADD KEY `fk_personne_adresse_personne_id` (`id_personne`),
  ADD KEY `fk_personne_adresse_adresse_id` (`id_adresse`);

--
-- Index pour la table `personne_detail`
--
ALTER TABLE `personne_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_personne_detail_personne_id` (`id_personne`);

--
-- Index pour la table `telephone`
--
ALTER TABLE `telephone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_telephone_personne_id` (`id_personne`) USING BTREE;

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD KEY `fk_ville_pays_id` (`id_pays`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
