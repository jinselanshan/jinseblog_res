package com.jinse.blog.utils;

import java.util.Locale;

public final class ConstantsUtil {
	private ConstantsUtil(){
		
	}
	// common
	
	// 表格模式有个下载模板
	public static final String LOCK_MODULE_TYPE_ATTDOWNLOAD = "download";
	// 表格模式里alive请求不该解锁
	public static final String LOCK_MODULE_TYPE_ALIVE = "alive";
	public static final String LOCK_MODULE_TYPE_DETAILS = "details";
	public static final String LOCK_MODULE_TYPE_GET_DETAILS = "getDetails";
	public static final String LOCK_MODULE_TYPE_EXECUTE_CASE = "executeCase";
	// 用例设计表格模式大锁
	public static final String LOCK_MODULE_TYPE_TESTCASE = "testcase";
	// 用例设计web模式大锁
	public static final String LOCK_MODULE_TYPE_W_TESTCASE = "Wtestcase";
	// 用例设计web模式小锁
	public static final String LOCK_MODULE_TYPE_TESTCASE_WEB = "testcaseWeb";
	// 测试执行表格模式大锁
	public static final String LOCK_MODULE_TYPE_EXECUTION = "execution";
	// 测试执行web模式大锁
	public static final String LOCK_MODULE_TYPE_W_EXECUTION = "Wexecution";
	// 测试执行web模式小锁
	public static final String LOCK_MODULE_TYPE_EXECUTION_WEB = "executionWeb";
	public static final Character LOCK_STATUS_LOCK = '1';
	public static final Character LOCK_STATUS_UNLOCK = '0';
	public static final String TEST_CASE_PRIORITY_OR_STATUSNAME_OTHER = "其它";

	public static final String AJAX_RESULT_SUCCESS = "success";
	public static final String AJAX_RESULT_FAIL = "fail";
	public static final String AJAX_UPDATE_MESSAGE_SUCCESS = "Update Successful";
	public static final String AJAX_UPDATE_MESSAGE_FAIL = "Update Failed";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_NOT_NULL = "用例名称、描述、步骤、期望结果、优先级、设计者栏不允许为空";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_PRIORITY_INVALID = "优先级输入不合法";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_STATUSNAME_INVALID = "状态输入不合法";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_DATE_INVALID = "日期格式不合法";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_EXECUTORNAME_INVALID = "执行者格式不合法";
	public static final String AJAX_UPDATE_MESSAGE_FAIL_DESIGNER_INVALID = "设计者格式不合法";
	public static final String AJAX_DELETE_MESSAGE_SUCCESS = "Delete Successful";
	public static final String AJAX_DELETE_MESSAGE_FAIL = "Delete Failed";
	public static final String AJAX_CLOSE_MESSAGE_SUCCESS = "Close Successful";
	public static final String AJAX_CLOSE_MESSAGE_FAIL = "Close Failed";
	public static final String AJAX_OPEN_MESSAGE_SUCCESS = "Open Successful";
	public static final String AJAX_OPEN_MESSAGE_FAIL = "Open Failed";
	public static final String AJAX_SAVE_MESSAGE_SUCCESS = "Save Successful";
	public static final String AJAX_SAVE_MESSAGE_FAIL = "Save Failed";
	public static final String AJAX_SAVE_MESSAGE_FAIL_ASSIGNED_USER = "该用户已拥有此权限";
	public static final String AJAX_UPLOAD_MESSAGE_SUCCESS = "Upload Successful";
	public static final String AJAX_UPLOAD_MESSAGE_FAIL = "Upload Failed";
	public static final String AJAX_UPLOAD_MESSAGE_FORMAT_FAIL = "文件格式不支持";
	public static final String AJAX_DOWNLOAD_MESSAGE_SUCCESS = "downLoad Successful";
	public static final String AJAX_DOWNLOAD_MESSAGE_FAIL = "downLoad Failed";
	public static final String AJAX_LOGIN_MESSAGE_SUCCESS = "Login Successful";
	public static final String AJAX_LOGIN_MESSAGE_FAIL = "Login Failed";
	public static final String AJAX_REGISTER_MESSAGE_SUCCESS = "Register Successful";
	public static final String AJAX_REGISTER_MESSAGE_FAIL = "Register Failed";
	public static final String AJAX_LOCK_MESSAGE_SUCCESS = "Lock Successful";
	public static final String AJAX_LOCK_MESSAGE_FAIL = "Lock Failed";
	public static final String AJAX_UNLOCK_MESSAGE_SUCCESS = "Unlock Successful";
	public static final String AJAX_UNLOCK_MESSAGE_FAIL = "Unlock Failed";
	public static final String AJAX_NODEFECT_MESSAGE_FAIL = "Defect No does not exist";
	public static final String AJAX_UP_SUPERUSER_SUCCESS = "Upgrade Successful";
	public static final String AJAX_UP_SUPERUSER_FAIL = "Upgrade Failed";
	public static final String AJAX_DOWN_SUPERUSER_SUCCESS = "Demotion Successful";
	public static final String AJAX_DOWN_SUPERUSER_FAIL = "Demotion Failed";

