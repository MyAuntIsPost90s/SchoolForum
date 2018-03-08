/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.17-log : Database - lingshi_schoolforum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lingshi_schoolforum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lingshi_schoolforum`;

/*Table structure for table `articlefeedbacks` */

DROP TABLE IF EXISTS `articlefeedbacks`;

CREATE TABLE `articlefeedbacks` (
  `articleFeedbackId` varchar(20) NOT NULL COMMENT '回复编号',
  `articleId` varchar(20) NOT NULL DEFAULT '' COMMENT '帖子编号',
  `articleFeedbackContent` varchar(500) NOT NULL DEFAULT '' COMMENT '内容',
  `articleFeedbackTime` datetime NOT NULL COMMENT '回复时间',
  `fromUserId` bigint(20) NOT NULL COMMENT '来源用户编号',
  `toUserId` bigint(20) NOT NULL DEFAULT '-1' COMMENT '目标用户编号',
  `parentId` varchar(20) NOT NULL DEFAULT '' COMMENT '父级编号',
  PRIMARY KEY (`articleFeedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articlefeedbacks` */

insert  into `articlefeedbacks`(`articleFeedbackId`,`articleId`,`articleFeedbackContent`,`articleFeedbackTime`,`fromUserId`,`toUserId`,`parentId`) values ('A11815295494914','A62109442981513','抱歉，根本不虚你','2018-02-09 15:29:55',7,4,''),('A32822514995810','A64411481521013','踩踩','2018-02-12 22:51:50',4,7,''),('A42414171049813','A64411481521013','你好你好','2018-02-09 14:17:10',7,-1,''),('A42714441620611','A62109442981513','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/37.gif\" alt=\"[色]\">你说啥都对，毕竟我是你爸爸','2018-02-09 14:44:16',7,-1,''),('A43614444540014','A62109442981513','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/39.gif\" alt=\"[鼓掌]\">好','2018-02-09 14:44:45',7,-1,''),('A46222523481111','A54009411920310','14嵌入蔡蔡','2018-02-12 22:52:35',4,-1,''),('A47214435792810','A62109442981513','你说的对','2018-02-09 14:43:58',7,-1,''),('A48019060692911','A95310472849211','拉拉','2018-02-17 19:06:07',7,-1,''),('A50314451219115','A62109442981513','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/24.gif\" alt=\"[哈欠]\">我不服，蔡秀清才是女神好吧','2018-02-09 14:45:12',7,-1,''),('A51320434008910','A44023015870511','啦啦啦','2018-02-18 20:43:40',7,-1,''),('A54714523179817','A62109442981513','<img src=\"http://localhost:8081/SchoolForumRoom/Contents/upload/articleimg/LG51014521045316.png\" alt=\"undefined\">','2018-02-09 14:52:32',7,-1,''),('A63215282340413','A62109442981513',' 小心我封你号<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/10.gif\" alt=\"[鄙视]\">','2018-02-09 15:28:23',4,7,''),('A65714442339212','A62109442981513','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/50.gif\" alt=\"[熊猫]\">','2018-02-09 14:44:23',7,-1,''),('A73514161034512','A64411481521013','123213','2018-02-09 14:16:10',7,-1,''),('A74414443256613','A62109442981513','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/40.gif\" alt=\"[晕]\">沙发','2018-02-09 14:44:33',7,-1,''),('A83015034979710','A58309422868711','处你个大头鬼<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/26.gif\" alt=\"[怒]\">','2018-02-09 15:03:50',7,-1,''),('A87119053776510','A25711464218612','消灭0回复<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/1.gif\" alt=\"[嘻嘻]\">','2018-02-17 19:05:38',7,-1,''),('A88420333037910','A64411481521013','<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/15.gif\" alt=\"[生病]\">','2018-03-03 20:33:30',4,-1,''),('A94320370847413','A64411481521013','&nbsp;<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/38.gif\" alt=\"[哼]\">你的表情真丑','2018-03-03 20:37:08',7,4,'');

/*Table structure for table `articles` */

DROP TABLE IF EXISTS `articles`;

CREATE TABLE `articles` (
  `articleId` varchar(20) NOT NULL COMMENT '帖子编号',
  `articleTitle` varchar(50) NOT NULL DEFAULT '' COMMENT '帖子标题',
  `articleContent` varchar(5000) NOT NULL DEFAULT '' COMMENT '帖子内容',
  `articleTime` datetime NOT NULL COMMENT '发布时间',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `articles` */

insert  into `articles`(`articleId`,`articleTitle`,`articleContent`,`articleTime`,`userId`) values ('A14009431703912','【比赛】比帅大赛开始了。','如题','2018-02-09 09:43:17',4),('A25711464218612','【水贴】帖子3','<p>如题</p>','2018-02-09 11:46:42',4),('A44023015870511','小菜的周六','六六六<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/46.gif\" alt=\"[互粉]\">','2018-02-17 23:01:59',7),('A48011462466510','【水贴】帖子1','如题','2018-02-09 11:46:25',4),('A51411463317011','【水贴】帖子2','如题','2018-02-09 11:46:33',4),('A54009411920310','【求助】有个男生特帅，是哪个班的？','如题','2018-02-09 09:41:19',4),('A58309422868711','【找对象】有没有处CP的？','如题','2018-02-09 09:42:29',4),('A62109442981513','【水贴】计算机女神','14嵌入班的女生都是女神，不服来辩','2018-02-09 09:44:30',4),('A64411481521013','【水贴】帖子4','如题','2018-02-09 11:48:15',4),('A95310472849211','【测试】帖子1','<img src=\"http://localhost:8081/SchoolForumRoom/Contents/lib/layui/images/face/26.gif\" alt=\"[怒]\">这是一篇测试帖子','2018-02-05 10:47:28',4);

/*Table structure for table `classes` */

DROP TABLE IF EXISTS `classes`;

CREATE TABLE `classes` (
  `classId` varchar(20) NOT NULL COMMENT '班级编号',
  `className` varchar(20) NOT NULL DEFAULT '' COMMENT '专业班级名称',
  `majorId` varchar(20) NOT NULL COMMENT '系院名称',
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `classes` */

insert  into `classes`(`classId`,`className`,`majorId`) values ('1','1','1'),('C55516462731910','14级计算机科学与技术(嵌入式)','M21413400957910'),('C59116471650112','14级软件工程','M21413400957910'),('C68816470111711','14级计算机科学与技术(网络)','M21413400957910');

/*Table structure for table `majors` */

DROP TABLE IF EXISTS `majors`;

CREATE TABLE `majors` (
  `majorId` varchar(20) NOT NULL COMMENT '系院编号',
  `majorName` varchar(20) NOT NULL DEFAULT '' COMMENT '系院名称',
  PRIMARY KEY (`majorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `majors` */

