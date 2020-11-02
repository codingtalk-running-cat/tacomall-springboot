DROP TABLE IF EXISTS `member`;;/*SkipError*/
CREATE TABLE `member`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    username VARCHAR(32)    COMMENT '账号' ,
    passwd VARCHAR(1024)    COMMENT '密码' ,
    nickname VARCHAR(32)    COMMENT '昵称' ,
    avatar VARCHAR(1024)    COMMENT '头像' ,
    gender INT   DEFAULT 0 COMMENT '性别' ,
    birthday DATE    COMMENT '生日' ,
    signature VARCHAR(1024)    COMMENT '签名' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户表 ';;

ALTER TABLE `member` COMMENT '用户表';;
DROP TABLE IF EXISTS `member_integral_log`;;/*SkipError*/
CREATE TABLE `member_integral_log`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    count_remain INT    COMMENT '剩余积分' ,
    count_cost INT    COMMENT '积分变化数量' ,
    change_type INT    COMMENT '改变类型：0->减少；1->新增' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户积分记录表 ';;

ALTER TABLE `member_integral_log` COMMENT '用户积分记录表';;
DROP TABLE IF EXISTS `member_coupon_admin`;;/*SkipError*/
CREATE TABLE `member_coupon_admin`(
    id INT    COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    coupon_id INT    COMMENT '优惠表外键' ,
    count INT    COMMENT '领取数量' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户平台优惠券表 ';;

ALTER TABLE `member_coupon_admin` COMMENT '用户平台优惠券表';;
DROP TABLE IF EXISTS `member_coupon_merchant`;;/*SkipError*/
CREATE TABLE `member_coupon_merchant`(
    id INT    COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    coupon_id INT    COMMENT '优惠表外键' ,
    count INT    COMMENT '领取数量' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户商家优惠券表 ';;

ALTER TABLE `member_coupon_merchant` COMMENT '用户商家优惠券表';;
DROP TABLE IF EXISTS `member_collect_goods`;;/*SkipError*/
CREATE TABLE `member_collect_goods`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '会员表外键' ,
    goods_id INT    COMMENT '产品表外键' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户收藏商品表 ';;

ALTER TABLE `member_collect_goods` COMMENT '用户收藏商品表';;
DROP TABLE IF EXISTS `member_weixin`;;/*SkipError*/
CREATE TABLE `member_weixin`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    union_id VARCHAR(1024)    COMMENT '微信union_id' ,
    nickname VARCHAR(32)    COMMENT '微信昵称' ,
    avatar VARCHAR(1024)    COMMENT '微信头像' ,
    gender INT   DEFAULT 0 COMMENT '微信性别' ,
    mobile VARCHAR(32)    COMMENT '微信手机号' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户微信表 ';;

ALTER TABLE `member_weixin` COMMENT '用户微信表';;
DROP TABLE IF EXISTS `member_weixin_ma`;;/*SkipError*/
CREATE TABLE `member_weixin_ma`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    open_id VARCHAR(1024)    COMMENT '微信open_id' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户微信小程序表 ';;

ALTER TABLE `member_weixin_ma` COMMENT '用户微信小程序表';;
DROP TABLE IF EXISTS `member_address`;;/*SkipError*/
CREATE TABLE `member_address`(
    id INT    COMMENT '主键' ,
    member_id VARCHAR(32)    COMMENT '会员表外键' ,
    post_code VARCHAR(32)    COMMENT '邮政编码' ,
    province VARCHAR(32)    COMMENT '省' ,
    area VARCHAR(32)    COMMENT '区域' ,
    city VARCHAR(32)    COMMENT '市' ,
    district VARCHAR(32)    COMMENT '街道' ,
    detail VARCHAR(32)    COMMENT '详细地址' ,
    receiver_name VARCHAR(32)    COMMENT '收件人名称' ,
    receiver_mobile VARCHAR(32)    COMMENT '收件人手机' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户收货地址表 ';;

ALTER TABLE `member_address` COMMENT '用户收货地址表';;
DROP TABLE IF EXISTS `member_growth_rule`;;/*SkipError*/
CREATE TABLE `member_growth_rule`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '名称' ,
    count VARCHAR(32)    COMMENT '成长值达标' ,
    is_delete INT   DEFAULT 0 COMMENT '删除时间' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户成长规则表 ';;

ALTER TABLE `member_growth_rule` COMMENT '用户成长规则表';;
DROP TABLE IF EXISTS `member_statistics_info`;;/*SkipError*/
CREATE TABLE `member_statistics_info`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    consume_amount INT    COMMENT '消费总金额' ,
    order_non_payment_count INT    COMMENT '未支付订单数量' ,
    order_paid_count INT    COMMENT '待收货订单数量' ,
    order_done_count INT    COMMENT '已完成订单数量' ,
    order_return_count INT    COMMENT '售后订单数量' ,
    integral_count INT    COMMENT '当前积分' ,
    growth_count INT    COMMENT '成长值' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户统计信息表 ';;

ALTER TABLE `member_statistics_info` COMMENT '用户统计信息表';;
DROP TABLE IF EXISTS `goods`;;/*SkipError*/
CREATE TABLE `goods`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    merchant_id INT    COMMENT '商户表外键' ,
    goods_brand_id INT    COMMENT '产品品牌表外键' ,
    goods_category_id INT    COMMENT '产品分类表外键' ,
    sn VARCHAR(32)    COMMENT '编号' ,
    name VARCHAR(1024)    COMMENT '名称' ,
    cover VARCHAR(32)    COMMENT '封面' ,
    description VARCHAR(1024)    COMMENT '描述' ,
    attr_json VARCHAR(1024)    COMMENT '商品规格json' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品表 ';;

ALTER TABLE `goods` COMMENT '产品表';;
DROP TABLE IF EXISTS `goods_item`;;/*SkipError*/
CREATE TABLE `goods_item`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    goods_id INT    COMMENT '产品表外键' ,
    sn VARCHAR(32)    COMMENT '编号' ,
    name VARCHAR(1024)    COMMENT '名称' ,
    cover VARCHAR(32)    COMMENT '封面' ,
    description VARCHAR(1024)    COMMENT '描述' ,
    amount DECIMAL(32,8)    COMMENT '金额' ,
    git_integral INT    COMMENT '赠送积分' ,
    gift_growth INT    COMMENT '赠送成长值' ,
    stock INT    COMMENT '库存' ,
    stock_low INT    COMMENT '库存预警' ,
    promote_type INT    COMMENT '促销类型：0->没有促销使用原价；1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购' ,
    promote_amount DECIMAL(32,8)    COMMENT '促销金额' ,
    promote_start_time DATETIME    COMMENT '促销开始时间' ,
    promote_end_time DATETIME    COMMENT '促销结束时间' ,
    promote_per_limit VARCHAR(32)    COMMENT '促销限购数量' ,
    status_new INT    COMMENT '新品状态:0->不是新品；1->新品' ,
    status_publish INT    COMMENT '上架状态：0->下架；1->上架' ,
    album_images VARCHAR(32)    COMMENT '相册' ,
    album_h5_images VARCHAR(32)    COMMENT '移动端相册' ,
    detail_images VARCHAR(32)    COMMENT '详情图片' ,
    detail_h5_images VARCHAR(32)    COMMENT '移动端详情图片' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商品表 ';;

ALTER TABLE `goods_item` COMMENT '商品表';;
DROP TABLE IF EXISTS `goods_attr_category`;;/*SkipError*/
CREATE TABLE `goods_attr_category`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    p_id INT    COMMENT '父id' ,
    name VARCHAR(32)    COMMENT '名称' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商品属性分类表 ';;

ALTER TABLE `goods_attr_category` COMMENT '商品属性分类表';;
DROP TABLE IF EXISTS `goods_attr_key`;;/*SkipError*/
CREATE TABLE `goods_attr_key`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    attr_category_id INT    COMMENT '属性分类表外键' ,
    name VARCHAR(32)    COMMENT '名称' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商品属性键表 ';;

ALTER TABLE `goods_attr_key` COMMENT '商品属性键表';;
DROP TABLE IF EXISTS `goods_attr_value`;;/*SkipError*/
CREATE TABLE `goods_attr_value`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '' ,
    attr_key_id INT    COMMENT '' ,
    name VARCHAR(32)    COMMENT '' ,
    is_delete INT   DEFAULT 0 COMMENT '' ,
    create_time DATETIME    COMMENT '' ,
    update_time DATETIME    COMMENT '' ,
    delete_time DATETIME    COMMENT '' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商品属性值表 ';;

ALTER TABLE `goods_attr_value` COMMENT '商品属性值表';;
DROP TABLE IF EXISTS `goods_evaluate`;;/*SkipError*/
CREATE TABLE `goods_evaluate`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    text VARCHAR(1024)    COMMENT '回复文本' ,
    images VARCHAR(32)    COMMENT '回复图片' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品评价表 ';;

ALTER TABLE `goods_evaluate` COMMENT '产品评价表';;
DROP TABLE IF EXISTS `goods_evaluate_reply`;;/*SkipError*/
CREATE TABLE `goods_evaluate_reply`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    evaluate_id INT    COMMENT '产品评论表外键' ,
    text VARCHAR(1024)    COMMENT '回复文本' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品评价回复表 ';;

ALTER TABLE `goods_evaluate_reply` COMMENT '产品评价回复表';;
DROP TABLE IF EXISTS `goods_category`;;/*SkipError*/
CREATE TABLE `goods_category`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    p_id INT    COMMENT '父id' ,
    is_index_floor INT    COMMENT '首页楼层分类：0->否；1->是' ,
    is_index_category INT    COMMENT '首页分类入口：0->否；1->是' ,
    name VARCHAR(32)    COMMENT '名称' ,
    cover VARCHAR(32)    COMMENT '封面' ,
    discription VARCHAR(1024)    COMMENT '描述' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品分类表 ';;

ALTER TABLE `goods_category` COMMENT '产品分类表';;
DROP TABLE IF EXISTS `goods_brand`;;/*SkipError*/
CREATE TABLE `goods_brand`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '名称' ,
    cover VARCHAR(32)    COMMENT '封面' ,
    description VARCHAR(1024)    COMMENT '描述' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品品牌表 ';;

ALTER TABLE `goods_brand` COMMENT '产品品牌表';;
DROP TABLE IF EXISTS `goods_service`;;/*SkipError*/
CREATE TABLE `goods_service`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品服务表 ';;

ALTER TABLE `goods_service` COMMENT '产品服务表';;
DROP TABLE IF EXISTS `goods_aftermarket`;;/*SkipError*/
CREATE TABLE `goods_aftermarket`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '产品售后表 ';;

ALTER TABLE `goods_aftermarket` COMMENT '产品售后表';;
DROP TABLE IF EXISTS `order`;;/*SkipError*/
CREATE TABLE `order`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    sn VARCHAR(32)    COMMENT '订单编号' ,
    total_amount DECIMAL(32,8)    COMMENT '订单总金额' ,
    pay_type INT    COMMENT '支付方式：0->未支付；1->支付宝；2->微信' ,
    pay_amount DECIMAL(32,8)    COMMENT '支付总金额' ,
    pay_time DATETIME    COMMENT '支付时间' ,
    delivery_amount DECIMAL(32,8)    COMMENT '物流费用金额' ,
    delivery_id INT    COMMENT '物流表外键' ,
    delivery_sn VARCHAR(32)    COMMENT '物流编号' ,
    delivery_time VARCHAR(32)    COMMENT '物流发货时间' ,
    promote_amount DECIMAL(32,8)    COMMENT '促销抵扣金额' ,
    integral_amount DECIMAL(32,8)    COMMENT '积分抵扣金额' ,
    coupon_amount DECIMAL(32,8)    COMMENT '优惠券抵扣金额' ,
    gift_integral INT    COMMENT '赠送积分' ,
    gift_growth INT    COMMENT '赠送成长值' ,
    receiver_name VARCHAR(32)    COMMENT '收件人名称' ,
    receiver_mobile VARCHAR(32)    COMMENT '收件人手机' ,
    receiver_post_sn VARCHAR(32)    COMMENT '收件区域编码' ,
    receiver_province VARCHAR(32)    COMMENT '省' ,
    receiver_city VARCHAR(32)    COMMENT '市' ,
    receiver_area VARCHAR(32)    COMMENT '区' ,
    receiver_district VARCHAR(32)    COMMENT '街道' ,
    receiver_detail VARCHAR(32)    COMMENT '详细地址' ,
    receiver_time VARCHAR(32)    COMMENT '收货时间' ,
    receipt_type INT    COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票' ,
    receipt_header VARCHAR(32)    COMMENT '发票抬头' ,
    receipt_content VARCHAR(32)    COMMENT '发票内容' ,
    receipt_receiver_email VARCHAR(32)    COMMENT '发票收件邮箱' ,
    receipt_receiver_mobile VARCHAR(32)    COMMENT '发票收件手机号' ,
    status INT    COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单' ,
    note VARCHAR(1024)    COMMENT '备注' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '订单表 ';;

ALTER TABLE `order` COMMENT '订单表';;
DROP TABLE IF EXISTS `order_mapping_goods_item`;;/*SkipError*/
CREATE TABLE `order_mapping_goods_item`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    order_id INT    COMMENT '订单表外键' ,
    goods_item_id INT    COMMENT '商品表外键' ,
    amount DECIMAL(32,8)    COMMENT '成交金额' ,
    quantity INT    COMMENT '数量' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '订单/产品中间关联表 ';;

ALTER TABLE `order_mapping_goods_item` COMMENT '订单/产品中间关联表';;
DROP TABLE IF EXISTS `order_return_apply`;;/*SkipError*/
CREATE TABLE `order_return_apply`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '订单退货申请表 ';;

ALTER TABLE `order_return_apply` COMMENT '订单退货申请表';;
DROP TABLE IF EXISTS `order_return_type`;;/*SkipError*/
CREATE TABLE `order_return_type`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '订单退货类型表 ';;

ALTER TABLE `order_return_type` COMMENT '订单退货类型表';;
DROP TABLE IF EXISTS `cart`;;/*SkipError*/
CREATE TABLE `cart`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    member_id INT    COMMENT '用户表外键' ,
    goods_item_id INT    COMMENT '商品表外键' ,
    quantity VARCHAR(32)    COMMENT '数量' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '购物车表 ';;

ALTER TABLE `cart` COMMENT '购物车表';;
DROP TABLE IF EXISTS `coupon`;;/*SkipError*/
CREATE TABLE `coupon`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    give_type INT    COMMENT '优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券' ,
    use_type INT    COMMENT '使用类型：0->全场通用；1->指定分类；2->指定商品' ,
    sn VARCHAR(32)    COMMENT '优惠码' ,
    name VARCHAR(32)    COMMENT '名称' ,
    amount DECIMAL(32,8)    COMMENT '金额' ,
    note VARCHAR(1024)    COMMENT '备注' ,
    description VARCHAR(1024)    COMMENT '描述' ,
    count INT    COMMENT '数量' ,
    receive_count INT    COMMENT '领取数量' ,
    use_count INT    COMMENT '使用数量' ,
    per_limit_count INT    COMMENT '没人限领数量' ,
    enable_time DATETIME    COMMENT '开始领取时间' ,
    start_time DATETIME    COMMENT '开始使用时间' ,
    end_time DATETIME    COMMENT '结束使用时间' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time VARCHAR(32)    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time VARCHAR(32)    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '优惠券主表 ';;

ALTER TABLE `coupon` COMMENT '优惠券主表';;
DROP TABLE IF EXISTS `merchant`;;/*SkipError*/
CREATE TABLE `merchant`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '商户名称' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商户表 ';;

ALTER TABLE `merchant` COMMENT '商户表';;
DROP TABLE IF EXISTS `merchant_user`;;/*SkipError*/
CREATE TABLE `merchant_user`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    merchant_id INT    COMMENT '商户账号' ,
    username VARCHAR(32)    COMMENT '用户名' ,
    passwd VARCHAR(1024)    COMMENT '密码' ,
    status INT    COMMENT '1' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商户用户表 ';;

ALTER TABLE `merchant_user` COMMENT '商户用户表';;
DROP TABLE IF EXISTS `merchant_coupon`;;/*SkipError*/
CREATE TABLE `merchant_coupon`(
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商户全品类表 ';;

ALTER TABLE `merchant_coupon` COMMENT '商户全品类表';;
DROP TABLE IF EXISTS `merchant_coupon_mapping_goods_category`;;/*SkipError*/
CREATE TABLE `merchant_coupon_mapping_goods_category`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    merchant_user_id INT    COMMENT '商户用户表外键' ,
    coupon_id INT    COMMENT '优惠券表外键' ,
    goods_category_id INT    COMMENT '产品分类表外键' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商户优惠券/产品分类中间关联表 ';;

ALTER TABLE `merchant_coupon_mapping_goods_category` COMMENT '商户优惠券/产品分类中间关联表';;
DROP TABLE IF EXISTS `merchant_coupon_mapping_goods_item`;;/*SkipError*/
CREATE TABLE `merchant_coupon_mapping_goods_item`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    merchant_user_id INT    COMMENT '商户用户表外键' ,
    coupon_id INT    COMMENT '优惠券表外键' ,
    goods_item_id INT    COMMENT '商品表外键' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '优惠券/商品中间关联表 ';;

ALTER TABLE `merchant_coupon_mapping_goods_item` COMMENT '优惠券/商品中间关联表';;
DROP TABLE IF EXISTS `merchant_user_login_logger`;;/*SkipError*/
CREATE TABLE `merchant_user_login_logger`(
    id INT NOT NULL   COMMENT '主键' ,
    ip VARCHAR(32)    COMMENT 'ip地址' ,
    user_id INT    COMMENT '用户外键' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '商户用户登录日志表 ';;

ALTER TABLE `merchant_user_login_logger` COMMENT '商户用户登录日志表';;
DROP TABLE IF EXISTS `sys_config_oss`;;/*SkipError*/
CREATE TABLE `sys_config_oss`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '阿里云存储配置表 ';;

ALTER TABLE `sys_config_oss` COMMENT '阿里云存储配置表';;
DROP TABLE IF EXISTS `sys_oss_object`;;/*SkipError*/
CREATE TABLE `sys_oss_object`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '阿里云存储对象表 ';;

ALTER TABLE `sys_oss_object` COMMENT '阿里云存储对象表';;
DROP TABLE IF EXISTS `sys_region`;;/*SkipError*/
CREATE TABLE `sys_region`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '区域表 ';;

ALTER TABLE `sys_region` COMMENT '区域表';;
DROP TABLE IF EXISTS `sys_weixin_ma_config`;;/*SkipError*/
CREATE TABLE `sys_weixin_ma_config`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '微信小程序配置表 ';;

ALTER TABLE `sys_weixin_ma_config` COMMENT '微信小程序配置表';;
DROP TABLE IF EXISTS `sys_sms_config`;;/*SkipError*/
CREATE TABLE `sys_sms_config`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '短信配置表 ';;

ALTER TABLE `sys_sms_config` COMMENT '短信配置表';;
DROP TABLE IF EXISTS `admin_auth_role`;;/*SkipError*/
CREATE TABLE `admin_auth_role`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '权限角色名' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理权限角色表 ';;

ALTER TABLE `admin_auth_role` COMMENT '管理权限角色表';;
DROP TABLE IF EXISTS `admin_auth_rule`;;/*SkipError*/
CREATE TABLE `admin_auth_rule`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '规则名称' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '删除时间' ,
    update_time VARCHAR(32)    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理权限规则表 ';;

ALTER TABLE `admin_auth_rule` COMMENT '管理权限规则表';;
DROP TABLE IF EXISTS `admin_auth_rule_view`;;/*SkipError*/
CREATE TABLE `admin_auth_rule_view`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    rule_id INT    COMMENT '规则外键' ,
    name VARCHAR(32)    COMMENT '视图名称' ,
    path VARCHAR(32)    COMMENT '视图地址' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理权限规则视图表 ';;

ALTER TABLE `admin_auth_rule_view` COMMENT '管理权限规则视图表';;
DROP TABLE IF EXISTS `admin_auth_role_mapping_rule`;;/*SkipError*/
CREATE TABLE `admin_auth_role_mapping_rule`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    role_id INT    COMMENT '角色外键' ,
    rule_id INT    COMMENT '规则外键' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理权限角色/规则关联表 ';;

ALTER TABLE `admin_auth_role_mapping_rule` COMMENT '管理权限角色/规则关联表';;
DROP TABLE IF EXISTS `admin_delivery`;;/*SkipError*/
CREATE TABLE `admin_delivery`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '物流表 ';;

ALTER TABLE `admin_delivery` COMMENT '物流表';;
DROP TABLE IF EXISTS `admin_user_login_logger`;;/*SkipError*/
CREATE TABLE `admin_user_login_logger`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    user_id INT    COMMENT '用户外键' ,
    ip VARCHAR(32)    COMMENT 'ip地址' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理员登录日志 ';;

ALTER TABLE `admin_user_login_logger` COMMENT '管理员登录日志';;
DROP TABLE IF EXISTS `admin_user`;;/*SkipError*/
CREATE TABLE `admin_user`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '组件' ,
    auth_role_id INT    COMMENT '权限角色外键' ,
    username VARCHAR(32)    COMMENT '用户名' ,
    passwd VARCHAR(1024)    COMMENT '密码' ,
    status INT    COMMENT '1' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '平台用户表 ';;

ALTER TABLE `admin_user` COMMENT '平台用户表';;
DROP TABLE IF EXISTS `admin_coupon`;;/*SkipError*/
CREATE TABLE `admin_coupon`(
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '平台全平类表 ';;

ALTER TABLE `admin_coupon` COMMENT '平台全平类表';;
DROP TABLE IF EXISTS `admin_coupon_mapping_goods_category`;;/*SkipError*/
CREATE TABLE `admin_coupon_mapping_goods_category`(
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '平台优惠券/产品分类中间关联表 ';;

ALTER TABLE `admin_coupon_mapping_goods_category` COMMENT '平台优惠券/产品分类中间关联表';;
DROP TABLE IF EXISTS `jobs_lock`;;/*SkipError*/
CREATE TABLE `jobs_lock`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '定时任务锁定表 ';;

ALTER TABLE `jobs_lock` COMMENT '定时任务锁定表';;
DROP TABLE IF EXISTS `jobs_log`;;/*SkipError*/
CREATE TABLE `jobs_log`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '定时任务日志表 ';;

ALTER TABLE `jobs_log` COMMENT '定时任务日志表';;
DROP TABLE IF EXISTS `jobs_registry`;;/*SkipError*/
CREATE TABLE `jobs_registry`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '定时任务注册表 ';;

ALTER TABLE `jobs_registry` COMMENT '定时任务注册表';;
DROP TABLE IF EXISTS `jobs_info`;;/*SkipError*/
CREATE TABLE `jobs_info`(
    REVISION INT    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '定时任务信息表 ';;

ALTER TABLE `jobs_info` COMMENT '定时任务信息表';;
DROP TABLE IF EXISTS `activity`;;/*SkipError*/
CREATE TABLE `activity`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    name VARCHAR(32)    COMMENT '名称' ,
    description VARCHAR(1024)    COMMENT '描述' ,
    cover VARCHAR(1024)    COMMENT '封面' ,
    url VARCHAR(128)    COMMENT 'H5地址' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '活动主表 ';;

ALTER TABLE `activity` COMMENT '活动主表';;
DROP TABLE IF EXISTS `activity_apply`;;/*SkipError*/
CREATE TABLE `activity_apply`(
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' 
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '活动申请表 ';;

ALTER TABLE `activity_apply` COMMENT '活动申请表';;
DROP TABLE IF EXISTS `seckill`;;/*SkipError*/
CREATE TABLE `seckill`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    apply_total_count INT    COMMENT '可申请加入数量' ,
    apply_used_count INT    COMMENT '已申请加入数量' ,
    start_time DATETIME    COMMENT '开启时间' ,
    end_time DATETIME    COMMENT '结束时间' ,
    is_delete INT   DEFAULT 0 COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀主表 ';;

ALTER TABLE `seckill` COMMENT '秒杀主表';;
DROP TABLE IF EXISTS `seckill_goods_item_apply`;;/*SkipError*/
CREATE TABLE `seckill_goods_item_apply`(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    seckill_id INT    COMMENT '秒杀主表外键' ,
    merchant_id INT    COMMENT '商户外键' ,
    goods_item_id INT    COMMENT '申请加入秒杀商品外键' ,
    total_count INT    COMMENT '可卖数量' ,
    sell_out_count INT    COMMENT '卖出数量' ,
    status INT    COMMENT '申请审核状态' ,
    is_delete INT    COMMENT '删除标记' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_time DATETIME    COMMENT '更新时间' ,
    delete_time DATETIME    COMMENT '删除时间' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀商品申请表 ';;

ALTER TABLE `seckill_goods_item_apply` COMMENT '秒杀商品申请表';;
