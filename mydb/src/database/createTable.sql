CREATE TABLE `stat_key_1d` (
  `dataTime` datetime NOT NULL,
  `key_name` varchar(64) NOT NULL,
  `value` bigint(20) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dataTime`,`key_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;