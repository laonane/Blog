/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ln_blog

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/07/2021 23:05:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `article_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `article_time` bigint NULL DEFAULT NULL,
  `article_pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_cid` int NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `fk_article_category_cid`(`article_cid`) USING BTREE,
  CONSTRAINT `fk_article_category_cid` FOREIGN KEY (`article_cid`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (23, '测试文章', '<p><br/></p><h1 style=\"border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;\" class=\"ue_t\">[此处键入文章标题]</h1><p><img src=\"http://img.baidu.com/hi/youa/y_0034.gif\" width=\"300\" height=\"200\"/>图文混排方法</p><p>1. 图片居左，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居左对齐，然后即可在右边输入多行文本</p><p><br/></p><p>2. 图片居右，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居右对齐，然后即可在左边输入多行文本</p><p><br/></p><p>3. 图片居中环绕排版</p><p>方法：亲，这个真心没有办法。。。</p><p><br/></p><p><br/></p><p><img src=\"http://img.baidu.com/hi/youa/y_0040.gif\" width=\"300\" height=\"300\"/></p><p>还有没有什么其他的环绕方式呢？这里是居右环绕</p><p><br/></p><p>欢迎大家多多尝试，为UEditor提供更多高质量模板！</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p>占位</p><p><br/></p><p><br/></p><p><br/></p>', 1607262659134, '33f1169917684938b78bf8c85c0a2d1b.jpg', '[此处键入文章标题]图文混排方法1. 图片居左，文字围绕图片排版方法：在文字前面插入图片，设置居左对齐，然后即可在右边输入多行文本2. 图片居右，文字围绕图片排版方法：在文字前面插入图片，设置居右对齐，然后即可在左边输入多行文本3. 图片居中环绕排版方法：亲，这个真心没有办法。。。还有没有什么其他的...', 19);
INSERT INTO `article` VALUES (24, '测试as打卡是来的鸡', '<h1 class=\"ue_t\" style=\"border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;\"><span style=\"color:#c0504d;\">[键入文档标题]</span></h1><p style=\"text-align:center;\"><strong class=\"ue_t\">[键入文档副标题]</strong></p><h3><span class=\"ue_t\" style=\"font-family:幼圆\">[标题 1]</span></h3><p class=\"ue_t\" style=\"text-indent:2em;\">对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 您可以使用这些库来插入表格、页眉、页脚、列表、封面以及其他文档构建基块。 您创建的图片、图表或关系图也将与当前的文档外观协调一致。</p><h3><span class=\"ue_t\" style=\"font-family:幼圆\">[标题 2]</span></h3><p class=\"ue_t\" style=\"text-indent:2em;\">在“开始”选项卡上，通过从快速样式库中为所选文本选择一种外观，您可以方便地更改文档中所选文本的格式。 您还可以使用“开始”选项卡上的其他控件来直接设置文本格式。大多数控件都允许您选择是使用当前主题外观，还是使用某种直接指定的格式。</p><h3><span class=\"ue_t\" style=\"font-family:幼圆\">[标题 3]</span></h3><p class=\"ue_t\">对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 您可以使用这些库来插入表格、页眉、页脚、列表、封面以及其他文档构建基块。 您创建的图片、图表或关系图也将与当前的文档外观协调一致。</p><p class=\"ue_t\"><br/></p><p><br/></p>', 1607266157395, '68446d4b434f4508806433f440c66a2c.png', '[键入文档标题][键入文档副标题][标题 1]对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 您可以使用这些库来插入表格、页眉、页脚、列表、封面以及其他文档构建基块。 您创建的图片、图表或关系图也将与当前的文档外观协调一致。[标题 2]在“开始”选项卡上，通过从快速样...', 7);
INSERT INTO `article` VALUES (25, 'MD风格', '<h1 style=\"border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;\"><span style=\"color:#e36c09;\" class=\"ue_t\">[此处键入简历标题]</span></h1><p><span style=\"color:#e36c09;\"><br/></span></p><table width=\"100%\" border=\"1\" style=\"border-collapse:collapse;\"><tbody><tr class=\"firstRow\"><td width=\"200\" style=\"text-align:center;\" class=\"ue_t\">【此处插入照片】</td><td><p><br/></p><p>联系电话：<span class=\"ue_t\">[键入您的电话]</span></p><p><br/></p><p>电子邮件：<span class=\"ue_t\">[键入您的电子邮件地址]</span></p><p><br/></p><p>家庭住址：<span class=\"ue_t\">[键入您的地址]</span></p><p><br/></p></td></tr></tbody></table><h3><span style=\"color:#e36c09;font-size:20px;\">目标职位</span></h3><p style=\"text-indent:2em;\" class=\"ue_t\">[此处键入您的期望职位]</p><h3><span style=\"color:#e36c09;font-size:20px;\">学历</span></h3><p><span style=\"display:none;line-height:0px;\">﻿</span></p><ol style=\"list-style-type: decimal;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入学校名称] </span> <span class=\"ue_t\">[键入所学专业]</span> <span class=\"ue_t\">[键入所获学位]</span></p></li><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入学校名称]</span> <span class=\"ue_t\">[键入所学专业]</span> <span class=\"ue_t\">[键入所获学位]</span></p></li></ol><h3><span style=\"color:#e36c09;font-size:20px;\" class=\"ue_t\">工作经验</span></h3><ol style=\"list-style-type: decimal;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入公司名称]</span> <span class=\"ue_t\">[键入职位名称]</span></p></li><ol style=\"list-style-type: lower-alpha;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li></ol><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入公司名称]</span> <span class=\"ue_t\">[键入职位名称]</span></p></li><ol style=\"list-style-type: lower-alpha;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li></ol></ol><p><span style=\"color:#e36c09;font-size:20px;\">掌握技能</span></p><p style=\"text-indent:2em;\">&nbsp;<span class=\"ue_t\">[这里可以键入您所掌握的技能]</span><br/></p><p><br/></p>', 1607266171658, 'ee549c901f9d436c8efb7f1699289aef.jpg', '[此处键入简历标题]【此处插入照片】联系电话：[键入您的电话]电子邮件：[键入您的电子邮件地址]家庭住址：[键入您的地址]目标职位[此处键入您的期望职位]学历﻿[键入起止时间] [键入学校名称]  [键入所学专业] [键入所获学位][键入起止时间] [键入学校名称] [键入所学专业] [键入所获学位...', 15);
INSERT INTO `article` VALUES (26, '阿里嘎多', '<h2 style=\"border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;text-align:center;\" class=\"ue_t\">[键入文章标题]</h2><p><strong><span style=\"font-size:12px;\">摘要</span></strong><span style=\"font-size:12px;\" class=\"ue_t\">：这里可以输入很长很长很长很长很长很长很长很长很差的摘要</span></p><p style=\"line-height:1.5em;\"><strong>标题 1</strong></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">这里可以输入很多内容，可以图文混排，可以有列表等。</span></p><p style=\"line-height:1.5em;\"><strong>标题 2</strong></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">来个列表瞅瞅：</span></p><ol style=\"list-style-type: lower-alpha;\" class=\" list-paddingleft-2\"><li><p class=\"ue_t\">列表 1</p></li><li><p class=\"ue_t\">列表 2</p></li><ol style=\"list-style-type: lower-roman;\" class=\" list-paddingleft-2\"><li><p class=\"ue_t\">多级列表 1</p></li><li><p class=\"ue_t\">多级列表 2</p></li></ol><li><p class=\"ue_t\">列表 3<br/></p></li></ol><p style=\"line-height:1.5em;\"><strong>标题 3</strong></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">来个文字图文混排的</span></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">这里可以多行</span></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">右边是图片</span></p><p style=\"text-indent:2em;\"><span style=\"font-size:14px;\" class=\"ue_t\">绝对没有问题的，不信你也可以试试看</span></p><p><br/></p><p><br/></p>', 1607266186657, 'abedaf8b8d8f40b29ed783fcc077e097.png', '[键入文章标题]摘要：这里可以输入很长很长很长很长很长很长很长很长很差的摘要标题 1这里可以输入很多内容，可以图文混排，可以有列表等。标题 2来个列表瞅瞅：列表 1列表 2多级列表 1多级列表 2列表 3标题 3来个文字图文混排的这里可以多行右边是图片绝对没有问题的，不信你也可以试试看...', 8);
INSERT INTO `article` VALUES (27, '234243432432', '<p class=\"ue_t\">欢迎使用UEditor！</p><p><br/></p>', 1607266201602, '5a343388760842d6ad38b601bc3caeab.jpg', '欢迎使用UEditor！...', 5);
INSERT INTO `article` VALUES (28, '和规范化共和国凤凰股份', '<h1 style=\"border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;\"><span style=\"color:#e36c09;\" class=\"ue_t\">[此处键入简历标题]</span></h1><p><span style=\"color:#e36c09;\"><br/></span></p><table width=\"100%\" border=\"1\" style=\"border-collapse:collapse;\"><tbody><tr class=\"firstRow\"><td width=\"200\" style=\"text-align:center;\" class=\"ue_t\">【此处插入照片】</td><td><p><br/></p><p>联系电话：<span class=\"ue_t\">[键入您的电话]</span></p><p><br/></p><p>电子邮件：<span class=\"ue_t\">[键入您的电子邮件地址]</span></p><p><br/></p><p>家庭住址：<span class=\"ue_t\">[键入您的地址]</span></p><p><br/></p></td></tr></tbody></table><h3><span style=\"color:#e36c09;font-size:20px;\">目标职位</span></h3><p style=\"text-indent:2em;\" class=\"ue_t\">[此处键入您的期望职位]</p><h3><span style=\"color:#e36c09;font-size:20px;\">学历</span></h3><p><span style=\"display:none;line-height:0px;\">﻿</span></p><ol style=\"list-style-type: decimal;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入学校名称] </span> <span class=\"ue_t\">[键入所学专业]</span> <span class=\"ue_t\">[键入所获学位]</span></p></li><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入学校名称]</span> <span class=\"ue_t\">[键入所学专业]</span> <span class=\"ue_t\">[键入所获学位]</span></p></li></ol><h3><span style=\"color:#e36c09;font-size:20px;\" class=\"ue_t\">工作经验</span></h3><ol style=\"list-style-type: decimal;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入公司名称]</span> <span class=\"ue_t\">[键入职位名称]</span></p></li><ol style=\"list-style-type: lower-alpha;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li></ol><li><p><span class=\"ue_t\">[键入起止时间]</span> <span class=\"ue_t\">[键入公司名称]</span> <span class=\"ue_t\">[键入职位名称]</span></p></li><ol style=\"list-style-type: lower-alpha;\" class=\" list-paddingleft-2\"><li><p><span class=\"ue_t\">[键入负责项目]</span> <span class=\"ue_t\">[键入项目简介]</span></p></li></ol></ol><p><span style=\"color:#e36c09;font-size:20px;\">掌握技能</span></p><p style=\"text-indent:2em;\">&nbsp;<span class=\"ue_t\">[这里可以键入您所掌握的技能]</span><br/></p><p><br/></p>', 1607266982384, '70a7f5edba87465290c52310b648acdb.jpg', '[此处键入简历标题]【此处插入照片】联系电话：[键入您的电话]电子邮件：[键入您的电子邮件地址]家庭住址：[键入您的地址]目标职位[此处键入您的期望职位]学历﻿[键入起止时间] [键入学校名称]  [键入所学专业] [键入所获学位][键入起止时间] [键入学校名称] [键入所学专业] [键入所获学位...', 17);
INSERT INTO `article` VALUES (29, '2021年7月10日', '<p><br/></p><p><br/></p><p><br/></p><p><img src=\"http://img.baidu.com/hi/jx2/j_0015.gif\"/></p><p><br/></p><p><br/></p><p>文章测试</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><img src=\"http://localhost:8080//ueditor/jsp/upload/image/20210710/1625929208858081227.jpg\" title=\"1625929208858081227.jpg\" alt=\"AdelaideVineyard_ZH-CN8408417885_1920x1080.jpg\"/></p><p><br/></p>', 1625929264885, '75257a686f3e40ca9bd8c90a3870e915.jpg', '文章测试...', 5);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentid` int NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'Java', 0);
INSERT INTO `category` VALUES (2, 'Python', 0);
INSERT INTO `category` VALUES (3, 'Web前端', 0);
INSERT INTO `category` VALUES (4, 'MySQL', 1);
INSERT INTO `category` VALUES (5, 'web服务器', 1);
INSERT INTO `category` VALUES (7, 'CSS', 3);
INSERT INTO `category` VALUES (8, 'HTML', 3);
INSERT INTO `category` VALUES (9, 'JS', 3);
INSERT INTO `category` VALUES (14, '字典', 2);
INSERT INTO `category` VALUES (15, '爬虫', 2);
INSERT INTO `category` VALUES (16, 'SSH', 1);
INSERT INTO `category` VALUES (17, 'SSM', 1);
INSERT INTO `category` VALUES (18, '数据分析', 2);
INSERT INTO `category` VALUES (19, 'TypeScript', 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'laona', '123');

SET FOREIGN_KEY_CHECKS = 1;
