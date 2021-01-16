// begin;
// update `t_permission_func` set permission_id='95' where func_url='/api/transReexchange/(.*):post';
// update `t_permission_func` set permission_id='96' where func_url='/api/applicationForManualEntry:put';
// update `t_permission_func` set permission_id='97' where func_url='/api/account:put';
// INSERT INTO `t_permission` VALUES
// ('94', '对账差错人工处理', '对账差错人工处理审核权限', '/errorQueryExamine/write', '40', null, null, null, null),
//   ('95', '退汇管理重新处理', '退汇管理重新处理权限', '/transReexchangeExamine/write', '40', null, null, null, null),
//   ('96', '未入账资金流水手工入账权限', '未入账资金流水手工入账权限', '/bankAccountTransDetailExamine/write', '17', null, null, null, null),
//   ('97', '账户管理权限', '账户管理权限(配置手续费)', '/accountExamine/write', '49', null, null, null, null);
// INSERT INTO `t_permission_func` VALUES
// ('94', '/api/settleCheckInfoExamine:put');
// commit;
