-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2016 at 03:55 AM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_amicoz`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `Comment_Id` int(11) NOT NULL,
  `Post_Id` int(11) NOT NULL,
  `User_Id` varchar(100) DEFAULT NULL,
  `Comment_Text` varchar(255) DEFAULT NULL,
  `Like_Count` int(11) DEFAULT NULL,
  `Dislike_Count` int(11) DEFAULT NULL,
  `Created_Date` datetime NOT NULL,
  `Created_By` varchar(100) NOT NULL,
  `Last_Updated_Date` datetime NOT NULL,
  `Last_Updated_By` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Comment_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `Sender_Id` int(11) NOT NULL,
  `Receiver_Id` int(11) NOT NULL,
  `Created_Date` datetime NOT NULL,
  `Created_By` varchar(100) NOT NULL,
  `Last_Updated_Date` datetime NOT NULL,
  `Last_Updated_By` varchar(100) NOT NULL,
  `Blocked` varchar(1) NOT NULL,
  PRIMARY KEY (`Sender_Id`,`Receiver_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`Sender_Id`, `Receiver_Id`, `Created_Date`, `Created_By`, `Last_Updated_Date`, `Last_Updated_By`, `Blocked`) VALUES
(2, 1, '2016-04-25 04:47:24', '1', '2016-04-25 04:47:24', '1', 'N'),
(16, 2, '2016-04-25 05:58:26', '1', '2016-04-25 05:58:26', '1', 'N'),
(18, 1, '2016-04-25 19:13:37', '1', '2016-04-25 19:13:37', '1', 'Y'),
(18, 17, '2016-04-25 14:39:02', '1', '2016-04-25 14:39:02', '1', 'Y'),
(19, 1, '2016-04-25 21:10:47', '1', '2016-04-25 21:10:47', '1', 'N'),
(20, 1, '2016-04-25 21:59:40', '1', '2016-04-25 21:59:40', '1', 'N');

-- --------------------------------------------------------

--
-- Table structure for table `friend_request`
--

