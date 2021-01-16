/** 本地测试服务器 */
// let baseUrl = 'http://192.168.20.16:8082/api'
// let baseUrl = 'http://192.168.20.10/utpmanage/api'
/** 外网服务器 */
// let baseUrl = 'http://utp.onebank.com.cn/utp-manage-sit/'
// let baseUrl = 'http://utp.onebank.com.cn/utp-manage-uat/'
// let baseUrl = 'http://jianzhong.deayou.com/ht-manage-api/'
// let baseUrl = 'http://125.77.254.130:8899/api'
// let baseUrl = 'http://192.168.214.16:8082/api/'
let baseUrl = window.g.ApiUrl
// /** 生产服务器 */
// let baseUrl = 'http://192.168.208.20:8082/api/'

/** 生产图片加载服务器 */
let baseImageUrl = ''

/** dev3服务器 */
// let baseUrl = 'http://132.232.68.60:8081/api'

/** dev3图片加载服务器 */
// let baseImageUrl = 'http://132.232.68.60:8088'

/** sit服务器 */
// let baseUrl = 'http://192.168.20.13:8081/api'

/** dev1服务器 */
// let baseUrl = 'http://119.27.162.113:8081/api'

/** dev2服务器 */
// let baseUrl = 'http://119.27.171.162:8081/api'

