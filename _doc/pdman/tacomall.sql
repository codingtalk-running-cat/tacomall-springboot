/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : tacomall

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 29/06/2020 22:07:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `cover` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'H5地址',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '平台' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admin_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_auth_role`;
CREATE TABLE `admin_auth_role`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for admin_auth_role_mapping_rule
-- ----------------------------
DROP TABLE IF EXISTS `admin_auth_role_mapping_rule`;
CREATE TABLE `admin_auth_role_mapping_rule`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限角色/规则关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_auth_role_mapping_rule
-- ----------------------------

-- ----------------------------
-- Table structure for admin_auth_rule
-- ----------------------------
DROP TABLE IF EXISTS `admin_auth_rule`;
CREATE TABLE `admin_auth_rule`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_auth_rule
-- ----------------------------

-- ----------------------------
-- Table structure for admin_delivery
-- ----------------------------
DROP TABLE IF EXISTS `admin_delivery`;
CREATE TABLE `admin_delivery`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_delivery
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '平台管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_auth_role`;
CREATE TABLE `admin_user_auth_role`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user_auth_role_mapping_rule
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_auth_role_mapping_rule`;
CREATE TABLE `admin_user_auth_role_mapping_rule`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限角色/规则关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_auth_role_mapping_rule
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user_auth_rule
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_auth_rule`;
CREATE TABLE `admin_user_auth_rule`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理权限规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_auth_rule
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user_login_logger
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_login_logger`;
CREATE TABLE `admin_user_login_logger`  (
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_login_logger
-- ----------------------------

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `goods_item_id` int(11) NULL DEFAULT NULL COMMENT '商品表外键',
  `quantity` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数量',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `give_type` int(11) NULL DEFAULT NULL COMMENT '优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券',
  `use_type` int(11) NULL DEFAULT NULL COMMENT '使用类型：0->全场通用；1->指定分类；2->指定商品',
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '金额',
  `note` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `receive_count` int(11) NULL DEFAULT NULL COMMENT '领取数量',
  `use_count` int(11) NULL DEFAULT NULL COMMENT '使用数量',
  `per_limit_count` int(11) NULL DEFAULT NULL COMMENT '没人限领数量',
  `enable_time` datetime(0) NULL DEFAULT NULL COMMENT '开始领取时间',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始使用时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束使用时间',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除标记',
  `create_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_mapping_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `coupon_mapping_goods_category`;
