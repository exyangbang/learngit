import Main from '../views/Main'

export const page404 = {
  path: '/*',
  name: 'error-404',
  meta: {
    title: '404-页面不存在'
  },
  component: () => import('../views/error-page/404.vue')
}

export const page403 = {
  path: '/403',
  meta: {
    title: '403-权限不足'
  },
  name: 'error-403',
  component: () => import('../views/error-page/403.vue')
}

export const page500 = {
  path: '/500',
  meta: {
    title: '500-服务端错误'
  },
  name: 'error-500',
  component: () => import('../views/error-page/500.vue')
}

// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
  path: '/',
  name: 'otherRouter',
  component: Main,
  redirect: '/home',
  children: [
    {path: 'home', title: {i18n: 'home'}, name: 'home_index', component: () => import('../views/home/home.vue')}]
}

// 作为Main组件的子页面展示并且在左侧菜单显示的路由写在appRouter里
export const appRouter = [
  {
    path: '/error-page',
    icon: 'android-sad',
    title: '错误页面',
    name: 'errorpage',
    component: Main,
    children: [
      { path: 'index', title: '错误页面', name: 'errorpage_index', component: () => import('../views/error-page/error-page.vue') }
    ]
  },
  {
    path: '/systemManage',
    title: '系统管理',
    name: 'systemManage',
    component: Main,
    children: [
      {path: '/userManage', title: '用户管理', name: 'userManage', component: () => import('../views/system/userManage/userManageList')},
      {path: '/userManage/addUser', title: '添加用户', name: 'addUser', component: () => import('../views/system/userManage/addUser')},
      {path: '/userManage/userDetail/:id', title: '用户详情', name: 'userDetail', component: () => import('../views/system/userManage/userDetail')},
      {path: '/userManage/editUser/:id', title: '用户编辑', name: 'editUser', component: () => import('../views/system/userManage/editUser')},
      {path: '/userManage/changeUserPassword/:username', title: '修改用户密码', name: 'changeUserPassword', component: () => import('../views/system/userManage/userChangePassword')},
      {path: '/roleManage', title: '角色管理', name: 'roleManage', component: () => import('../views/system/roleManage/roleManage')},
      {path: '/roleManage/addRole', title: '角色添加', name: 'addRole', meta: {keepAlive: true}, component: () => import('../views/system/roleManage/addRole')},
      {path: '/roleManage/editRole/:id', title: '角色编辑', name: 'editRole', component: () => import('../views/system/roleManage/editRole')},
      {path: '/roleManage/detailRole/:id', title: '角色详情', name: 'detailRole', component: () => import('../views/system/roleManage/detailRole')},
      {path: '/permissionManage', title: '权限管理', name: 'permissionManage', component: () => import('../views/system/permissionManage/permissionManage')},
      {path: '/cardBinInfoList', title: '卡Bin管理列表', name: 'cardBinInfoList', component: () => import('../views/system/cardBinInfo/cardBinInfoList')},
      {path: '/cardBinInfoDetail/:id', title: '卡Bin详情', name: 'cardBinInfoDetail', component: () => import('../views/system/cardBinInfo/cardBinInfoDetail')},
      {path: '/addCardBinInfo', title: '新增卡Bin', name: 'addCardBinInfo', component: () => import('../views/system/cardBinInfo/addCardBinInfo')},
      {path: '/editCardBinInfo', title: '编辑卡Bin', name: 'editCardBinInfo', component: () => import('../views/system/cardBinInfo/editCardBinInfo')},
      {path: '/importCardBinInfo', title: '导入卡Bin', name: 'importCardBinInfo', component: () => import('../views/system/cardBinInfo/importCardBin')},
      {path: '/channelRespcodeList', title: '错误码管理', name: 'channelRespcodeList', component: () => import('../views/system/channelRespcode/channelRespcodeList')},
      {path: '/addChannelRespcode', title: '新增错误码', name: 'addChannelRespcode', component: () => import('../views/system/channelRespcode/addChannelRespcode')},
      {path: '/editChannelRespcode/:id', title: '编辑错误码', name: 'editChannelRespcode', component: () => import('../views/system/channelRespcode/editChannelRespcode')},
      {path: '/codeDictionaryList', title: '数据字典管理', name: 'codeDictionaryList', component: () => import('../views/system/codeDictionary/codeDictionaryList')},
      {path: '/addCodeDictionary', title: '新增数据字典', name: 'addCodeDictionary', component: () => import('../views/system/codeDictionary/addCodeDictionary')},
      {path: '/editCodeDictionary/:id', title: '编辑数据字典', name: 'editCodeDictionary', component: () => import('../views/system/codeDictionary/editCodeDictionary')}
    ]
  },
  {
    path: '/industry',
    title: '客户管理',
    name: 'industry',
    component: Main,
    children: [
      {path: 'industryList', title: '客户管理', name: 'industryList', component: () => import('../views/industry/industryInfo')},
      {path: 'addIndustry', title: '添加客户', name: 'addIndustry', component: () => import('../views/industry/addIndustry')},
      {path: 'editIndustry/:id', title: '编辑客户', name: 'editIndustry', component: () => import('../views/industry/editIndustry')},
      {path: 'subPayPayeeWhiteList/:id', title: '子账户单笔付款收款白名单', name: 'subPayPayeeWhiteList', component: () => import('../views/industry/whiteList/subPayPayeeWhiteList')},
      {path: 'importSubPayPayeeWhiteList/:id', title: '导入子账户单笔付款收款白名单', name: 'importSubPayPayeeWhiteList', component: () => import('../views/industry/whiteList/importSubPayPayeeWhiteList')},
      {path: 'industryDetail/:id', title: '客户详情', name: 'industryDetail', component: () => import('../views/industry/industryDetail')},
      {path: 'addIndustryData', title: '添加客户资料', name: 'addIndustryData', component: () => import('../views/industry/addIndustryData')},
      {path: 'linkIndustryList/:id', title: '客户_支付产品管理', name: 'linkIndustryList', component: () => import('../views/industry/link/linkIndustry')},
      {path: 'channelLink/:id', title: '客户_支付产品管理', name: 'channelLink', component: () => import('../views/industry/link/channelLink')},
      {path: 'addChannelIndustry/:id', title: '新增客户关联渠道', name: 'addChannelIndustry', component: () => import('../views/industry/link/addChannelIndustry')},
      {path: 'editChannelIndustry/:id', title: '修改客户关联渠道', name: 'editChannelIndustry', component: () => import('../views/industry/link/editChannelIndustry')},
      {path: 'linkBank/:id', title: '来款账户管理', name: 'linkBank', component: () => import('../views/industry/bank/linkBank')}, // 来款账户管理
      {path: 'addBank/:id', title: '新增来款账户', name: 'addBank', component: () => import('../views/industry/bank/addBank')},
      {path: 'editBanky/:id', title: '修改来款账户', name: 'editBank', component: () => import('../views/industry/bank/editBank')},
      {path: 'feeAcountList', title: '功能账户配置', name: 'feeAcountList', component: () => import('../views/industry/feeAcountSet/feeAcountInfo')}, //手续费账户配置
      {path: 'addFeeAcount', title: '新增手续费账户', name: 'addFeeAcount', component: () => import('../views/industry/feeAcountSet/addFeeAcount')},
      {path: 'editFeeAcount', title: '编辑手续费账户', name: 'editFeeAcount', component: () => import('../views/industry/feeAcountSet/editFeeAcount')},
      {path: 'infoFeeCashSet', title: '提现账户列表', name: 'infoFeeCashSet', component: () => import('../views/industry/feeAcountSet/feeCashSet/infoFeeCashSet')},
      {path: 'addFeeCashSet', title: '新增提现账户', name: 'addFeeCashSet', component: () => import('../views/industry/feeAcountSet/feeCashSet/addFeeCashSet')},
      {path: 'editFeeCashSet', title: '编辑提现账户', name: 'editFeeCashSet', component: () => import('../views/industry/feeAcountSet/feeCashSet/editFeeCashSet')},
      {path: 'feeAcountDetail', title: '手续费账户详情', name: 'feeAcountDetail', component: () => import('../views/industry/feeAcountSet/feeAcountDetail')},
      {path: 'listIncoming/:id', title: '功能账户账户管理', name: 'listIncoming', component: () => import('../views/industry/feeAcountSet/feeAccount/infoIncoming')},
      {path: 'addIncoming', title: '新增手续费来款账户', name: 'addIncoming', component: () => import('../views/industry/feeAcountSet/feeAccount/addIncoming')},
      {path: 'editIncoming', title: '编辑手续费来款账户', name: 'editIncoming', component: () => import('../views/industry/feeAcountSet/feeAccount/editIncoming')},
      {path: 'listWhiteList', title: '来款账户白名单', name: 'listWhiteList', keepAlive: false, component: () => import('../views/industry/whiteList/infoWhiteList')}, // 来款账户白名单
      {path: 'addWhiteList', title: '新增来款账户白名单', name: 'addWhiteList', keepAlive: true, component: () => import('../views/industry/whiteList/addWhiteList')},
      {path: 'editWhiteList', title: '编辑来款账户白名单', name: 'editWhiteList', component: () => import('../views/industry/whiteList/editWhiteList')},
      {path: 'capitalAcountSearchList', title: '客户实体账户管理', name: 'capitalAcountSearchList', component: () => import('../views/accountManage/capitalAcount')},
      {path: 'quotaExaApprovalList', title: '交易限额管理', name: 'quotaExaApprovalList', component: () => import('../views/industry/quotaExaApproval/quotaExaApprovalList')},
      // {path: 'addQuotaExaApproval', title: '新增交易限额管理', name: 'addQuotaExaApproval', component: () => import('../views/industry/quotaExaApproval/addQuotaExaApproval')},
      // {path: 'editQuotaExaApproval', title: '编辑交易限额管理', name: 'editQuotaExaApproval', component: () => import('../views/industry/quotaExaApproval/editQuotaExaApproval')},
      {path: 'whiteListPaymentsList', title: '出款账户白名单', name: 'whiteListPaymentsList', component: () => import('../views/industry/whiteList/whiteListPayments')}, // 出款账户白名单
      {path: 'addWhiteListPayments', title: '新增出款账户白名单', name: 'addWhiteListPayments', component: () => import('../views/industry/whiteList/addWhiteListPayments')},
      {path: 'editWhiteListPayments', title: '编辑出款账户白名单', name: 'editWhiteListPayments', component: () => import('../views/industry/whiteList/editWhiteListPayments')},
      {path: 'whiteListPaymentsShenhe', title: '出款账户白名单审核列表', name: 'whiteListPaymentsShenhe', component: () => import('../views/industry/whiteList/whiteListPaymentsShenhe')},
      {path: 'industryAmLimitList', title: '客户风控参数管理', name: 'industryAmLimitList', component: () => import('../views/industry/quotaExaApproval/quotaExaApprovalList')},
      {path: 'addQuotaExaApproval', title: '新增客户风控参数管理', name: 'addQuotaExaApproval', component: () => import('../views/industry/quotaExaApproval/addQuotaExaApproval')},
      {path: 'editQuotaExaApproval', title: '编辑客户风控参数管理', name: 'editQuotaExaApproval', component: () => import('../views/industry/quotaExaApproval/editQuotaExaApproval')},
      {path: 'industryAmLimitApprovalList', title: '客户风控参数审核管理', name: 'industryAmLimitApprovalList', component: () => import('../views/industry/quotaExaApproval/industryAmLimitApprovalList')},
      {path: 'subaccountsList', title: '子账户交易限额管理', name: 'subaccountsList', component: () => import('../views/industry/subaccounts/subaccountsList')},
      {path: 'addSubaccounts', title: '新增子账户客户风控参数管理', name: 'addSubaccounts', component: () => import('../views/industry/subaccounts/addSubaccounts')},
      {path: 'editSubaccounts', title: '编辑子账户客户风控参数管理', name: 'editSubaccounts', component: () => import('../views/industry/subaccounts/editSubaccounts')},
      {path: 'subaccountsApprovalList', title: '子账户交易限额审核', name: 'subaccountsApprovalList', component: () => import('../views/industry/subaccounts/subaccountsApprovalList')},
      {path: 'blacklistManger', title: '分账黑名单管理', name: 'blacklistManger', component: () => import('../views/industry/blacklist/blacklistManger')},
      {path: 'addblacklist', title: '新增分账黑名单', name: 'addblacklist', component: () => import('../views/industry/blacklist/addblacklist')},
      {path: 'editblacklist', title: '编辑分账黑名单', name: 'editblacklist', component: () => import('../views/industry/blacklist/editblacklist')},
      {path: 'blacklistAprOperManger', title: '分账黑名单审核列表', name: 'blacklistAprOperManger', component: () => import('../views/industry/blacklist/blacklistAprOperManger')},
      {path: 'specialIndustrySyncConfig', title: '资金同步特殊名单配置', name: 'specialIndustrySyncConfig', component: () => import('../views/industry/blackList/specialIndustrySyncConfig')},
      {path: 'addSpecialIndustrySyncConfig', title: '添加资金同步特殊名单配置', name: 'addSpecialIndustrySyncConfig', component: () => import('../views/industry/blackList/addSpecialIndustrySyncConfig')}
      ]
  },
  {
    path: '/merchantManage',
    title: '商户管理',
    name: 'merchantManage',
    component: Main,
    children: [
      {path: 'list', title: '商户管理', name: 'merchantManageList', component: () => import('../views/merchant/merchantManage')},
      {path: 'import', title: '商户模板导入', name: 'importMerchant', component: () => import('../views/merchant/importMerchant')},
      {path: 'addMerchant', title: '新增商户', name: 'addMerchant', component: () => import('../views/merchant/addMerchant')},
      {path: 'editMerchant', title: '编辑商户', name: 'editMerchant',component: () => import('../views/merchant/editMerchant')},
      {path: 'detail/:id', title: '商户详情', name: 'detailMerchant', component: () => import('../views/merchant/detailMerchant')},
      {path: 'linkMerchantList/:id', title: '商户号_支付产品管理', name: 'linkMerchantList', component: () => import('../views/merchant/link/linkMerchant')},
      {path: 'addChannelMerchant/:id', title: '新增商户关联渠道', name: 'addChannelMerchant', component: () => import('../views/merchant/link/addChannelMerchant')},
      {path: 'editChannelMerchant/:id', title: '修改商户关联渠道', name: 'editChannelMerchant', component: () => import('../views/merchant/link/editChannelMerchant')}
    ]
  },
  {
    path: '/organization',
    title: '机构管理',
    name: 'organization',
    component: Main,
    children: [
      {path: 'list', title: '机构管理', name: 'organizationManageList', component: () => import('../views/organization/mechanismManage/organizationInfo')},
      {path: 'addOrganization', title: '添加机构', name: 'addOrganization', component: () => import('../views/organization/mechanismManage/addOrganization')},
      {path: 'editOrganization/:id', title: '编辑机构', name: 'editOrganization', component: () => import('../views/organization/mechanismManage/editOrganization')},
      {path: 'organizationDetail/:id', title: '机构详情', name: 'organizationDetail', component: () => import('../views/organization/mechanismManage/organizationDetail')}
    ]
  },
  {
    path: '/certificate',
    title: '证书管理',
    name: 'certificate',
    component: Main,
    children: [
      {path: '/channelCerManage/list', title: '渠道证书管理', name: 'channelCerManage', component: () => import('../views/certificate/channelCerManage/channelCerManage')},
      {path: '/channelCerManage/addCertificate', title: '添加渠道证书', name: 'addChannelCer', component: () => import('../views/certificate/channelCerManage/addChannelCer')},
      {path: '/channelCerManage/detailCertificate/:id', title: '渠道证书详情', name: 'detailChannelCer', component: () => import('../views/certificate/channelCerManage/channelCerDetail')},
      {path: '/channelCerManage/editCertificate/:id', title: '编辑渠道证书', name: 'editChannelCer', component: () => import('../views/certificate/channelCerManage/editChannelCer')},
      {path: '/orgCerManage/list', title: '客户证书管理', name: 'orgCerManage', component: () => import('../views/certificate/orgCerManage/orgCerManage')},
      {path: '/orgCerManage/addCertificate', title: '添加客户证书', name: 'addOrgCer', component: () => import('../views/certificate/orgCerManage/addOrgCer')},
      {path: '/orgCerManage/detailCertificate/:id', title: '客户证书详情', name: 'detailOrgCer', component: () => import('../views/certificate/orgCerManage/orgCerDetail')},
      {path: '/orgCerManage/editCertificate/:id', title: '编辑客户证书', name: 'editOrgCer', component: () => import('../views/certificate/orgCerManage/editOrgCer')}
    ]
  },
  {
    path: '/productManage',
    title: '支付产品管理',
    name: 'productManage',
    component: Main,
    children: [
      {path: 'list', title: '支付产品管理', name: 'productManageList', component: () => import('../views/product/productInfo')},
      {path: 'addProduct', title: '添加支付产品', name: 'addProduct', component: () => import('../views/product/addProduct')},
      {path: 'editProduct/:id', title: '编辑支付产品', name: 'editProduct', component: () => import('../views/product/editProduct')},
      {path: 'productDetail/:id', title: '支付产品详情', name: 'productDetail', component: () => import('../views/product/productDetail')}
    ]
  },
  {
    path: '/fee',
    title: '手续费管理',
    name: 'feeManage',
    component: Main,
    children: [
      {path: 'list', title: '手续费管理', name: 'feeManageList', component: () => import('../views/fee/feeInfo')},
      {path: 'addFee', title: '添加手续费模板', name: 'addFee', component: () => import('../views/fee/addFee')},
      {path: 'editFee/:id', title: '编辑手续费模板', name: 'editFee', component: () => import('../views/fee/editFee')},
      {path: 'feeDetail/:id', title: '手续费模板详情', name: 'feeDetail', component: () => import('../views/fee/feeDetail')}
    ]
  },
  {
    path: '/channel',
    title: '渠道管理',
    name: 'channelManage',
    component: Main,
    children: [
      {path: 'list', title: '渠道管理', name: 'channelManageList', component: () => import('../views/channel/channelInfo')},
      {path: 'addChannel', title: '添加渠道', name: 'addChannel', component: () => import('../views/channel/addChannel')},
      {path: 'editChannel/:id', title: '编辑渠道', name: 'editChannel', component: () => import('../views/channel/editChannel')},
      {path: 'channelDetail/:id', title: '渠道详情', name: 'channelDetail', component: () => import('../views/channel/channelDetail')}
    ]
  },
  {
    path: '/tradeFlowManage',
    title: '交易流水查询',
    name: 'tradeFlowManage',
    component: Main,
    children: [
      {path: 'list', title: '当前交易流水', name: 'tradeFlows', component: () => import('../views/tradeFlow/tradeFlowManage')},
      {path: 'hisList', title: '历史交易流水', name: 'tradeHisFlows', component: () => import('../views/tradeFlow/hisFlowManage')},
      {path: 'listOutsideTransOrder', title: '上送支付流水查询', name: 'listOutsideTransOrder', component: () => import('../views/tradeFlow/listOutsideTransOrder')},
      {path: 'listSplitInfo', title: '平台分账信息查询', name: 'listSplitInfo', component: () => import('../views/tradeFlow/listSplitInfo')},
      {path: 'flowingIntoGold', title: '入金流水查询', name: 'flowingIntoGold', component: () => import('../views/tradeFlow/flowingIntoGold')},
      {path: 'singleTransactionFlow', title: '单笔流水查询', name: 'singleTransactionFlow', component: () => import('../views/tradeFlow/singleTransactionFlow')},
      {path: 'listSplitInfoDetail', title: '关联支付流水查询', name: 'listSplitInfoDetail', component: () => import('../views/tradeFlow/listSplitInfoDetail')},
      {path: 'flowingIntoGoldDetail', title: '入金关联支付流水查询', name: 'flowingIntoGoldDetail', component: () => import('../views/tradeFlow/flowingIntoGoldDetail')},
      {path: 'subAccountSettleSplitList', title: '子账户分账信息查询', name: 'subAccountSettleSplitList', component: () => import('../views/tradeFlow/subAccountSettleSplitList')},
      {path: 'subAccountSettleSplitDetail', title: '关联支付流水查询', name: 'subAccountSettleSplitDetail', component: () => import('../views/tradeFlow/subAccountSettleSplitDetail')},
      {path: 'subAccountPaymentList', title: '子账户单笔付款信息查询', name: 'subAccountPaymentList', component: () => import('../views/tradeFlow/subAccountPaymentList')},
      {path: 'subAccountPaymentDetail', title: '关联支付流水查询', name: 'subAccountPaymentDetail', component: () => import('../views/tradeFlow/subAccountPaymentDetail')},
    ]
  },
  {
    path: '/settle',
    title: '对账查询',
    name: 'settle',
    component: Main,
    children: [
      {path: 'errList', title: '差错流水查询', name: 'errorQuery', component: () => import('../views/reconciliations/errorQuery')},
      {path: 'orgList', title: '机构对账单', name: 'orgReconciliations', component: () => import('../views/reconciliations/orgReconciliations')},
      {path: 'merList', title: '客户对账单', name: 'merReconciliations', component: () => import('../views/reconciliations/merReconciliations')},
      {path: 'merRecordList', title: '商户对账表', name: 'merReconcileRecord', component: () => import('../views/reconciliations/merReconcileRecord')},
      {path: 'remittanceManager', title: '退汇管理', name: 'remittanceManager', component: () => import('../views/reconciliations/remittanceManager')},
      {path: 'addRemittance', title: '新增退汇', name: 'addRemittance', component: () => import('../views/reconciliations/addRemittance')}
    ]
  },
  {
    path: '/accountManage',
    title: '账户管理',
    name: 'accountManage',
    component: Main,
    children: [
      {path: 'accountList', title: '虚拟账户查询', name: 'accountList', component: () => import('../views/accountManage/accountInfo')},
      {path: 'accountFrozenThawList', title: '账户冻结解冻', name: 'accountFrozenThawList', component: () => import('../views/accountManage/accountFrozenThawList')},
      {path: 'setFee', title: '设置手续费', name: 'setFee', component: () => import('../views/accountManage/setFee')},
      {path: 'accountDetail/:id', title: '资金明细', name: 'accountDetail', component: () => import('../views/accountManage/accountDetail')},
      {path: 'accountDetailTwo/:id', title: '账户详情', name: 'accountDetailTwo', component: () => import('../views/accountManage/accountDetailTwo')},
      {path: 'accountDetailThree/:id', title: '账户详情', name: 'accountDetailThree', component: () => import('../views/accountManage/accountDetailThree')},
      {path: 'accountBankCardList/:id', title: '银行卡列表', name: 'accountBankCardList', component: () => import('../views/accountManage/accountBankCardList')},
      {path: 'capitalAcountDetail', title: '客户实体管理查询明细', name: 'capitalAcountDetail', component: () => import('../views/accountManage/capitalAcountDetail')},
      {path: 'addCapitalAcount', title: '新增客户实体账户', name: 'addCapitalAcount', component: () => import('../views/accountManage/addCapitalAcount')},
      {path: 'editCapitalAcount', title: '编辑客户实体账户', name: 'editCapitalAcount', component: () => import('../views/accountManage/editCapitalAcount')},
      {path: 'bankAccountTransDetail', title: '未入账资金流水查询', name: 'bankAccountTransDetail', component: () => import('../views/accountManage/accountTntryNot')},
      {path: 'accountEntryApply', title: '手工入账审核', name: 'accountEntryApply', component: () => import('../views/accountManage/accountEntryApply')},
      {path: 'withdrawalsRecord', title: '手续费收益提现审核', name: 'withdrawalsRecord', component: () => import('../views/accountManage/withdrawalsRecord')},
      {path: 'cashExamineDetail', title: '收益账户提现详情', name: 'cashExamineDetail', component: () => import('../views/accountManage/cashExamineDetail')},
      {path: 'merchantInfoManager', title: '企业鉴权审核', name: 'merchantInfoManager', component: () => import('../views/accountManage/merchantInfoManager')},
      {path: 'merchantInfoDetail', title: '企业鉴权详情', name: 'merchantInfoDetail', component: () => import('../views/accountManage/merchantInfoDetail')},
      {path: 'personalInfoAuth', title: '个体工商户鉴权审核', name: 'personalInfoAuth', component: () => import('../views/accountManage/personalInfoAuth')},
      {path: 'personalInfoAuthDetail', title: '个体工商户鉴权详情', name: 'personalInfoAuthDetail', component: () => import('../views/accountManage/personalInfoAuthDetail')},
      {path: 'feeIncomeAccountMonthStat', title: '手续费归集统计查询', name: 'feeIncomeAccountMonthStat', component: () => import('../views/accountManage/feeIncomeAccountMonthStat')},
      {path: 'freezingFundsOpeRecord', title: '资金冻结解冻审核', name: 'freezingFundsOpeRecord', component: () => import('../views/accountManage/freezingFundsOpeRecordList')},
      {path: 'modifyMerchantInfo', title: '更新资料', name: 'modifyMerchantInfo', component: () => import('../views/accountManage/modifyMerchantInfo')}
    ]
  },
  {
    path: '/jobTask',
    title: '定时任务',
    name: 'jobTask',
    component: Main,
    children: [
      {path: 'jobTaskList', title: '定时任务列表', name: 'jobTaskList', component: () => import('../views/jobTask/jobTaskInfo')},
      {path: 'jobTaskDetail/:id', title: '定时任务详情', name: 'jobTaskDetail', component: () => import('../views/jobTask/jobTaskDetail')},
      {path: 'addJobTask', title: ' 新增定时任务', name: 'addJobTask', component: () => import('../views/jobTask/addJobTask')},
      {path: 'editJobTask', title: ' 编辑定时任务', name: 'editJobTask', component: () => import('../views/jobTask/editJobTask')},
      {path: 'jobTaskRecordList', title: ' 对账任务查询', name: 'jobTaskRecordList', component: () => import('../views/jobTask/jobTaskRecord')}
    ]
  },
  {
    path: '/reportForm',
    title: '报表查询 / 交易统计报表',
    name: 'reportForm',
    component: Main,
    children: [
      {path: 'reportFormList', title: '交易统计报表', name: 'reportFormList', component: () => import('../views/reportForm/trandReportForm')},
      {path: 'capitalFormList', title: '资金账户统计报表', name: 'capitalFormList', component: () => import('../views/reportForm/capitalFormList')}
    ]
  }
]

// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
  path: '/login',
  name: 'login',
  meta: {
    title: 'Login - 登录'
  },
  component: () => import('../views/login/login.vue')
}

export const locking = {
  path: '/locking',
  name: 'locking',
  component: () => import('../views/main-components/lockscreen/components/locking-page.vue')
}

export const routers = [
  ...appRouter,
  otherRouter,
  loginRouter,
  locking,
  page500,
  page403,
  page404
]
