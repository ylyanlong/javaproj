namespace java com.yl.thrift.demo

# shell 风格的注释
// thrift idl demo

/*
 该文件的目的是尽可能多的覆盖到 thrift idl 的语法
 */

// 枚举允许常量是16进制的, 末尾无分号
enum RTN_TYPE{
    RTN_SUCCESS,  // 成功
    RTN_FAIL = 0  // 默认是从0开始的赋值的，如果想赋值给定值直接赋值就可以, 32位正整数, 0.6版本是负数有warning
}

// 注意 typedef 行后面是没有逗号的，C++的应该都知道吧；可以用在 struct 里面
// typedef i32 Integer

// const i32 INIT_NUM = 10;  // 末尾的分号是可选的，可有可无，支持16进制赋值
// 复杂的类型和结构体可使用JSON形式表示
// const map<string,string> MAP_CONST = {"hello": "world", "goodnight": "moon"}
// 返回的Map结构里面的KEY定义
const string NAME = "NAME";  // 用户的昵称
const string AGE = "AGE";  // 用户的年龄
const string ADDR = "ADDR";  // 住址

// 请求
struct UserInfoReq{
    1: required i64 uid = 100;  // 用户 uid
    2: optional string appdata;  // 应用上下文，可选
    9: optional map<string, string> extdinfo;  // 扩展用信息，暂时用不到
}

exception UserInfoReqException{
    1: i32 code;
    2: string message;
}

// 响应
struct UserInfoRsp{
    1: required RTN_TYPE result = RTN_TYPE.RTN_FAIL;  // 接口返回值
    2: string appdata; // 应用上下文
    3: map<string, string> key2info;  // 用户的具体属性，key-value对 形式存储
}

// 服务相关
// service 支持继承，一个service可使用extends关键字继承另外一个service
service UserInfoService{
    UserInfoRsp getUserInfo(1: UserInfoReq req) throws (1: UserInfoReqException e);  // 可能抛出异常
    // 可以继续写其他接口


    // ”oneway”标识符表示client发出请求后不必等待回复（非阻塞）直接进行下面的操作，
    // ”oneway”方法的返回值必须是void
    // oneway void zip()
}