	// add by felix
	public static final String AJAX_EDIT_MESSAGE = "请填写该缺陷";
	// add end

	public static final String COMMON_DOMAIN = "domain";
	public static final String COMMON_ADMIN = "admin";
	public static final String COMMON_PM = "pm";
	public static final String CURRENT_PM = "current_pm";
	public static final String COMMON_ADMIN_USERS = "admin";
	public static final String COMMON_CTP_AUDIT_USERS = "audit";
	public static final String COMMON_CTP_MANAGE_USERS = "ctpManage";

	public static final String SEPERATE_POLE = "-";
	public static final String SEPERATE_UNDERLINE = "_";
	public static final String COMMONURL_QAMSPROJID = "alphaTtest/projId/";
	public static final String COMMONURL_PROJID = "projId";
	public static final String COMMON_DEFECT_NUMS = "defectNums";
	public static final String DASHBOARD_SWITCH = "dashboardSwitch";

	public static final String SEPERATE_SLASH = "/";
	public static final String ERROR_BROWSER_COMPATABILITY = "errors/browsers-compatability";
	public static final String CODING_HOOKS = "/alphaTest/hooks";

	public static final String[] MIME_TYPE_IMAGE = { "image/gif", "image/jpeg", "application/x-bmp", "image/bmp",
			"image/png", "image/x-icon", "image/pjpeg", "image/x-png" };
	// VALIDATION
	public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
	public static final String VALIDATION_SUCCESS = "VALIDATION_SUCCESS";

	public static final String USER_TYPE_SITE_ADMIN = "siteadmin";
	public static final String USER_TYPE_SITE_USER = "siteuser";

	// Indicates the attachment is pending to be used by a new DEFECT / a new
	// REQUIREMENT
	// The status should be updated to 'A' when the new DEFECT / REQUIREMENT is
	// created or will remain
	// as 'P' if the new DEFECT / REQUIREMENT is cancelled.
	public static final Character STATUS_CODE_PENDING = 'P';
	public static final Character STATUS_CODE_DELETE = 'D';
	public static final Character STATUS_CODE_AVAILABLE = 'A';
	// If the project is finish, the status should be updated to 'F'.
	// As the same,'U' means that the project is unsuitable issue.
	public static final Character STATUS_CODE_FINISH = 'F';
	public static final Character STATUS_CODE_UNSUITABLE = 'U';
	public static final String STATUS_CODE_COLUMN_NAME = "statusCode";

	public static final String TEST_CASE_PRIORITY_HIGH = "3High";
	public static final String TEST_CASE_PRIORITY_MIDDLE = "2Middle";
	public static final String TEST_CASE_PRIORITY_LOW = "1Low";

	public static final String TEST_CASE_PRIORITY_C_HIGH = "高";
	public static final String TEST_CASE_PRIORITY_C_MIDDLE = "中";
	public static final String TEST_CASE_PRIORITY_C_LOW = "低";

	public static final String DEFECT_PRIORITY_HIGH = "3High";
	public static final String DEFECT_PRIORITY_MIDDLE = "2Middle";
	public static final String DEFECT_PRIORITY_LOW = "1Low";

