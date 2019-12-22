DELIMITER $$
CREATE  PROCEDURE `java`.`test`()
    BEGIN
	DECLARE V_CHANNEL_ID INT(100);
  DECLARE V_CHANNEL_NAME VARCHAR(60);
  DECLARE V_COUNT INT(100) DEFAULT 1;
  DECLARE V_DATE  VARCHAR(60);
  -- 遍历数据结束标志
  DECLARE done INT DEFAULT FALSE;
  -- 游标
  DECLARE cur CURSOR FOR SELECT ID FROM ACCOUNT_FLOW where ID
		not in (SELECT ID FROM ACCOUNT_FLOW WHERE TRANS_AMOUNT_IN =0 and  TRANS_AMOUNT_OUT = 0 and BALANCE =0)
	      order by DATE desc;
-- 将结束标志绑定到游标
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
-- 打开游标
OPEN cur;
-- 开始循环
read_loop: LOOP
-- 提取游标里的数据，这里只有一个，多个的话也一样；
FETCH cur INTO V_CHANNEL_ID;
-- 声明结束的时候
IF done THEN
LEAVE read_loop;
END IF;
-- 这里做你想做的循环的事件
SELECT V_CHANNEL_ID;
update ACCOUNT_FLOW set num = V_COUNT where id = V_CHANNEL_ID;
set V_COUNT = V_COUNT + 1;

END LOOP;

-- 关闭游标

CLOSE cur;

    END$$

DELIMITER ;