insert  into `majors`(`majorId`,`majorName`) values ('M21413400957910','计算机科学系'),('M21413400957912','美术学院'),('M21413400957913','人文传播学院');

/*Table structure for table `notices` */

DROP TABLE IF EXISTS `notices`;

CREATE TABLE `notices` (
  `noticeId` varchar(20) NOT NULL COMMENT '公告编号',
  `noticeImgUrl` varchar(100) NOT NULL DEFAULT '' COMMENT '公告预览图',
  `noticeTitle` varchar(50) NOT NULL DEFAULT '' COMMENT '公告标题',
  `noticeContent` varchar(5000) NOT NULL DEFAULT '' COMMENT '公告内容',
  `noticeTime` datetime NOT NULL COMMENT '公告时间',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notices` */

insert  into `notices`(`noticeId`,`noticeImgUrl`,`noticeTitle`,`noticeContent`,`noticeTime`,`userId`) values ('N12715252775911','/Contents/upload/noticehead/N12715252775911.png?a=LG56521263352211','测试2','<p style=\"text-align: center;\"><b style=\"\">我是标题</b></p><p style=\"text-align: left;\">1.我是图片<img src=\"http://localhost:8081/SchoolForumRoom/Contents/lib/layui/images/face/0.gif\" alt=\"[微笑]\"></p><p style=\"text-align: left;\"><img src=\"http://localhost:8081/SchoolForumRoom/Contents/upload/articleimg/LG55216471483410.png\" alt=\"undefined\"><br></p>','2018-02-02 15:25:06',4),('N20021000087316','/Contents/upload/noticehead/N20021000087316.png?a=LG69421000133617','停水通知','学校一区 二区 三区 教学楼 图书馆因抢修水管于3月5日上午8至上午10点停水，特此通知。','2018-03-04 20:59:39',7),('N92721370919910','/Contents/upload/noticehead/N92721370919910.png?a=LG24121370974711','测试3','','2018-02-02 21:36:58',4),('N94515115783213','/Contents/upload/noticehead/N94515115783213.png?a=LG53915231099110','测试','<p style=\"text-align: center;\"><b>测测</b></p>','2018-02-02 15:11:48',4);

/*Table structure for table `suggestions` */

DROP TABLE IF EXISTS `suggestions`;

CREATE TABLE `suggestions` (
  `suggestionId` varchar(20) NOT NULL COMMENT '建议编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `suggestionTitle` varchar(50) NOT NULL DEFAULT '' COMMENT '建议标题',
  `suggestionContent` varchar(5000) NOT NULL DEFAULT '' COMMENT '建议内容',
  `suggestionTime` datetime NOT NULL COMMENT '建议时间',
  `suggestionFeedback` varchar(5000) NOT NULL DEFAULT '' COMMENT '建议反馈',
  `suggestionFBTime` datetime NOT NULL DEFAULT '2018-01-01 00:00:00' COMMENT '建议反馈时间',
  `suggestionScore` int(11) NOT NULL DEFAULT '0' COMMENT '处理得分(非常满意 10 满意8 一般6 不满意1)',
  `suggestionFBUId` bigint(20) NOT NULL DEFAULT '-1' COMMENT '处理者编号',
  `suggestionType` int(11) NOT NULL DEFAULT '1' COMMENT '建议类型(0匿名 1实名)',
  `suggestionStatus` int(11) NOT NULL DEFAULT '0' COMMENT '建议状态(0未处理 1已处理)',
  `suggestionCount` int(11) NOT NULL DEFAULT '1' COMMENT '建议数量',
  PRIMARY KEY (`suggestionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suggestions` */

insert  into `suggestions`(`suggestionId`,`userId`,`suggestionTitle`,`suggestionContent`,`suggestionTime`,`suggestionFeedback`,`suggestionFBTime`,`suggestionScore`,`suggestionFBUId`,`suggestionType`,`suggestionStatus`,`suggestionCount`) values ('S27016570131210',4,'测试','<p>这是只是一条普通的建议<img src=\"http://localhost:8081/SchoolForumRoom/Contents/lib/layui/images/face/43.gif\" alt=\"[黑线]\"></p>','2018-02-05 16:57:01','','2018-02-06 15:07:30',0,4,1,0,2),('S27720552638215',7,'三堂井盖不稳','三堂转弯处井盖不稳 容易造成危险','2018-03-03 20:55:26','','2018-03-03 20:56:17',10,7,1,1,1),('S36920350967712',4,'食堂的卫生问题','<p>感觉一堂二楼的卫生不好<img src=\"http://localhost:63342/webapp/Contents/lib/layui/images/face/15.gif\" alt=\"[生病]\"></p><p><img src=\"http://localhost:8081/SchoolForumRoom/Contents/upload/articleimg/LG59920350370411.png\" alt=\"undefined\"><br></p>','2018-03-03 20:35:10','','2018-03-03 20:39:54',8,4,1,1,2),('S92323030671113',7,'小菜的建议','原谅我这一条，不为谁而作的建议','2018-02-17 23:03:07','','2018-02-20 21:29:24',8,4,1,1,1);

/*Table structure for table `suggestionusers` */

DROP TABLE IF EXISTS `suggestionusers`;

CREATE TABLE `suggestionusers` (
  `suggestionId` varchar(20) NOT NULL COMMENT '建议编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `suggestionUserId` varchar(20) NOT NULL COMMENT '主键',
  PRIMARY KEY (`suggestionUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suggestionusers` */

insert  into `suggestionusers`(`suggestionId`,`userId`,`suggestionUserId`) values ('S36920350967712',7,'S23021590435410'),('S27016570131210',7,'S40319321663711'),('S27016570131210',4,'S49419264022110');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userName` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `realName` varchar(20) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `sex` varchar(2) NOT NULL DEFAULT '0' COMMENT '0女 1男',
  `birthday` date NOT NULL DEFAULT '2014-01-01' COMMENT '出生日期',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `headImgUrl` varchar(200) NOT NULL DEFAULT '' COMMENT '头像路径',
  `classId` varchar(20) NOT NULL DEFAULT '' COMMENT '班级编号',
  `userType` int(11) NOT NULL DEFAULT '0' COMMENT '用户类型(0普通用户 1管理员 -1默认用户（不允许删除）)',
  `userStatus` int(11) NOT NULL DEFAULT '1' COMMENT '0冻结 1正常',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userId`,`userName`,`password`,`realName`,`sex`,`birthday`,`phone`,`headImgUrl`,`classId`,`userType`,`userStatus`) values (4,'admin','C4CA4238A0B923820DCC509A6F75849B','管理员','1','2014-01-01','17605036258','/Contents/upload/userhead/4.png?version=90f16445-cccc-48b4-b1d4-1e57a9198b49','',-1,1),(5,'admin2','C4CA4238A0B923820DCC509A6F75849B','我是MT','0','2014-01-01','admin2','/Contents/upload/userhead/5.png?version=8ba60708-4cbb-4ef2-8afc-fed22bb504fe','',1,1),(6,'1126670571','C4CA4238A0B923820DCC509A6F75849B','蔡蔡','1','2018-02-02','17605036258','','C55516462731910',0,1),(7,'3141101247','C4CA4238A0B923820DCC509A6F75849B','小菜','1','2014-01-01','17605036258','/Contents/upload/userhead/7.png?version=97e17825-ccc4-4b6b-a217-bac34f8e5149','C55516462731910',0,1);

/*Table structure for table `votes` */

DROP TABLE IF EXISTS `votes`;

CREATE TABLE `votes` (
  `voteId` varchar(20) NOT NULL COMMENT '投票编号',
  `voteTitle` varchar(50) NOT NULL DEFAULT '' COMMENT '投票标题',
  `voteContent` varchar(2000) NOT NULL DEFAULT '' COMMENT '投票内容',
  `voteField` varchar(200) NOT NULL DEFAULT '' COMMENT '投票字段',
  `voteValue` varchar(200) NOT NULL DEFAULT '' COMMENT '投票值',
  `voteBeginTime` datetime NOT NULL COMMENT '投票开始时间',
  `voteEndTime` datetime NOT NULL COMMENT '投票结束时间',
  `voteCreateTime` datetime NOT NULL COMMENT '创建时间',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`voteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `votes` */

insert  into `votes`(`voteId`,`voteTitle`,`voteContent`,`voteField`,`voteValue`,`voteBeginTime`,`voteEndTime`,`voteCreateTime`,`userId`) values ('V17913463837410','未开始测试','这是一条未开始的投票信息','1,2','0,0','2019-02-01 13:46:15','2018-02-07 13:46:20','2018-02-07 13:46:38',4),('V39511510202811','谁是帅哥','帅哥投票','小虎哥,蔡城虎','1,0','2018-02-07 11:50:57','2018-03-14 13:18:16','2018-02-07 11:51:02',4),('V57110445029310','投票测试','<p><img src=\"http://localhost:8081/SchoolForumRoom/Contents/lib/layui/images/face/26.gif\" alt=\"[怒]\">这只是一条普通的投票</p>','投票1,投票2','0,0','2018-02-07 10:44:43','2018-02-07 10:44:44','2018-02-07 10:44:50',4),('V74020502935914','为活动起名','为活动起名','百镇白村,百镇千村,精准扶贫,60周年庆','0,0,1,0','2018-03-03 20:49:53','2018-03-04 20:50:16','2018-03-03 20:50:29',4);

/*Table structure for table `voteusers` */

DROP TABLE IF EXISTS `voteusers`;

CREATE TABLE `voteusers` (
  `voteId` varchar(20) CHARACTER SET armscii8 NOT NULL COMMENT '投票编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `voteField` varchar(20) NOT NULL COMMENT '投票字段',
  PRIMARY KEY (`voteId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `voteusers` */

insert  into `voteusers`(`voteId`,`userId`,`voteField`) values ('V39511510202811',4,'小虎哥'),('V74020502935914',7,'精准扶贫');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