	public static final int DEFAULT_PRECISION = 3;
	public static final String DEFAULT_PASSWORD = "123456";
	public static final String DEFAULT_TEST_CASE_STATUS_NAME = "Not Executed";
	public static final String DEFAULT_PROJECT_ID = "2";
	public static final String DEFAULT_USER_ID = "42";
	public static final String DEFAULT_PROJECT_PICTURE_ID = "5";
	public static final String DEFAULT_TEST_CASE_TEMPLATE_NAME = "TestCase_Template.xlsx";
	public static final String DEFAULT_TEST_EXECUTION_TEMPLATE_NAME = "TestExecution_Template.xlsx";
	public static final String DEFAULT_EXCEL_TEMPLATE_CONTENT_TYPE = "aplication/vnd.ms-excel";
	public static final String DEFAULT_PROJECT_PICTURE_NAME = "project_default.jpg";

	public static final String IS_ACTIVE = "Y";
	public static final String NO_ACTIVE = "N";

	public static final Character IS_ASSIGN = 'Y';
	public static final Character NOT_ASSIGN = 'N';

	public static final Character PLACE_STATUS_PLANNING = 'P';
	public static final Character PLACE_STATUS_EXEXUTION = 'E';
	public static final Character PLACE_STATUS_OPEN = 'O';
	public static final Character PLACE_STATUS_CLOSE = 'F';

	public static final String FOLDER_FLAG_FOLDER = "F";
	public static final String FOLDER_FLAG_RELEASE = "E";
	public static final String FOLDER_FLAG_CYCLE = "C";
	public static final String FOLDER_FLAG_REQUMT = "R";
	public static final String FOLDER_FLAG_TESTCASE = "T";
	public static final String FOLDER_FLAG_SUBFOLDER = "S";
	public static final String FOLDER_HAS_SUB_FOLDER = "Y";
	public static final String FOLDER_HAS_NO_SUB_FOLDER = "N";
	public static final String HAS_ATTACHMENT = "Y";
	public static final String HAS_NO_ATTACHMENT = "N";

	public static final String SEARCH_COLUMN_NAMES = "columnNames";
	public static final String SEARCH_COLUMN_VALUES = "columnValues";

	public static final String KEY_WORD_SEARCH_NAME = "keyword";

	public static final String URL_PATH_SEPARTOR = "/";

	// 附件类型
	public static final String ATTACHMENT_TYPE_PROJECT = "PROJECT";
	public static final String ATTACHMENT_TYPE_REQUIRMENT = "REQUIRMENT";
	public static final String ATTACHMENT_TYPE_DEFECT = "DEFECT";
	public static final String ATTACHMENT_TYPE_TESTCASE = "TESTCASE";
	// add
	public static final String ATTACHMENT_TYPE_TESTEXECUTION = "TESTEXE";
	public static final String ATTACHMENT_TYPE_FOLD = "FOLD";
	public static final String ATTACHMENT_TYPE_REPORT = "REPORT";
	public static final String ATTACHMENT_TYPE_RELEASE = "RELEASE";
	public static final String ATTACHMENT_TYPE_CYCLE = "CYCLE";
	public static final String ATTACHMENT_TYPE_COMMENT = "COMMENT";

	public static final String ATTACHMENT_PICTURE_JPG = "jpg";
	public static final String ATTACHMENT_PICTURE_PNG = "png";
	public static final String ATTACHMENT_PICTURE_GIF = "jpeg";
	public static final String ATTACHMENT_PICTURE_BMP = "bmp";
	public static final String ATTACHMENT_PICTURE_JPG_CAPITAL = "JPG";
	public static final String ATTACHMENT_PICTURE_PNG_CAPITAL = "PNG";
	public static final String ATTACHMENT_PICTURE_GIF_CAPITAL = "JPEG";
	public static final String ATTACHMENT_PICTURE_BMP_CAPITAL = "BMP";
	public static final String ATTACHMENT_DEFAULT_OBJECT_ID = "default";

	public static final String PROPERTIES_PATH = "/qams.properties";
	public static final String CODING_PROPERTIES_PATH = "/coding.properties";
	public static final String REDMINE_PROPERTIES_PATH = "/redmine.properties";
	public static final String TIANJI_PROPERTIES_PATH = "/tianji.properties";
	public static final String PROPERTIES_ATTACHMENT = "attachmentPath";
	public static final String PROPERTIES_WORKSPACEIMAGEPATH = "workspaceImagePath";

