create DATABASE  seckill;
create TABLE seckinfotable(
  seckill_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT  COMMENT '秒杀商品的id',
  create_time TIMESTAMP not NULL  DEFAULT  current_timestamp,
  seckinfo   VARCHAR(30) NOT NULL COMMENT '商品的详细信息',
  secknum    INT         NOT NULL COMMENT '商品的数量',
  seckseller VARCHAR (20) not NULL  COMMENT '商品的卖家信息',
  start_time  TIMESTAMP  not NULL COMMENT '秒杀的起始时间',
  end_time    timestamp not null comment '商品的结束时间',
  key (start_time),
  key (end_time),
  key (create_time)
)ENGINE =InnoDB AUTO_INCREMENT=1000 CHARSET =utf8 COMMENT '商品秒杀表';
INSERT INTO seckinfotable (seckinfo,secknum,seckseller,start_time,end_time) VALUES ("1000元抢小米note",300,"小明","2016-01-01 00:00:00",
        "2016-01-03 08:00:00"
);

INSERT INTO seckinfotable (seckinfo,secknum,seckseller,start_time,end_time) VALUES ("600元抢红米note",500,"小红","2016-01-01 00:00:00",
                                                                               "2016-01-03 08:00:00"
);

INSERT INTO seckinfotable (seckinfo,secknum,seckseller,start_time,end_time) VALUES ("2000元抢iphone",100,"小明","2016-01-01 00:00:00",
                                                                               "2016-01-03 08:00:00"
);
INSERT INTO seckinfotable (seckinfo,secknum,seckseller,start_time,end_time) VALUES ("800元抢魅族metal",50,"小亮","2016-01-01 00:00:00",
                                                                               "2016-01-03 08:00:00"
);

INSERT INTO seckinfotable (seckinfo,secknum,seckseller,start_time,end_time) VALUES ("1200元魅族pro5",100,"小明","2016-01-01 00:00:00",
                                                                               "2016-01-03 08:00:00"
);
CREATE  TABLE  success_seck(
   seckill_id BIGINT not NULL COMMENT '抢购商品的信息',
   usertel CHAR(11) not NULL COMMENT '抢到商品的人的电话',
   state TINYINT not NULL  COMMENT  '状态',
   create_time timestamp not null  COMMENT '创建的时间',
   PRIMARY KEY (seckill_id,usertel),
   KEY (create_time)
)ENGINE =InnoDB CHARSET =utf8 COMMENT '秒杀信息表';