CREATE TABLE `coupon_mapping_goods_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coupon_id` int(11) NULL DEFAULT NULL COMMENT '优惠券表外键',
  `goods_category_id` int(11) NULL DEFAULT NULL COMMENT '产品分类表外键',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券/产品分类中间关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_mapping_goods_category
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_mapping_goods_item
-- ----------------------------
DROP TABLE IF EXISTS `coupon_mapping_goods_item`;
CREATE TABLE `coupon_mapping_goods_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coupon_id` int(11) NULL DEFAULT NULL COMMENT '优惠券表外键',
  `goods_item_id` int(11) NULL DEFAULT NULL COMMENT '商品表外键',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券/商品中间关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_mapping_goods_item
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `merchant_id` decimal(32, 8) NULL DEFAULT NULL COMMENT '商户表外键',
  `goods_brand_id` int(11) NULL DEFAULT NULL COMMENT '产品品牌表外键',
  `goods_category_id` int(11) NULL DEFAULT NULL COMMENT '产品分类表外键',
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `cover` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `json_attr` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性json数据',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, NULL, NULL, 3, NULL, '阿玛塔 Intel八核/4G独显组装电脑主机游戏商用办公家用台式整机全套 套餐一(八核/750 4G/1030 2G)12G', NULL, '【8核CPU强芯】【4G独显游戏N卡】京东闪购，千元主机送24英寸曲面显示器，整点抢电竞低音炮 查看>', NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (2, NULL, NULL, 3, NULL, '联想(Lenovo)天逸510S 英特尔酷睿i3 个人商务台式机电脑整机(i3-9100 8G 1T WiFi 三年上门 Win10)21.5英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (3, NULL, NULL, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)21.5英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (4, NULL, NULL, 3, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）21.5英寸', NULL, '九代酷睿I5，8G大内存，内置WIFI，蓝牙，工业用9针串口，享受无线高端办公', NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (5, NULL, NULL, 3, NULL, '联想(Lenovo)小新Air14 2020锐龙版 全面屏金属超轻薄笔记本电脑(6核R5-4600U 16G 512G IPS高清屏 高色域)灰', NULL, '【爆款热销#BOYS天团“裂墙”推荐】学生网课办公娱乐，全金属高色域100%sRGB，指纹背光，“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动) 查看>', NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods` VALUES (6, NULL, NULL, 3, NULL, '硕扬 intel十二线程强芯/GTX1050独显/16G内存/办公游戏台式电脑主机/DIY组装机', NULL, '【行业爆款·高配主机·超值之选】活动下单即送24英寸高端电竞显示器，升i9级十二线程强芯，抢升16G高频内存！升级高端电竞独显，血亏冲量！活动专场 查看>', NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goods_aftermarket
-- ----------------------------
DROP TABLE IF EXISTS `goods_aftermarket`;
CREATE TABLE `goods_aftermarket`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品售后表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_aftermarket
-- ----------------------------

-- ----------------------------
-- Table structure for goods_attr_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_category`;
CREATE TABLE `goods_attr_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `p_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_attr_category
-- ----------------------------

-- ----------------------------
-- Table structure for goods_attr_key
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_key`;
CREATE TABLE `goods_attr_key`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attr_category_id` int(11) NULL DEFAULT NULL COMMENT '属性分类表外键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性键表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_attr_key
-- ----------------------------

-- ----------------------------
-- Table structure for goods_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `goods_attr_value`;
CREATE TABLE `goods_attr_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_key_id` int(11) NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` int(11) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `delete_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_attr_value
-- ----------------------------

-- ----------------------------
-- Table structure for goods_brand
-- ----------------------------
DROP TABLE IF EXISTS `goods_brand`;
CREATE TABLE `goods_brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `cover` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_brand
-- ----------------------------

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `p_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `cover` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `discription` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES (1, 0, '热门推荐', NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_category` VALUES (2, 1, '热门分类', NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_category` VALUES (3, 2, '电脑', NULL, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goods_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `goods_evaluate`;
CREATE TABLE `goods_evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `text` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复文本',
  `images` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复图片',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for goods_evaluate_reply
-- ----------------------------
DROP TABLE IF EXISTS `goods_evaluate_reply`;
CREATE TABLE `goods_evaluate_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `evaluate_id` int(11) NULL DEFAULT NULL COMMENT '产品评论表外键',
  `text` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复文本',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品评价回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_evaluate_reply
-- ----------------------------

-- ----------------------------
-- Table structure for goods_item
-- ----------------------------
DROP TABLE IF EXISTS `goods_item`;
CREATE TABLE `goods_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '产品表外键',
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `cover` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '金额',
  `git_integral` int(11) NULL DEFAULT NULL COMMENT '赠送积分',
  `gift_growth` int(11) NULL DEFAULT NULL COMMENT '赠送成长值',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `stock_low` int(11) NULL DEFAULT NULL COMMENT '库存预警',
  `promote_type` int(11) NULL DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价；1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `promote_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '促销金额',
  `promote_start_time` datetime(0) NULL DEFAULT NULL COMMENT '促销开始时间',
  `promote_end_time` datetime(0) NULL DEFAULT NULL COMMENT '促销结束时间',
  `promote_per_limit` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '促销限购数量',
  `new_status` int(11) NULL DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `publish_status` int(11) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `album_images` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相册',
  `album_mobile_images` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动端相册',
  `detail_images` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情图片',
  `detail_mobile_images` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动端详情图片',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_item
-- ----------------------------
INSERT INTO `goods_item` VALUES (1, 1, NULL, '阿玛塔 Intel八核/4G独显组装电脑主机游戏商用办公家用台式整机全套 套餐一(八核/750 4G/1030 2G)12G', NULL, '【8核CPU强芯】【4G独显游戏N卡】京东闪购，千元主机送24英寸曲面显示器，整点抢电竞低音炮 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (2, 1, NULL, '阿玛塔 Intel八核/4G独显组装电脑主机游戏商用办公家用台式整机全套 套餐二(八核/GTX1050 2G独显)16G', NULL, '【8核CPU强芯】【4G独显游戏N卡】京东闪购，千元主机送24英寸曲面显示器，整点抢电竞低音炮 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (3, 2, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑整机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）19.5英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (4, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 19.5英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (5, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (6, 2, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）19.5英寸', NULL, '九代酷睿i5,8G大内存，1TB大存储，上年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (7, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (8, 2, NULL, '联想（Lenovo）天逸510S 第八代英特尔酷睿i3 个人商务台式电脑整机 （i3-8100 8G 1T win10）19.5英寸', NULL, '八代酷睿i3,8G大内存，1TB大存储，三年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (9, 2, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T集显 WiFi 蓝牙 win10）19.5英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (10, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (11, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (12, 2, NULL, '联想(Lenovo)天逸510S 英特尔酷睿i3 个人商务台式机电脑整机(i3-9100 8G 1T WiFi 三年上门 Win10)21.5英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (13, 2, NULL, '联想(Lenovo)天逸510S锐龙版 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 21.5英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (14, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (15, 2, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）21.5英寸', NULL, '九代酷睿I5，8G大内存，内置WIFI，蓝牙，工业用9针串口，享受无线高端办公', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (16, 2, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i5个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (17, 2, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i5个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (18, 2, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T WiFi 蓝牙 win10）21.5英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (19, 2, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i3 个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (20, 2, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i3 个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (21, 2, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑整机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）23英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (22, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 23英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (23, 2, NULL, '联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (24, 2, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (25, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (26, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (27, 2, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T WiFi 蓝牙 win10）23英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (28, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (29, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (30, 2, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑主机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）单主机', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (31, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 单主机', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (32, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 单主机', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (33, 2, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）单主机', NULL, '九代酷睿i5,8G大内存，1TB大存储，三年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (34, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (35, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (36, 2, NULL, '联想（Lenovo）天逸310S个人商务台式电脑主机（AMD A6 4G 1T WiFi 蓝牙 win10）单主机', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (37, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (38, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (39, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (40, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (41, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (42, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (43, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (44, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (45, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (46, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (47, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (48, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (49, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (50, 2, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (51, 2, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (52, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (53, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (54, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (55, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (56, 2, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (57, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i7-10700 8G 256SSD 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (58, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i5-10400 8G 256GSSD 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (59, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代I5-10400 8G 512GSSD 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (60, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i5-10400 8G 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (61, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 256GSSD 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (62, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 256GSSD 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (63, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 1T 三年上门售后)27英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (64, 3, NULL, '戴尔(DELL)成就3471 高性能 商用办公 台式电脑整机(九代i5-9400 8G 1T 四年上门售后 键鼠 WIFI)27英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿i5，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (65, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)27英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (66, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)27英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (67, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i7-10700 8G 256GSSD 1T 三年上门售后)23.8英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (68, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i5-10400 8G 256GSSD 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (69, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i5-10400 8G 512GSSD 三年上门售后)23.8英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (70, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i5-10400 8G 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (71, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 256GSSD 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (72, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 256GSSD 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (73, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (74, 3, NULL, '戴尔(DELL)成就3681台式电脑整机(十代i3-10100 8G 1T 三年上门售后)23.8英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (75, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (76, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (77, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (78, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (79, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (80, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (81, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)23.8英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (82, 3, NULL, '戴尔(DELL)成就5090 英特尔酷睿i5 高性能商用办公台式电脑(i5-9400 8G 256G 1T RX550 4G 四年上门)23.8英寸', NULL, '【网课推荐，直播利器,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (83, 3, NULL, '戴尔(DELL)成就5090 英特尔酷睿i5 高性能商用办公台式电脑(i5-9400 8G 256G 1T RX550 4G 四年上门)23.8英寸', NULL, '【网课推荐，直播利器,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (84, 3, NULL, '戴尔(DELL)成就5090 英特尔酷睿i5 高性能商用办公台式电脑(i5-9400 8G 256G 1T RX550 4G 四年上门)23.8英寸', NULL, '【网课推荐，直播利器,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (85, 3, NULL, '戴尔(DELL)成就5090 英特尔酷睿i5 高性能商用办公台式电脑(i5-9400 8G 256G 1T RX550 4G 四年上门)23.8英寸', NULL, '【网课推荐，直播利器,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (86, 3, NULL, '戴尔(DELL)成就5090 英特尔酷睿i5 高性能商用办公台式电脑(i5-9400 8G 256G 1T RX550 4G 四年上门)23.8英寸', NULL, '【网课推荐，直播利器,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (87, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i7-10700 8G 256SSD 1T 三年上门售后)21.5英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (88, 3, NULL, '戴尔(DELL)成就3681英特尔酷睿i5商用办公高性能台式电脑整机(十代i5-10400 8G 256G 1T 三年上门)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (89, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代I5-10400 8G 512GSSD 三年上门售后)21.5英寸', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (90, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i5-10400 8G 1T 三年上门售后)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (91, 3, NULL, '戴尔(DELL)成就3681英特尔酷睿i3商用办公高性能台式电脑整机(十代i3-10100 8G 256G 1T 三年上门)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (92, 3, NULL, '戴尔(DELL)成就3681英特尔酷睿i3商用办公高性能台式电脑整机(十代i3-10100 8G 256G 1T 三年上门)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (93, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代i3-10100 8G 1T 三年上门售后)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (94, 3, NULL, '戴尔(DELL)成就3471英特尔酷睿i5商用办公台式电脑整机(九代i5-9400 8G 1T 四年上门 键鼠 WIFI)21.5英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿i5，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (95, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)21.5英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (96, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑整机(i3-9100 8G 1T 四年上门 WIFI)21.5英寸', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (97, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑主机(十代i7-10700 8G 256SSD 1T 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (98, 3, NULL, '戴尔(DELL)成就3681台式电脑主机(十代i5-10400 8G 256GSSD 1T 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (99, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑整机(十代I5-10400 8G 512GSSD 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (100, 3, NULL, '戴尔(DELL)成就3681台式电脑主机(十代i5-10400 8G 1T 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (101, 3, NULL, '戴尔(DELL)成就3681商用办公高性能台式电脑主机(十代i3-10100 8G 256GSSD 1T 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (102, 3, NULL, '戴尔(DELL)成就5090 高性能 商用办公 台式电脑主机(九代i5-9400 8G 256G 1T RX550 4G 四年服务)', NULL, '【新品上市,4G独显】4年整机上门+3年硬盘保留服务,九代酷睿i5处理器,RX550,4G显卡,超强扩展能力,免工具拆装。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (103, 3, NULL, '戴尔(DELL)成就3681台式电脑主机(十代i3-10100 8G 1T 三年上门售后)', NULL, '搭载十代处理器性能强劲；7L超小机箱节约空间；EPA电源更加节能；内置WIFI；更强拓展,更多接口', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (104, 3, NULL, '戴尔(DELL)成就3471高性能商用办公台式电脑主机(九代i5-9400/8G/1T/四年上门售后/键鼠/WIFI)', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (105, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑主机(i3-9100 8G 1T 四年上门 WIFI)', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (106, 3, NULL, '戴尔(DELL)成就3471 英特尔酷睿i3 高性能 商用办公 台式电脑主机(i3-9100 8G 1T 四年上门 WIFI)', NULL, '【小机身大容量，成就高效办公】九代酷睿，4年整机上门服务，8G高频内存，内置WiFi，独特导风罩设计。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (107, 4, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑整机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）19.5英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (108, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 19.5英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (109, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (110, 4, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）19.5英寸', NULL, '九代酷睿i5,8G大内存，1TB大存储，上年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (111, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (112, 4, NULL, '联想（Lenovo）天逸510S 第八代英特尔酷睿i3 个人商务台式电脑整机 （i3-8100 8G 1T win10）19.5英寸', NULL, '八代酷睿i3,8G大内存，1TB大存储，三年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (113, 4, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T集显 WiFi 蓝牙 win10）19.5英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (114, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (115, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）19.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (116, 4, NULL, '联想(Lenovo)天逸510S 英特尔酷睿i3 个人商务台式机电脑整机(i3-9100 8G 1T WiFi 三年上门 Win10)21.5英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (117, 4, NULL, '联想(Lenovo)天逸510S锐龙版 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 21.5英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (118, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (119, 4, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）21.5英寸', NULL, '九代酷睿I5，8G大内存，内置WIFI，蓝牙，工业用9针串口，享受无线高端办公', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (120, 4, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i5个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (121, 4, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i5个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (122, 4, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T WiFi 蓝牙 win10）21.5英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (123, 4, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i3 个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (124, 4, NULL, '联想(Lenovo)天逸510Pro英特尔酷睿i3 个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）21.5英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (125, 4, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑整机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）23英寸', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (126, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 23英寸', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (127, 4, NULL, '联想(Lenovo)天逸510S 英特尔酷睿i5 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (128, 4, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (129, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (130, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (131, 4, NULL, '联想（Lenovo）天逸310S个人商务台式电脑整机（AMD A6 4G 1T WiFi 蓝牙 win10）23英寸', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (132, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (133, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）23英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (134, 4, NULL, '联想（Lenovo）天逸510S个人商务台式机电脑主机（i3-9100 8G 1T WiFi 蓝牙 三年上门 Win10）单主机', NULL, '【网课学习好帮手、智能办公更高效】九代酷睿，三年上门服务，内置WiFi，预装Office，工业用9针串口，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (135, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 单主机', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (136, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑整机(RYZEN锐龙5-3500U 8G 1TB HDD WiFi Win10 ) 单主机', NULL, 'AMD锐龙5四核，Vega高性能核显媲美独立显卡，全新矿石灰小巧机身！逸起拯点新的》 查看>', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (137, 4, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）单主机', NULL, '九代酷睿i5,8G大内存，1TB大存储，三年上门服务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (138, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (139, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (140, 4, NULL, '联想（Lenovo）天逸310S个人商务台式电脑主机（AMD A6 4G 1T WiFi 蓝牙 win10）单主机', NULL, '【网课学习好帮手、智能办公更高效】内置WiFi，预装Office，拉丝工艺小机箱', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (141, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (142, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (143, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (144, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i3-9100 8G 1T wifi win10）单主机', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (145, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (146, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (147, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (148, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (149, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (150, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (151, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (152, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (153, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (154, 4, NULL, '联想(Lenovo)天逸510S 个人商务台式机电脑主机(i5-9400 16G 1T+256G SSD WiFi Win10)21.5英寸FHD', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (155, 4, NULL, '联想（Lenovo）天逸510S 英特尔酷睿i5 个人商务台式电脑整机（I5-9400 8G 1T WiFi Win10 ）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (156, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (157, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (158, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (159, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (160, 4, NULL, '联想(Lenovo)天逸510Pro个人商务台式机电脑整机（i5-9400 8G 1T wifi win10）27英寸', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (161, 5, NULL, '联想(Lenovo)小新Pro13锐龙版 性能网课办公轻薄笔记本电脑(标压R5-3550H 16G 512G 人脸识别 100%sRGB)银', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,游戏级标压CPU,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (162, 5, NULL, '联想(Lenovo)小新Pro13锐龙版 性能网课办公轻薄笔记本电脑(标压R5-3550H 16G 512G 人脸识别 100%sRGB)银', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,游戏级标压CPU,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (163, 5, NULL, '联想(Lenovo)小新Pro13锐龙版 性能网课办公轻薄笔记本电脑(标压R5-3550H 16G 512G 人脸识别 100%sRGB)银', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,游戏级标压CPU,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (164, 5, NULL, '联想(Lenovo)小新Air14 2020锐龙版 全面屏金属超轻薄笔记本电脑(6核R5-4600U 16G 512G IPS高清屏 高色域)灰', NULL, '【爆款热销#BOYS天团“裂墙”推荐】学生网课办公娱乐，全金属高色域100%sRGB，指纹背光，“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (165, 5, NULL, '联想(Lenovo)小新Air14 2020锐龙版 全面屏金属超轻薄笔记本电脑(6核R5-4600U 16G 512G IPS高清屏 高色域)灰', NULL, '【爆款热销#BOYS天团“裂墙”推荐】学生网课办公娱乐，全金属高色域100%sRGB，指纹背光，“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (166, 5, NULL, '联想(Lenovo)小新Air14 2020锐龙版 全面屏金属超轻薄笔记本电脑(6核R5-4600U 16G 512G IPS高清屏 高色域)灰', NULL, '【爆款热销#BOYS天团“裂墙”推荐】学生网课办公娱乐，全金属高色域100%sRGB，指纹背光，“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (167, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(6核R5-4600U 16G 512G 高色域）银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (168, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(6核R5-4600U 16G 512G 高色域）银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (169, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(6核R5-4600U 16G 512G 高色域）银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (170, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(8核R7-4800U 16G 512G 高清屏 高色域)银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (171, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(8核R7-4800U 16G 512G 高清屏 高色域)银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (172, 5, NULL, '联想(Lenovo)小新15 2020锐龙版 15.6英寸大屏高性能轻薄笔记本电脑(8核R7-4800U 16G 512G 高清屏 高色域)银', NULL, '【添加关注到货有提醒】学生网课办公娱乐,数字小键盘，70Wh大电池长续航，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (173, 5, NULL, '联想(Lenovo)小新Pro13 2020 锐龙版 全面屏性能超轻薄笔记本电脑(6核R5-4600U 16G 512G 2.5K屏 高色域)灰', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,全新锐龙4000真6核,,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (174, 5, NULL, '联想(Lenovo)小新Pro13 2020 锐龙版 全面屏性能超轻薄笔记本电脑(6核R5-4600U 16G 512G 2.5K屏 高色域)灰', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,全新锐龙4000真6核,,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (175, 5, NULL, '联想(Lenovo)小新Pro13 2020 锐龙版 全面屏性能超轻薄笔记本电脑(6核R5-4600U 16G 512G 2.5K屏 高色域)灰', NULL, '【爆款热销#性能小钢炮】学生网课办公娱乐,全新锐龙4000真6核,,低蓝光认证,智能散热调节,人脸识别,接口丰富可快充更多尖货', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (176, 5, NULL, '联想(Lenovo)小新Pro13 2020锐龙版 全面屏高性能超轻薄笔记本电脑(8核R7-4800U 16G 512G 2.5K屏 高色域 )灰', NULL, '【添加关注到货有提醒】学生网课办公娱乐,低蓝光认证，人脸识别,接口丰富可快充，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (177, 5, NULL, '联想(Lenovo)小新Pro13 2020锐龙版 全面屏高性能超轻薄笔记本电脑(8核R7-4800U 16G 512G 2.5K屏 高色域 )灰', NULL, '【添加关注到货有提醒】学生网课办公娱乐,低蓝光认证，人脸识别,接口丰富可快充，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (178, 5, NULL, '联想(Lenovo)小新Pro13 2020锐龙版 全面屏高性能超轻薄笔记本电脑(8核R7-4800U 16G 512G 2.5K屏 高色域 )灰', NULL, '【添加关注到货有提醒】学生网课办公娱乐,低蓝光认证，人脸识别,接口丰富可快充，暂时缺货“亲兄弟”独显版火热销售中（查看性能版）(此商品不参加上述活动)', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (179, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 爵士黑', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (180, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 爵士黑', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (181, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 爵士黑', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (182, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 迷迭绿', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (183, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 迷迭绿', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (184, 5, NULL, '联想（Lenovo）小新新选 新动系列 休闲斜挎包 多彩配色 迷迭绿', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (185, 5, NULL, '联想(Lenovo)小新新选 新动系列 防蓝光贴膜 防刮耐磨 保护屏幕 进口材质 环保可靠 适配小新Air14', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (186, 5, NULL, '联想(Lenovo)小新新选 新动系列 防蓝光贴膜 防刮耐磨 保护屏幕 进口材质 环保可靠 适配小新Air14', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `goods_item` VALUES (187, 5, NULL, '联想(Lenovo)小新新选 新动系列 防蓝光贴膜 防刮耐磨 保护屏幕 进口材质 环保可靠 适配小新Air14', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goods_service
-- ----------------------------
DROP TABLE IF EXISTS `goods_service`;
CREATE TABLE `goods_service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品服务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_service
-- ----------------------------

-- ----------------------------
-- Table structure for jobs_info
-- ----------------------------
DROP TABLE IF EXISTS `jobs_info`;
CREATE TABLE `jobs_info`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs_info
-- ----------------------------

-- ----------------------------
-- Table structure for jobs_lock
-- ----------------------------
DROP TABLE IF EXISTS `jobs_lock`;
CREATE TABLE `jobs_lock`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务锁定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs_lock
-- ----------------------------

-- ----------------------------
-- Table structure for jobs_log
-- ----------------------------
DROP TABLE IF EXISTS `jobs_log`;
CREATE TABLE `jobs_log`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs_log
-- ----------------------------

-- ----------------------------
-- Table structure for jobs_registry
-- ----------------------------
DROP TABLE IF EXISTS `jobs_registry`;
CREATE TABLE `jobs_registry`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务注册表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs_registry
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `passwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(11) NULL DEFAULT 0 COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `signature` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名',
  `integral` int(11) NULL DEFAULT NULL COMMENT '积分',
  `growth` int(11) NULL DEFAULT NULL COMMENT '成长值',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for member_address
-- ----------------------------
DROP TABLE IF EXISTS `member_address`;
CREATE TABLE `member_address`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '主键',
  `member_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员表外键',
  `post_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `area` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域',
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `district` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `detail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `receiver_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人名称',
  `receiver_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人手机',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_address
-- ----------------------------

-- ----------------------------
-- Table structure for member_collect_goods
-- ----------------------------
DROP TABLE IF EXISTS `member_collect_goods`;
CREATE TABLE `member_collect_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员表外键',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '产品表外键',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收藏商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_collect_goods
-- ----------------------------

-- ----------------------------
-- Table structure for member_coupon
-- ----------------------------
DROP TABLE IF EXISTS `member_coupon`;
CREATE TABLE `member_coupon`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `coupon_id` int(11) NULL DEFAULT NULL COMMENT '优惠表外键',
  `count` int(11) NULL DEFAULT NULL COMMENT '领取数量',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户优惠券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for member_growth
-- ----------------------------
DROP TABLE IF EXISTS `member_growth`;
CREATE TABLE `member_growth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `count` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成长值达标',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户成长表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_growth
-- ----------------------------

-- ----------------------------
-- Table structure for member_integral
-- ----------------------------
DROP TABLE IF EXISTS `member_integral`;
CREATE TABLE `member_integral`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `count` int(11) NULL DEFAULT NULL COMMENT '积分变化数量',
  `change_type` int(11) NULL DEFAULT NULL COMMENT '改变类型：0->减少；1->新增',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户积分表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_integral
-- ----------------------------

-- ----------------------------
-- Table structure for member_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `member_statistics_info`;
CREATE TABLE `member_statistics_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `consume_amount` int(11) NULL DEFAULT NULL COMMENT '消费总金额',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '订单数量',
  `comment_count` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `coupon_count` int(11) NULL DEFAULT NULL COMMENT '优惠券数量',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户统计信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_statistics_info
-- ----------------------------

-- ----------------------------
-- Table structure for member_weixin
-- ----------------------------
DROP TABLE IF EXISTS `member_weixin`;
CREATE TABLE `member_weixin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `union_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信union_id',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `avatar` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信头像',
  `gender` int(11) NULL DEFAULT 0 COMMENT '微信性别',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信手机号',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户微信表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_weixin
-- ----------------------------

-- ----------------------------
-- Table structure for member_weixin_ma
-- ----------------------------
DROP TABLE IF EXISTS `member_weixin_ma`;
CREATE TABLE `member_weixin_ma`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `open_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信open_id',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户微信小程序表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_weixin_ma
-- ----------------------------

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `passwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商户主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户表外键',
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `total_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '订单总金额',
  `pay_type` int(11) NULL DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `pay_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '支付总金额',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `delivery_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '物流费用金额',
  `delivery_id` int(11) NULL DEFAULT NULL COMMENT '物流表外键',
  `delivery_sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流编号',
  `delivery_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流发货时间',
  `promote_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '促销抵扣金额',
  `integral_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '积分抵扣金额',
  `coupon_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '优惠券抵扣金额',
  `gift_integral` int(11) NULL DEFAULT NULL COMMENT '赠送积分',
  `gift_growth` int(11) NULL DEFAULT NULL COMMENT '赠送成长值',
  `receiver_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人名称',
  `receiver_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人手机',
  `receiver_post_sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件区域编码',
  `receiver_province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `receiver_city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `receiver_area` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `receiver_district` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `receiver_detail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `receiver_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货时间',
  `receipt_type` int(11) NULL DEFAULT NULL COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票',
  `receipt_header` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `receipt_content` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票内容',
  `receipt_receiver_email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票收件邮箱',
  `receipt_receiver_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票收件手机号',
  `status` int(11) NULL DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `note` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_mapping_goods_item
-- ----------------------------
DROP TABLE IF EXISTS `order_mapping_goods_item`;
CREATE TABLE `order_mapping_goods_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单表外键',
  `goods_item_id` int(11) NULL DEFAULT NULL COMMENT '商品表外键',
  `amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '成交金额',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单/产品中间关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_mapping_goods_item
-- ----------------------------

-- ----------------------------
-- Table structure for order_return_apply
-- ----------------------------
DROP TABLE IF EXISTS `order_return_apply`;
CREATE TABLE `order_return_apply`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单退货申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_return_apply
-- ----------------------------

-- ----------------------------
-- Table structure for order_return_type
-- ----------------------------
DROP TABLE IF EXISTS `order_return_type`;
CREATE TABLE `order_return_type`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单退货类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_return_type
-- ----------------------------

-- ----------------------------
-- Table structure for pdman_db_version
-- ----------------------------
DROP TABLE IF EXISTS `pdman_db_version`;
CREATE TABLE `pdman_db_version`  (
  `DB_VERSION` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `VERSION_DESC` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREATED_TIME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdman_db_version
-- ----------------------------

-- ----------------------------
-- Table structure for seckill
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_item_id` int(11) NULL DEFAULT NULL COMMENT '商品外键',
  `stock` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '秒杀库存',
  `start_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开启时间',
  `end_tme` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结束时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_config_oss`;
CREATE TABLE `sys_config_oss`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '阿里云存储配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oss_object
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss_object`;
CREATE TABLE `sys_oss_object`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '阿里云存储对象表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss_object
-- ----------------------------

-- ----------------------------
-- Table structure for sys_region
-- ----------------------------
DROP TABLE IF EXISTS `sys_region`;
CREATE TABLE `sys_region`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_region
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sms_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_config`;
CREATE TABLE `sys_sms_config`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_sms_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_weixin_ma_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_weixin_ma_config`;
CREATE TABLE `sys_weixin_ma_config`  (
  `REVISION` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '微信小程序配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_weixin_ma_config
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