	public static final String PROPERTIES_TEST_CASE_EXCEL_TEMPLATE = "testcase.excel.template.path";
	public static final String PROPERTIES_TEST_EXECUTION_EXCEL_TEMPLATE = "testexecution.excel.template.path";
	public static final String PROPERTIES_DEFECT_EXCEL_TEMPLATE = "defect.excel.template.path";
	public static final String PROPERTIES_PROJECT_EXCEL_TEMPLATE = "project.excel.template.path";
	public static final String PROPERTIES_STEP_EXCEL_TEMPLATE = "Step.excel.template.path";
	public static final String PROPERTIES_DOWNLOAD_TEMP_PATH = "download.temp.path";
	public static final String PROPERTIES_DOWNLOAD_USER_GUIDE_PATH = "user.help.userguide.path";
	public static final String PROPERTIES_DOWNLOAD_USER_GUIDE_DATA_TYPE = "user.help.userguide.dataType";
	public static final String PROPERTIES_APPLICATION_REVISION = "app.revision";

	public static final Long FOLDRE_MODULE_TYPE_REQUIREMENT = 0L;
	public static final Long FOLDER_MODULE_TYPE_PLANNING = 1L;

	// Planning
	public static final String PLANNING_REPORT_NAME = "name";
	public static final String PLANNING_REPORT_SUMMARY = "summary";
	public static final String PLANNING_REPORT_ASSIGN = "assign";
	public static final String PLANNING_REPORT_EXECUTE = "execute";

	public static final String DEFECT_DESCR_CONDITON = "先决条件：";
	public static final String DEFECT_DESCR_CASESTEP = "测试步骤：";
	public static final String DEFECT_DESCR_EXPECTEDRSSULT = "预期结果：";
	public static final String DEFECT_DESCR_EXECUTERESULT = "实际结果：";

	public static final String DEFECT_STATUS_ANALYSED = "Analysed";
	public static final String DEFECT_STATUS_DEV_COMPLETED = "Dev Completed";
	public static final String DEFECT_STATUS_OPENED = "Open";
	public static final String DEFECT_STATUS_CLOSEED = "Closed";

	public static final String TIANJI_DEFECT_STATUS_ACTIVE = "active";
	public static final String TIANJI_DEFECT_STATUS_CLOSEED = "closed";
	public static final String TIANJI_DEFECT_STATUS_RESOLVED = "resolved";

	public static final String DEFECT_STATUS_C_ANALYSED = "分析完成";
	public static final String DEFECT_STATUS_C_DEV_COMPLETED = "开发完成";
	public static final String DEFECT_STATUS_C_OPENED = "打开";
	public static final String DEFECT_STATUS_C_CLOSEED = "关闭";

	public static final String DEFECT_TENDENCY_REPORT_DATE = "name";
	public static final String DEFECT_TENDENCY_REPORT_OPEN = "newCreated";
	public static final String DEFECT_TENDENCY_REPORT_TOTAL_OPEN = "totalCreated";
	public static final String DEFECT_TENDENCY_REPORT_RESLOVE = "resolved";
	public static final String DEFECT_TENDENCY_REPORT_TOTAL_RESLOVE = "totalResolved";

	// Execution
	public static final String Execution_REPORT_NAME_SUM = "汇总";
	public static final String Execution_REPORT_NAME = "Name";
	public static final String Execution_REPORT_TOTAL = "Total";
	public static final String Execution_REPORT_NOTEXECUTED = "Not Executed";
	public static final String Execution_REPORT_INVAILD = "Invaild";
	public static final String Execution_REPORT_BLOCK = "Block";
	public static final String Execution_REPORT_FAIL = "Fail";
	public static final String Execution_REPORT_PASS = "Pass";

	public static final String Execution_REPORT_C_NOTEXECUTED = "未执行";
	public static final String Execution_REPORT_C_INVALID = "无效";
	public static final String Execution_REPORT_C_BLOCK = "阻塞";
	public static final String Execution_REPORT_C_FAIL = "失败";
	public static final String Execution_REPORT_C_PASS = "通过";