let constants = {
  /* url配置 */
  BaseUrl: baseUrl,
  BaseImageUrl: baseImageUrl,
  TempUrl: baseUrl + 'merchantTemplate.xlsx',
  UploadImageUrl: baseUrl + 'upload/image', // 图片上传地址
  UploadMerchantUrl: baseUrl + 'merchantInfo/upload', // 商户导入地址
  importardBinCUrl: baseUrl + 'cardBinInfo/runsql', // 卡Bin导入地址 /api/cardBinInfo/runsql
  importSubPayPayeeWhiteListCUrl: baseUrl + 'subPayPayeeWhiteList', // 导入入款白名单
  UploadCertificateUrl: baseUrl + 'certificateInfo/uploadUpPrivateKey', // 上传私钥证书
  UpdatePrivateKeyUrl: baseUrl + 'certificateInfo/update/upPrivateKey', // 更新私钥
  UploadPublicCertificateUrl: baseUrl + 'certificateInfo/uploadMerPublicKey', // 上传公钥
  UpdatePublicCertificateUrl: baseUrl + 'certificateInfo/update/merPublicKey', // 更新公钥
  base64EchangeConf: 'data:image/png;base64,',
  /* 资源权限配置 */
  resourceAccessMap: {
    'listUser': '/system/user/read',
    'detailUser': '/system/user/read',
    'addUser': '/system/user/write',
    'editUser': '/system/user/write',
    'deleteUser': '/system/user/write',
    'resetPwdUser': '/system/user/pwd/write',
    'modifyPwdUser': '/system/user/pwd/write',
    'listCardBinInfo': '/system/cardBinInfo/read',
    'detailCardBinInfo': '/system/cardBinInfo/read',
    'addCardBinInfo': '/system/cardBinInfo/write',
    'deleteCardBinInfo': '/system/cardBinInfo/write',
    'editCardBinInfo': '/system/cardBinInfo/write',
    'importCardBinInfo': '/system/cardBinInfo/write',
    'channelRespcodeList': '/channelRespcode/read', // 错误码管理列表
    'channelRespcodeDelete': '/channelRespcode/write', // 错误码管理删除

    'codeDictionaryList': '/codeDictionary/read', // 数据字典管理查询
    'detailCodeDictionary': '/codeDictionary/read', // 详情 数据字典管理查询
    'addCodeDictionary': '/codeDictionary/write', // 添加 数据字典管理
    'editCodeDictionary': '/codeDictionary/write', // 修改 数据字典管理
    'deleteCodeDictionary': '/codeDictionary/write', // 删除 数据字典管理

    // role
    'listRole': '/system/role/read',
    'detailRole': '/system/role/read',
    'addRole': '/system/role/write',
    'editRole': '/system/role/write',
    'deleteRole': '/system/role/write',
    // organization
    'listOrganization': 'organization/read',
    'detailOrganization': 'organization/read',
    'addOrganization': 'organization/write',
    'editOrganization': 'organization/write',
    'deleteOrganization': 'organization/write',
    // product
    'listProduct': '/product/read',
    'detailProduct': '/product/read',
    'addProduct': '/product/write',
    'editProduct': '/product/write',
    'deleteProduct': '/product/write',
    // fee
    'listFee': '/fee/read',
    'detailFee': '/fee/read',
    'addFee': '/fee/write',
    'editFee': '/fee/write',
    'deleteFee': '/fee/write',
    // channel
    'listChannel': '/channel/read',
    'detailChannel': '/channel/read',
    'addChannel': '/channel/write',
    'editChannel': '/channel/write',
    'deleteChannel': '/channel/write',
    // merchant
    'listMerchant': '/merchantInfo/read',
    'detailMerchant': '/merchantInfo/read',
    'addMerchant': '/merchantInfo/write',
    'editMerchant': '/merchantInfo/write',
    'deleteMerchant': '/merchantInfo/write',
    'personalInfoAuth': '/personalInfoAuth/write',
    'personalInfoAuthDetail': '/personalInfoAuthDetail/read', // 企业证件管理详情
    // channelMerchant
    'listChannelMerchant': '/channelMerchant/read',
    'detailChannelMerchant': '/channelMerchant/read',
    'addChannelMerchant': '/channelMerchant/write',
    'editChannelMerchant': '/channelMerchant/write',
    // channelIndustry
    'listChannelIndustry': '/channelIndustry/read',
    'detailChannelIndustry': '/channelIndustry/read',
    'addChannelIndustry': '/channelIndustry/write', // 代付客户关联
    'editChannelIndustry': '/channelIndustry/write',
    'linkBankAcountReand': '/industryAccount/read',


    // channelCertificateInfo
    'channelListCertificateInfo': '/channelCertificateInfo/read',
    'channelDetailCertificateInfo': '/channelCertificateInfo/read',
    'channelAddCertificateInfo': '/channelCertificateInfo/write',
    'channelEditCertificateInfo': '/channelCertificateInfo/write',
    'channelDeleteCertificateInfo': '/channelCertificateInfo/write',
    'channelRefCertificateInfo': '/channelCertificateInfo/write',
    // orgCertificateInfo
    'orgListCertificateInfo': '/orgCertificateInfo/read',
    'orgDetailCertificateInfo': '/orgCertificateInfo/read',
    'orgAddCertificateInfo': '/orgCertificateInfo/write',
    'orgEditCertificateInfo': '/orgCertificateInfo/write',
    'orgDeleteCertificateInfo': '/orgCertificateInfo/write',
    'orgRefCertificateInfo': '/orgCertificateInfo/write',  // 关联
    // tradeFlowCash
    'listTradeFlowCash': '/tradeFlowCash/read',
    'listTradeFlowCashDown': '/tradeFlowCash/read',
    'listHisTradeFlowCash': '/listHisTradeFlowCash/read',
    'listHisTradeFlowCashDown': '/listHisTradeFlowCash/read',
    'listSplitInfo': '/splitInfo/read', // 分账信息记录查询
    'listOutsideTransOrder': '/outsideTransOrder/read', // 上送支付流水查询
    // settle
    'listErrorQuery': '/errorQuery/read',
    'listErrorQueryRun': '/errorQuery/write', // 人工处理
    'listErrorQueryApply': '/errorQueryExamine/write', // 对账差错人工处理审核权限
    'listErrorQueryDown': '/errorQuery/read',
    'listOrgReconciliations': '/orgReconciliations/read',
    'listMerReconciliations': '/indReconciliations/read',
    'merReconcileRecord': '/indReconcileRecord/read',
    'merReconcileRecordDownLoad': '/indReconcileRecord/read',
    'remittanceList': '/transReexchange/read', // 退汇
    'addRemittance': '/transReexchange/write',
    'remarkGoAgain': '/transReexchangeExamine/write', // 退汇管理 重新处理权限
    'downLoading': '/transReexchange/read',
    // industry
    'listIndustry': '/industry/read', // 代付客户管理列表
    'detailIndustry': '/industry/read',
    'addIndustry': '/industry/write',
    'editIndustry': '/industry/write',
    'deleteIndustry': '/industry/write',
    'auditStatusApply': '/examine/write', // 代付客户审核权限
    'resetDate': '/industry/write', // 日期重置
    'listFeeAcount': '/feeAccount/read', // 功能账户配置
    'detailFeeAcount': '/feeAccount/read',
    'addFeeAcount': '/feeAccount/write',
    'deleteFeeAcount': '/feeAccount/write',
    'editFeeAcount': '/feeAccount/write',
    'aboutFeeAcount': '/feeAccount/write',
    'getCash': '/feeAccount/write',
    'addIndustryFeeAccount': '/industryFeeAccount/read', // 新增配置来款账户
    'ListIndustryFeeAccount': '/industryFeeAccount/read', // 配置来款账户列表
    'editIndustryFeeAccount': '/industryFeeAccount/read',
    'deleteIndustryFeeAccount': '/industryFeeAccount/write',
    'listWhiteList': '/whiteList/read', // 来款账户白名单
    'addWhiteList': '/whiteList/write',
    'delWhiteList': '/whiteList/write',
    'editWhiteList': '/whiteList/write',
    'quotaExaApprovalList': '/industryAmLimit/read', // 交易限额列表查询
    'quotaExaApprovalShuaXin': '/industryAmLimit/read', // 交易限额刷新额度
    'quotaExaApprovalListShuaXin': '/industryAmLimit/read', // 刷新额度
    'quotaExaApprovalEdit' : '/industryAmLimitApproval/write', // 编辑交易限额
    'quotaExaApprovalAdd' : '/industryAmLimitApproval/write', // 新增交易限额
    'industryAmLimitApprovalList': '/industryAmLimitApproval/read', // 交易限额审核列表
    'quotaExaApprovalApply': '/industryAmLimitApprovalAudit/write', // 交易限额审核按钮
    'subaccountsAmtLimitList': '/subaccountsAmtLimit/read',  // 子账户交易限额列表查询
    'subaccountsAmtLimitEdit' : '/subaccountsmtALimitApproval/write', // 编辑子账户交易限额
    'subaccountsAmtLimitAdd' : '/subaccountsmtALimitApproval/write', // 新增子账户交易限额
    'subaccountsAmtLimitDel' : '/subaccountsmtALimitApproval/write', // 删除子账户交易限额
    'subaccountsmtALimitApprovalList': '/subaccountsmtALimitApproval/read', // 子账户交易限额审核列表
    'subaccountsmtALimitApprovalApply': '/subaccountsmtALimitApproval/write', // 子账户交易限额审核按钮
    'whiteListPaymentsList': '/whiteListPayments/read', // 出款白名单列表
    'addWhiteListPayments': '/whiteListPayments/write', // 新增出款白名单
    'editWhiteListPayments': '/whiteListPayments/write', // 编辑出款白名单
    'delWhiteListPayments': '/whiteListPayments/write', // 删除出款白名单
    'whiteListPaymentsAuditList': 'whiteListPaymentsAudit/read', // 出款白名单审核列表
    'whiteListPaymentsExamine': '/whiteListPaymentsExamine/write', // 出款白名单审核
    'specialIndustrySyncConfig': '/specialIndustrySyncConfig/read', // 资金同步特殊名单配置
    'delspecialIndustrySyncConfig': '/specialIndustrySyncConfig/write', // 资金同步特殊名单配置维护


    // AccountManage
    'listAccount': '/account/read',
    'detailAccount': '/account/read', // 资金明细
    'accountSetFee' : '/accountExamine/write', // 虚拟账户配置手续费
    'setFee': '/account/write',
    'cashApply': '/account/write', // 提现
    'listCapitalAcount': '/fundAccount/read',
    'delCapitalAcount': '/fundAccount/write',
    'editCapitalAcount': '/fundAccount/write',
    'detailCapitalAcount': '/fundAccount/read',
    'bankAccountTransDetail': '/bankAccountTransDetail/read', // 未入账
    'accountEntryWrite': '/bankAccountTransDetailExamine/write', // 未入账资金流水查询手工入账
    'getCashList': '/withdrawCashAccount/read', // 提现审核列表
    'getTranZhuang': '/withdrawCashAccount/read', // 获取交易状态
    'getCashDetail': '/withdrawCashAccount/read', // 提现审核详情
    'getCashExamine': '/withdrawCashAccount/write', // 提现审核按钮
    'merchantInfoManager': '/merchantInfo/read', // 企业证件管理
    'merchantInfoManagerDetail': '/merchantInfo/read', // 企业证件管理详情
    'merchantInfoApply': '/merchantInfoAuth/write', // 企业证件管理审核
    'accountEntryApplyList': '/applicationForManualEntry/read', // 手工入账审核列表
    'accountEntryApplyBtn': '/applicationForManualEntry/write', // 手工入账审核按钮
    'accountFrozenThawList': '/operationRecord/read', // 冻结解冻列表
    'frozenBtn': '/operationRecord/write', // 冻结
    'thawBtn': '/operationRecord/write', // 解冻
    'accountShenHe': '/operationRecordOper/write', // 冻结解冻审核
    'accountBatchAudit': '/operationRecordOper/write', // 批量冻结解冻审核
    'accounElectronic': '/accounElectronic/read', // 开户电子回单
    'accountBankCardList': '/merchantAccountInfo/read', // 银行卡列表
    'modifyMerchantInfo': '/merchantInfo/write', // 银行卡列表


    // timedTask
    'listJobTask': '/jobTask/read',
    'detailJobTask': '/jobTask/read',
    'runAgain': '/jobTask/write',
    'addJobTask': '/jobTask/write',
    'editJobTask': '/jobTask/write',
    'deleteJobTask': '/jobTask/write',
    'listJobTaskRecord': '/jobTask/read',
    'detailJobTaskRecord': '/jobTask/read',
    'reconcileRecordOld': '/reconcileRecord/write',
    // reportForm
    'listReportForm': '/reportForm/read',
    'listReportFormDownLoad': '/reportForm/read',
    'capitalReportForm': '/financialAccountStatement/read',
    'capitalReportFormDown': '/financialAccountStatement/read',
    'withdrawalsRecordList': '/withdrawalsRecord/read', // 归集账户列表
    'withdrawalsRecordTiXian': '/withdrawalsRecord/write', // 归集账户提现
    'feeIncomeAccountMonthStatList': '/feeIncomeAccountMonthStat/read', // 手续费归集统计查询列表
    'feeIncomeAccountMonthStatGuiJiBtn': '/feeIncomeAccountMonthStat/write', // 2.重新归集划转按钮
    'feeIncomeAccountMonthStatHuaZhangBtn': '/feeIncomeAccountMonthStat/write', // 2.重新归集划转按钮
    'feeManualVerificationBtn': '/feeIncomeAccountMonthStat/write', // 人工核查
    'blacklistMangerList': '/blacklist/read', // 分账黑名单管理列表
    'blacklistAprAdd': '/blacklistApr/write', // 分账黑名单管理新增
    'fenZhangblacklistApr': '/blacklistApr/read', // 分账黑名单审核管理列表
    'blacklistAprOperListShenHe': '/blacklistAprOper/write', // 分账黑名单审核管理审核
    'thawBtnZiJin': '/freezingFundsOpeRecord/write', // 资金冻结
    'freezingFundsOpeRecord': '/freezingFundsOpeRecord/read', // 资金冻结解冻审批查询
    'freezingFundsOpeRecordJieDong': '/freezingFundsOpeRecord/write', // 资金解冻
    'subaccountSettleSplitForm': '/subAccountSettleSplit/read', // 子账户分账信息查询
    'subaccountSettleSplitFormDownLoad': '/subAccountSettleSplit/read', // 子账户分账信息导出
    'subaccountPaymentForm': '/subAccountPayment/read', // 子账户单笔付款信息查询
    'subaccountPaymentFormDownLoad': '/subAccountPayment/read', // 子账户单笔付款信息导出

  },
  /* 全量侧边菜单及权限配置 */
  menuList: [
    {
      icon: 'user',
      title: '系统管理',
      access: '/system',
      name: 'systemManage',
      children: [
        {access: '/system/role/read', icon: 'user', title: '角色管理', name: 'roleManage'},
        {access: '/system/user/read', icon: 'user', title: '用户管理', name: 'userManage'},
        {access: '/system/cardBinInfo/read', icon: 'user', title: '卡Bin管理', name: 'cardBinInfoList'},
        {access: '/channelRespcode/read', icon: 'user', title: '错误码管理', name: 'channelRespcodeList'},
        {access: '/codeDictionary/read', icon: 'user', title: '数据字典管理', name: 'codeDictionaryList'}
      ]
    },
    {
      icon: 'pay',
      title: '客户管理',
      access: '/industry',
      name: 'industry',
      children: [
        {access: '/industry/read', icon: 'pay', title: '客户管理', name: 'industryList'},
        {access: '/feeAccount/read', icon: 'pay', title: '功能账户配置', name: 'feeAcountList'},
        {access: '/whiteList/read', icon: 'pay', title: '来款账户白名单', name: 'listWhiteList'},
        {access: '/fundAccount/read', icon: 'pay', title: '客户实体账户管理', name: 'capitalAcountSearchList'},
        {access: '/industryAmLimit/read', icon: 'pay', title: '客户风控参数管理', name: 'industryAmLimitList'}, //
        {access: '/industryAmLimitApproval/read', icon: 'pay', title: '客户风控参数审核列表', name: 'industryAmLimitApprovalList'},
        {access: '/subaccountsAmtLimit/read', icon: 'pay', title: '子账户交易限额管理', name: 'subaccountsList'}, //
        {access: '/subaccountsmtALimitApproval/read', icon: 'pay', title: '子账户交易限额审核', name: 'subaccountsApprovalList'},
        {access: '/whiteListPayments/read', icon: 'pay', title: '出款白名单', name: 'whiteListPaymentsList'},
        {access: '/whiteListPaymentsExamine/write', icon: 'pay', title: '出款白名单审核列表', name: 'whiteListPaymentsShenhe'},
        {access: '/blacklist/read', icon: 'pay', title: '分账黑名单管理', name: 'blacklistManger'},
        {access: '/blacklistApr/read', icon: 'pay', title: '分账黑名单审核', name: 'blacklistAprOperManger'},
        {access: '/specialIndustrySyncConfig/read', icon: 'pay', title: '资金同步特殊名单配置', name: 'specialIndustrySyncConfig'},
        // {access: '/specialIndustrySyncConfig/write', icon: 'pay', title: '资金同步特殊名单配置维护', name: 'delspecialIndustrySyncConfig'}
      ]
    },
    {
      icon: 'org',
      title: '机构管理',
      access: '/organization',
      name: 'organization',
      children: [
        {access: '/organization/read', icon: 'org', title: '机构管理', name: 'organizationManageList'}
      ]
    },
    // {
    //   icon: 'mer',
    //   title: '商户管理',
    //   access: '/merchant',
    //   name: 'merchantManage',
    //   children: [
    //     {access: '/merchantInfo/read', icon: 'mer', title: '商户管理', name: 'merchantManageList'}
    //   ]
    // },
    // {
    //   icon: 'cert',
    //   title: '证书管理',
    //   access: '/certificateInfo',
    //   name: 'certificate',
    //   children: [
    //     // {access: '/channelCertificateInfo/read', icon: 'cert', title: '渠道证书管理', name: 'channelCerManage'},
    //     {access: '/orgCertificateInfo/read', icon: 'cert', title: '客户证书管理', name: 'orgCerManage'}
    //   ]
    // },
    {
      icon: 'product',
      title: '产品管理',
      access: '/product',
      name: 'productManage',
      children: [
        {access: '/product/read', icon: 'product', title: '支付产品管理', name: 'productManageList'}
      ]
    },
    {
      icon: 'trade',
      title: '手续费管理',
      access: '/fee',
      name: 'feeManage',
      children: [
        {access: '/fee/read', icon: 'trade', title: '手续费管理', name: 'feeManageList'}
      ]
    },
    {
      icon: 'channeicon',
      title: '渠道管理',
      access: '/channel',
      name: 'pchannelManage',
      children: [
        {access: '/channel/read', icon: 'channeicon', title: '渠道管理', name: 'channelManageList'}
      ]
    },
    {
      icon: 'trand',
      title: '交易流水查询',
      name: 'tradeFlowManage',
      access: '/tradeFlowCash',
      children: [
        {access: '/tradeFlowCash/read', icon: 'trand', title: '当前交易流水查询', name: 'tradeFlows'},
        {access: '/listHisTradeFlowCash/read', icon: 'trand', title: '历史交易流水查询', name: 'tradeHisFlows'},
        {access: '/outsideTransOrder/read', icon: 'trand', title: '上送支付流水查询', name: 'listOutsideTransOrder'},
        {access: '/splitInfo/read', icon: 'trand', title: '平台分账信息查询', name: 'listSplitInfo'},
        {access: '/flowingIntoGold/read', icon: 'trand', title: '入金流水查询', name: 'flowingIntoGold'},
        {access: '/singleTransactionFlow/read', icon: 'trand', title: '单笔流水查询', name: 'singleTransactionFlow'},
        {access: '/subAccountSettleSplit/read', icon: 'trand', title: '子账户分账信息查询', name: 'subAccountSettleSplitList'},
        {access: '/subAccountPayment/read', icon: 'trand', title: '子账户单笔付款信息查询', name: 'subAccountPaymentList'}
      ]
    },
    {
      icon: 'bill',
      title: '对账查询',
      name: 'settle',
      access: '/settle',
      children: [
        {access: '/errorQuery/read', icon: 'bill', title: '差错流水查询', name: 'errorQuery'},
        // {access: '/orgReconciliations/read', icon: 'trade', title: '机构对账单', name: 'orgReconciliations'},
        {access: '/indReconcileRecord/read', icon: 'bill', title: '客户对账单', name: 'merReconciliations'},
        {access: '/transReexchange/read', icon: 'bill', title: '退汇管理', name: 'remittanceManager'}
        // {access: '/merReconcileRecord/read', icon: 'trade', title: '商户对账表', name: 'merReconcileRecord'}
      ]
    },
    {
      icon: 'account',
      title: '账户管理',
      access: '/account',
      name: 'account',
      children: [
        {access: '/account/read', icon: 'account', title: '虚拟账户查询', name: 'accountList'},
        {access: '/operationRecord/read', icon: 'account', title: '冻结解冻列表', name: 'accountFrozenThawList'},
        {access: '/bankAccountTransDetail/read', icon: 'account', title: '未入账资金流水查询', name: 'bankAccountTransDetail'},
        {access: '/withdrawalsRecord/read', icon: 'account', title: '手续费收益提现审核', name: 'withdrawalsRecord'},
        {access: '/merchantInfo/read', icon: 'account', title: '企业鉴权审核', name: 'merchantInfoManager'},
        {access: '/personalInfoAuth/read', icon: 'account', title: '个体工商户鉴权审核', name: 'personalInfoAuth'},
        {access: '/applicationForManualEntry/read', icon: 'account', title: '手工入账审核', name: 'accountEntryApply'},
        {access: '/feeIncomeAccountMonthStat/read', icon: 'account', title: '手续费归集统计查询', name: 'feeIncomeAccountMonthStat'},
        {access: '/freezingFundsOpeRecord/read', icon: 'account', title: '资金冻结解冻审核', name: 'freezingFundsOpeRecord'}
        // {access: '/modifyMerchantInfo/read', icon: 'account', title: '资金冻结解冻审核', name: 'modifyMerchantInfo'}
      ]
    },
    {
      icon: 'task',
      title: '定时任务',
      access: '/jobTask',
      name: 'jobTask',
      children: [
        {access: '/jobTask/read', icon: 'task', title: '定时任务', name: 'jobTaskList'},
        {access: '/reconcileRecord/read', icon: 'task', title: '对账任务查询', name: 'jobTaskRecordList'}
      ]
    },
    {
      icon: 'search',
      title: '报表查询',
      access: '/reportForm',
      name: 'reportForm',
      children: [
        {access: '/reportForm/read', icon: 'search', title: '交易统计报表', name: 'reportFormList'},
        {access: '/financialAccountStatement/read', icon: 'search', title: '资金账户统计报表', name: 'capitalFormList'}
      ]
    }
  ],
  /* 接口配置 */
  restful: {
    login: 'auth/login',
    permissions: 'permissions',
    permissionPaths: 'permissionPaths',
    userPermission: 'userPermission',
    roles: 'roles',
    role: 'role',
    users: 'users', // 查询所有用户
    user: 'user', // 用户详情
    userUnLock: 'user/unlock', // 解锁
    userResetPwd: 'user/reset/password', // 重置密码
    userChangePwd: 'user/password', // 修改密码
    merchantInfo: 'merchantInfo',
    merchantInfos: 'merchantInfo/list', // 商户基本信息表
    merchantInfoCers: 'merchantInfo/queryListWithCertId', // 证书关联的商户
    industryInfoCers: 'industry/queryListWithCertId', // 证书关联的商户
    tradeFlowCashs: 'tradeFlowCash/list',
    certificateInfos: 'certificateInfo/list',
    certificateInfo: 'certificateInfo', // 证书详情
    ploadUpPrivateKey: 'certificateInfo/uploadUpPrivateKey', // 上传私钥证书
    updatePrivateKey: 'certificateInfo/update/upPrivateKey', // 更新私钥证书
    uploadMerPublicKey: 'certificateInfo/uploadMerPublicKey', // 上传公钥证书
    updatePublicKey: 'certificateInfo/update/merPublicKey', // 更新公钥证书
    certificateMerchantInfo: 'certificateMerchantInfo', // 证书关联商户
    certificateIndustryInfo: 'certificateIndustryInfo', // 证书关联平台
    certificateMerchantInfoList: 'certificateMerchantInfo/list', // 证书关联的商户列表
    organizations: 'organizations',
    products: 'products',
    subaccountSettleSplitFormList: 'subAccountSettleSplit/list', // 子账户分账信息查询
    subAccountPaymentFormList: 'subAccountPayment/list' // 子账户单笔信息查询
  },
  dictionary: {
    bizType: [
      {code: '000401', name: '代付'},
      {code: '000301', name: '认证支付2.0'},
      {code: '000302', name: '评级支付'},
      {code: '000501', name: '000501'},
      {code: '000601', name: '账单支付'},
      {code: '000801', name: '跨行收单'},
      {code: '000901', name: '绑定支付'},
      {code: '001001', name: '订购'},
      {code: '000202', name: 'B2B'}
    ],
    bizTypeMap: {
      '000401': '代付',
      '000301': '认证支付2.0',
      '000302': '评级支付',
      '000501': '000501',
      '000601': '账单支付',
      '000801': '跨行收单',
      '000901': '绑定支付',
      '001001': '订购',
      '000202': 'B2B'
    },
    txnTypeMap: {
      '12': '单笔',
      '21': '批量'
    },
    trandType: [
      {value: 'PRIVATE', name: '(非签约)单笔实时代收'},
      {value: 'REFUND', name: '退款交易'},
      {value: 'VERIFI_BANK4_SIGNED_PRIVATE', name: '4要素单笔实时代收'},
      {value: 'VERIFI_BANK4_PRIVATE', name: '(签约)单笔实时代收'},
      {value: 'VERIFY_BANK4_SIGN', name: '银行卡4要素签约'},
      {value: 'QUERY_PRIVATE', name: '单笔实时代收状态查询'},
      {value: 'BG_VALIDATE', name: '业务鉴权'},
      {value: 'BATCH_UPLOAD', name: '(非签约)批量代收'},
      {value: 'QUERY_BATCH', name: '批量代收状态查询'},
      {value: 'DOWNLOAD_BATCH_DATA', name: '批量代收回执'},
      {value: 'DOWNLOAD_SETTLE_DATA', name: '对账单下载'}
    ],
    tradeType: [
      {value: 'WITHDRAW', name: '提现'},
      {value: 'TRANSFER', name: '平台转账'},
      {value: 'TRANSFER_USER2USER', name: '转账(用户-用户)'},
      {value: 'TRANSFER_USER2INDUSTRY', name: '转账(用户-代付客户平台)'},
      {value: 'SGL_PAYMENT', name: '单笔实时代付'},
      {value: 'FEE_COLLECTION_TRANSFER', name: '收益账户归集划转'},
      {value: 'COLLECT_ACCOUNT_WITHDRAW', name: '后管归集账户提现'},
      {value: 'SPLIT_PAYMENT', name: '平台分账'},
      {value: 'SUBACCOUNT_SPLIT_PAYMENT', name: '子账户分账'},
      {value: 'SPLIT_PAYMENT_REFUND', name: '平台分账退款'},
      {value: 'SUBACCOUNT_SPLIT_PAYMENT_REFUND', name: '子账户分账退款'},
      {value: 'BALANCE_PAYMENT', name: '余额支付'},
      {value: 'BALANCE_PAYMENT_REFUND', name: '余额支付退款'},
      {value: 'RANDOM_AMT_PAYMENT_AUTH', name: '打款验证'},
      {value: 'ACC_PAYMENT', name: '子账户单笔付款'},
      {value: 'REFUND_ORDERID', name: '订单退款'}
      // {value: 'UPLOAD_ACCOUNT_SETTLE', name: '预付费卡清算'}
    ],
    totalTradeTypeMap: {
      'WITHDRAW': '提现',
      'TRANSFER': '平台转账',
      'TRANSFER_USER2USER': '转账(用户-用户)',
      'TRANSFER_USER2INDUSTRY': '转账(用户-代付客户平台)',
      'SGL_PAYMENT': '单笔实时代付',
      'FEE_COLLECTION_TRANSFER': '收益账户归集划转',
      'COLLECT_ACCOUNT_WITHDRAW': '后管归集账户提现',
      'SPLIT_PAYMENT': '平台分账',
      'SUBACCOUNT_SPLIT_PAYMENT': '子账户分账',
      'BALANCE_PAYMENT': '余额支付',
      'BALANCE_PAYMENT_REFUND': '余额支付退款',
      'RANDOM_AMT_PAYMENT_AUTH': '打款验证',
      'ACC_PAYMENT': '子账户单笔付款',
      'SPLIT_PAYMENT_REFUND': '平台分账退款',
      'SUBACCOUNT_SPLIT_PAYMENT_REFUND': '子账户分账退款'
    },
    accountTypeMap: {
      '1': '平台账户',
      '2': '企业账户',
      '3': '个人账户',
      '4': '手续费收益账户',
      '5': '手续费支出账户',
      '6': '归集账户',
      '7': '佣金账户',
      '8': '个体工商户账户',
      '9': '待结算账户',
      '10': '小额打款支出账户'
    },
    accountTypeArray: [
      {value: '1', name: '平台账户'},
      {value: '2', name: '企业账户'},
      {value: '3', name: '个人账户'},
      {value: '4', name: '手续费收益账户'},
      {value: '5', name: '手续费支出账户'},
      {value: '6', name: '归集账户'},
      {value: '7', name: '佣金账户'},
      {value: '8', name: '个体工商户账户'},
      {value: '9', name: '待结算账户'},
      {value: '10', name: '小额打款支出账户'}
    ],
    // 资金来源表
    fundResourcesDic: {
      '00': '一般性付款',
      '01': '境内转账',
      '02': '现金付款',
      '03': '营销返现',
      '04': '商户资金结算',
      '05': '农林牧副渔收购',
      '06': '跨境退税',
      '07': '跨境汇款',
      '11': '投资赎回',
      '12': '政府服务',
      '15': '信用卡还款',
      '16': '个人支付账户提现',
      '17': '单位支付账户提现',
      '18': '保险理赔/分红',
      '19': '薪资发放',
      '20': '信贷发放',
      '21': '转账验证'
    },
    fundResourcesArray: [
      {value: '00', name: '一般性付款'},
      {value: '01', name: '境内转账'},
      {value: '02', name: '现金付款'},
      {value: '03', name: '营销返现'},
      {value: '04', name: '商户资金结算'},
      {value: '05', name: '农林牧副渔收购'},
      {value: '06', name: '跨境退税'},
      {value: '07', name: '跨境汇款'},
      {value: '11', name: '投资赎回'},
      {value: '12', name: '政府服务'},
      {value: '15', name: '信用卡还款'},
      {value: '16', name: '个人支付账户提现'},
      {value: '17', name: '单位支付账户提现'},
      {value: '18', name: '保险理赔/分红'},
      {value: '19', name: '薪资发放'},
      {value: '20', name: '信贷发放'},
      {value: '21', name: '转账验证'}
    ],
    // 企业类型
    typeOfEnterpriseArray: [
      {value: '2020', name: '非法人企业'},
      {value: '2030', name: '金融机构'},
      {value: '2040', name: '事业单位'},
      {value: '2050', name: '社会团体'},
      {value: '2060', name: '党政机关'},
      {value: '2061', name: '中央政府'},
      {value: '2062', name: '地方政府'},
      {value: '2063', name: '社会保障基金'},
      {value: '2064', name: '外国政府'},
      {value: '2065', name: '住房公积金'},
      {value: '2070', name: '个体工商户'},
      {value: '2080', name: '小微企业'},
      {value: '2090', name: '代表处(驻华机构)'},
      {value: '2100', name: '部队'},
      {value: '2110', name: '国际组织'},
      {value: '2120', name: '农村合作社'},
      {value: '9999', name: '其他'},
      {value: '2011', name: '企业法人-国有企业'},
      {value: '2012', name: '企业法人-其它'}
    ],
    // 企业规模
    enterpriseScaleArray: [
      {value: '20', name: '大型企业'},
      {value: '30', name: '中型企业'},
      {value: '40', name: '小型企业'},
      {value: '41', name: '微型企业'},
      {value: '99', name: '其他'}
    ],
    // 企业经济性质
    econNatureOfEnterprisesArray: [
      {value: '100', name: '内资'},
      {value: '110', name: '国有全资'},
      {value: '120', name: '集体全资'},
      {value: '130', name: '股份合作'},
      {value: '140', name: '联营'},
      {value: '141', name: '国有联营'},
      {value: '142', name: '集体联营'},
      {value: '143', name: '国有与集体联营'},
      {value: '149', name: '其他联营'},
      {value: '150', name: '有限责任（公司）'},
      {value: '151', name: '国有独资（公司）'},
      {value: '159', name: '其他有限责任（公司）'},
      {value: '160', name: '股份有限（公司）'},
      {value: '170', name: '私有'},
      {value: '171', name: '私有独资'},
      {value: '172', name: '私有合伙'},
      {value: '173', name: '私营有限责任（公司）'},
      {value: '174', name: '私营股份有限（公司）'},
      {value: '175', name: '个体经营'},
      {value: '179', name: '其他私有'},
      {value: '190', name: '其他内资'},
      {value: '200', name: '港澳台投资'},
      {value: '210', name: '内地和港澳台合资'},
      {value: '220', name: '内地和港澳台合作'},
      {value: '230', name: '港澳台独资'},
      {value: '240', name: '港澳台投资股份有限（公司）'},
      {value: '290', name: '其他港澳台投资'},
      {value: '300', name: '国外投资'},
      {value: '310', name: '中外合资'},
      {value: '320', name: '中外合作'},
      {value: '330', name: '外资'},
      {value: '340', name: '国外投资股份有限（公司）'},
      {value: '390', name: '其他国外投资'},
      {value: '400', name: '境外机构'},
      {value: '900', name: '其他'}
    ],
    // 上市类型
    ListingTypeArray: [
      {value: '01', name: 'A股'},
      {value: '02', name: 'B股'},
      {value: '03', name: 'H股'},
      {value: '99', name: '其他'}
    ],
    // 行业类型
    industryTypeArray: [
      {value: 'A', name: '农、林、牧、渔业'},
      {value: 'B', name: '采矿业'},
      {value: 'C', name: '制造业'},
      {value: 'D', name: '电力、热力、燃气及水生产和供应业'},
      {value: 'E', name: '建筑业'},
      {value: 'F', name: '批发和零售业'},
      {value: 'G', name: '交通运输、仓储和邮政业'},
      {value: 'H', name: '住宿和餐饮业'},
      {value: 'I', name: '信息传输、软件和信息技术服务业'},
      {value: 'J', name: '金融业'},
      {value: 'K', name: '房地产业'},
      {value: 'L', name: '租赁和商务服务业'},
      {value: 'M', name: '科学研究和技术服务业'},
      {value: 'N', name: '水利、环境和公共设施管理业'},
      {value: 'O', name: '居民服务、修理和其他服务业'},
      {value: 'P', name: '教育'},
      {value: 'Q', name: '卫生和社会工作'},
      {value: 'R', name: '文化、体育和娱乐业'},
      {value: 'S', name: '公共管理、社会保障和社会组织'},
      {value: 'T', name: '国际组织'},
      {value: 'X', name: '未知'}
    ],
    // 二级账户入金类型
    subIncomeTypeArray: [
      {value: '1', name: '仅同名账户二级账户入金'},
      {value: '2', name: '无账户限制二级账户入金'},
      {value: '3', name: '仅白名单账户二级账户入金'}
    ],
    transStatusMap: {
      'PRE_CREATE': '创建订单',
      'PROCESSING': '处理中',
      'TRADE_SUCCESS': '交易成功',
      'TRADE_FAILURE': '交易失败'
    },
    // 分账入账状态
    splitStatusMap: {
      '0': '未入账',
      '1': '已入账'
    },
    // 分账结算方式
    splitSettleModeMap: {
      '0': '代付结算',
      '1': '记账结算'
    },
    banktypeflag: [
      { value: '0', name: '一般银行'},
      { value: '1', name: '村镇银行'},
      { value: '2', name: '港澳外资银行'}
    ],
    cuplogoflag: [
      { value: '0', name: '否'},
      { value: '1', name: '是'}
    ],
    debitcreditflag: [
      { value: 'D', name: '借记卡'},
      { value: 'C', name: '贷记卡'},
      { value: 'Z', name: '准贷记卡'},
      { value: 'Y', name: '预付卡'}
    ]
  },
  pageSet: {
    nameSize: 200,
    accountSize: 40,
    twelveSize: 12
  }
}

export default constants
