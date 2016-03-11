CREATE TABLE `stat_key_1d` (
  `dataTime` datetime NOT NULL,
  `key_name` varchar(64) NOT NULL,
  `value` bigint(20) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dataTime`,`key_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `statis_act`.`users` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(48) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8