	// home
	public static final String HOME_REPORT_TEST_EXECUTION_CYCLE = "cycle";
	public static final String HOME_REPORT_TEST_EXECUTION_NEWCREATED = "newCreated";
	public static final String HOME_REPORT_TEST_EXECUTION_RESOLVED = "resolved";
	public static final String HOME_REPORT_TEST_EXECUTION_PLANEXECUTE = "planExecute";
	public static final String HOME_REPORT_TEST_EXECUTION_EXECUTED = "executed";
	public static final String HOME_REPORT_TEST_EXECUTION_PASSED = "passed";

	public static final String HOME_REPORT_MY_DEFECTS_SEVERITY = "severity";
	public static final String HOME_REPORT_MY_DEFECTS_DEFECTID = "defectId";
	public static final String HOME_REPORT_MY_DEFECTS_DEFECTNUM = "defectNum";
	public static final String HOME_REPORT_MY_DEFECTS_SUMMARY = "summary";
	public static final String HOME_REPORT_MY_DEFECTS_STATUS = "status";

	public static final String HOME_REPORT_QUALITY_OVERVIEW_REQUIREMENT = "requirement";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_RESOLVED = "resolved";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_DTOTAL = "dTotal";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_EXECUTED = "executed";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_TTOTAL = "tTotal";

	public static final String HOME_REPORT_QUALITY_OVERVIEW_MODULE = "module";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_RESOLVEDDEFECT = "resolvedDefect";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_UNRESOLVEDDEFECT = "unResolvedDefect";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_EXECUTEDCASE = "executedCase";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_UNEXECUTEDCASE = "unExecutedCase";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_RESOLVEDDEFECT_PRE = "resolvedDefectPre";
	public static final String HOME_REPORT_QUALITY_OVERVIEW_EXECUTEDCASE_PRE = "executedCasePre";

	public static final String HOME_REPORT_DEFECTS_TENDENCY_TOTAL_CREATED = "totalCreated";
	public static final String HOME_REPORT_DEFECTS_TENDENCY_TOTAL_RESOLVED = "totalResolved";
	public static final String HOME_REPORT_DEFECTS_TENDENCY_DATE = "name";

	public static final String STRING_PROJECT = "PROJECT";
	public static final String STRING_USER = "USER";

	public static final String STRING_CURRENT_USER = "CURRENT_USER";

	public static final String STRING_USER_NAME = "username";
	public static final String STRING_CURRENT_PROJECT = "CURRENT_PROJECT";
	public static final String STRING_CURRENT_RELEASE = "CURRENT_RELEASE";
	public static final String STRING_PROJECTS = "PROJECT_LIST";

	public static final String MESSAGE_SOURCE_BEAN_NAME = "messageSource";
	public static final Locale DEFAULE_LOCALE = Locale.CHINA;

	public static final String HOME_REPORT_QUALITY_FILTER_RESOLVEDPER = "resolvedPer";
	public static final String HOME_REPORT_QUALITY_FILTER_EXECUTEDPER = "executedPer";

	// defect
	public static final String DEFECT_RESOLUTION_FIXED = "Fixed";
	public static final String DEFECT_RESOLUTION_INVALID = "Invalid";
	public static final String DEFECT_RESOLUTION_LATER = "Later";
	public static final String DEFECT_RESOLUTION_UNRESOLVED = "Unresolved";
	public static final String DEFECT_RESOLUTION_RESOLVED = "Resolved";

	public static final String DEFECT_RESOLUTION_C_FIXED = "已修复";
	public static final String DEFECT_RESOLUTION_C_INVALID = "无效";
	public static final String DEFECT_RESOLUTION_C_LATER = "延迟";
	public static final String DEFECT_RESOLUTION_C_UNRESOLVED = "待修复";
	public static final String DEFECT_RESOLUTION_C_RESOLVED = "已解决";

	public static final String DEFECT_SERVERITY_BLOCKER = "Blocker";
	public static final String DEFECT_SERVERITY_CRITICAL = "Critical";
	public static final String DEFECT_SERVERITY_MAJOR = "Major";
	public static final String DEFECT_SERVERITY_NORMAL = "Normal";
	public static final String DEFECT_SERVERITY_MINOR = "Minor";
	public static final String DEFECT_SERVERITY_TRIVIAL = "Trivial";

