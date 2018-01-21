/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : jinseblog

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-01-21 21:53:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(8) NOT NULL auto_increment,
  `blog_id` int(8) default NULL,
  `content` varchar(2000) default NULL,
  PRIMARY KEY  (`article_id`),
  KEY `FK_Reference_8` (`blog_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `avatar`
-- ----------------------------
DROP TABLE IF EXISTS `avatar`;
CREATE TABLE `avatar` (
  `avatar_id` int(8) NOT NULL auto_increment,
  `url` varchar(500) character set utf8 collate utf8_bin NOT NULL,
  `user_id` int(8) default NULL,
  PRIMARY KEY  (`avatar_id`),
  KEY `FK_Reference_7` (`user_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of avatar
-- ----------------------------

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_id` int(8) NOT NULL auto_increment,
  `title` varchar(20) default NULL,
  `description` varchar(300) default NULL,
  `tag` varchar(60) default NULL,
  `score` double(3,1) default NULL,
  `like_number` int(8) default NULL,
  `url` varchar(500) default NULL,
  `user_id` int(8) default NULL,
  `createat` datetime default NULL,
  `hot` int(8) default NULL,
  `deleted` varchar(1) default NULL,
  PRIMARY KEY  (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('100', '主题', null, null, null, null, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=719983795,511384679&fm=27&gp=0.jpg', '100', null, null, null);
INSERT INTO `blog` VALUES ('103', '杭州', '杭州', '杭州', null, null, 'http://p1vkce34m.bkt.clouddn.com/image/jpg/pictureimage/jpg/107', null, null, null, null);

-- ----------------------------
-- Table structure for `blog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` int(10) NOT NULL auto_increment,
  `tag_id` int(8) NOT NULL,
  `blog_id` int(8) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(8) NOT NULL auto_increment,
  `blog_id` int(8) NOT NULL,
  `content` varchar(500) NOT NULL,
  `user_id` int(8) NOT NULL,
  `author_id` int(8) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY  (`comment_id`),
  KEY `FK_Reference_11` (`blog_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `likeif`
-- ----------------------------
DROP TABLE IF EXISTS `likeif`;
CREATE TABLE `likeif` (
  `likeif_id` int(8) NOT NULL auto_increment,
  `user_id` int(8) NOT NULL,
  `blog_id` int(8) NOT NULL,
  `likeif` varchar(1) NOT NULL,
  PRIMARY KEY  (`likeif_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likeif
-- ----------------------------

-- ----------------------------
-- Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `picture_id` int(12) NOT NULL auto_increment,
  `blog_id` int(8) default NULL,
  `type` varchar(1) character set utf8 collate utf8_bin default NULL,
  `price` int(11) default NULL,
  `buy` varchar(1) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`picture_id`),
  KEY `FK_Reference_1` (`blog_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('100', '100', '1', '1', 'Y');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(8) NOT NULL auto_increment,
  `content` varchar(300) NOT NULL,
  `user_id` int(8) NOT NULL,
  `comment_user_id` int(8) NOT NULL,
  `comment_id` int(8) NOT NULL,
  PRIMARY KEY  (`reply_id`),
  KEY `FK_Reference_12` (`comment_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(8) NOT NULL auto_increment,
  `博客id` int(8) NOT NULL,
  `用户id` int(8) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY  (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(8) NOT NULL auto_increment,
  `tag_name` varchar(10) NOT NULL,
  `type` varchar(1) default NULL,
  PRIMARY KEY  (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(8) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `following_number` int(8) default NULL,
  `follower_number` int(8) default NULL,
  `email` varchar(30) default NULL,
  `birthday` datetime default NULL,
  `avatar_id` int(8) default NULL,
  `money` int(8) default NULL,
  `create_time` datetime default NULL,
  `phone` varchar(11) default NULL,
  `gender` varchar(0) default NULL,
  `role_id` int(8) default NULL,
  `signatur` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100', '111', '111', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `users_tag`
-- ----------------------------
DROP TABLE IF EXISTS `users_tag`;
CREATE TABLE `users_tag` (
  `id` int(8) NOT NULL auto_increment,
  `tag_id` int(8) NOT NULL,
  `user_id` int(8) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `user_follower`
-- ----------------------------
DROP TABLE IF EXISTS `user_follower`;
CREATE TABLE `user_follower` (
  `id` int(8) NOT NULL auto_increment,
  `user_id` int(8) NOT NULL,
  `follower_id` int(8) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_follower
-- ----------------------------

-- ----------------------------
-- Table structure for `user_following`
-- ----------------------------
DROP TABLE IF EXISTS `user_following`;
CREATE TABLE `user_following` (
  `id` int(8) NOT NULL auto_increment,
  `user_id` int(8) NOT NULL,
  `following_id` int(8) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_following
-- ----------------------------

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_id` int(8) NOT NULL auto_increment,
  `blog_id` int(8) default NULL,
  `pass` varchar(1) default NULL,
  PRIMARY KEY  (`video_id`),
  KEY `FK_Reference_6` (`blog_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