DROP TABLE IF EXISTS `friend_request`;
CREATE TABLE IF NOT EXISTS `friend_request` (
  `Receiver_Id` int(11) NOT NULL,
  `Sender_Id` int(11) NOT NULL,
  `Created_By` varchar(255) NOT NULL,
  `Created_Date` datetime NOT NULL,
  `Last_Updated_By` varchar(255) NOT NULL,
  `Last_Updated_Date` datetime NOT NULL,
  PRIMARY KEY (`Receiver_Id`,`Sender_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friend_request`
--

INSERT INTO `friend_request` (`Receiver_Id`, `Sender_Id`, `Created_By`, `Created_Date`, `Last_Updated_By`, `Last_Updated_Date`) VALUES
(1, 16, '16', '2016-04-25 12:52:54', '16', '2016-04-25 12:52:54'),
(2, 18, '18', '2016-04-25 14:09:16', '18', '2016-04-25 14:09:16'),
(2, 20, '20', '2016-04-25 22:00:49', '20', '2016-04-25 22:00:49'),
(17, 19, '19', '2016-04-25 19:20:52', '19', '2016-04-25 19:20:52');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `Group_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Admin_User_Id` int(11) NOT NULL,
  `Group_Name` varchar(255) NOT NULL,
  `Is_Chat_Group` char(2) DEFAULT NULL,
  `User_Limit` int(11) DEFAULT NULL,
  `Group_Members` varchar(255) DEFAULT '',
  `Created_By` varchar(255) DEFAULT NULL,
  `Creation_Date` date DEFAULT NULL,
  `Last_Updated_By` varchar(255) DEFAULT NULL,
  `Last_Update_Date` date DEFAULT NULL,
  `Is_Deleted` char(1) DEFAULT NULL,
  `Group_Description` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`Group_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=671 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`Group_Id`, `Admin_User_Id`, `Group_Name`, `Is_Chat_Group`, `User_Limit`, `Group_Members`, `Created_By`, `Creation_Date`, `Last_Updated_By`, `Last_Update_Date`, `Is_Deleted`, `Group_Description`) VALUES
(565, 1, 'Software Engineering', 'N', 20, '1, 2', '1', '2016-04-23', '1', '2016-04-23', 'N', NULL),
(649, 1, 'Cloud Computing', 'N', 10, NULL, '1', '2016-04-23', '1', '2016-04-23', 'N', NULL),
(650, 1, 'My group1', '0', 0, '2, 1', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'My group!!!!'),
(651, 1, 'My group', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'My group created'),
(652, 1, 'My group!!!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'My se group'),
(653, 1, 'My group!!!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'My first group'),
(654, 1, 'My group!!!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'This is my group!!!'),
(655, 1, 'My group!!!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'This is my group!!!'),
(656, 1, 'my amicozzz group', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'this is my group'),
(657, 1, 'My amicoz group!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'This is my group'),
(658, 1, 'My amicoz group!!!', '0', 0, '2, 17', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'Teja''s group!!!'),
(659, 1, 'New Group', '0', 0, '2, 18', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'This is my first group.'),
(660, 1, 'Indiana University Fall 2015', '0', 0, '2, 19, 18', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', ''),
(661, 1, 'Indiana University Fall 2015', '0', 0, '2, 19', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', ''),
(662, 1, 'Indiana University Fall 2015', '0', 0, '2', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', ''),
(663, 1, 'Indiana University Fall 2015', '0', 0, '2', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', ''),
(664, 1, 'daasfawafa', '0', 0, '2, 2', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'sefewfewf'),
(665, 1, 'daasfawafa', '0', 0, '1', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'sefewfewf'),
(666, 1, 'daasfawafa', '0', 0, '18', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'sefewfewf'),
(667, 1, 'daasfawafa', '0', 0, '2, 19, 18', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'sefewfewf'),
(668, 1, 'dikhata hun group', '0', 0, '2, 1', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'asafafnasjkfnasjkfnafsj'),
(669, 1, 'final grop teat', '0', 0, '2, 19', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', 'knfkaf af'),
(670, 1, 'New one', '0', 0, '20, 18', 'ADMIN', '2016-04-25', 'ADMIN', '2016-04-25', 'N', '');

-- --------------------------------------------------------

--
-- Table structure for table `groups_chat`
--

DROP TABLE IF EXISTS `groups_chat`;
CREATE TABLE IF NOT EXISTS `groups_chat` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  UNIQUE KEY `gid_UNIQUE` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups_chat`
--

INSERT INTO `groups_chat` (`gid`, `gname`) VALUES
(1, 'mumbai indians'),
(2, 'rising pune'),
(3, 'delhi daredevils'),
(4, 'sunrisers hyderabad'),
(5, 'gujrat lions'),
(6, 'kahihi dila');

-- --------------------------------------------------------

--
-- Table structure for table `groups_users_mapper`
--

DROP TABLE IF EXISTS `groups_users_mapper`;
CREATE TABLE IF NOT EXISTS `groups_users_mapper` (
  `gid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups_users_mapper`
--

INSERT INTO `groups_users_mapper` (`gid`, `uid`) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 6),
(2, 4),
(2, 2),
(3, 1),
(3, 3),
(3, 4),
(4, 5),
(4, 6),
(4, 2),
(5, 2),
(5, 6),
(5, 3),
(6, 6),
(6, 7),
(6, 8);

-- --------------------------------------------------------

--
-- Table structure for table `group_messages`
--

DROP TABLE IF EXISTS `group_messages`;
CREATE TABLE IF NOT EXISTS `group_messages` (
  `gmid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `message` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`gmid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_messages`
--

INSERT INTO `group_messages` (`gmid`, `gid`, `uid`, `message`) VALUES
(1, 1, 2, 'mumbai win'),
(2, 3, 1, 'enjoying the ipl'),
(3, 6, 3, 'not enjoying ipl'),
(4, 1, 3, 'yessssssss'),
(5, 1, 1, 'man of the math rohit sharma'),
(6, 1, 1, 'pandya played well too'),
(7, 1, 3, 'bad day for bumrah'),
(8, 1, 1, 'jaga kaha hai'),
(9, 1, 1, 'pandya played well too2'),
(10, 1, 2, 'foreign key kadhun taak');

-- --------------------------------------------------------

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
CREATE TABLE IF NOT EXISTS `likes` (
  `Liked_Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Created_By` varchar(255) NOT NULL,
  `Created_Date` datetime NOT NULL,
  `Last_Updated_By` varchar(255) NOT NULL,
  `Last_Updated_Date` datetime NOT NULL,
  `Like_On` varchar(255) DEFAULT NULL,
  `Like_Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Liked_Id`,`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `fromid` int(11) DEFAULT NULL,
  `toid` int(11) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `timestamp` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`mid`, `fromid`, `toid`, `message`, `timestamp`) VALUES
(20, 1, 2, 'akshbdhkasbdas', '2016-04-25 20:40:12'),
(21, 2, 1, 'khhdbasd', '2016-04-25 20:41:35'),
(22, 2, 1, 'ladsadsjasdads', '2016-04-25 21:07:08'),
(23, 1, 2, '', '2016-04-25 21:07:19'),
(24, 2, 1, 'jdlnjadads', '2016-04-25 21:07:29'),
(25, 1, 2, 'ljdaa,sdbjads', '2016-04-25 21:07:33'),
(26, 20, 1, 'Hello Anand', '2016-04-25 21:59:53'),
(27, 1, 20, 'Hi Munir', '2016-04-25 22:00:07');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `Post_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Comment_Count` int(11) DEFAULT NULL,
  `Created_By` varchar(255) NOT NULL,
  `Created_Date` datetime NOT NULL,
  `Dislike_Count` int(11) DEFAULT NULL,
  `Last_Updated_By` varchar(255) NOT NULL,
  `Last_Updated_Date` datetime NOT NULL,
  `Like_Count` int(11) DEFAULT NULL,
  `Post_Text` varchar(255) DEFAULT NULL,
  `Post_Visibility` varchar(255) NOT NULL,
  `User_Id` int(11) DEFAULT NULL,
  `Group_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Post_Id`),
  KEY `Post_FK1` (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`Post_Id`, `Comment_Count`, `Created_By`, `Created_Date`, `Dislike_Count`, `Last_Updated_By`, `Last_Updated_Date`, `Like_Count`, `Post_Text`, `Post_Visibility`, `User_Id`, `Group_Id`) VALUES
(1, 0, 'ADMIN', '2016-04-23 21:27:17', 0, 'ADMIN', '2016-04-23 21:27:38', 0, 'I like this post', 'Y', 1, 2),
(2, 0, 'ADMIN', '2016-04-23 21:29:37', 0, 'ADMIN', '2016-04-23 21:29:52', 0, 'I am feeling awesome today', 'Y', 2, 1),
(3, 0, 'ADMIN', '2016-04-23 21:27:17', 0, 'ADMIN', '2016-04-23 21:27:38', 0, 'I like this post', 'Y', 1, NULL),
(4, 0, 'ADMIN', '2016-04-23 21:29:37', 0, 'ADMIN', '2016-04-23 21:29:52', 0, 'I am feeling awesome today', 'Y', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Primary_Email_Id` varchar(60) NOT NULL,
  `Secondary_Email_Id` varchar(100) DEFAULT NULL,
  `Password` varchar(50) NOT NULL,
  `Secret_Question_Id` varchar(50) DEFAULT NULL,
  `Answer` varchar(50) DEFAULT NULL,
  `Created_By` varchar(50) DEFAULT NULL,
  `Creation_Date` date DEFAULT NULL,
  `Last_Updated_By` varchar(50) DEFAULT NULL,
  `Last_Update_Date` date DEFAULT NULL,
  `Recovery_Bit` int(11) DEFAULT '0',
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_Id`, `Primary_Email_Id`, `Secondary_Email_Id`, `Password`, `Secret_Question_Id`, `Answer`, `Created_By`, `Creation_Date`, `Last_Updated_By`, `Last_Update_Date`, `Recovery_Bit`) VALUES
(1, 'anandk10@gmail.com', 'anandk10@yahoo.com', '81dc9bdb52d04dc20036dbd8313ed055', 'What was your first pet''s name?', 'answer', 'Admin', '2016-04-23', 'Admin', '2016-04-23', 0),
(2, 'ingale.rohan@ymail.com', 'ringale@indiana.edu', '81dc9bdb52d04dc20036dbd8313ed055', 'What was the first street you lived on as a child?', 'answer', 'Admin', '2016-04-23', 'Admin', '2016-04-23', 0),
(16, 'anandk101992@gmail.com', '', '81dc9bdb52d04dc20036dbd8313ed055', 'What is your mother''s maiden name?', 'answer', 'Admin', '2016-04-25', 'Admin', '2016-04-25', 0),
(17, 'me@tejaskumthekar.com', 'tejaskumthekar26@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 'What is your mother''s maiden name?', 'answer', 'Admin', '2016-04-25', 'Admin', '2016-04-25', 0),
(18, 'girish_g10@yahoo.com', 'ggabra@indiana.edu', '81dc9bdb52d04dc20036dbd8313ed055', 'What is your mother''s maiden name?', 'answer', 'Admin', '2016-04-25', 'Admin', '2016-04-25', 0),
(19, 'rutuja.kulkarni24@gmail.com', '', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'What was the first street you lived on as a child?', 'abc', 'Admin', '2016-04-25', 'Admin', '2016-04-25', 0),
(20, 'safim@indiana.edu', '', '7f5caa74260ac9a97131e6a41e72c6eb', 'What was the first street you lived on as a child?', 'Lincoln Trail', 'Admin', '2016-04-25', 'Admin', '2016-04-25', 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `uid` int(11) NOT NULL,
  `uname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `uname`) VALUES
(1, 'tk'),
(2, 'ri'),
(3, 'ak'),
(4, 'gg'),
(5, 'sm'),
(6, 'ss'),
(7, 'dp'),
(8, 'ab');

-- --------------------------------------------------------

--
-- Table structure for table `user_groups`
--

DROP TABLE IF EXISTS `user_groups`;
CREATE TABLE IF NOT EXISTS `user_groups` (
  `User_Id` int(11) NOT NULL,
  `Group_Id` int(11) NOT NULL,
  `Created_By` varchar(255) NOT NULL,
  `Created_Date` datetime NOT NULL,
  `Last_Updated_By` varchar(255) NOT NULL,
  `Updated_Date` datetime NOT NULL,
  PRIMARY KEY (`User_Id`,`Group_Id`),
  KEY `User_groups_Fk1` (`Group_Id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `user_groups`
--

INSERT INTO `user_groups` (`User_Id`, `Group_Id`, `Created_By`, `Created_Date`, `Last_Updated_By`, `Updated_Date`) VALUES
(1, 565, '1', '2016-04-23 21:47:44', '1', '2016-04-23 21:47:44'),
(1, 649, '1', '2016-04-24 17:57:11', '1', '2016-04-24 17:57:11'),
(1, 665, 'ADMIN', '2016-04-25 21:42:13', 'ADMIN', '2016-04-25 21:42:13'),
(1, 668, 'ADMIN', '2016-04-25 21:44:31', 'ADMIN', '2016-04-25 21:44:31'),
(2, 649, '2', '2016-04-23 22:57:07', '2', '2016-04-23 22:57:07'),
(2, 660, 'ADMIN', '2016-04-25 21:30:58', 'ADMIN', '2016-04-25 21:30:58'),
(2, 661, 'ADMIN', '2016-04-25 21:32:09', 'ADMIN', '2016-04-25 21:32:09'),
(2, 662, 'ADMIN', '2016-04-25 21:33:14', 'ADMIN', '2016-04-25 21:33:14'),
(2, 663, 'ADMIN', '2016-04-25 21:33:47', 'ADMIN', '2016-04-25 21:33:47'),
(2, 664, 'ADMIN', '2016-04-25 21:41:53', 'ADMIN', '2016-04-25 21:41:53'),
(2, 667, 'ADMIN', '2016-04-25 21:43:14', 'ADMIN', '2016-04-25 21:43:14'),
(2, 668, 'ADMIN', '2016-04-25 21:44:31', 'ADMIN', '2016-04-25 21:44:31'),
(2, 669, 'ADMIN', '2016-04-25 21:52:00', 'ADMIN', '2016-04-25 21:52:00'),
(18, 660, 'ADMIN', '2016-04-25 21:30:58', 'ADMIN', '2016-04-25 21:30:58'),
(18, 666, 'ADMIN', '2016-04-25 21:42:38', 'ADMIN', '2016-04-25 21:42:38'),
(18, 667, 'ADMIN', '2016-04-25 21:43:15', 'ADMIN', '2016-04-25 21:43:15'),
(18, 670, 'ADMIN', '2016-04-25 22:12:36', 'ADMIN', '2016-04-25 22:12:36'),
(19, 660, 'ADMIN', '2016-04-25 21:30:58', 'ADMIN', '2016-04-25 21:30:58'),
(19, 661, 'ADMIN', '2016-04-25 21:32:09', 'ADMIN', '2016-04-25 21:32:09'),
(19, 667, 'ADMIN', '2016-04-25 21:43:14', 'ADMIN', '2016-04-25 21:43:14'),
(19, 669, 'ADMIN', '2016-04-25 21:52:00', 'ADMIN', '2016-04-25 21:52:00'),
(20, 670, 'ADMIN', '2016-04-25 22:12:36', 'ADMIN', '2016-04-25 22:12:36');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `User_Id` int(11) NOT NULL,
  `FIRST_NAME` varchar(100) DEFAULT NULL,
  `LAST_NAME` varchar(100) DEFAULT NULL,
  `Contact_Number` varchar(15) DEFAULT '000-000-0000',
  `Date_Of_Birth` date DEFAULT NULL,
  `Bio` varchar(160) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `ProfilePic_URL` varchar(100) DEFAULT 'profilePics/default.jpg',
  `City` varchar(100) DEFAULT NULL,
  `State` varchar(100) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `School` varchar(100) DEFAULT NULL,
  `Profile_Visibility` char(1) DEFAULT 'Y',
  `Created_By` varchar(100) DEFAULT 'ADMIN',
  `Created_Date` date DEFAULT NULL,
  `Last_Updated_By` varchar(100) DEFAULT 'ADMIN',
  `Last_Updated_Date` date DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`User_Id`, `FIRST_NAME`, `LAST_NAME`, `Contact_Number`, `Date_Of_Birth`, `Bio`, `Gender`, `ProfilePic_URL`, `City`, `State`, `Country`, `School`, `Profile_Visibility`, `Created_By`, `Created_Date`, `Last_Updated_By`, `Last_Updated_Date`) VALUES
(1, 'Anand', 'Karandikar', '', '2002-04-02', 'Hi, this is Anand Karandikar.', 'male', 'profilePics/1461573208i4l6ir522d9n8txqafffbt9z194scczhi7pjiadhul6e69n6t0.jpg', 'bombay', 'IN', 'US', 'IUBloomington', 'F', 'ADMIN', NULL, 'ADMIN', NULL),
(2, 'Rohan', 'Ingale', '123-456-7890', NULL, '', 'female', 'profilePics/14615782874e69n6t0xdfosjrem0am5afl0j9fitg3t94cwo3dhreyo3ghca.jpg', 'mumbai', '', '', '', 'Y', 'ADMIN', NULL, 'ADMIN', NULL),
(16, 'Anand', 'Karandikar', '000-000-0000', NULL, NULL, NULL, 'profilePics/1461578615a2socn5d9dcayydm4mjgaj141t8v7nl2tjnx7auokl687xl3z9.jpg', 'Bangalore', NULL, NULL, NULL, 'Y', 'ADMIN', NULL, 'ADMIN', NULL),
(17, 'Tejas', 'Kumthekar', '812-258-6985', NULL, '', 'female', 'profilePics/1461598658nfe5vxbl612orqw9itdhjp086arl19mf0zoorcyoyo42bbz5x3.jpg', 'Mumbai', '', '', '', 'F', 'ADMIN', NULL, 'ADMIN', NULL),
(18, 'Girish', 'Gabra', '', NULL, '', 'male', 'profilePics/default.jpg', 'Mumbai', '', '', '', 'Y', 'ADMIN', NULL, 'ADMIN', NULL),
(19, 'Rutuja', 'Kulkarni', '000-000-0000', NULL, NULL, NULL, 'profilePics/1461626411e47jpd159xsr8y47w1ovq45fyt7ibktuuwyimzaxgwi5ohu70n.jpg', NULL, NULL, NULL, NULL, 'Y', 'ADMIN', NULL, 'ADMIN', NULL),
(20, 'Munir', 'Safi', '000-000-0000', NULL, NULL, NULL, 'profilePics/default.jpg', NULL, NULL, NULL, NULL, 'Y', 'ADMIN', NULL, 'ADMIN', NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `user_search_v`
--
DROP VIEW IF EXISTS `user_search_v`;
CREATE TABLE IF NOT EXISTS `user_search_v` (
`user_id` int(11)
,`Primary_Email_Id` varchar(60)
,`Full_Name` varchar(201)
,`City` varchar(100)
,`FIRST_NAME` varchar(100)
,`LAST_NAME` varchar(100)
,`ProfilePic_URL` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `user_search_v`
--
DROP TABLE IF EXISTS `user_search_v`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_search_v`  AS  (select `a`.`User_Id` AS `user_id`,`a`.`Primary_Email_Id` AS `Primary_Email_Id`,concat(`b`.`FIRST_NAME`,' ',`b`.`LAST_NAME`) AS `Full_Name`,`b`.`City` AS `City`,`b`.`FIRST_NAME` AS `FIRST_NAME`,`b`.`LAST_NAME` AS `LAST_NAME`,`b`.`ProfilePic_URL` AS `ProfilePic_URL` from (`user` `a` join `user_info` `b`) where (`a`.`User_Id` = `b`.`User_Id`)) ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `Post_FK1` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_groups`
--
ALTER TABLE `user_groups`
  ADD CONSTRAINT `user_groups_fk1` FOREIGN KEY (`Group_Id`) REFERENCES `groups` (`Group_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