	public static final String DEFECT_SERVERITY_C_BLOCKER = "致命";
	public static final String DEFECT_SERVERITY_C_CRITICAL = "严重";
	public static final String DEFECT_SERVERITY_C_MAJOR = "主要";
	public static final String DEFECT_SERVERITY_C_NORMAL = "一般";
	public static final String DEFECT_SERVERITY_C_MINOR = "次要";
	public static final String DEFECT_SERVERITY_C_TRIVIAL = "轻微";

	// email
	public static final String MAIL_HOST = "mail.host";
	public static final String MAIL_USER = "mail.username";
	public static final String MAIL_PASS = "mail.password";

	// filter
	public static final String COMMON_FILTER_URL = "filter.url";

	// system butt joint
	public static final String SYSTEM_CODING_URL = "system.coding.url";
	public static final String PRODUCT_CODING_URL = "coding.server.url";
	public static final String PRODUCT_CODING_HOME_URL = "coding.server.home.url";

	public static final String PRIVATE_TOKEN = "coding.private.token";

	public static final String TOKEN_EXCEL_PATH = "coding.token.excelpath";
	public static final String ROOT_TOKEN = "coding.token.rootToken";
	public static final String CODING_HOOKS_URL = "coding.hooks.url";

	public static final int TYPE_SEVERITY = 0;
	public static final int TYPE_REASON = 1;
	public static final int TYPE_RESOLUTION = 2;
	public static final int TYPE_MILESTONE = 3;

	public static final String SYSTEM_ID_CODING = "0";
	public static final String SYSTEM_ID_REDMINE = "1";
	public static final String SYSTEM_LINKED_CODING = "is_linked_coding";
	public static final String SYSTEM_LINKED_REDMINE = "is_linked_redmine";
	public static final String REDMINE_PROJECT_RESTFULL_URL = "redimine.project.restfull.url";
	public static final String REDMINE_ISSUES_RESTFULL_URL = "redimine.issues.restfull.url";
	public static final String REDMINE_VERSIONS_RESTFULL_URL = "redimine.versions.restfull.url";
	public static final String REDMINE_USERS_RESTFULL_URL = "redimine.users.restfull.url";
	public static final String REDMINE_ATTACHMENTS_RESTFULL_URL = "redimine.attachments.restfull.url";

	// qamsFactory service
	public static final String FACTORY_SERVICE_TARGET_SYSTEM_CODING = "Coding";
	public static final String FACTORY_SERVICE_TARGET_SYSTEM_REDMINE = "Redmine";
	public static final String FACTORY_SERVICE_TARGET_SYSTEM_DEFAULT = "Redmine";
	public static final String FACTORY_SERVICE_CREATE_REQUIREMENT_DES_CODING = "Coding --> QAMS issue同步时候创建";
	public static final String FACTORY_SERVICE_CREATE_REQUIREMENT_DES_REDMINE = "Redmine --> QAMS issue同步时候创建";
	public static final String FACTORY_SERVICE_CREATE_REQUIREMENT_DES_DEFAULT = "默认需求创建";
	public static final String FACTORY_SERVICE_CREATE_REQUIREMENT_DEFAULT_NAME = "默认需求";
	// TestPlan status
	public static final String TEST_PLAN_STATUS_PLANING = "Planing";
	public static final String TEST_PLAN_STATUS_FAIL = "Fail";
	public static final String TEST_PLAN_STATUS_PENDING = "Penging";
	public static final String TEST_PLAN_STATUS_NOT_EXECUTED = "Not Executed";
	public static final String TEST_PLAN_STATUS_PASS = "Pass";
	// user doc
	public static final String HELP_USER_USERGUIDE_FILENAME = "QAMSUserGuide.docx";

	public static final String ALPHATEST_PROPERTIES_PATH = "/alphatest.properties";
	
	//poi
	public static final short POI_CONTENT_FONT_SIZE = 12;
	public static final short POI_FONT_BOLD_WEIGHT = 5;
	public static final short POI_HEX_DECIMAL = 16;
	
	//index user type
	public static final String USER_TYPE_PUTONG = "2";
	public static final String USER_TYPE_SYSADMIN = "1";
}
